package exercicios_poo.exe_produtos;

public class Fornecedor {
	private String cnpj; 
	private String nome; 
	private String produtos_fornecidos;
	
	public Fornecedor(String cnpj, String nome, String produtos_fornecidos) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.produtos_fornecidos = produtos_fornecidos;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProdutos_fornecidos() {
		return produtos_fornecidos;
	}

	public void setProdutos_fornecidos(String produtos_fornecidos) {
		this.produtos_fornecidos = produtos_fornecidos;
	}

	@Override
	public String toString() {
		return "cnpj=" + cnpj + ", nome=" + nome + ", produtos_fornecidos=" + produtos_fornecidos;
	}

	
}
