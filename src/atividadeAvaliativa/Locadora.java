package atividadeAvaliativa;

import java.util.ArrayList;

public class Locadora {
	public ArrayList<Veiculo> RepositorioDeVeiculos; // Vai armazenar todos os veiculos cadastrados na locadora
	public ArrayList<Cliente> Clientes; // Armazena todos os clientes cadastrados
	
	public Locadora() {
		// Inicializando minha lista que armazena veiculos
		RepositorioDeVeiculos = new ArrayList<Veiculo>();
		Clientes = new ArrayList<Cliente>();
	}

	public boolean inserir(Cliente cliente) {
		// Cadastra o cliente passado no parametro
		if (!pesquisarCliente(cliente)) {
			Clientes.add(cliente);
			return true;
		}
		return false;
	}

	public boolean inserir(Veiculo veiculo) {
		if (!pesquisar(veiculo)) { // Caso o veiculo nao seja encontrado
			RepositorioDeVeiculos.add(veiculo);
			return true;
		}
		return false;
	}

	public boolean pesquisarCliente(Cliente cliente) {
		return Clientes.contains(cliente);
	}

	public Cliente pesquisarCliente(String documento) {
		for (Cliente cliente : Clientes) {
			if (cliente.getDocumento().equalsIgnoreCase(documento)) {
				return cliente;
			}
		}
		return null;
	}

	public boolean pesquisar(Veiculo veiculo) {
		// Caso exista um veiculo no arrayList
		return RepositorioDeVeiculos.contains(veiculo);
	}

	public Veiculo pesquisar(String placa) {
		// Pesuisa utilizando o atributo placa
		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
				return veiculo;
			}
		}
		return null;
	}

	// Metodos de pesquisa especificas:
	public ArrayList<Veiculo> pesquisarMoto(int cilindrada, int tipo) {
		ArrayList<Veiculo> lista = new ArrayList<>();

		if (tipo != 1) {
			return null;
		}

		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getCilindrada() == cilindrada) {
				lista.add(veiculo);
			}
		}
		return lista;
	}

	public ArrayList<Veiculo> pesquisarCarro(int categoria, int tipo) {
		ArrayList<Veiculo> lista = new ArrayList<>();

		if (tipo != 2) {
			return null;
		}

		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getCilindrada() == categoria) {
				lista.add(veiculo);
			}
		}
		return lista;
	}

	public ArrayList<Veiculo> pesquisarOnibus(int passageiros, int tipo) {
		ArrayList<Veiculo> lista = new ArrayList<>();

		if (tipo != 3) {
			return null;
		}

		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getCilindrada() == passageiros) {
				lista.add(veiculo);
			}
		}
		return lista;
	}

	public ArrayList<Veiculo> pesquisarCaminhao(int carga, int tipo) {
		ArrayList<Veiculo> lista = new ArrayList<>();

		if (tipo != 4) {
			return null;
		}

		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getCilindrada() == carga) {
				lista.add(veiculo);
			}
		}
		return lista;
	}

	// METODOS QUE O CLIENTE VAI USAR:
	public boolean alugarVeiculo(String placa, int dias, int tipo, Cliente cliente) {
		// Vai alugar um veiculo, e calcular o valor que o cliente pagara no aluguel
		Veiculo veiculo = pesquisar(placa);

		if (veiculo != null) {
			if (!veiculo.isStatus()) {
				calcularAluguel(placa, dias, tipo);
				registrarAluguel(veiculo, cliente);
				veiculo.setStatus(true); // Carro indisponivel para aluguel
				return true;
			}
		}
		return false;
	}

	public double calcularAluguel(String placa, int dias, int tipo) {
		// Calcula o aluguel de cada veiculo
		Veiculo veiculo = pesquisar(placa);

		if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
			// Verificar qual tipo de veiculo tem essa palca
			if (veiculo.getTipo() == 1) {
				veiculo.SomaDias(dias);
				veiculo.setAluguel((veiculo.getDiaria() + veiculo.calculoSeguroMoto(tipo)) * dias);
				
				veiculo.somaFaturamento(veiculo.getAluguel()); //Somando o faturamento
				return veiculo.getAluguel();

			} else if (veiculo.getTipo() == 2) {
				veiculo.SomaDias(dias);
				veiculo.setAluguel((veiculo.getDiaria() + veiculo.calculoSeguroCarro(tipo)) * dias);
				
				veiculo.somaFaturamento(veiculo.getAluguel()); //Somando o faturamento
				return veiculo.getAluguel();

			} else if (veiculo.getTipo() == 3) {
				veiculo.SomaDias(dias);
				veiculo.setAluguel((veiculo.getDiaria() + veiculo.calculoSeguroCarro(tipo)) * dias);
				
				veiculo.somaFaturamento(veiculo.getAluguel()); //Somando o faturamento
				return veiculo.getAluguel();

			} else if (veiculo.getTipo() == 4) {
				veiculo.SomaDias(dias);
				veiculo.setAluguel((veiculo.getDiaria() + veiculo.calculoSeguroCaminhao(tipo)) * dias);
				
				veiculo.somaFaturamento(veiculo.getAluguel()); //Somando o faturamento
				return veiculo.getAluguel();
			}
		}
		return -1;
	}

	public boolean registrarAluguel(Veiculo veiculo, Cliente cliente) {
		// Registrando o carro na lista de aluguel do cliente
		if (!cliente.pesquisarVeiculoAlugado(veiculo)) {
			cliente.getVeiculosAlugados().add(veiculo);
			return true;
		}
		return false;
	}

	public boolean registrarDevolucao(String placa, Cliente cliente) {
		// Retirando o carro da listade aluguel do cliente
		Veiculo veiculo = cliente.pesquisarVeiculoAlugado(placa);

		if (veiculo != null) {
			cliente.getVeiculosAlugados().remove(veiculo);
			veiculo.setStatus(false);
			return true;
		}
		return false;
	}

	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {
		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getTipo() == tipo) {
				if (!(veiculo.getValor() - (veiculo.getValor() * taxaDepreciacao) < 0)) {
					veiculo.setValor(veiculo.getValor() - (veiculo.getValor() * taxaDepreciacao));
				}
			}
		}
	}

	public void aumentarDiaria(int tipo, double taxaAumento) {
		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getTipo() == tipo) {
				veiculo.setDiaria(veiculo.getDiaria() + (veiculo.getDiaria() * taxaAumento));
			}
		}
	}
	
	public double faturamentoTotal (int tipo) {
		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getTipo() == tipo) {
				return veiculo.getFaturamento();
			}
		}
		return -1;
	}
	
	public int quantidadeTotalDiarias (int tipo) {
		int soma=0; 
		for (Veiculo veiculo : RepositorioDeVeiculos) {
			if (veiculo.getTipo() == tipo) {
				soma += veiculo.getSomaDias(); 
			}
		}
		return soma; 
	}

}






