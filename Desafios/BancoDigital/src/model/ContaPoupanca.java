package model;

public class ContaPoupanca extends Conta {
double taxaJurosMensal  =  0.65/100;
	
	public ContaPoupanca(Banco banco, Cliente cliente, double saldo) {
	super(banco, cliente, saldo);
	// TODO Auto-generated constructor stub
}
	public double getTaxaJurosMensal() {
		return taxaJurosMensal;
	}
	public void setTaxaJurosMensal(double taxaJurosMensal) {
		this.taxaJurosMensal = taxaJurosMensal;
	}
	
}
