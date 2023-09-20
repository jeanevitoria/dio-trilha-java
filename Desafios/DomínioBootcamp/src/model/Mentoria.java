package model;

import java.time.LocalDate;

public class Mentoria extends Conteudo {
private LocalDate data;

public Mentoria(String titulo, String descricao, LocalDate data) {
	super(titulo, descricao);
	this.setData(data);
}

@Override
public double calcularXP() {
	return XP_PADRAO + 20;
}

public LocalDate getData() {
	return data;
}

public void setData(LocalDate data) {
	this.data = data;
}


}
