package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
	
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			// Sempre atualizar o banco de dados com uma restrição
			// se n todo o banco sera atualizado
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Prontoooo : " + rowsAffected);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			DB.closeStatement(st);
			// Sempre fechar a conexão por ultimo
			DB.closeConnection();
		}
		
		
		
	}	
}
