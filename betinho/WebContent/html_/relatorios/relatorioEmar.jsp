<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@page import="org.br.apav.framework.DataUtility"%>

<html>

<body>
<a href="javascript:window.print();">imprimir</a>

<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />


<table>
<tr>
<td>&nbsp;</td>
<td width="235" class="tituloList"  >Data Inicio</td>
<td width="235"  class="tituloList"   >Data Final</td>
<td width="235"  class="tituloList"   >Remedio 1</td>
<td width="235"  class="tituloList"   >Remedio 2</td>
<td width="235"  class="tituloList"   >Remedio 3</td>
<td width="235"  class="tituloList"   >Situacao</td>

<c:forEach var="option" items="${emars}" >


</tr>
 <tr>
<td></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.dataInicioStr}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.dataFinalStr}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.remedio1}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.remedio2}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.remedio3}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.situacao}" /></font></td>

</tr>
</c:forEach>
</table>
</body>
</html>
