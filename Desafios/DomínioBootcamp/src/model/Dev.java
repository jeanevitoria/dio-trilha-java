package model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
String nome;
int XPs = 0;
Set<Conteudo> conteudoInscrito = new LinkedHashSet<>();
Set<Conteudo> conteudoConcluido = new LinkedHashSet<>();

public Dev(String nome) {
	super();
	this.nome = nome;
	XPs = 0;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Set<Conteudo> getConteudoInscrito() {
	return conteudoInscrito;
}
public void setConteudoInscrito(Set<Conteudo> conteudoInscrito) {
	this.conteudoInscrito = conteudoInscrito;
}
public Set<Conteudo> getConteudoConcluido() {
	return conteudoConcluido;
}
public void setConteudoConcluido(Set<Conteudo> conteudoConcluido) {
	this.conteudoConcluido = conteudoConcluido;
}
public int getXPs() {
	return XPs;
}
public void setXPs(double d) {
	this.XPs = (int) d;
}
@Override
public String toString() {
	return "Dev [nome=" + nome + ", XPs=" + XPs + "]";
}
}
