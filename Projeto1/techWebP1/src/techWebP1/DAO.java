package techWebP1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {

	private Connection connection = null;

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/projeto1", "root", "lulu0147");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Clientes> getClientes() {

		List<Clientes> pessoas = new ArrayList<Clientes>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM cadastroClientes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				Clientes cliente = new Clientes();
				cliente.setId(rs.getInt("id"));
				cliente.setName(rs.getString("name"));
				cliente.setAdress(rs.getString("adress"));
				cliente.setCelphone(rs.getString("celphone"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("birth"));
				cliente.setBirth(data);
				pessoas.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pessoas;

	}
}
