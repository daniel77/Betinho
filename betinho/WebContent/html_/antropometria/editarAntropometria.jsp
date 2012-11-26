<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@page import="org.br.apav.framework.DataUtility"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<c:import url="/index.jsp" /><br>


<jsp:useBean id="antropometria" scope="request" class="org.br.apav.model.Antropometria" />
<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />

<form action="antropometria.html" method="POST">

<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="codAntropometria" value="<%=request.getParameter("codAntropometria") %>">
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">

    <div style="text-align: center" >
        <br />
        <span style="font-size: 16pt; text-decoration: underline">
       Cadastro Antropometria</span>
        <br />
        <br />
        <br />
        
        <table>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="crianca" property="nome" /></td>
            </tr>
</table>
        
        <table style="width:; height: 334px" border=0>
            <tr>
                <td class="labelEditar" >
                    Data:</td>
                <td style="width: 624px; text-align: left;">
                    
                      <input type="text"  id="data" name="data" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(antropometria.getData())%>"
			 <c:out value="${disabled}" /> />
                
                    
                    </td>
            </tr>
            
            
            <tr>
                  <td class="labelEditar" >
                    Peso(g):</td>
                <td style="width: 400px; text-align: left;">
                    <input id="peso" name="peso" class="inputtext" type="text"   maxlength="5" onkeypress='return verificaNro( event );'
                    value="<jsp:getProperty name="antropometria" property="peso" />"  <c:out value="${disabled}" /> /></td>
            </tr>
            
            <tr>
                  <td class="labelEditar" >
                    Altura(cm):</td>
                <td style="width: 400px; text-align: left;">
                    <input id="altura" name="altura" class="inputtext" type="text" maxlength="4" onkeypress='return verificaNro( event );'
                    value="<jsp:getProperty name="antropometria" property="altura" />"   <c:out value="${disabled}" /> /></td>
            </tr>

            <tr>
                  <td class="labelEditar" >
                    Numero da Roupa:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="numeroRoupa" name="numeroRoupa" class="inputtext" type="text" maxlength="10"  <c:out value="${disabled}" />
                    value="<jsp:getProperty name="antropometria" property="numeroRoupa" />"  /></td>
            </tr>

            <tr>
                  <td class="labelEditar" >
                    Numero do Sapato:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="numeroSapato" name="numeroSapato" class="inputtext" type="text" maxlength="10"  <c:out value="${disabled}" />
                    value="<jsp:getProperty name="antropometria" property="numeroSapato" />"  /></td>
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
  		
  			alert("Data do exame inválida");
  			return;
  			//retorna 
  		}
  		
  		datanasc = data;
		if(validaDatas(data,'<%=crianca.getDataNascimentoStr()%>')){
			alert("a data de inicio da medicação não pode ser menor que a data de nascimento da criança <%=crianca.getDataNascimentoStr()%>!");
			return;
		}
  		
  		
  		
  		
  		
  		
		  if(document.forms[0].peso.value == ''){
  		
  			alert("Peso Inválido");
  			return;
  			//retorna 
  		}
  		
  		if(document.forms[0].altura.value == ''){
  		
  			alert("Altura Inválida");
  			return;
  			//retorna 
  		}
  		
  		//se tudo legal submit!!
  		document.forms[0].submit();
  		
  }else{
  		alert("Preencha o Data");
 }
}
</script>
</body>
</html>