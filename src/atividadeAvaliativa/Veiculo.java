package atividadeAvaliativa;

public class Veiculo { 
	private String marca; 
	private String modelo; 
	private String placa; 
	
	private double valor; //Valor do bem
	private double diaria;	//Valor da diaria 
	private double aluguel; //Valor do aluguel do carro, calculado conforme a quantidade de dias
	
	private int ano; 
	private int tipo; //Tipo vai servir para identifica-lo como automovel
	
	private int carga; //Especifico de caminhao
	private int cilindrada; //Especifico de moto
	private int categoria;  //Especifico de carro
	private int passageiros; //Especifico de onibus
	
	private boolean status; //Para saber se o carro foi ou nao alugado
	private int somaDias; 
	private double somaFaturamento; 
	
	// moto (tipo 1), carro (tipo 2), ônibus (tipo 3) e caminhão (tipo 4)
	public Veiculo(String marca, String modelo, String placa, double valor, double diaria, int ano, int tipo, int carga,
			int cilindrada, int categoria, int passageiros) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.valor = valor;
		this.diaria = diaria;
		this.ano = ano;
		this.tipo = tipo;
		
		//Para cada tipo especifico de veiculo: 
		if (this.tipo == 1) {
			this.cilindrada = cilindrada;
		}else if (this.tipo == 2) {
			this.categoria = categoria; 
		}else if (this.tipo == 3) {
			this.passageiros = passageiros;
		}else if (this.tipo == 4) {
			this.carga = carga;
		}
	}
	
	public double calculoSeguroMoto (int tipo) {
		if (tipo != 1) return -1; 
		
		//Vai calcular o valor do seguro diario da moto do tipo determinado
		 return valor * 0.11 / 365;  
	}
	
	public double calculoSeguroCarro (int tipo) {
		if (tipo != 2) return -1; 
		
		//Vai calcular o valor do seguro diario do carro do tipo determinado
		 return valor * 0.3 / 365;  
	}
	
	public double calculoSeguroOnibus (int tipo) {
		if (tipo != 3) return -1; 
		
		//Vai calcular o valor do seguro diario do onibus do tipo determinado
		 return valor * 0.20 / 365;  
	}
	
	public double calculoSeguroCaminhao (int tipo) {
		if (tipo != 4) return -1; 
		
		//Vai calcular o valor do seguro diario do caminhao do tipo determinado
		 return valor * 0.8 / 365;  
	}
	
	//Criando os getrs e setrs da minha classe veiculo: 
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getDiaria() {
		return diaria;
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Veiculo other = (Veiculo) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		
		return true;
	}

	public double getAluguel() {
		return aluguel;
	}

	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void SomaDias(int quant) {
		this.somaDias += quant; 
	}

	public int getSomaDias() {
		return this.somaDias; 
	}
	
	public double getFaturamento() {
		return somaFaturamento;
	}

	public void somaFaturamento(double faturamento) {
		this.somaFaturamento += faturamento; 
	}
	
}
