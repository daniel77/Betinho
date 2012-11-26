<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>

<c:import url="/index.jsp" /><br>
<jsp:useBean id="crianca" scope="request" class="org.br.apav.model.Crianca" />
<jsp:useBean id="tratamento" scope="request" class="org.br.apav.model.Tratamento" />

<form action="tratamento.html" method="POST">

<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">

<input type='hidden' name="codCrianca" value="<%=request.getParameter("codCrianca") %>">
<input type='hidden' name="codTratamento" value="<%=request.getParameter("codTratamento") %>">

    <div style="text-align: center" >
        <br />
	 <span class="tituloEditar">
       Tratamento </span>
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
		<td class="labelEditar">CID 10</td>
		<td class="tdEstilo">
		
		<select name="cid10" <c:out value="${disabled}" /> >
			<c:forEach var="option" items="${cids}">
				<option value="<c:out value="${option.cid10}" />" >
				<c:out value="${option.descr}" /></option>
			</c:forEach>
		</select>
		
		</td>
	</tr>
         
        </table>
        <br />
        <br />


    	<suportweb:botoes/>    
    </div>
    

    
</form>

<script>
setSelected('cid10','<%=(String)request.getAttribute("cid10id")%>' );

function submitLocal(){

  		document.forms[0].submit();

}
</script>
</body>
</html>