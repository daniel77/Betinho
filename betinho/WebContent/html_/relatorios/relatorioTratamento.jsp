<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<%@page import="org.br.apav.framework.DataUtility"%>



<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />
<jsp:useBean id="tratamento" scope="request" class="org.br.apav.model.Tratamento" />

<html>
<head>
<a href="javascript:window.print();">imprimir</a>
		<table>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="crianca" property="nome" /></td>
            </tr>
            </table>



            
            <c:forEach var="optiont" items="${tratamentos}" >

<table border=1>            
            <tr>
                <td class="labelEditar" >
                    Tratamento para:</td>
                <td style="width: 624px; text-align: left;">
               <c:out value="${optiont.cid10.descr}" /></td>
            </tr>

</table>        
 <br>   
Medicações
<table>




<tr>
<td>

<table>
<tr>
<td>&nbsp;</td>
<td width="235" class="tituloList"  >Data Inicio</td>
<td width="235"  class="tituloList"   >Data Final</td>
<td width="235"  class="tituloList"   >Remedio </td>
<td width="235"  class="tituloList"   >Posologia</td>
<td width="235"  class="tituloList"   >Dosagem</td>


<c:forEach var="option" items="${optiont.medicacao}" >

   </tr>
 <tr>
<td></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.dataInicioStr}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.dataFinalStr}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.remedio}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.poslogia}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.dosagem}" /></font></td>


</tr>
</c:forEach>


            </c:forEach>
            
</head>
<body>

</body>
</html>