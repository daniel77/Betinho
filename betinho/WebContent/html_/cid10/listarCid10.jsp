<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<c:import url="/index.jsp"></c:import>

<script>
function submitAcao(perform){
 if(perform != 'insert' && document.forms[0].cid10.value == '' ){
 	alert("Selecione um registro! ");
 }else{
 	document.forms[0].event.value = perform;
 	document.forms[0].submit();
 }
}

</script>



<form action="cid10.html" method="POST">
<input type='hidden' name="perform" value="load" >
<input type='hidden' name="event" value="" >
<input type='hidden' name="cid10" value="" >
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

<td width="200" ><b>cid10</td>

</tr>

<c:forEach var="option" items="${cid10s}" >
<tr>
<td><input type="radio" name="itens" onclick="document.forms[0].cid10.value='<c:out value="${option.cid10}" />';" ></td>

<td width="35" ><font face="arial" size="2"><c:out value="${option.descr}" /></font></td>
</tr>
</c:forEach>
</table>


</form>
<br><br>

</body>
</html>