package techWebP1;

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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/projeto1?useTimezone=true&serverTimezone=UTC","root","lulu0147"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Clients> getClientes() {

		List<Clients> clients = new ArrayList<Clients>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM CadastroCliente");
			ResultSet rs = null;
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
		String sql = "INSERT INTO CadastroCliente" + "(Nome,Nascimento,CPF,Endere�o,Celular) values(?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getBirth());
			stmt.setString(3, client.getCPF());
			stmt.setString(4, client.getAdress());
			stmt.setString(5, client.getCelphone());
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
	


	public void close() {
	
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
