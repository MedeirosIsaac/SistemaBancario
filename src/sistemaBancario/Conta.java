package sistemaBancario;

public abstract class Conta {
	protected String numeroConta;
	protected String cliente;
	protected double saldo;
	
	public Conta(String numeroConta, String cliente){
		this.numeroConta = numeroConta;
		this.cliente = cliente;
		this.saldo = 0.0;
	}
	
	public void depositar(double valor) {
		if(valor > 0) {
			this.saldo += valor;
			System.out.println("Deposito realizado no valor de R$" + valor + " na conta Nº" + numeroConta);
		} else {
			System.out.println("Valor de depósito inválido");
		}
	}
	
	public abstract boolean sacar(double valor);
	public abstract boolean transferir(double valor, Conta contaDestino);
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	
}
