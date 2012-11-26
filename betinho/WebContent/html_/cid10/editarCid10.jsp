<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp" /><br>
<jsp:useBean id="cid10" scope="request" class="org.br.apav.model.Cid10" />


<form action="cid10.html" method="POST">

<input type='hidden' name="perform" value="<%=request.getParameter("event") %>">
<input type='hidden' name="cid10" value="<%=request.getParameter("cid10") %>">

    <div style="text-align: center" >
        <br />
	 <span class="tituloEditar">
       Cadastro Cid10 </span>
        <br />
        <br />
        <br />
        <table style="width:; height: 334px" border=0>
         
             <tr>
				<td class="labelEditar" >
    	            Cid10:</td>
                                <td class="tdEstilo">
                    <input id="cid10" name="cid10" class="inputtext" type="text"
                    value="<jsp:getProperty name="cid10" property="cid10" />"  /></td>
           	  </tr>
           	  
           	     <tr>
				<td class="labelEditar" >
    	            opc:</td>
                                <td class="tdEstilo">
                    <input id="opc" name="opc" class="inputtext" type="text"
                    value="<jsp:getProperty name="cid10" property="opc" />"  /></td>
           	  </tr>
           	  
           	     <tr>
				<td class="labelEditar" >
    	            cat:</td>
                                <td class="tdEstilo">
                    <input id="cat" name="cat" class="inputtext" type="text"
                    value="<jsp:getProperty name="cid10" property="cat" />"  /></td>
           	  </tr>
           	  
           	  
           	  <tr>
           	 	<td class="labelEditar" >
    	            subcat:</td>
                               <td class="tdEstilo">
                    <input id="subcat" name="subcat" class="inputtext" type="text" 
                    value="<jsp:getProperty name="cid10" property="subcat" />"  /></td>
              </tr>
              
              <tr>
               <td class="labelEditar" >
    	           descr:</td>
                              <td class="tdEstilo">
                    <input id="descr" name="descr" class="inputtext" type="text" 
                    value="<jsp:getProperty name="cid10" property="descr" />"  /></td>
			 </tr>

              <tr>
               <td class="labelEditar" >
    	           restrsexo:</td>
                              <td class="tdEstilo">
                    <input id="restrsexo" name="restrsexo" class="inputtext" type="text" 
                    value="<jsp:getProperty name="cid10" property="restrsexo" />"  /></td>
			 </tr>              
                  		
        </table>
        <br />
        <br />


    	<suportweb:botoes/>    
    </div>
    

    	
    	
</form>

<script>
function submitLocal(){

  if(document.forms[0].descr.value != ''){
  		  		  		document.forms[0].submit();
  }else{
  		alert("Preencha todos os campos!");
 }
 }
 

</script>
</body>
</html>