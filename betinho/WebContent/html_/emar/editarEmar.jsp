<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@page import="org.br.apav.framework.DataUtility"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<c:import url="/index.jsp"></c:import>

<jsp:useBean id="emar" scope="request" class="org.br.apav.model.Emar" />
<jsp:useBean id="crianca" scope="request"
	class="org.br.apav.model.Crianca" />


<form action="emar.html" method="POST"><input type='hidden'
	name="perform" value="<%=request.getParameter("event") %>"> <input
	type='hidden' name="codEmar"
	value="<%=request.getParameter("codEmar") %>">
	 <input
	type='hidden' name="codCrianca"
	value="<%=request.getParameter("codCrianca") %>">

<div style="text-align: center"><br />
<span class="tituloEditar"> Cadastro Emar </span> <br />
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
		<td class="labelEditar">Data Inicio:</td>
		<td class="tdEstilo"><input type="text" id="dataInicio"
			name="dataInicio" class="inputtext" style="width: 366px" type="text"
			maxlength="10" size="12" onkeypress="return formataData(this,event);"
			value="<%=DataUtility.dateToString(emar.getDataInicio())%>" />
	</tr>

	<tr>
		<td class="labelEditar">Data Fim:</td>
		<td class="tdEstilo"><input type="text" id="dataFim"
			name="dataFim" class="inputtext" style="width: 366px" type="text"
			maxlength="10" size="12" onkeypress="return formataData(this,event);"
			value="<%=DataUtility.dateToString(emar.getDataFim())%>" />
	</tr>
	<tr>
		<td class="labelEditar">medicamento:</td>
		<td class="tdEstilo">
		<select name="remedio1">
			<c:forEach var="option" items="${remedios}">
				<option value="<c:out value="${option.codRemedio}" />" >
				<c:out value="${option.descricao}" /></option>
			</c:forEach>
		</select>
		</td>
	</tr>	
		
	<tr>
		<td class="labelEditar">medicamento:</td>
		<td class="tdEstilo">
		<select name="remedio2">
			<c:forEach var="option" items="${remedios}">
				<option value="<c:out value="${option.codRemedio}" />" >
				<c:out value="${option.descricao}" /></option>
			</c:forEach>
		</select>
		</td>
	</tr>
	
	<tr>
		<td class="labelEditar">medicamento:</td>
		<td class="tdEstilo">
		<select name="remedio3">
			<c:forEach var="option" items="${remedios}">
				<option value="<c:out value="${option.codRemedio}" />" >
				<c:out value="${option.descricao}" /></option>
			</c:forEach>
		</select>
		</td>
	</tr>



            <tr>
                <td class="labelEditar" >
                    Ativo:</td>
                <td class="tdEstilo">
                <select name="ativo" >
                <option value="true">SIM</option>  
                <option value="false">NÃO</option>
                </select>
                    </td>
            </tr>

	<!--<tr>
		<td class="labelEditar">CID 10</td>
		<td class="tdEstilo">
		
		<select name="cid10">
			<c:forEach var="option" items="${cids}">
				<option value="<c:out value="${option.cid10}" />" >
				<c:out value="${option}" /></option>
			</c:forEach>
		</select>
		
		</td>
	</tr>


--></table>
<br />
<br />

</div>

       <suportweb:botoes/>


</form>
<script>
<%int i =0; %>
<c:forEach var="option" items="${emar.remedios}">
setSelected('remedio<%=++i%>','<c:out value="${option.codRemedio}" />' );
</c:forEach>


setSelected('ativo','<jsp:getProperty name="emar" property="ativo" />' );








function submitLocal(){
//VALIDAR DATAS


		  		//pega o atributo do form 
  		dataInicio = document.forms[0].dataInicio.value;
  		dataFim = document.forms[0].dataFim.value;  		
  		
  		//funcao para validacao ver scripts.js
  		if(!validaData(dataInicio)){
	  		alert("Data de inicio invalida");
  			return;
  			//retorna 
  		}
  		
  		if(!validaData(dataFim)){
	  		alert("Data de final invalida");
  			return;
  			//retorna 
  		}

		if(validaDatas(dataInicio,'<%=crianca.getDataNascimentoStr()%>')){
			alert("a data de inicio do emar não pode ser menor que a data de nascimento da criança <%=crianca.getDataNascimentoStr()%>!");
			return;
		}
  		
  		
		if(!validaDatas(dataInicio,dataFim)){
			alert("a data final da medicação não pode ser menor que a data inicial");
			return;
		}

 		document.forms[0].submit();

 }
 

</script>
</body>
</html>
