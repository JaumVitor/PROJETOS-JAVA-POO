package exercicios_poo.exe_produtos;

public class Produto {
	//Atributos da classe
	private String descricao; 
	
	private int codigo; 
	private int quant; 
	private int estoque_minimo;
	
	private double valor_compra;
	private double valor_venda;
	
	private Fornecedor fornecedor; 
	
	//Contrutor da classe
	public Produto(String descricao, int codigo, int quant, int estoque_minimo, double valor_compra, 
			double valor_venda, Fornecedor fornecedor) {
		this.descricao = descricao;
		this.codigo = codigo;
		this.quant = quant;
		this.estoque_minimo = estoque_minimo;
		this.valor_compra = valor_compra;
		this.valor_venda = valor_venda;
		this.fornecedor = fornecedor; 
	}
	
	public Produto () {}
	
	//Metodos da classe para repor ou calcular valor arrecadado pelos produtos 
	public void compra (int quant, double valor) {
		//Incrementa a quantidade e atualiza o preco de compra
		setQuant(getQuant() + quant);
		setValor_compra(valor);
		
		System.out.printf("Comprou %d no valor de R$%.2f\n\n", quant, getValor_compra());
	}
	
	public double venda (int quant, double valor) {
		//Decrementa a quantidade do item e retorna o valor da venda
		if (getQuant() - quant > getEstoque_minimo()) {
			setQuant(getQuant() - quant);
			setValor_venda(valor);
			
			System.out.printf("Vendeu %d que rendeu o valor de R$%.2f\n\n", quant, getValor_venda() * quant);
		}else {
			System.out.println("Não foi possivel fazer venda, ESTOQUE BAIXO");
			return 0;
		}
		return getValor_venda() * quant;
	}
	
	//Getters e setters
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public double getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}

	public double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(double valor_venda) {
		this.valor_venda = valor_venda;
	}

	public int getEstoque_minimo() {
		return estoque_minimo;
	}

	public void setEstoque_minimo(int estoque_minimo) {
		this.estoque_minimo = estoque_minimo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		
		return "---------- INFORMACOES DE PRODUTO ---------\n"
				+ "DESCRICAO=" + descricao + ",\nCODIGO = " + codigo + ",\nQUANT = " + quant + ",\nESTOQUE = "
				+ estoque_minimo + ",\nVALOR-COMPRA = " + valor_compra + ",\nVALOR-VENDA = " + valor_venda + ",\nFORNECEDOR = "
				+ fornecedor + "]"
				+ "\n-------------------------------\n";	
	}

	
}
