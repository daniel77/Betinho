package org.br.apav.taglib;



import java.io.ByteArrayInputStream;

import java.text.*;
import java.util.*;
import javax.servlet.jsp.JspException;

import javax.servlet.jsp.tagext.*;

public class CalendarTag extends BodyTagSupport
{
 static final long serialVersionUID = 14;
 public CalendarTag()
 {
     sdf = new SimpleDateFormat();
     urlDf = new SimpleDateFormat();
     initialized = false;
     navigation = false;
     displayDate = null;
     todayDate = null;
 }

 public int doStartTag()
 {
     if(!initialized)
     {
         Locale lc = null;
         try
         {
             lc = (Locale)super.pageContext.findAttribute("locale");
         }
         catch(ClassCastException classcastexception) { }
         catch(NullPointerException nullpointerexception) { }
         setLocale(lc);
     }
     return 2;
 }

 public void setLocale(String str)
 {
     if(str != null)
     {
         Locale lc = null;
         StringTokenizer st = new StringTokenizer(str, " ,;-:");
         String languageCode = st.nextToken();
         String countryCode = st.nextToken();
         if(st.hasMoreTokens())
             lc = new Locale(languageCode, countryCode, st.nextToken());
         else
             lc = new Locale(languageCode, countryCode);
         setLocale(lc);
     }
 }

 private void setLocale(Locale lc)
 {
     DateFormatSymbols dfs = lc != null ? new DateFormatSymbols(lc) : sdf.getDateFormatSymbols();
     monthNames = dfs.getMonths();
     dayNames = dfs.getShortWeekdays();
     WIDTH = dayNames[1].length() + 1;
     LINE_LENGTH = 7 * WIDTH;
     int extra = Math.abs(WIDTH - 4);
     boolean pad = extra != 0;
     String foo;
     for(foo = new String(); extra-- > 0; foo = foo + " ");
     PAD = pad ? foo : null;
     initialized = true;
 }

 public void setUrlFormat(String uf)
 {
     urlFormat = uf;
 }

 public void setNavigate(String nv)
 {
     navigation = nv != null && !nv.equals("false");
 }

 public void setDisplay(String str)
 {
     try
     {
         sdf.applyPattern("MM/yyyy");
         displayDate = sdf.parse(str);
     }
     catch(ParseException parseexception) { }
 }

 public void setToday(String str)
 {
     try
     {
         sdf.applyPattern("dd/MM/yyyy");
         todayDate = sdf.parse(str);
     }
     catch(ParseException parseexception) { }
 }

 public final int doEndTag()
     throws JspException
 {
     String result = new String();
     Properties dates = new Properties();
     javax.servlet.jsp.JspWriter out = super.pageContext.getOut();
     boolean navigateEveryDay = true;
     try
     {
         String bodyStr = super.bodyContent.getString();
         if(bodyStr.length() > 0)
         {
             ByteArrayInputStream body = new ByteArrayInputStream(bodyStr.getBytes());
             dates.load(body);
             navigation = true;
             navigateEveryDay = false;
         }
     }
     catch(Exception exception) { }
     if(navigation)
     {
         sdf.applyPattern("MM/dd/yyyy");
         if(urlFormat == null)
             urlDf.applyPattern("yyyy/MM/dd");
         else
             urlDf.applyPattern(urlFormat);
     }
     try
     {
         GregorianCalendar cal = (GregorianCalendar)Calendar.getInstance();
         if(todayDate != null)
             cal.setTime(todayDate);
         int td = cal.get(5);
         int tm = cal.get(2);
         int ty = cal.get(1);
         int dm;
         int dy;
         if(displayDate != null)
         {
             cal.setTime(displayDate);
             dm = cal.get(2);
             dy = cal.get(1);
         } else
         {
             dm = tm;
             dy = ty;
         }
         String monthName = monthNames[dm];
         cal.set(5, 1);
         int dow = cal.get(7) - 1;
         result = result + "<pre class=\"calendar\">\n";
         result = result + "<span class=\"calMonth\">" + monthName + " " + dy + "</span>\n";
         result = result + "<span class=\"calDays\">";
         for(int d = 1; d <= 7; d++)
         {
             result = result + " " + dayNames[d];
             if(4 > WIDTH)
                 result = result + PAD;
         }

         result = result + "</span>\n";
         int linePosition = dow * WIDTH;
         int maxDays;
         if(dow > 0)
         {
             cal.set(2, --dm);
             maxDays = cal.getActualMaximum(5);
             result = result + "<span class=\"calPrev\">";
             for(int d = (maxDays - dow) + 1; d <= maxDays; d++)
             {
                 if(tm == dm && d == td)
                     result = result + "<span class=\"calNow\"> " + d + " </span>";
                 else
                     result = result + " " + d + " ";
                 if(WIDTH > 4)
                     result = result + PAD;
             }

             result = result + "</span>";
             cal.set(2, ++dm);
         }
         maxDays = cal.getActualMaximum(5);
         for(int d = 1; d <= maxDays; d++)
         {
             if(dm == tm && d == td)
                 result = result + "<span class=\"calNow\">";
             if(d < 10)
                 result = result + ' ';
             result = result + ' ';
             if(navigation)
             {
                 String date = (tm >= 10 ? "" : "0") + (tm + 1) + "/" + (d >= 10 ? "" : "0") + d + "/" + ty;
                 if(navigateEveryDay)
                 {
                     try
                     {
                         Date urlDate = sdf.parse(date);
                         String href = urlDf.format(urlDate);
                         result = result + "<span onClick=\"" + href + "\" >" + d + "</span>";
                     }
                     catch(Exception exception1)
                     {
                         out.write("#");
                     }
                 } else
                 {
                     boolean activeDate = dates.containsKey(date);
                     if(activeDate)
                     {
                         String href = dates.getProperty(date);
                         if(href == null || href.length() == 0)
                         {
                             Date urlDate = sdf.parse(date);
                             href = urlDf.format(urlDate);
                         }
                         result = result + "<span onClick=\"" + href + "\" >";
                     }
                     result = result + d;
                     if(activeDate)
                         result = result + "</span>";
                 }
             } else
             {
                 result = result + d;
             }
             result = result + ' ';
             if(WIDTH > 4)
                 result = result + PAD;
             if(dm == tm && d == td)
                 result = result + "</span>";
             linePosition += WIDTH;
             if(linePosition == LINE_LENGTH)
             {
                 linePosition = 0;
                 result = result + "\n";
             }
         }

         if(linePosition > 0 && linePosition < LINE_LENGTH)
         {
             result = result + "<span class=\"calNext\">";
             for(int d = 1; linePosition != LINE_LENGTH; d++)
             {
                 if(dm == tm - 1 && d == td)
                     result = result + "<span class=\"calNow\">  " + d + " </span>";
                 else
                     result = result + "  " + d + " ";
                 if(WIDTH > 4)
                     result = result + PAD;
                 linePosition += WIDTH;
             }

             result = result + "</span>";
         }
         if(linePosition > 0)
             result = result + "\n";
         result = result + "</pre>\n";
         out.write(result);
     }
     catch(Exception eek)
     {
         eek.printStackTrace();
         throw new JspException("CalendarTag -- " + eek.getClass().getName() + ": " + eek.getMessage());
     }
     return 6;
 }


 private String monthNames[];
 private String dayNames[];
 private SimpleDateFormat sdf;
 private SimpleDateFormat urlDf;
 private String urlFormat;
 private int WIDTH;
 private int LINE_LENGTH;
 private String PAD;
 private boolean initialized;
 private boolean navigation;
 private Date displayDate;
 private Date todayDate;
}
