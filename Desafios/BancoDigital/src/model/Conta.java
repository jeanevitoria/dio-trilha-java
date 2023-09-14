package model;

import java.util.ArrayList;

public abstract class Conta {
int numero;
Banco banco;
Cliente cliente;
double saldo;
ArrayList<Historico> historico = new ArrayList<Historico>();

public Conta(Banco banco, Cliente cliente, double saldo) {
	super();
	this.banco = banco;
	this.cliente = cliente;
	this.saldo = saldo;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public double getSaldo() {
	return saldo;
}
public void setSaldo(double saldo) {
	this.saldo = saldo;
}

@Override
public String toString() {
	return "Banco: " + banco.getNome() + "/n" +
			"Nome do cliente: " + cliente.getNome() + "/n" +
			"CPF: " + cliente.getCPF() + "/n" +
			"Numero da conta: " + this.numero + "/n" + 
			"Saldo: " + this.saldo;
}
public ArrayList<Historico> getHistorico() {
	return historico;
}
}
