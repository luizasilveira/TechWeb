package br.edu.insper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import techWebP1.Clients;
import techWebP1.DAO;

/**
 * Servlet implementation class AddLoja
 */
@WebServlet("/AddLoja")
public class AddLoja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLoja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		DAO dao = new DAO();
		Loja loja = new Loja();
		String user = request.getParameter("username");
		String senha = request.getParameter("password");
		String cnfSenha = request.getParameter("ConfirmPassword");

		if (!senha.equals(cnfSenha)) {

			response.sendRedirect(request.getContextPath()+"/Cadastro.jsp");
		
		}
		else {
			loja.setName(user);
			loja.setPassword(senha);
			loja.setConfirmPassword(cnfSenha);
			dao.adicionaLoja(loja);
			dao.close();
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			
			
		}
				
			}
	

		
	}


