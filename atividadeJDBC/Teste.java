package atividadeJDBC;

public class Teste {

	public static void main(String[] args) {
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		Veiculo v1 = new Veiculo("JKF-7071", "Azul", "Celta", "Luiz", 2015);
		Veiculo v2 = new Veiculo("JPM-8185", "Verde", "Fox", "Rodolfo", 2013);
		
		// Cadastrar
		veiculoDAO.cadastrarVeiculo(v1);
		veiculoDAO.cadastrarVeiculo(v2);
		
		// Imprimir
		veiculoDAO.imprimirVeiculo(v1);
		veiculoDAO.imprimirVeiculo(v2);
		
		
		// Atualizar
		v1.setCor("Prata");
		v1.setProprietario("Inácio");
		veiculoDAO.atualizarVeiculo(v1);
		
		
		veiculoDAO.deletarVeiculo("JKF-7071");	

	}

}
