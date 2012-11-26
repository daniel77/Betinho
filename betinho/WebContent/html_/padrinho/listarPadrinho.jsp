<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<c:import url="/index.jsp"></c:import>

<script>
function submitAcao(perform){
 if(perform != 'insert' && document.forms[0].codPadrinho.value == '' ){
 	alert("Selecione um registro! ");
 }else{
 	document.forms[0].event.value = perform;
 	document.forms[0].submit();
 }
}

</script>



<form action="padrinho.html" method="POST">
<input type='hidden' name="perform" value="load" >
<input type='hidden' name="event" value="" >
<input type='hidden' name="codPadrinho" value="" >
<table align="center" border="1">
<tr>
<td align="center" width="70" >
<a href="javascript:submitAcao('insert');"  >
<img src="imagens/b_incluir.gif" border="0" ></a><br>Novo&nbsp;
</td>
<td align="center"  width="70" >
<a href="javascript:submitAcao('update');"  >
<img src="imagens/b_alterar.gif" border="0" ></a><br>Editar&nbsp;
</td>
<td align="center"  width="70" >
<a href="javascript:submitAcao('delete');" >
<img src="imagens/b_excluir.gif" border="0" ></a><br>Excluir&nbsp;
</td>
</tr>
</table>
<br>
<table>

<tr>

<td width="10" ></td>

<td width="200" ><b>Nome Padrinho</td>

</tr>

<c:forEach var="option" items="${padrinhos}" >
<tr>
<td><input type="radio" name="itens" onclick="document.forms[0].codPadrinho.value='<c:out value="${option.codPadrinho}" />';" ></td>

<td width="35" ><font face="arial" size="2"><c:out value="${option.nome}" /></font></td>
</tr>
</c:forEach>
</table>


</form>
<br><br>

</body>
</html>