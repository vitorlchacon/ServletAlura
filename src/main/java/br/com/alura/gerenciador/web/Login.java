package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {
	
	//final static Map<String, Usuario> USUARIOS_LOGADOS = new HashMap<>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if(usuario == null){
			resp.getWriter().println("<html><body>Usuario inválido!</body></html>");
		} else {
			//String codigoAleatorio = "" + System.currentTimeMillis() + "/" + Math.random();
			//USUARIOS_LOGADOS.put(codigoAleatorio,usuario);
			//Cookie cookie = new Cookie("usuario.logado", codigoAleatorio);
			//cookie.setMaxAge(600);
			//resp.addCookie(cookie);
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);
			resp.getWriter().println("<html><body>Bem-vindo "+ usuario.getEmail() +"!</body></html>");
		}
	}

}
	