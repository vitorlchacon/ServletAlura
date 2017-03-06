package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Cookie cookieUsuario = new Cookies(req.getCookies()).getUsuarioLogado();
		req.getSession().removeAttribute("usuario.logado");
		//if (cookieUsuario == null) {
		//	writer.println("<html><body>O usuário não estava logado!</body></html>");
		//	return;
		//}
		//resp.addCookie(cookieUsuario);
		resp.getWriter().println("<html><body>Deslogado com sucesso!</body></html>");
	}

}
