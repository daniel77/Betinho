<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp" /><br>
<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />
<jsp:useBean id="pcr" scope="request" class="org.br.apav.model.PCR" />


<form action="pcr.html" method="POST">

<input type='hidden' name="perform" value="<%=request.getAttribute("event_") %>">
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">
<input type='hidden' name="codPCR" value="<jsp:getProperty name="pcr" property="codPCR" />">

    <div style="text-align: center" >
        <br />
        <span class="tituloEditar">
       Cadastro PCR </span>
        <br />
        <br />
        <br />
        <table style="width:; height: 334px" border=0>
            <tr>
                <td class="labelEditar" >
                    Nome Criança:</td>
                <td style="width: 624px; text-align: left;">
                <jsp:getProperty name="crianca" property="nome" /></td>
            </tr>
            
               <tr>
                <td class="labelEditar" >
                    Data do Exame:</td>
                <td class="tdEstilo">
                
                <input type="text"  id="data" name="data" class="inputtext"  style="width: 366px" type="text" 
			maxlength="10" size="12" onkeypress="return formataData(this,event);" value="<%=DataUtility.dateToString(pcr.getData())%>" />
                
            </tr>
            


            <tr>
                <td class="labelEditar" >
                    Resultado:</td>
                <td class="tdEstilo">
                <select name="pcr" >
                <option value="true">POSITIVO</option>  
                <option value="false">NEGATIVO</option>
                </select>
                    </td>
            </tr>
            
        </table>  
        
        <suportweb:botoes/>
    
    </div>

</form>

<script>
//NAO REMOVER POR FAVOR :-\
setSelected('pcr','<jsp:getProperty name="pcr" property="pcr" />' );

function submitLocal(){
	
		
  var erros = ""; 
  if(document.forms[0].data	.value != ''){
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
  	
  		//se tudo legal submit!!
  		document.forms[0].submit();
  		
  }else{
  		alert("Preencha a Data");
 }

 
}
</script>
</script>
</body>

</html>