package sistemaBancario;

public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente(String numeroConta, String cliente) {
		super(numeroConta, cliente);
	}
	
	@Override
	public boolean sacar(double valor) {
		
		double taxa = valor * 0.05;
		double valorDescontado = valor + taxa;
		
		
		if(this.saldo >= valorDescontado) {
			this.saldo = this.saldo - valorDescontado;
			System.out.println("Saque de R$ " + valor + " - Taxa Cobrada: " + taxa);
			return true;
		} else {
			System.out.println("Saldo insuficiente, operação negada.");
			return false;
		}
	}
	
	@Override
	public boolean transferir(double valor, Conta contaDestino) {
		if(this.sacar(valor)) {
			contaDestino.depositar(valor);
			System.out.println("Transferência realizada no valor de R$ " + valor);
			return true;
		} else {
			System.out.println("Operação falhou!");
			return false;
		}
	}

	@Override
	public double calcularTributos() {
		double imposto = this.saldo * 0.01;
		return imposto;
	}
}
