<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="suportweb" prefix="suportweb"%>
<%@page import="org.br.apav.framework.DataUtility"%>

<c:import url="/index.jsp" /><br>


</head>
<body>

    <div style="text-align: center" >
        <br />
        <span class="tituloEditar">
       <%=request.getAttribute("mensagem") %>
       </span>
</body>
</html>