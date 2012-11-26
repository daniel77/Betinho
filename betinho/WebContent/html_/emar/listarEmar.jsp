<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp"></c:import>

<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />


<script>
function submitAcao(perform){
 if(perform != 'insert' && document.forms[0].codEmar.value == '' ){
 	alert("Selecione um registro! ");
 }else{
 	document.forms[0].event.value = perform;
 	document.forms[0].submit();
 }
}

function emitirRelatorioEmar(){
	PopUpCenter("/betinho/relatorios.html?perform=emar&codCrianca=<%=request.getParameter("codCrianca") %>",800,600);
}

</script>



<form action="emar.html" method="POST">
<input type='hidden' name="perform" value="load" >
<input type='hidden' name="event" value="" >
<input type='hidden' name="codEmar" value="" >
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">

<suportweb:opcoes excluir="false" />
<br>
<table>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="crianca" property="nome" /></td>
            </tr>
<tr>
	<td width="10" ></td>

		<td width="200" ><b>Listagem de medicamento anti-retrovirais: </td>
</tr>
</table>
<table>
<tr>
<td>&nbsp;</td>
<td width="235" class="tituloList"  >Data Inicio</td>
<td width="235"  class="tituloList"   >Data Final</td>
<td width="235"  class="tituloList"   >Remedio</td>
<td width="235"  class="tituloList"   >Remedio</td>
<td width="235"  class="tituloList"   >Remedio</td>
<td width="235"  class="tituloList"   >Situacao</td>

<c:forEach var="option" items="${emars}" >


</tr>
 <tr>
<td><input type="radio" name="itens" onclick="document.forms[0].codEmar.value='<c:out value="${option.codEmar}" />';" ></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.dataInicioStr}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.dataFinalStr}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.remedio1}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.remedio2}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.remedio3}" /></font></td>
<td width="235" ><font face="arial" size="2"><c:out value="${option.situacao}" /></font></td>

</tr>
</c:forEach>
</table>


</form>
<br>
    <table width="98%" border="0" cellspacing="0" cellpadding="0"
	align="center">
	<tr class="backtable">
		<td class="textnormal" height="20" align="center"><span
			class="textnormal"> <b>:</b> 
				<a href="javascript:emitirRelatorioEmar()" >
				Emitir Relatório do Emar
			 </a> <b>:</b> 

	</td>		 
			 
			 </td>
</tr>
</table>

<br><br>


</body>


</html>