package view;

import java.util.Scanner;

import controller.Controller;
import model.Banco;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class Main {
static Banco banco = new Banco("Nubanco");
static Scanner scanner = new Scanner(System.in);
static Controller controller = new Controller();

	public static void main(String[] args) {
		boolean encerrar = false;
		Cliente logado = null;
		while (!encerrar) {
			System.out.println("BANCO DIGITAL: ");
			System.out.println("====================BEM-VINDO AO NUBANCO=======================" + "\n" + 
					"Escolha uma opção: " + "\n" +
					"1. Login" + "\n" + 
					"2. Cadastro" + "\n" +
					"3. Sair " + "\n" +
					"Resposta: ");
			int resposta = scanner.nextInt();
			scanner.nextLine();
			switch(resposta) {		
			case 1: System.out.println("Email: ");
			String email = scanner.nextLine();
			System.out.println("Senha: ");
			String senha = scanner.nextLine();
			if (controller.verificarLogin(email, senha)) {
				logado = controller.retornarCliente(email);
				menu(logado);
			}
			else {
				System.out.println("Usuario nao encontrado.");
			} break;
			case 2: cadastro(); break;
			case 3: encerrar = true; break;
			}
		}
		
	}

	private static void cadastro() {
	
	System.out.println("===================== CADASTRO ============================");
	System.out.println("Digite seu nome: ");
	String nome = scanner.nextLine();
	System.out.println("CPF: ");
	long CPF = scanner.nextLong();
	scanner.nextLine();
	System.out.println("Email: ");
	String email = scanner.nextLine();
	System.out.println("Senha: ");
	String senha = scanner.nextLine();
	controller.cadastrarCliente(nome, CPF, email, senha);
	System.out.println("===========================================================");
	System.out.println("Escolha o tipo de conta: " + "\n" + 
	"1. Conta Corrente " + "\n" + 
	"2. Conta Poupanca ");
	System.out.println("Resposta: ");
	int resp = scanner.nextInt();
	switch(resp) {
	case 1: 
	Cliente c = controller.retornarCliente(email);
	ContaCorrente conta = new ContaCorrente(c, banco, 0);
	controller.cadastrarConta(conta); break;
	case 2: Cliente cl = controller.retornarCliente(email);
	ContaPoupanca contaP = new ContaPoupanca(banco, cl, 0);
	controller.cadastrarConta(contaP); break;
	}
	System.out.println("===========================================================");
	}

	private static void menu(Cliente logado) {
		boolean sair = false;
		while(!sair) {
			
			System.out.println("========================== MENU ===========================" + "\n" + 
					"Escolha uma opção: " + "\n" +
					"1. Ver saldo" + "\n" + 
					"2. Extrato" + "\n" +
					"3. Transferir " + "\n" +
					"4. Sacar " + "\n" +
					"5. Depositar " + "\n" +
					"6. Sair " + "");
			if (controller.retornarContaCliente(logado)instanceof ContaPoupanca) {
				System.out.println("\n7. Ver Rendimento por mes");
			}
			System.out.println("===========================================================");	
			int resposta = scanner.nextInt();
			switch(resposta) {
			case 1: System.out.println(controller.retornarContaCliente(logado).getSaldo()); break;
			case 2: controller.imprimirExtrato(controller.retornarContaCliente(logado)); break;
			case 3: System.out.println("Numero da conta destino: ");
			int numeroDestino = scanner.nextInt();
			Conta conta = controller.retornarContaPorNumero(numeroDestino);
			System.out.println("Valor a ser transferido: ");
			double valor = scanner.nextDouble();
			if (conta != null) {
				controller.transferir(controller.retornarContaCliente(logado), conta, valor);
			}
			else {
				System.out.println("Conta destino nao encontrada.");
			} break;
			case 4: System.out.println("Valor a ser sacado: ");
			double valorS = scanner.nextDouble();
				controller.sacar(controller.retornarContaCliente(logado), valorS); break;
			case 5: System.out.println("Valor a ser depositado: ");
			double valorD = scanner.nextDouble();
			controller.depositar(controller.retornarContaCliente(logado), valorD); break;
			case 6: sair = true; break; 
			case 7: System.out.println("Digite o mês a ser calculado o rendimento: ");
			int mes = scanner.nextInt();
			System.out.println("Rendimento após " + mes + " meses: " + controller.calcularRendimentoMensal(controller.retornarContaCliente(logado), mes));
			break;
			}
		}
	}

}
