package mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc.model.Clients;
import mvc.model.DAO;

@Controller
public class ClientsController {

	@RequestMapping("addClient")
	public String form() {
		return "addClient";
	}

	@RequestMapping("adicionaCliente")
	public String adiciona(Clients cliente, HttpSession session) {

		DAO dao = new DAO();
		int id = (int) session.getAttribute("lojaid");
		System.out.println(id);
		cliente.setUserid(id);
		dao.adiciona(cliente);
		dao.close();
		return "redirect:listaCliente";

	}
	

	@RequestMapping(value = "listaCliente", method = RequestMethod.GET)
	public String lista(HttpSession session) {

		DAO dao = new DAO();
		int lojaid = (int) session.getAttribute("lojaid");
		List<Clients> clientes = dao.getClientes(lojaid);
		session.setAttribute("clientes", clientes);

		
		return "lista";

	}
	
	@RequestMapping("editarCliente")
	public String editar(Clients cliente, HttpSession session) {

		DAO dao = new DAO();
		int id = cliente.getId();
		System.out.println(id);
		List<Clients> clientes = dao.ShowData(id);
		session.setAttribute("clientes", clientes);

		
		return "ClientData";

	}
	
	@RequestMapping("removerCliente")
	public String remover(Clients cliente) {

		DAO dao = new DAO();
		dao.remove(cliente.getId());
		return "redirect:listaCliente";
	

	}
	
	@RequestMapping("update")
	public String update(Clients cliente) {

		DAO dao = new DAO();
		dao.altera(cliente);
		return "redirect:listaCliente";
		

	}

}
