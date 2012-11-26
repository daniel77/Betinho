
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>


<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>

<style type="text/css">

      *{

            font-family: Verdana, Arial;

      }

      table{

            background-color: #EEEEEE;

            border: solid #CCCCCC 1px;

      }

      th{

            background-color: #CCCCCC;

            color: #FFFFFF;

      }

      .campo{

            border: solid #CCCCCC 1px;

      }

</style>

</head>

<body>

<form method="POST" action="login.html">
<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>
		<title>Betinho</title>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<meta name="Author" content="Ci&amp;T - SPI Team">
		<meta name="GENERATOR" content="Mozilla/4.7 [en] (WinNT; I) [Netscape]">
		<link rel="Stylesheet" media="screen" title="Style" href="../styles/cit_docs.css">
		<!-- page color & background setup -->
	</head>

	<body text="#000088" bgcolor="#ffffff" link="#cc0000" vlink="#660066" alink="#660066">
		<div CLASS="coverbottom" ALIGN="center"><img SRC="imagens/capa.jpg" height="350" width="500">
			<hr NOSHADE ALIGN="center" WIDTH="70%">
		</div>
	</body>

      <td> Login: </td>
      <td><input class="campo" type="text" name="login" /></td>

      <td>Senha: </td>
      <td><input class="campo" type="password" name="senha" /></td>
      <%  String[] erros = {"Usuario ou senha incorretos!", "Você não está logado!"};
                String erro = (String)request.getAttribute("erro");
                if(erro!=null){%>

<td style="color: #FF0000" colspan="2"><%=erros[Integer.parseInt(erro)-1]
          %></td>

<% } %>



<td colspan="2" align="center"><input type="submit" value="Entrar" /></td>

</html>
</form>
<script>
document.forms[0].login.focus();
</script>
</body>

</html>