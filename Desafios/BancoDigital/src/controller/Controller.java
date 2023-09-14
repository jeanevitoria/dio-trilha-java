package controller;

import java.util.ArrayList;

import model.Cliente;
import model.Conta;
import model.ContaPoupanca;
import model.Historico;

public class Controller {
ArrayList<Conta> contas = new ArrayList<Conta>();
ArrayList<Cliente> clientes = new ArrayList<Cliente>();

int controladorIndiceConta = 0;
public void cadastrarCliente(String nome, long CPF, String email, String senha) {
	if (nome != null && email != null && senha != null && !verificarExistenciaCliente(email, CPF)) {
	Cliente aux = new Cliente(nome, CPF, email, senha);	
	this.clientes.add(aux);
	System.out.println("Cadastrado efetuado.");
	}
	else {
	System.out.println("CPF ou e-mail ja cadastrado.");
	}
}

public void cadastrarConta(Conta conta) {
	if (conta != null && conta.getCliente()!= null && verificarExistenciaCliente(conta.getCliente().getEmail(), conta.getCliente().getCPF())) {
	conta.setNumero(controladorIndiceConta);
	controladorIndiceConta++;
	this.contas.add(conta);
	}
	else {
		System.out.println("Dados inválidos");
	}
}

public Conta retornarContaCliente(Cliente c) {
	for (Conta conta : this.contas) {
		if (conta.getCliente().equals(c)) {
			return conta;
		}
	}
	return null;
}

public void transferir(Conta origem, Conta destino, double valor) {
	if (origem.getSaldo() >= valor && verificarExistenciaConta(origem) && verificarExistenciaConta(destino) && origem.getNumero()!= destino.getNumero()) {
		origem.setSaldo(origem.getSaldo()-valor);
		destino.setSaldo(destino.getSaldo()+valor);
		origem.getHistorico().add(new Historico("Credito", valor));
		destino.getHistorico().add(new Historico("Debito", valor));

	}
	else if (origem.getNumero()== destino.getNumero()) {
		System.out.println("Voce nao pode transferir para sí mesmo.");
	}
	else if (origem.getSaldo() < valor){
		System.out.println("FALHA: Saldo insuficiente.");
	}
}

public void imprimirExtrato(Conta c) {
	System.out.println("data                  historico            valor" );
	
	for (Historico t: c.getHistorico()) {
		if (t.getTipo().equals("Credito")) {
			System.out.println(t.getHorario() + "      " + "CREDITO" + "         " + "-" + t.getValor());
		}
		else {
			System.out.println(t.getHorario() + "      " + "DÉBITO" + "         " + "+" + t.getValor());
		}
	}
	System.out.println("SALDO TOTAL: " + c.getSaldo());
}

public void sacar(Conta c, double valor) {
	if (verificarExistenciaConta(c)&& c.getSaldo() >= valor) {
		c.setSaldo(c.getSaldo()-valor);
		c.getHistorico().add(new Historico("Credito", valor));
	}
	else {
		System.out.println("FALHA: Saldo insuficiente.");
	}
}

public void depositar(Conta c, double valor) {
	if (verificarExistenciaConta(c)) {
		c.setSaldo(c.getSaldo()+valor);
		c.getHistorico().add(new Historico("Debito", valor));
		}
}

public double calcularRendimentoMensal(Conta c, int mes) {
	if (c instanceof ContaPoupanca) {
		ContaPoupanca p = (ContaPoupanca) c;
		return c.getSaldo() + (c.getSaldo()* p.getTaxaJurosMensal()*mes);
	}
	return 0;
}
private boolean verificarExistenciaCliente(String email, long CPF) {
	for (Cliente c : clientes){
		if (c.getEmail().equals(email) || c.getCPF() == CPF) {
		return true;
		}
	}
	return false;
}
public boolean verificarLogin(String email, String senha) {
	for (Cliente c : this.clientes) {
		if (c.getEmail().equals(email) && c.getSenha().equals(senha)) {
			return true;
		}
	}
	return false;
}
private boolean verificarExistenciaConta(Conta c) {
	if (this.contas.contains(c)) {
		return true;
	}
	return false;
}
public void removerConta(Conta c) {
	if (this.contas.contains(c)&& c.getSaldo() >= 0) {
		this.contas.remove(c);
		this.clientes.remove(c.getCliente());
	}
	else {
		System.out.println("Falha ao remover a conta: a conta nao existe ou possui saldo negativo.");
	}
}
public Conta retornarContaPorNumero(int numero) {
	for (Conta c: this.contas) {
		if (c.getNumero() == numero) {
			return c;
		}
	}
	return null;
}
public Cliente retornarCliente (String email) {
	for (Cliente c: this.clientes) {
		if (c.getEmail().equals(email)) {
			return c;
		}
	}
	return null;
}
public boolean removerCliente(Cliente c) {
	boolean valido = true;
	if (this.clientes.contains(c)) {
		for (Conta conta : this.contas) {
			if (conta.getCliente().equals(c)) {
				if (conta.getSaldo() >= 0) {
					this.contas.remove(conta);
				}
				else {
					valido = false;
				}
			}
		}
		if (valido) {
			this.clientes.remove(c);
		}
		else {
			System.out.println("Falha: nao eh possivel excluir clientes com conta negativada.");
		}
	}
	return valido;
}

}
