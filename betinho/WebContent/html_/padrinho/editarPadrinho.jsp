<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp" />
<br>
<jsp:useBean id="padrinho" scope="request"
	class="org.br.apav.model.Padrinho" />


<form action="padrinho.html" method="POST"><input type='hidden'
	name="perform" value="<%=request.getParameter("event") %>"> <input
	type='hidden' name="codPadrinho"
	value="<%=request.getParameter("codPadrinho") %>">

<div style="text-align: center"><br />
<span class="tituloEditar"> Cadastro Padrinho </span> <br />
<br />
<br />
<table style="width:; height: 334px" border=0>
	<tr>
		<td class="labelEditar">Nome Padrinho:</td>
		<td class="tdEstilo"><input id="nome" name="nome"
			class="inputtext" type="text"  <c:out value="${disabled}" />
			value="<jsp:getProperty name="padrinho" property="nome" />" /></td>
	</tr>
	<tr>
		<td class="labelEditar">Data Nacimento:</td>
		<td class="tdEstilo"><input type="text" id="dataNascimento"
			name="dataNascimento" class="inputtext" style="width: 366px"
			type="text" maxlength="10" size="12"  <c:out value="${disabled}" />
			onkeypress="return formataData(this,event);"
			value="<%=DataUtility.dateToString(padrinho.getDataNascimento())%>" />
	</tr>
	<tr>

		<td class="labelEditar">CPF:</td>
		<td class="tdEstilo"><input id="cpf" name="cpf" class="inputtext"
			type="text" size=15 onkeypress="return formataCPF(cpf, event );"  <c:out value="${disabled}" />
			value="<jsp:getProperty name="padrinho" property="cpf" />" /></td>
	</tr>
	<tr>
		<td class="labelEditar">RG:</td>
		<td class="tdEstilo"><input id="rg" name="rg" class="inputtext" onkeypress='return verificaNro( event );'
			type="text"  <c:out value="${disabled}" /> value="<jsp:getProperty name="padrinho" property="rg" />" /></td>
	</tr>

	<tr>
		<td class="labelEditar">Endereco:</td>
		<td class="tdEstilo"><input id="endereco" name="endereco"
			class="inputtext" type="text"  <c:out value="${disabled}" />
			value="<jsp:getProperty name="padrinho" property="endereco" />" /></td>
	</tr>

	<tr>
		<td class="labelEditar">Telefone Celular:</td>
		<td class="tdEstilo"><input id="telefoneCelular"   <c:out value="${disabled}" />
			name="telefoneCelular" class="inputtext" type="text"
			value="<jsp:getProperty name="padrinho" property="telefoneCelular" />" /></td>
	</tr>

	<tr>
		<td class="labelEditar">Telefone Comercial:</td>
		<td class="tdEstilo"><input id="telefoneComercial"  <c:out value="${disabled}" />
			name="telefoneComercial" class="inputtext" type="text"
			value="<jsp:getProperty name="padrinho" property="telefoneComercial" />" /></td>
	</tr>
	<tr>

		<td class="labelEditar">Telefone Residencial:</td>
		<td class="tdEstilo"><input id="telefoneResidencial"  <c:out value="${disabled}" />
			name="telefoneResidencial" class="inputtext" type="text"
			value="<jsp:getProperty name="padrinho" property="telefoneResidencial" />" /></td>

	</tr>


	<tr>

		<td class="labelEditar">EstadoCivil:</td>
		<td class="tdEstilo"><input id="estadoCivil" name="estadoCivil"
			class="inputtext" type="text"  <c:out value="${disabled}" />
			value="<jsp:getProperty name="padrinho" property="estadoCivil" />" /></td>
	</tr>
	<tr>
		<td class="labelEditar">Sexo:</td>
		<td class="tdEstilo">
		           <input id="sexo" name="sexo" class="inputtext" type="radio" 
                    value="M" <% if("M".equals(padrinho.getSexo())){out.print("CHECKED");}%>  />Masc.
                   <input id="sexo" name="sexo" class="inputtext" type="radio" 
                    value="F" <% if("F".equals(padrinho.getSexo())){out.print("CHECKED");}%> />Fem. </td>
	</tr>

	<tr>

		<td class="labelEditar">Cidade:</td>
		<td class="tdEstilo"><input id="cidade" name="cidade"
			class="inputtext" type="text"  <c:out value="${disabled}" />
			value="<jsp:getProperty name="padrinho" property="cidade" />" /></td>
	</tr>

	<tr>

		<td class="labelEditar">UF:</td>
		<td class="tdEstilo"><input id="uf" name="uf" class="inputtext"  <c:out value="${disabled}" />
			type="text" value="<jsp:getProperty name="padrinho" property="uf" />" /></td>
	</tr>


	<tr>
		<td class="labelEditar">Email:</td>
		<td class="tdEstilo"><input id="email" name="email"
			class="inputtext" type="text"  <c:out value="${disabled}" />
			value="<jsp:getProperty name="padrinho" property="email" />" /></td>
	</tr>

</table>
<br />
<br />


<suportweb:botoes /></div>




</form>

<script>



function submitLocal(){

	if(document.forms[0].perform.value == "delete"){
		document.forms[0].submit();
		return;
	}

 if(document.forms[0].nome.value != ''){
 	if(document.forms[0].dataNascimento.value != ''){
  		//pega o atributo do form 
  		dataNascimento = document.forms[0].dataNascimento.value;
  		//funcao para validacao ver scripts.js
  		if(!validaData(dataNascimento)){
  		
  			alert("Data de nascimento invalida");
  			return;
  			//retorna 
  		}

  		
  		if(document.forms[0].rg.value == "" ){
  			alert("RG Invalido");
  			return;
  			//retorna 
  		}
  		if(document.forms[0].endereco.value == "" ){
  			alert("Endereco Invalido");
  			return;
  			//retorna 
  		}
  		
		cpf = document.forms[0].cpf.value;
		if(cpf != "" && !validaCPF(cpf)){
			alert("cpf invalido");
  			return;
		}
		
  		//se tudo legal submit!!
  		document.forms[0].submit();
  		
	}else
	{
	    alert("Preencha o Data");
	}

  }else{
  		alert("Preencha todos os campos!");
 }
 }
 


</script>
</body>
</html>
