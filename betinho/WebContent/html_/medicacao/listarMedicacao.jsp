<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp"></c:import>

<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />
<jsp:useBean id="tratamento" scope="request" class="org.br.apav.model.Tratamento" />

<script>
function submitAcao(perform){
 if(perform != 'insert' && document.forms[0].codMedicacao.value == '' ){
 	alert("Selecione um registro! ");
 }else{
 	document.forms[0].event.value = perform;
 	document.forms[0].submit();
 }
}

</script>

<form action="medicacao.html" method="POST">
<input type='hidden' name="perform" value="load" >
<input type='hidden' name="event" value="" >

<input type='hidden' name="codMedicacao" value="">
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">
<input type='hidden' name="codTratamento" value="<%=request.getParameter("codTratamento") %>">

<suportweb:opcoes editar="false" />
<br>
<table>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="crianca" property="nome" /></td>
            </tr>
            <tr>
                <td class="labelEditar" >
                    Tratamento para:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="tratamento" property="cid10" /></td>
            </tr>
</table>         <br>   
<table>
<tr>
<td>Medicações</td>
</tr>
<tr>
<c:forEach var="option" items="${medicacoes}" >
<tr>
<td><input type="radio" name="itens"
 onclick="document.forms[0].codMedicacao.value='<c:out value="${option.codMedicacao}" />';" ></td>

<td ><font face="arial" size="2"><c:out value="${option}" /></font></td>
</tr>
</c:forEach>
</table>


</form>
<br><br>

</body>
</html>