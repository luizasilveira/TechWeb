package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import techWebP1.DAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
			String usuario = request.getParameter("username");
			String senha = request.getParameter("password");

			
			Loja login = dao.checkLogin(usuario, senha);
			if (login == null) {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			
			} else {
				int lojaid = 0;
				lojaid = dao.lojaId(usuario, senha);
				
				request.setAttribute("lojaid", lojaid);
				request.setAttribute("nome", usuario);
				
				HttpSession session = request.getSession(true);
				session.setAttribute("lojaid", lojaid);
				response.sendRedirect(request.getContextPath()+"/add.html");
		        
			}
			
			
			
					
			
		
		}		
	}


