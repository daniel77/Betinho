<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<c:import url="/index.jsp" /><br>

<script>
function submitAcao(perform){
 if(perform != 'insert' && document.forms[0].codAntropometria.value == '' ){
 	alert("Selecione um registro! ");
 }else{
 	document.forms[0].event.value = perform;
 	document.forms[0].submit();
 }
}
function links(event){
	if(document.forms[0].codCrianca.value == '' ){
 		alert("Selecione um registro! ");
 	}else {
		window.open("/betinho/arquivo.html?codCrianca="+document.forms[0].codCrianca.value);

  	}
}
</script>
<form action="antropometria.html" method="POST">
<input type='hidden' name="perform" value="load"> 
<input type='hidden' name="event" value="">
<input type='hidden' name="codAntropometria" value="" >
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">

<suportweb:opcoes />
<br>
<table align="center" border="1">
<tr>
<br>

<table>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="crianca" property="nome" /></td>
            </tr>
</table>

<table>

<tr>

<td width="10" ></td>

<td width="200" ><b>Data do exame</td>

</tr>

<c:forEach var="option" items="${antropometrias}" >
<tr>
<td><input type="radio" name="itens" onclick="document.forms[0].codAntropometria.value='<c:out value="${option.codAntropometria}" />';" ></td>

<td width="35" ><font face="arial" size="2"><c:out value="${option.dataExameStr}" /></font></td>
</tr>
</c:forEach>
</table>


</form>
<br><br>
    <table width="98%" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr class="backtable">
		<td class="textnormal" height="20" align="center"><span
			class="textnormal"> <b>:</b> 
				<a href="/betinho/crianca.csv?relatorio=antropometria&codCrianca=<%=request.getParameter("codCrianca") %>" 
				target="new">
				Emitir Relatório do Gráfico de Antropometria
			 </a> <b>:</b> 
			 <b>:</b> 
				<a href="GraficoAntropometria.xls" 
				target="new" >
				Arquivo Relatório Para exibir do Gráfico de Antropometria(Botão Direito Salvar)
			 </a> <b>:</b>
	</td>		 
			 
			 </td>
</tr>
</table>
</body>

</html>