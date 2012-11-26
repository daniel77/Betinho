<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<c:import url="/index.jsp" /><br>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<%@page import="org.br.apav.framework.DataUtility"%>

<jsp:useBean id="cargaViral" scope="request" class="org.br.apav.model.CargaViral" />
<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />

<form action="cargaviral.html" method="POST">
<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="codCargaViral" value="<%=request.getParameter("codCargaViral") %>">
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">

<table>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="crianca" property="nome" /></td>
            </tr>
</table>

    <div style="text-align: center" >
        <br />
        <span style="font-size: 16pt; text-decoration: underline">
       Cadastro Carga Viral</span>
        <br />
        <br />
        <br /> 
        <table style="width:; height: 334px" border=0>
            <tr>
            
                <td class="labelEditar" >
                    Data:</td>
                <td class="tdEstilo">
                
                                
                <input type="text"  id="data" name="data" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(cargaViral.getData())%>" 
			<c:out value="${disabled}" /> />
                
    </td>
            </tr>
            
            
            <tr>
                <td class="labelEditar" >
                    CD8:</td>
                <td class="tdEstilo">
                    <input id="cd8" name="cd8" class="inputtext"  type="text" maxlength="5" onkeypress='return verificaNro( event );'
                    value="<jsp:getProperty name="cargaViral" property="cd8" />" <c:out value="${disabled}" /> /></td>
            </tr>
            
            <tr>
                <td class="labelEditar" >
                    CD4:</td>
                <td class="tdEstilo">
                    <input id="cd4" name="cd4" class="inputtext"  type="text" maxlength="5" onkeypress='return verificaNro( event );'
                    value="<jsp:getProperty name="cargaViral" property="cd4" />" <c:out value="${disabled}" /> /></td>
            </tr>
            
            <tr>
                <td class="labelEditar" >
                    LOG:</td>
                <td class="tdEstilo">
                    <input id="log" name="log" class="inputtext"  type="text" maxlength="15"
                    value="<jsp:getProperty name="cargaViral" property="log" />" <c:out value="${disabled}" /> /></td>
            </tr>
        </table>
        <br />
        <br />
    
    </div>


        <suportweb:botoes/>
</form>

<script>
function submitLocal(){
	if(document.forms[0].perform.value == "delete"){
		document.forms[0].submit();
		return;
	}
		
  var erros = ""; 
  if(document.forms[0].data.value != ''){
  		//pega o atributo do form 
  		data = document.forms[0].data.value;
  		//funcao para validacao ver scripts.js
  		if(!validaData(data)){
	  		alert("Data de exame invalida");
  			return;
  			//retorna 
  		}
  		
  		datanasc = data;
		if(validaDatas(data,'<%=crianca.getDataNascimentoStr()%>')){
			alert("a data do exame não pode ser menor que a data de nascimento da criança <%=crianca.getDataNascimentoStr()%>!");
			return;
		}
  		
  		
  		if(document.forms[0].cd8.value == '' ){
  			alert("Preencha o CD8");
  			return;
  			//retorna 
  		}

  		if(document.forms[0].cd8.value == 0){
  			alert("Preencha o CD8");
  			return;
  			//retorna 
  		}

  		
  		if(document.forms[0].cd4.value == ''){
  			alert("Preencha o CD4");
  			return;
  			//retorna 
  		}
  		
  		if(document.forms[0].cd4.value == 0){
  			alert("Preencha o CD4");
  			return;
  			//retorna 
  		}
  		
  		
  		//se tudo legal submit!!
  		document.forms[0].submit();
  		
  }else{
  		alert("Preencha a Data");
 }

 
}
</script>
</body>
</html>