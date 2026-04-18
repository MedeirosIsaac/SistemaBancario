package sistemaBancario;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String numeroConta, String cliente) {
		super(numeroConta, cliente);
	}
	
	@Override
	public boolean sacar(double valor) {
		
		if(this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			System.out.println("Saque de R$ " + valor);
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
}
