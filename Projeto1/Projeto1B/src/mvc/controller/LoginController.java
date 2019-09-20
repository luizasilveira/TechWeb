package mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.model.Loja;
import mvc.model.DAO;

@Controller
public class LoginController {
	
	@RequestMapping("Cadastroloja")
	public String form() {
		return "Cadastro";
		
	}
	
	@RequestMapping(value = "efetuaCadastro", method = RequestMethod.POST)
	public String form1(Loja loja) {
		DAO dao = new DAO();
		String user = loja.getName();
		String senha = loja.getPassword();
		String cnfSenha = loja.getConfirmPassword();

		if (!senha.equals(cnfSenha)) {

			return "Cadastroloja";
		
		}
		else {
			loja.setName(user);
			loja.setPassword(senha);
			loja.setConfirmPassword(cnfSenha);
			dao.adicionaLoja(loja);
			dao.close();
			return "redirect:Login";
			
			
		}
		
	}
	
	@RequestMapping("Login")
	public String login() {
		return "login";
		
	}

	@RequestMapping(value = "efetuaLogin", method = RequestMethod.POST)
	public String efetuaLogin(Loja loja, HttpSession session) {
		DAO dao = new DAO();
		String usuario = loja.getName();
		String senha = loja.getPassword();
		Loja login = dao.checkLogin(usuario, senha);
		if (login == null) {
			return "Login";
		
		} else {
			int lojaid = 0;
			lojaid = dao.lojaId(usuario, senha);
			System.out.println(lojaid);
			
			session.setAttribute("lojaid", lojaid);
			return "redirect: addClient";
	        
		}
		
		
	}

}
