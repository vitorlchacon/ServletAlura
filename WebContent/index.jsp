<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}">
	Logado como ${usuarioLogado.email}
</c:if>

<form action="novaEmpresa" method="POST">
	Nome: <input type="text" name="nome">
	<input type="submit" value="Enviar">
</form>

<form action="login" method="POST">
	E-mail: <input type="text" name="email">
	Senha : <input type="password" name="senha">
	<input type="submit" value="Enviar">
</form>

<form action="fazTudo" method="POST">
	<input type="hidden" name="tarefa" value="Logout">
	<input type="submit" value="Logoff">
</form>
</body>
</html>