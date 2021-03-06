package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DAO {

	private Connection connection = null;

	public DAO() {
		String url = System.getenv("mysql_url");
		System.out.println(url);
		String user = System.getenv("mysql_user");
		System.out.println(user);
		String password = System.getenv("mysql_password");
		System.out.println(password);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
//			connection = DriverManager.getConnection(
//					"jdbc:mysql://localhost/projeto1?useTimezone=true&serverTimezone=UTC","root","lulu0147"); 
			connection = DriverManager.getConnection("url","user","password"); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Clients> getClientes(Integer lojaid) {

		List<Clients> clients = new ArrayList<Clients>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM CadastroCliente where lojaid=?");
			ResultSet rs = null;
			stmt.setInt(1, lojaid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Clients client = new Clients();
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("Nome"));
				client.setBirth(rs.getString("Nascimento"));
				client.setCPF(rs.getString("CPF"));
				client.setAdress(rs.getString("Endere�o"));
				client.setCelphone(rs.getString("Celular"));
				clients.add(client);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;

	}
	
	public List<Clients> ShowData(Integer id) {

		List<Clients> clients = new ArrayList<Clients>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM CadastroCliente WHERE id=?");
			stmt.setLong(1, id);
			ResultSet rs = null;
			rs = stmt.executeQuery();
			while (rs.next()) {
				Clients data = new Clients();
				data.setId(rs.getInt("id"));
				data.setName(rs.getString("Nome"));
				data.setBirth(rs.getString("Nascimento"));
				data.setCPF(rs.getString("CPF"));
				data.setAdress(rs.getString("Endere�o"));
				data.setCelphone(rs.getString("Celular"));
				clients.add(data);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;

	}
	
	public void remove(Integer id) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("DELETE FROM CadastroCliente WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	public void adiciona(Clients client) {
		String sql = "INSERT INTO CadastroCliente" + "(Nome,Nascimento,CPF,Endere�o,Celular, lojaid) values(?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getBirth());
			stmt.setString(3, client.getCPF());
			stmt.setString(4, client.getAdress());
			stmt.setString(5, client.getCelphone());
			stmt.setInt(6, client.getUserid());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public void altera(Clients cliente) {
		String sql = "UPDATE CadastroCliente SET " +
		 "Nome=?, Nascimento=?, CPF=?,Endere�o=?, Celular=? WHERE id=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		
			stmt.setString(1, cliente.getName());
		
			stmt.setString(2, cliente.getBirth());
		
			stmt.setString(3, cliente.getCPF());
		
			stmt.setString(4, cliente.getAdress());
		
			stmt.setString(5, cliente.getCelphone());
		
			stmt.setInt(6, cliente.getId());
		
			stmt.execute();
		
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	
	
	public Loja checkLogin(String login , String senha){
		PreparedStatement stmt = null;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM login Where login=? AND senha=?");
			
			stmt.setString(1,login);
			stmt.setString(2,senha);
			ResultSet rs = null;
			rs = stmt.executeQuery();
			while (rs.next()) {
				
			Loja User = new Loja();
			User.setName(rs.getString("login"));
			User.setPassword(rs.getString("senha")); 
			return User;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int lojaId(String login , String senha){
		int id = 0;
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT id FROM login WHERE "
					+ "login = ? AND senha = ?");
			stmt.setString(1,login);
			stmt.setString(2,senha);
			ResultSet rs = null;
			rs = stmt.executeQuery();
			while (rs.next()) {
				
				id = rs.getInt("id");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
		
		
	}
	
	
	
	
	public void adicionaLoja(Loja loja) {
		String sql = "INSERT INTO login" +
		"(login,senha,confirmarSenha) values(?,?,?)";
		
		PreparedStatement stmt = null;
		try {
			System.out.println("teste");
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, loja.getName());
			stmt.setString(2, loja.getPassword());
			stmt.setString(3, loja.getConfirmPassword());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


	public void close() {
	
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
