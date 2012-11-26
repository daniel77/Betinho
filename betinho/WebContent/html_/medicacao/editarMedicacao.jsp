<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<c:import url="/index.jsp" /><br>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<%@page import="org.br.apav.framework.DataUtility"%>

<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />
<jsp:useBean id="tratamento" scope="request" class="org.br.apav.model.Tratamento" />
<jsp:useBean id="medicacao" scope="request" class="org.br.apav.model.Medicacao" />



<form action="medicacao.html" method="POST">
<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="codTratamento" value="<%=request.getParameter("codTratamento") %>">
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">
<input type='hidden' name="codMedicacao" value="<%=request.getParameter("codMedicacao") %>">

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
            
</table>

    <div style="text-align: center" >
        <br />
        <span style="font-size: 16pt; text-decoration: underline">
       Cadastro Medicações para Tratamento</span>
        <br />
        <br />
        <br /> 
        <table style="width:; height: 334px" border=0>
            <tr>
            
                <td class="labelEditar" >
                    Data Inicio:</td>
                <td class="tdEstilo">
                
                                
                <input type="text"  id="dataInicio" name="dataInicio" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(medicacao.getDataInicio())%>"
			<c:out value="${disabled}" /> />
                
    </td>
            </tr>

            <tr>
            
                <td class="labelEditar" >
                    Data Fim:</td>
                <td class="tdEstilo">
                
                                
                <input type="text"  id="dataFim" name="dataFim" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(medicacao.getDataFim())%>" 
			<c:out value="${disabled}" /> />
                
    </td>
            </tr>
            
            
            <tr>
                <td class="labelEditar" >
                    Dosagem:</td>
                <td class="tdEstilo">
                    <input id="dosagem" name="dosagem" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="medicacao" property="dosagem" />" <c:out value="${disabled}" /> /></td>
            </tr>
            
            <tr>
                <td class="labelEditar" >
                    poslogia:</td>
                <td class="tdEstilo">
                    <input id="poslogia" name="poslogia" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="medicacao" property="poslogia" />" <c:out value="${disabled}" /> /></td>
            </tr>
 
 	<tr>
		<td class="labelEditar">Remedio:</td>
		<td class="tdEstilo">
		<select name="codRemedio" <c:out value="${disabled}" /> >
			<c:forEach var="option" items="${remedios}">
				<option value="<c:out value="${option.codRemedio}" />" >
				<c:out value="${option.descricao}" /></option>
			</c:forEach>
		</select>
		</td>
	</tr>	
 
        </table>
        <br />
        <br />
    
    </div>


        <suportweb:botoes/>
</form>

<script>
setSelected('codRemedio','<c:out value="${medicacao.remedio.codRemedio}"/>');
function submitLocal(){
	if(document.forms[0].perform.value == "delete"){
		document.forms[0].submit();
		return;
	}
		
  var erros = ""; 
  
  		//pega o atributo do form 
  		dataInicio = document.forms[0].dataInicio.value;
  		dataFim = document.forms[0].dataFim.value;  		
  		
  		//funcao para validacao ver scripts.js
  		if(!validaData(dataInicio)){
	  		alert("Data de inicio invalida");
  			return;
  			//retorna 
  		}else
  		
  		if(!validaData(dataFim)){
	  		alert("Data de final invalida");
  			return;
  			//retorna 
  		}else
		
		datanasc = dataInicio;
		if(validaDatas(datanasc,'<%=crianca.getDataNascimentoStr()%>')){
			alert("a data de inicio da medicação não pode ser menor que a data de nascimento da criança <%=crianca.getDataNascimentoStr()%>!");
			return;
		}
  		
	
		if(validaDatas(dataFim,dataInicio)){

			alert("a data final da medicação não pode ser menor que a data inicial");
			return;
		}
  		
  		//se tudo legal submit!!
  		document.forms[0].submit();


 
}
</script>
</body>
</html>