package exercicios_poo.exe_produtos;

public class Estoque {
	private Produto produtos[] = new Produto[50];
	private int size;
	
	public void criarProduto (Produto produto) { 
		produtos[size++] = produto;
	}
	
	private Produto buscar (int codigo) {
		for (int i=0; i<size; i++) {
			if (produtos[i].getCodigo() == codigo) {
				return produtos[i]; 
			}
		}
		return null;
	}
	
	public void compra (int codigo, int quant, double valor) {
		//Pesquisar o produto que corresponde a esse codigo (Que nao deve ser repetido)
		Produto produto = buscar (codigo);
		
		if (produto != null ) {
			produto.compra(quant, valor);
		}else {
			System.out.println("Codigo desse produto nao foi encontrado!");
		}
	}
	
	public void venda (int codigo, int quant, double valor) {
		Produto produto = buscar (codigo); 
		
		if (produto != null ) {
			produto.venda(quant, valor);
		}else {
			System.out.println("Codigo desse produto nao foi encontrado!");
		}
	}
}
