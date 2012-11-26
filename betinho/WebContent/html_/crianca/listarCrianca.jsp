<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<c:import url="/index.jsp"></c:import>

<script>
function submitAcao(perform){
 if(perform != 'insert' && document.forms[0].codCrianca.value == '' ){
 	alert("Selecione um registro! ");
 }else{
 	document.forms[0].perform.value = "load";
 	document.forms[0].event.value = perform;
 	document.forms[0].submit();
 }
}

function links(event){
	if(document.forms[0].codCrianca.value == '' ){
 		alert("Selecione um registro! ");
 		
 	}else {
 		if( (event != "pcr") && 
 			(document.forms[0].pcr.value == "" || document.forms[0].pcr.value == "false")){
	 		alert("o exame de pcr está negativo, verifique essa situação");
 		}else{
		  	document.forms[0].perform.value = "path";
		  	document.forms[0].event.value = event;
		  	document.forms[0].submit();
		 }
  	}

}

function pesquisar(){
	document.forms[0].perform.value = "list";
  	document.forms[0].submit();

}

function setCrianca(cod,pcr){
document.forms[0].codCrianca.value =cod;
document.forms[0].pcr.value =pcr;
}

</script>



<form action="crianca.html" method="POST">
<input type='hidden' name="perform" value="load"> 
<input type='hidden' name="event" value="">
<input type='hidden' name="codCrianca" value="">
<input type='hidden' name="pcr" value="">

<suportweb:opcoes excluir="false" />

<table>
	<tr>
		<td>NOME:</td>
		<td><input type="text" name="nomePesquisa" /><a
			href="javascript:pesquisar();"> <img
			src="imagens/b_pesquisar.gif" alt="Pesquisar Crianca" border=0></a>
		</td>
	</tr>

	<tr>

		<td width="10"></td>

		<td width="200"><b>nome</td>
		<td width="30"><b>data Nasc.</td>
		<td width="40"><b>CPF</td>

	</tr>

	<c:forEach var="option" items="${criancas}">
		<tr>
			<td><input type="radio" name="itens"
				onclick="setCrianca('<c:out value="${option.codCrianca}" />','<c:out value="${option.pcr.pcr}" />')"></td>


			<td width="200"><font face="arial" size="2"><c:out
				value="${option.nome}" /></font></td>
			<td width="200"><font face="arial" size="2"><c:out
				value="${option.dataNascimentoStr}" /></font></td>
			<td width="200"><font face="arial" size="2"><c:out
				value="${option.cpf}" /></font></td>

		</tr>
	</c:forEach>
</table>
<table width="98%" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr class="backtable">
		<td class="textnormal" height="20" align="center"><span
			class="textnormal"> <b>:</b> 
			<a href="javascript:javascript:links('pcr');">
			PCR
			 </a> <b>:</b> 
			  <b>:</b> 
			<a href="javascript:javascript:links('cargaviral');">
			Carga Viral
			 </a> <b>:</b> 
			 <a href="javascript:javascript:links('antropometria');">
			Antropometria
			 </a> <b>:</b> 
			  <b>:</b> 
			<a href="javascript:javascript:links('emar');">
			Emar
			 </a> <b>:</b>
			  <b>:</b> 
			<a href="javascript:javascript:links('tratamento');">
			Tratamento
			 </a> <b>:</b>
			 <b>:</b> 
			 <a href="javascript:javascript:links('contato');">
			Contato
			 </a> <b>:</b>
			 </span>
			 
			 </td>
	</tr>
</table>

</form>
<br>
<br>

</body>
</html>
