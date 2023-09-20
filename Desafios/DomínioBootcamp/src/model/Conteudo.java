package model;

public abstract class Conteudo {
private String titulo;
private String descricao;
protected static final double XP_PADRAO = 10d;

public Conteudo(String titulo, String descricao) {
	super();
	this.titulo = titulo;
	this.descricao = descricao;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public abstract double calcularXP();
@Override
public String toString() {
	return "[titulo=" + titulo + ", descricao=" + descricao + "]";
}

}
