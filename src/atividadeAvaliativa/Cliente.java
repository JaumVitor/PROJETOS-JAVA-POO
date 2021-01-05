package atividadeAvaliativa;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String documento;
	private ArrayList<Veiculo> veiculosAlugados = new ArrayList<>(); 
	
	public Cliente(String nome, String documento) {
		this.nome = nome;
		this.documento = documento;
	}
	
	public boolean pesquisarVeiculoAlugado (Veiculo veiculo) {
		//Vai pecorrer a lista procurando veiculos que foram alugados pelo cliente
		return veiculosAlugados.contains(veiculo); 
	}
	
	public Veiculo pesquisarVeiculoAlugado (String placa) {
		//Vai pecorrer a lista procurando veiculos que foram alugados pelo cliente
		for (Veiculo veiculo : veiculosAlugados) {
			if (veiculo.getPlaca() == placa) {
				return veiculo;
			}
		}
		return null; 
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public ArrayList<Veiculo> getVeiculosAlugados() {
		return veiculosAlugados;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		return true;
	}
	
}
