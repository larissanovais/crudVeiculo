package atividadeJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

	private static final String driver = "com.mysql.cj.jdbc.Driver"; 
 	private static final String url = "jdbc:mysql://localhost:3306/atividadejdbc";  	
 	private static final String user = "root";  	
 	private static final String password = ""; 
 	
 
 	public static Connection getConexao() { 
 	 	Connection conexao = null; 
 	 	 
 	 	try { 
 	 	 	Class.forName(driver); 
 	 	 	conexao = DriverManager.getConnection(url, user, password);
 
 	 	} catch (ClassNotFoundException | SQLException e) {  	 	 	
 	 		System.err.println("Erro na conexão com o banco de dados"); 
 	 		e.printStackTrace();
 	 	} 
 	 	return conexao; 
 	} 
 	
 	public static void closeConexao(Connection conexao) {
 		
 		try {
 			
 			if(conexao!= null)
 				conexao.close();
 			
 		} catch (Exception e){
 			System.out.println("Erro ao fechar a conexão");
 			e.printStackTrace();
 		}
 		
 	}

}
