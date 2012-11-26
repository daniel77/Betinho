<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp"></c:import>

<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />

<script>
function submitAcao(perform){
 if(perform != 'insert' && document.forms[0].codTratamento.value == '' ){
 	alert("Selecione um registro! ");
 }else{
 	document.forms[0].event.value = perform;
 	document.forms[0].submit();
 }
}
function links(event){
	if(document.forms[0].codTratamento.value == '' ){
 		alert("Selecione um registro! ");
 		
 	}else {
    
  	document.forms[0].perform.value = "path";
  	document.forms[0].event.value = event;
  	document.forms[0].submit();
  	}

}

function emitirRelatorioTratamento(){
	PopUpCenter("/betinho/relatorios.html?perform=tratamentos&codCrianca=<%=request.getParameter("codCrianca") %>",800,600);
}

</script>

<form action="tratamento.html" method="POST">
<input type='hidden' name="perform" value="load" >
<input type='hidden' name="event" value="" >
<input type='hidden' name="codTratamento" value="" >
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">

<suportweb:opcoes />
<br>
<table>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="crianca" property="nome" /></td>
            </tr>
</table>         <br>   
<table>
<tr>
<td>Tratamentos</td>
</tr>
<tr>
<c:forEach var="option" items="${tratamentos}" >
<tr>
<td><input type="radio" name="itens"
 onclick="document.forms[0].codTratamento.value='<c:out value="${option.codTratamento}" />';" ></td>

<td><font face="arial" size="2"><c:out value="${option.cid10.descr}" /></font></td>
</tr>
</c:forEach>
</table>

    <table width="98%" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr class="backtable">
		<td class="textnormal" height="20" align="center"><span
			class="textnormal"> <b>:</b> 
				<a href="javascript:javascript:links('medicacao');">
				Medicação
			 </a> <b>:</b> 
			 <b>:</b> 
				<a href="javascript:emitirRelatorioTratamento();">
				Emitir Relatório de Tratamentos
			 </a> <b>:</b>
	</td>		 
			 </span>
			 
			 </td>
	</tr>
</table>
</form>
<br><br>

</body>
</html>