package atividadeAvaliativa.Testes;

import static org.junit.Assert.*;
import org.junit.Test;

import atividadeAvaliativa.Cliente;
import atividadeAvaliativa.Locadora;
import atividadeAvaliativa.Veiculo;

public class LocadoraTest {

	@Test
	public void inserirVeiculos() {
		Locadora locadora = new Locadora(); 
		Veiculo veiculo1 = new Veiculo("Honda", "g3x", "123", 0f, 0f, 2020, 1, 0,0,0,0); 
		Veiculo veiculo2 = new Veiculo("Gol", "g2x", "234", 0f, 0f, 2019, 2, 0,0,0,0); 
		Veiculo veiculo3 = new Veiculo("Honda", "g3x", "345", 0f, 0f, 2020, 1, 0,0,0,0); 
		Veiculo veiculo4 = new Veiculo("Honda", "g3x", "3454", 0f, 0f, 2020, 1, 0,0,0,0);
		Veiculo veiculo5 = new Veiculo("Rxt", "freg", "3454", 0f, 0f, 2021, 3000, 0,0,0,0);
		
		assertEquals(true, locadora.inserir(veiculo1));
		assertEquals(true, locadora.inserir(veiculo2));
		assertEquals(true, locadora.inserir(veiculo3));
		assertEquals(true, locadora.inserir(veiculo4));
		assertEquals(false, locadora.inserir(veiculo5));
	}
	
	@Test
	public void pesquisarVeiculos() {
		Locadora locadora = new Locadora(); 
		Veiculo veiculo1 = new Veiculo("Honda", "g3x", "123", 0f, 0f, 2020, 1, 0,0,0,0); 
		Veiculo veiculo2 = new Veiculo("Honda", "g3x", "234", 0f, 0f, 2020, 2, 0,0,0,0); 
		Veiculo veiculo3 = new Veiculo("Gol", "g2x", "345", 0f, 0f, 2019, 2, 0,0,0,0); 
		
		assertEquals(true, locadora.inserir(veiculo1));
		assertEquals(true, locadora.inserir(veiculo2));
		assertEquals(true, locadora.inserir(veiculo3));
		
		assertEquals(true, locadora.pesquisar(veiculo1));
		assertEquals(true, locadora.pesquisar(veiculo2));
		assertEquals(true, locadora.pesquisar(veiculo3));
		
		assertEquals(veiculo1, locadora.pesquisar("123"));
		assertEquals(veiculo2, locadora.pesquisar("234"));
		assertEquals(veiculo3, locadora.pesquisar("345"));
		assertEquals(null, locadora.pesquisar("41324"));
	}
	
	@Test
	public void pesquisarMoto() { //Se funcionar pra moto, em teoria pro resto tambem serve
		Locadora locadora = new Locadora(); 
		Veiculo veiculo1 = new Veiculo("Honda", "g3x", "123", 0f, 0f, 2020, 1, 0,1,0,0); 
		Veiculo veiculo2 = new Veiculo("Honda", "g3x", "234", 0f, 0f, 2020, 2, 0,0,0,0); 
		Veiculo veiculo3 = new Veiculo("Gol", "g2x", "456", 0f, 0f, 2019, 1, 0,100,0,0); 
		Veiculo veiculo4 = new Veiculo("Honda", "g3x", "566", 0f, 0f, 2020, 1, 0,100,0,0); 
		
		locadora.inserir(veiculo1);
		locadora.inserir(veiculo2);
		locadora.inserir(veiculo3);
		locadora.inserir(veiculo4); 
		
		//Falta modificar o metodo pesquisarMoto() ele deve retonar um arrayList
		assertEquals(2, locadora.pesquisarMoto(100, 1).size());
		
		assertEquals(null, locadora.pesquisarMoto(2, 1));
		assertEquals(null, locadora.pesquisarMoto(100, 2));
		assertEquals(1, locadora.pesquisarMoto(1, 1));
		assertEquals(null, locadora.pesquisarMoto(200, 1));
	}
	
	@Test
	public void AlugarVeiculo() {
		Locadora locadora = new Locadora();
		Cliente cliente = new Cliente ("Junior", "3442");
		
		//marca, modelo, placa, valor, diaria, ano, tipo, carga, cilindrada, categoria, passageiros
		Veiculo veiculo1 = new Veiculo("Honda", "g3x", "123", 50000f, 500f, 2020, 1, 0,0,0,0); 
		locadora.inserir(veiculo1);
		
		//Alugando um carro para o cliente
		locadora.inserir(cliente);
		assertEquals (true, locadora.alugarVeiculo("123", 2, 1, cliente)); 
		assertEquals (false, locadora.alugarVeiculo("123", 2, 1, cliente)); 
		assertEquals (false, locadora.alugarVeiculo("123", 2, 1, cliente)); 
	}
	
	@Test
	public void registrarDevolucao() {
		Locadora locadora = new Locadora();
		Cliente cliente = new Cliente ("Junior", "3442");
		
		//marca, modelo, placa, valor, diaria, ano, tipo, carga, cilindrada, categoria, passageiros
		Veiculo veiculo1 = new Veiculo("Honda", "g3x", "123", 50000f, 500f, 2020, 1, 0,0,0,0); 
		locadora.inserir(veiculo1);
		
		//Alugando um carro para o cliente
		locadora.inserir(cliente);
		assertEquals (true, locadora.alugarVeiculo("123", 2, 1, cliente));
		assertEquals (true, locadora.registrarDevolucao("123", cliente)); 
		assertEquals (false, locadora.registrarDevolucao("123", cliente)); 
	}
}
