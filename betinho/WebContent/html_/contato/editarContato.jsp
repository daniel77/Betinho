<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<c:import url="/index.jsp" /><br>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<%@page import="org.br.apav.framework.DataUtility"%>

<jsp:useBean id="contato" scope="request" class="org.br.apav.model.Contato" />
<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />

<form action="contato.html" method="POST">

<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="codContato" value="<%=request.getParameter("codContato") %>">
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
       Cadastro Contato </span>
        <br />
        <br />
        <br />
        <table style="width:; height: 334px" border=0>
            <tr>
                <td class="labelEditar" >
                    Nome Contato:</td>
               <td class="tdEstilo">
                    <input id="nome" name="nome" class="inputtext" type="text" 
                    value="<jsp:getProperty name="contato" property="nome" />" <c:out value="${disabled}" /> /></td>
            </tr>
            
            
            <tr>
                <td class="labelEditar" >
                    Parentesco:</td>
             <td class="tdEstilo">
                    <input id="parentesco" name="parentesco" class="inputtext" type="text" 
                    value="<jsp:getProperty name="contato" property="parentesco" />" <c:out value="${disabled}" /> /></td>
            </tr>
            


            <tr>
                <td class="labelEditar" >
                    Endereço:</td>
              <td class="tdEstilo">
                    <input id="endereco" name="endereco" class="inputtext" type="text" 
                    value="<jsp:getProperty name="contato" property="endereco" />" <c:out value="${disabled}" /> /></td>
            </tr>

            <tr>
                <td class="labelEditar" >
                    Bairro:</td>
            <td class="tdEstilo">
                    <input id="bairro" name="bairro" class="inputtext" type="text" 
                    value="<jsp:getProperty name="contato" property="bairro" />" <c:out value="${disabled}" /> /></td>
            </tr>

            <tr>
                <td class="labelEditar" >
                    Cidade:</td>
              <td class="tdEstilo">
                    <input id="cidade" name="cidade" class="inputtext" type="text" 
                    value="<jsp:getProperty name="contato" property="cidade" />" <c:out value="${disabled}" /> /></td>
            </tr>

            <tr>
                <td class="labelEditar" >
                    UF:</td>
             <td class="tdEstilo">
                    <input id="uf" name="uf" class="inputtext" type="text" 
                    value="<jsp:getProperty name="contato" property="uf" />" <c:out value="${disabled}" />  /></td>
            </tr>            

            <tr>
                <td class="labelEditar" >
                    Telefone Residencial:</td>
      <td class="tdEstilo">
                    <input id="telefoneResidencial" name="telefoneResidencial" class="inputtext" type="text" 
                    value="<jsp:getProperty name="contato" property="telefoneResidencial" />"  <c:out value="${disabled}" /> /></td>
            </tr>            
            
            <tr>
                <td class="labelEditar" >
                   Telefone Celular:</td>
                <td class="tdEstilo">
                    <input id="telefoneCelular" name="telefoneCelular" class="inputtext" type="text" 
                    value="<jsp:getProperty name="contato" property="telefoneCelular" />" <c:out value="${disabled}" /> /></td>
            </tr>            
            
        </table>
        <br />
        <br />


    
    </div>

</form>
   <suportweb:botoes/>
<script>
function submitLocal(){
	if(document.forms[0].perform.value == "delete"){
		document.forms[0].submit();
		return;
	}
		
var erros = ""; 
  if(document.forms[0].nome.value != ''){

  		if(document.forms[0].parentesco.value == ''){
  			alert("Campo Parentesco Obrigatorio");
  			return;
  			//retorna 
  		}
  		if(document.forms[0].endereco.value == ''){
  			alert("Campo Endereco Obrigatorio");
  			return;
  			//retorna 
  		}
  		if(document.forms[0].telefoneResidencial.value == ''){
  			alert("Telefone Residencial Obrigatório");
  			return;
  			//retorna 
  		}
 		
  		//se tudo legal submit!!
  		document.forms[0].submit();
  		
  }else{
  		alert("Preencha o Nome");
 }
}
</script>
</body>
</html>