<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>


Relatorios de contatos


<a href="javascript:window.print();">imprimir</a>
	<table>
	<c:forEach var="option" items="${contatos}">
		<tr>

			<td width="200"><font face="arial" size="2"><c:out
				value="${option.nome}" /></font></td>
				<td width="35" ><font face="arial" size="2"><c:out value="${option.parentesco}" /></font></td>
				<td width="35" ><font face="arial" size="2"><c:out value="${option.telefoneResidencial}" /></font></td>
			
		</tr>
	</c:forEach>
	</table>

</html>
