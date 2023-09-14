package model;

public class Cliente {
String nome;
long CPF;
String email;
String senha;

public Cliente(String nome, long CPF, String email, String senha) {
this.nome = nome;
this.CPF = CPF;
this.email = email;
this.senha = senha;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public long getCPF() {
	return CPF;
}
public void setCPF(long cPF) {
	CPF = cPF;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}

}
