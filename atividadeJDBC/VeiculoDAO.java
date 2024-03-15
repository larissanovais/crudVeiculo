package atividadeJDBC;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 

public class VeiculoDAO { 
 	 
	public void imprimirVeiculo (Veiculo veiculo) {
 	 	 
		Connection conexao = ConexaoDAO.getConexao(); 
 	 	String sql = "SELECT * FROM TBL_VEICULO"; 
 	 	 
 	 	try { 
 	 	 	
 	 	 	PreparedStatement ps = conexao.prepareStatement(sql); 
 	 	 	ResultSet rs = ps.executeQuery();
 	 	 	 
 	 	 	if (rs.next()) { 
 	 	 		int id_veiculo = rs.getInt("Id_veiculo");
 	 	 		String placa = rs.getString("Placa"); 
 	 	 		String cor = rs.getString("Cor"); 
 	 	 	 	String modelo = rs.getString("Modelo");
 	 	 	 	int ano = rs.getInt("Ano");
 	 	 	 	String proprietario = rs.getString("Proprietario");
 	 	 	 	 
 	 	 	 	System.out.printf("Id: %d, Placa: %s, Cor: %S, Modelo: %s, Ano: %d, Proprietário: %s", id_veiculo, placa,  
 	 	 	 	cor, modelo, ano, proprietario); 
 	 	 	 	System.out.println("");
 	 	 	} 
 	 	 	 
 	 	} catch (SQLException e) { 
 	 	 	System.err.println("Falha ao imprimir clientes: " +  
 	 	 	e.getMessage()); 
 	 	} finally {
 	 		ConexaoDAO.closeConexao(conexao);
 	 	}

	}
	
	
 	public void cadastrarVeiculo (Veiculo veiculo) { 
 	 	
 		Connection conexao = ConexaoDAO.getConexao(); 
 	 	String sql = "INSERT INTO TBL_VEICULO (ID_VEICULO, COR, PLACA, MODELO, ANO, PROPRIETARIO) VALUES (?, ?, ?, ?, ?, ?)"; 
 	 	 
 	 	try {
 	 		 	 
 	 	 	PreparedStatement ps = conexao.prepareStatement(sql);
 	 	 	ps.setInt(1, veiculo.getIdVeiculo());
 	 	 	ps.setString(2, veiculo.getCor());
 	 	 	ps.setString(3, veiculo.getPlaca());
 	 	 	ps.setString(4, veiculo.getModelo());
 	 	 	ps.setInt(5, veiculo.getAno());
 	 	 	ps.setString(6, veiculo.getProprietario());
 	 	 	ps.executeUpdate();
 	 	 	
 	 	 	System.out.println("Cadastrado.");
 	 	 	 
 	 	} catch (SQLException e) { 
 	 	 	System.err.println("Falha ao cadastrar veículo: " +  
 	 	 	e.getMessage()); 
 	 	} finally {
 	 		ConexaoDAO.closeConexao(conexao);
 	 	}
 	 	 
 	 } 
 	
 	
 	public void atualizarVeiculo (Veiculo veiculo) {
 		
 		Connection conexao = ConexaoDAO.getConexao(); 
 		String sql = "UPDATE TBL_VEICULO SET COR=?, PROPRIETARIO=? WHERE PLACA=?";
 		
 		try {
 			 
 	 	 	PreparedStatement ps = conexao.prepareStatement(sql); 
 	 	 	ps.setString(1, veiculo.getCor());
 	 	 	ps.setString(2, veiculo.getProprietario());
 	 	 	ps.setString(3, veiculo.getPlaca());
 	 	 	
 	 	 	ps.executeUpdate();
 	 	 	
 		} catch (SQLException e) { 
 	 	 	System.err.println("Falha ao atualizar veículo: " +  
 	 	 	e.getMessage()); 
 	 	} finally {
 	 		ConexaoDAO.closeConexao(conexao);
 	 	}
 		
 	}
 	
 	
 	public void deletarVeiculo (String placa) {
 		
 		Connection conexao = ConexaoDAO.getConexao(); 
 		String sql = "DELETE FROM tbl_veiculo WHERE placa=?";
 		
 		try {
 			 
 	 	 	PreparedStatement ps = conexao.prepareStatement(sql); 
 	 	 	ps.setString(1, placa);
 	 	 	
 	 	 	ps.executeUpdate();
 	 	 	
 		} catch (SQLException e) { 
 	 	 	System.err.println("Falha ao atualizar veículo: " +  
 	 	 	e.getMessage()); 
 	 	} finally {
 	 		ConexaoDAO.closeConexao(conexao);
 	 	}
 		
 	}
 	
} 

