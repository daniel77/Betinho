<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>





<a href="javascript:window.print();">imprimir</a>
	<table>
	<c:forEach var="option" items="${criancas}">
		<tr>

			<td width="200"><font face="arial" size="2"><c:out
				value="${option.nome}" /></font></td>
			<td width="200"><font face="arial" size="2"><c:out
				value="${option.dataNascimentoStr}" /></font></td>
			<td width="200"><font face="arial" size="2"><c:out
				value="${option.cpf}" /></font></td>

		</tr>
	</c:forEach>
	</table>

</html>



