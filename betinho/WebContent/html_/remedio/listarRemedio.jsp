<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<c:import url="/index.jsp"></c:import>

<script>
function submitAcao(perform){
 if(perform != 'insert' && document.forms[0].codRemedio.value == '' ){
 	alert("Selecione um registro! ");
 }else{
 	document.forms[0].event.value = perform;
 	document.forms[0].submit();
 }
}

</script>



<form action="remedio.html" method="POST">
<input type='hidden' name="perform" value="load" >
<input type='hidden' name="event" value="" >
<input type='hidden' name="codRemedio" value="" >

<suportweb:opcoes excluir="false" />
<br>
<table>

<tr>

<td width="10" ></td>

<td width="200" ><b>Remedio</td>

</tr>

<tr>

<td width="10" ></td>

<td width="235" class="tituloList"  >Descrição</td>
<td width="235"  class="tituloList"   >EAN</td>

</tr>
<c:forEach var="option" items="${remedios}" >
<tr>
<td><input type="radio" name="itens" onclick="document.forms[0].codRemedio.value='<c:out value="${option.codRemedio}" />';" ></td>


<td ><font face="arial" size="2"><c:out value="${option.descricao}" /></font></td>
<td ><font face="arial" size="2"><c:out value="${option.EAN}" /></font></td>
</tr>
</c:forEach>
</table>


</form>
<br><br>

</body>
</html>