package exercicios_poo.exe_produtos;

public class MainProdutos {
	public static void main(String[] args) {
		Fornecedor fornecedor = new Fornecedor("cnpjFornc", "Jose", "Cosmeticos"); 
		Produto produto = new Produto("Cosmeticos", 101, 0, 0, 0, 0, fornecedor);
		
		Estoque estoque = new Estoque();
		
//		//Fazendo compra dos produtos: 
//		produto.compra(3, 30);
//		System.out.println(produto);
//		
//		//Fazendo venda dos produtos: 
//		produto.venda(2, 40);
//		System.out.println(produto);
//		
//		produto.compra(10, 100);
//		System.out.println(produto);
//		
//		produto.venda(1, 30);
//		System.out.println(produto);
		
		//Fazendo uso da classe Estoque:
		estoque.criarProduto(produto);
		System.out.println(produto);
		
		estoque.compra(101, 3, 10);
		System.out.println(produto);
		
		estoque.venda(101, 2, 50);
		System.out.println(produto);
	}
	
}
