<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@page import="org.br.apav.framework.DataUtility"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<jsp:useBean id="contato" scope="request" class="org.br.apav.model.Contato" />
<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />


<form action="contato.html" method="POST">
<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="codContato" value="<%=request.getParameter("codContato") %>">
<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">

    <div style="text-align: center" >
        <br />
        <span style="font-size: 16pt; text-decoration: underline">
       Cadastro Contato </span>
        <br />
        <br />
        <br />
        <table style="width:; height: 334px" border=0>
            <tr>
                <td style="width: 244px; text-align: right;">
                    Nome Contato:</td>
                <td style="width: 624px; text-align: left;">
                    <input id="nome" name="nome" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="contato" property="nome" />"  /></td>
            </tr>
            
            
            <tr>
                <td style="width: 244px; text-align: right;">
                    Parentesco:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="parentesco" name="parentesco" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="contato" property="parentesco" />"  /></td>
            </tr>
            


            <tr>
                <td style="width: 244px; text-align: right;">
                    Endereço:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="endereco" name="endereco" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="contato" property="endereco" />"  /></td>
            </tr>

            <tr>
                <td style="width: 244px; text-align: right;">
                    Bairro:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="bairro" name="bairro" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="contato" property="bairro" />"  /></td>
            </tr>

            <tr>
                <td style="width: 244px; text-align: right;">
                    Cidade:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="cidade" name="cidade" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="contato" property="cidade" />"  /></td>
            </tr>

            <tr>
                <td style="width: 244px; text-align: right;">
                    UF:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="uf" name="uf" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="contato" property="uf" />"  /></td>
            </tr>            

            <tr>
                <td style="width: 244px; text-align: right;">
                    Telefone Residencial:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="telefoneResidencial" name="telefoneResidencial" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="contato" property="telefoneResidencial" />"  /></td>
            </tr>            
            
            <tr>
                <td style="width: 244px; text-align: right;">
                   Telefone Celular:</td>
                <td style="width: 400px; text-align: left;">
                    <input id="telefoneCelular" name="telefoneCelular" style="width: 366px" type="text" 
                    value="<jsp:getProperty name="contato" property="telefoneCelular" />"  /></td>
            </tr>            
            
        </table>
        <br />
        <br />


    
    </div>
<table align="center">

	<tr align="center">
		<td align="center">
			<a href="javascript:submitLocal();" >Salvar</a>&nbsp;
			<a href="javascript:clearForm();"  >Limpar</a>&nbsp;
			<a href="javascript:history.go(-1);"  >Voltar</a>&nbsp;
		</td>
	</tr>			

</table>
</form>

<script>
function submitLocal(){
//validar campos aqui?
  //if(document.forms[0].mensagem.value != ''  ){
  		document.forms[0].submit();
  //}else{
  //		alert("Preencha todos os campos!");
  //}
}
</script>
</body>
</html>