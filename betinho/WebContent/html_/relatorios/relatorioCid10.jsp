<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>





<a href="javascript:window.print();">imprimir</a>
	<table>
	<c:forEach var="option" items="${cids}">
		<tr>

			<td><font face="arial" size="2">
			<c:out value="${option}" /></td>
			
		</tr>
	</c:forEach>
	</table>

</html>
