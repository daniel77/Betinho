<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp" /><br>
<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />


<form action="crianca.html" method="POST">

<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">

    <div style="text-align: center" >
        <br />
        <span class="tituloEditar">
       Cadastro Criança </span>
        <br />
        <br />
        <br />
        <table style="width:; height: 334px" border=0>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                    <input id="nome" name="nome" class="inputtext" type="text" size="60"
                    value="<jsp:getProperty name="crianca" property="nome" />"  /></td>
            </tr>
            
            
            <tr>
                <td class="labelEditar" >
                    Data Nacimento:</td>
                <td class="tdEstilo">
                
                <input type="text"  id="dataNascimento" name="dataNascimento" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(crianca.getDataNascimento())%>" />
                
            </tr>
            


            <tr>
                <td class="labelEditar" >
                    Nome do Pai:</td>
                <td class="tdEstilo">
                    <input id="nomePai" name="nomePai"  class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="nomePai" />"  /></td>
            </tr>

            <tr>
                <td class="labelEditar" >
                    Nome da Mãe:</td>
                <td class="tdEstilo">
                    <input id="nomeMae" name="nomeMae" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="nomeMae" />"  /></td>
            </tr>

            <tr>
                <td class="labelEditar" >
                    Nome da Avó Materno:</td>
                <td class="tdEstilo">
                    <input id="avoMaterno" name="avoMaterno" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="avoMaterno" />"  /></td>
            </tr>

            <tr>
                <td class="labelEditar" >
                    Nome da Avó Paterno:</td>
                <td class="tdEstilo">
                    <input id="avoPaterno" name="avoPaterno" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="avoPaterno" />"  /></td>
            </tr>            

            <tr>
                <td class="labelEditar" >
                    Nome do Avô Materno:</td>
                <td class="tdEstilo">
                    <input id="avohMaterno" name="avohMaterno" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="avohMaterno" />"  /></td>
            </tr>            
            
            <tr>
                <td class="labelEditar" >
                    Nome do Avô Materno:</td>
                <td class="tdEstilo">
                    <input id="avohPaterno" name="avohPaterno" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="avohPaterno" />"  /></td>
            </tr>            
            
            <tr>
                <td class="labelEditar" >
                    Encaminhado por:</td>
                <td class="tdEstilo">
                    <input id="encaminhadoPor" name="encaminhadoPor" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="encaminhadoPor" />"  /></td>
            </tr>            

            <tr>
                <td class="labelEditar" >
                    Data de Abrigamento :</td>
                <td class="tdEstilo">
                
                               <input type="text"  id="dataAbrigamento" name="dataAbrigamento" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(crianca.getDataAbrigamento())%>" />
            </td>
            </tr>            
            
            <tr>
                <td class="labelEditar" >
                    Data de Desabrigamento :</td>
                <td class="tdEstilo">
                
                              <input type="text"  id="dataDesabrigamento" name="dataDesabrigamento" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(crianca.getDataDesabrigamento())%>" />
			                </td>
            </tr>            

            <tr>
                <td class="labelEditar" >
                    Motivo Desabrigamento:</td>
                <td class="tdEstilo">
                    <input id="motivoDesabrigamento" name="motivoDesabrigamento" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="motivoDesabrigamento" />"  /></td>
            </tr>            
            
            <tr>
                <td class="labelEditar" >
                    Certidão de Nascimento:</td>
                <td class="tdEstilo">
                    <input id="certidaoNascimento" name="certidaoNascimento" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="certidaoNascimento" />"  /></td>
            </tr>            

            <tr>
                <td class="labelEditar" >
                    RG:</td>
                <td class="tdEstilo">
                    <input id="rg" name="rg" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="rg" />" 
                    onkeypress='return verificaNro( event );' /></td>
            </tr>            
            
            <tr>
                <td class="labelEditar" >
                    CPF:</td>
                <td class="tdEstilo">
                    <input id="cpf" name="cpf" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="cpf" />"
                    onkeypress="return formataCPF(cpf, event );"   /></td>
            </tr>            

            <tr>
                <td class="labelEditar" >
                    Sexo:</td>
                <td class="tdEstilo">
                    <input id="sexo" name="sexo" class="inputtext" type="radio" 
                    value="M" <% if("M".equals(crianca.getSexo())){out.print("CHECKED");}%>  />Masc.
                   <input id="sexo" name="sexo" class="inputtext" type="radio" 
                    value="F" <% if("F".equals(crianca.getSexo())){out.print("CHECKED");}%> />Fem. </td>
            </tr>            

            <tr>
                <td class="labelEditar" >
                    Cidade:</td>
                <td class="tdEstilo">
                    <input id="cidade" name="cidade" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="cidade" />"  /></td>
            </tr>                                    

            <tr>
                <td class="labelEditar" >
                    Estado:</td>
                <td class="tdEstilo">
                    <input id="uf" name="uf" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="uf" />"  /></td>
            </tr>                                    

            <tr>
                <td class="labelEditar" >
                    Carteira do HC:</td>
                <td class="tdEstilo">
                    <input id="carteiraHc" name="carteiraHc" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="carteiraHc" />"  /></td>
            </tr>                                    

            <tr>
                <td class="labelEditar" >
                    Carteira do SUS:</td>
                <td class="tdEstilo">
                    <input id="carteiraSus" name="carteiraSus" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="carteiraSus" />"  /></td>
            </tr>                                    

            <tr>
                <td class="labelEditar" >
                    Tipo Sanguineo:</td>
                <td class="tdEstilo">
                    <input id="tipoSanguineo" name="tipoSanguineo" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="tipoSanguineo" />"  /></td>
            </tr>                                    

            <tr>
                <td class="labelEditar" >
                    Fator RH:</td>
                <td class="tdEstilo">
                    <input id="fatorRh" name="fatorRh" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="fatorRh" />"  /></td>
            </tr>                                    

            <tr>
                <td class="labelEditar" >
                    Cartório:</td>
                <td class="tdEstilo">
                    <input id="cartorio" name="cartorio" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="cartorio" />"  /></td>
            </tr>                                    

            <tr>
                <td class="labelEditar" >
                    Email:</td>
                <td class="tdEstilo">
                    <input id="email" name="email" class="inputtext" type="text" 
                    value="<jsp:getProperty name="crianca" property="email" />"  /></td>
            </tr>            
          
        </table>
        <br />
        <br />


    	<suportweb:botoes/>  
    
    </div>

</form>

<script>

function submitLocal(){
	
		
	var erros = ""; 
  if(document.forms[0].nome.value != ''){

  		//pega o atributo do form 
  		dataNascimemto = document.forms[0].dataNascimento.value;
  		dataAbrigamento = document.forms[0].dataAbrigamento.value;
		dataDesabrigamento = document.forms[0].dataDesabrigamento.value;
  		
  		//funcao para validacao ver scripts.js
  		if(!validaData(dataNascimemto)){
  		
  			alert("Data de nascimento invalida");
  			return;
  			//retorna 
  		}
  		
  		if(dataAbrigamento != "" && !validaData(dataAbrigamento)){
  		
  			alert("Data de abrigamento invalida");
  			return;
  			//retorna 
  		}
  		
  		if(dataDesabrigamento!= "" && !validaData(dataDesabrigamento)){
  		
  			alert("Data de Desabrigamento invalida");
  			return;
  			//retorna 
  		}
  		
  		
		if((dataDesabrigamento!= "" && dataAbrigamento!= "")
		 &&(validaDatas(dataDesabrigamento,dataAbrigamento))){
			alert("a data de desabrigamento não pode ser menor que a data de abrigamento");
			return;
		}
  		
		cpf = document.forms[0].cpf.value;
		if(cpf != "" && !validaCPF(cpf)){
			alert("cpf invalido");
  			return;
		}
		
  		//se tudo legal submit!!
  		document.forms[0].submit();
  		
  }else{
  		alert("Preencha o nome");
 }
}
</script>
</body>


</html>