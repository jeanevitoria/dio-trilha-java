package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Bootcamp {
	private Set<Conteudo> conteudo = new LinkedHashSet<>();
	private Set<Dev> alunos = new HashSet<>();
	private String nome;
	private String descricao;
	private final LocalDate data_inicio = LocalDate.now();
	private final LocalDate data_final = data_inicio.plusDays(45);

public Bootcamp(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

public void setConteudos(Set<Conteudo> conteudo) {
	this.conteudo = conteudo;
}
public Set<Conteudo> getConteudo(){
	return this.conteudo;
}
public Set<Dev> getAlunos() {
	return alunos;
}
public void setAlunos(Set<Dev> alunos) {
	this.alunos = alunos;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public LocalDate getData_inicio() {
	return data_inicio;
}
public LocalDate getData_final() {
	return data_final;
}

@Override
public String toString() {
	return "Bootcamp: [nome=" + nome + ", descricao=" + descricao + ", data_inicio=" + data_inicio + ", data_final="
			+ data_final + "]";
}

}
