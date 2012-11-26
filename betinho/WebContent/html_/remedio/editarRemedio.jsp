<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<c:import url="/index.jsp" /><br>
<jsp:useBean id="remedio" scope="request" class="org.br.apav.model.Remedio" />


<form action="remedio.html" method="POST">

<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="codRemedio" value="<%=request.getParameter("codRemedio") %>" >

    <div style="text-align: center" >
        <br />
	 <span class="tituloEditar">
       Cadastro Remédio </span>
        <br />
        <br />
        <br />
        <table style="width:; height: 334px" border=0>
             <tr>
				<td class="labelEditar" >
                    EAN:</td>
                 <td class="tdEstilo">
                    <input id="EAN" name="EAN" class="inputtext" type="text"  <c:out value="${disabled}" />
                    onkeypress='return verificaNro( event );' maxlength="5"
                    value="<jsp:getProperty name="remedio" property="EAN" />"  /></td>
             </tr>
            <tr>
				<td class="labelEditar" >
                    Descrição:</td>
                 <td class="tdEstilo">
                    <input id="descricao" name="descricao" class="inputtext" type="text" <c:out value="${disabled}" />
                    value="<jsp:getProperty name="remedio" property="descricao" />"  /></td>
             </tr>
             <tr>       
				<td class="labelEditar" >
				Formula:</td>
                <td class="tdEstilo">
                    <input id="formula" name="formula" class="inputtext" type="text" <c:out value="${disabled}" />
                    value="<jsp:getProperty name="remedio" property="formula" />"  /></td>            
             </tr>
             <tr>       
	            <td class="labelEditar" >
    			Quantidade Embalagem :</td>
               <td class="tdEstilo">
                    <input id="qtdeEmbalagem" name="qtdeEmbalagem" class="inputtext" type="text" 
                    value="<jsp:getProperty name="remedio" property="qtdeEmbalagem" />"   <c:out value="${disabled}" /> 
                    onkeypress='return verificaNro( event );'  maxlength="4"/></td>
           	  </tr>
           	  <tr>
				<td class="labelEditar" >
    			Tipo Quantidade:</td>
              	<td class="tdEstilo">
                    <input id="tipoQtde" name="tipoQtde" class="inputtext" type="text"  maxlength="5" 
                    value="<jsp:getProperty name="remedio" property="tipoQtde" />" <c:out value="${disabled}" /> /></td>
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
  if(document.forms[0].EAN.value != ''){

  		if(document.forms[0].descricao.value == "" ){
  		
  			alert("Campo Descricao obrigatorio");
  			return;
  			//retorna 
  		}
  		
  		 if(document.forms[0].formula.value == "" ){
  		
  			alert("Campo Formula obrigatorio");
  			return;
  			//retorna 
  		}

  		 if(document.forms[0].qtdeEmbalagem.value == "" ){
  		
  			alert("Campo Quantidade Embalagem obrigatorio");
  			return;
  			//retorna 
  		}

  		 if(document.forms[0].tipoQtde.value == "" ){
  		
  			alert("Campo Tipo Quantidade obrigatorio");
  			return;
  			//retorna 
  		}
  		//se tudo legal submit!!
  		document.forms[0].submit();
  		
  }else{
  		alert("Campo EAN Obrigatório");
 }
}
</script>
</body>
</html>