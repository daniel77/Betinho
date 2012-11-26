<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp" /><br>
<jsp:useBean id="funcionario" scope="request" class="org.br.apav.model.Funcionario" />


<form action="funcionario.html" method="POST">

<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="codFuncionario" value="<%=request.getParameter("codFuncionario") %>">

    <div style="text-align: center" >
        <br />
	 <span class="tituloEditar">
       Cadastro Funcionario </span>
        <br />
        <br />
        <br />
        <table style="width:; height: 334px" border=0>
            <tr>
				<td class="labelEditar" >
                    Nome Funcionario:</td>
                 <td class="tdEstilo">
                    <input id="nome" name="nome" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="nome" />"  /></td>
             </tr>
             <tr>       
				<td class="labelEditar" >
			    Data Nacimento:</td>
                <td class="tdEstilo">
                
                <input type="text"  id="dataNascimento" name="dataNascimento" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(funcionario.getDataNascimento())%>" />
            
             </tr>
             <tr>       
	            <td class="labelEditar" >
    	            CPF:</td>
               <td class="tdEstilo">
                     <input id="cpf" name="cpf" class="inputtext" type="text" size=15 onblur="Verifica_campo_cpf(this)"
                    value="<jsp:getProperty name="funcionario" property="cpf" />"  /></td>
           	  </tr>
           	  <tr>
				<td class="labelEditar" >
    	            RG:</td>
                                <td class="tdEstilo">
                    <input id="rg" name="rg" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="rg" />"  /></td>
           	  </tr>
           	  
           	  <tr>
           	 	<td class="labelEditar" >
    	            Endereco:</td>
                               <td class="tdEstilo">
                    <input id="endereco" name="endereco" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="endereco" />"  /></td>
              </tr>
              
              <tr>
               <td class="labelEditar" >
    	           Telefone Celular:</td>
                              <td class="tdEstilo">
                    <input id="telefoneCelular" name="telefoneCelular" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="telefoneCelular" />"  /></td>
			 </tr>
              
              <tr>
				<td class="labelEditar" >
    	            Telefone Comercial:</td>
                               <td class="tdEstilo">
                    <input id="telefoneComercial" name="telefoneComercial" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="telefoneComercial" />"  /></td>
              </tr>
              <tr>

				<td class="labelEditar" >
    	            Telefone Residencial:</td>
                               <td class="tdEstilo">
                    <input id="telefoneResidencial" name="telefoneResidencial" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="telefoneResidencial" />"  /></td>

              </tr>
    		
    		
    		<tr>
    		
    		<td class="labelEditar" >
    	            EstadoCivil:</td>
                                <td class="tdEstilo">
                    <input id="estadoCivil" name="estadoCivil" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="estadoCivil" />"  /></td>
    		</tr>
    		<tr>
    		                <td class="labelEditar" >
                    Sexo:</td>
                <td class="tdEstilo">
                    <input id="sexo" name="sexo" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="sexo" />"  /></td>
    		</tr>
    		
    		<tr>
    		
    		<td class="labelEditar" >
    	            Cidade:</td>
                               <td class="tdEstilo">
                    <input id="cidade" name="cidade" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="cidade" />"  /></td>
    		</tr>
    		
    		<tr>
    		
    		<td class="labelEditar" >
    	            UF:</td>
                               <td class="tdEstilo">
                    <input id="uf" name="uf" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="uf" />"  /></td>
    		</tr>
    		
    		<tr>
    		<td class="labelEditar" >
    	            Email:</td>
                               <td class="tdEstilo">
                    <input id="email" name="email" class="inputtext" type="text" 
                    value="<jsp:getProperty name="funcionario" property="email" />"  /></td>
    		</tr>
    		
        </table>
        <br />
        <br />


    	<suportweb:botoes/>    
    </div>
    

    	
    	
</form>

<script>
function submitLocal(){

  if(document.forms[0].nome.value != ''){
  		document.forms[0].submit();
  }else{
  		alert("Preencha o campo nome!");
 }
}
 
// Função Validação de CPF 
// Feita por Anderson Luciano Santos da Silva e Marçal de Lima Hokama   
// retirada do site http://www.construindoseusite.com.br/javascript/scripts/js_validacao_cpf_imp.htm

function Verifica_campo_cpf(campo) {
var cpf = campo.value; // Recebe o valor digitado no campo

// Aqui começa a checagem do cpf
var POSICAO, I, SOMA, DV, DV_INFORMADO;
var DIGITO = new Array(10);
DV_INFORMADO = cpf.substr(9, 2); // Retira os dois últimos dígitos do número informado

// Desemembra o número do cpf na array DIGITO
for (I=0; I<=8; I++) {
  DIGITO[I] = cpf.substr( I, 1);
}

// Calcula o valor do 10º dígito da verificação
POSICAO = 10;
SOMA = 0;
   for (I=0; I<=8; I++) {
      SOMA = SOMA + DIGITO[I] * POSICAO;
      POSICAO = POSICAO - 1;
   }
DIGITO[9] = SOMA % 11;
   if (DIGITO[9] < 2) {
        DIGITO[9] = 0;
}
   else{
       DIGITO[9] = 11 - DIGITO[9];
}

// Calcula o valor do 11º dígito da verificação
POSICAO = 11;
SOMA = 0;
   for (I=0; I<=9; I++) {
      SOMA = SOMA + DIGITO[I] * POSICAO;
      POSICAO = POSICAO - 1;
   }
DIGITO[10] = SOMA % 11;
   if (DIGITO[10] < 2) {
        DIGITO[10] = 0;
   }
   else {
        DIGITO[10] = 11 - DIGITO[10];
   }

// Verifica se os valores dos dígitos verificadores conferem
DV = DIGITO[9] * 10 + DIGITO[10];
   if (DV != DV_INFORMADO) {
      alert('cpf inválido');
      campo.value = '';
      campo.focus();
      return false;
   } 
}


  
  

  
</script>
</body>
</html>