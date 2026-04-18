package sistemaBancario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		ArrayList<Conta> listaContas = new ArrayList<>();
		boolean ativo = true;
		
		while(ativo) {
			System.out.println("\n===== SISTEMA BANCÁRIO =====");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Realizar Depósito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Realizar Transferência");
            System.out.println("5 - Listar Contas");
            System.out.println("6 - Consultar Tributos");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = leitor.nextInt();
            leitor.nextLine();
            
            switch(opcao) {
            
	            case 1:
	            	System.out.print("Nome do Cliente: ");
	            	String nome = leitor.nextLine();
	            	System.out.print("Número da Conta: ");
	            	String num = leitor.nextLine();
	            	System.out.println("Tipo: 1-Corrente | 2-Poupança");
	            	int tipo = leitor.nextInt();
	            	
	            	if(tipo == 1) {
	            		listaContas.add(new ContaCorrente(num, nome));
	            	} else {
	            		listaContas.add(new ContaPoupanca(num, nome));
	            	}
	            	System.out.println("Conta criada com sucesso!");
	            	break;
	            case 2:
	            	System.out.print("Número da conta: ");
	            	String numDep = leitor.nextLine();
	            	Conta contaDep = encontrarConta(listaContas, numDep);
	            	if(contaDep != null) {
	            		System.out.print("Valor do depósito:");
	            		double valorDep = leitor.nextDouble();
	            		contaDep.depositar(valorDep);
	            	} else {
	            		System.out.println("Conta não encontrada!");
	            	}
	            	break;
	            case 3:
	            	System.out.print("Número da conta: ");
	            	String numSaq = leitor.nextLine();
	            	Conta contaSaq = encontrarConta(listaContas, numSaq);
	            	if(contaSaq != null) {
	            		System.out.print("Valor do saque: ");
	            		double valorSaq = leitor.nextDouble();
	            		contaSaq.sacar(valorSaq);
	            	} else {
                        System.out.println("Conta não encontrada!");
	            	}
	            	break;
	            case 4:
	            	System.out.print("Número da conta de ORIGEM: ");
                    String numOrigem = leitor.nextLine();
                    Conta contaOrigem = encontrarConta(listaContas, numOrigem);
                    
                    System.out.print("Número da conta de DESTINO: ");
                    String numDestino = leitor.nextLine();
                    Conta contaDestino = encontrarConta(listaContas, numDestino);
                    
                    if (contaOrigem != null && contaDestino != null) {
                        System.out.print("Valor da transferência: ");
                        double vTra = leitor.nextDouble();
                        contaOrigem.transferir(vTra, contaDestino);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
	            case 5:
                    System.out.println("\n--- LISTA DE CONTAS ---");
                    for (Conta c : listaContas) {
                        String tipoTexto = (c instanceof ContaCorrente) ? "Corrente" : "Poupança";
                        System.out.println("Titular: " + c.getCliente() + 
                                         " | N°: " + c.getNumeroConta() + 
                                         " | Saldo: R$ " + c.getSaldo() +
                                         " | Tipo: " + tipoTexto);
                    }
                    break;
	            case 6:
	            	System.out.println("\n--- RECOLHIMENTO DE TRIBUTOS DO BANCO ---");
                    double totalTributos = 0.0;
                    
                    for (Conta conta : listaContas) {
                        
                        if (conta instanceof Tributavel) {
                            
                            Tributavel contaTributavel = (Tributavel) conta;
                            
                            totalTributos += contaTributavel.calcularTributos();
                        }
                    }
                    
                    System.out.println("========================================");
                    System.out.printf("Total de tributos a recolher: R$ %.2f\n", totalTributos);
                    System.out.println("========================================");
                    break;
	            case 7:
                    System.out.println("Encerrando sistema...");
                    ativo = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        		leitor.close();
	}


	
	
	public static Conta encontrarConta(ArrayList<Conta> lista, String numero) {
        for (Conta c : lista) {
            if (c.getNumeroConta().equals(numero)) {
                return c;
            }
        }
        return null;
    }
}
