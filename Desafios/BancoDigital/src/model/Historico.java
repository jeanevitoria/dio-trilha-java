package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historico {
String tipo;
double valor;
LocalDateTime horario;

public Historico(String tipo, double valor) {
	super();
	this.tipo = tipo;
	this.valor = valor;
	this.horario = LocalDateTime.now();
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public double getValor() {
	return valor;
}

public void setValor(double valor) {
	this.valor = valor;
}

public String getHorario() {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dataFormatada = horario.format(formato);
    return dataFormatada;
}

public void setHorario(LocalDateTime horario) {
	this.horario = horario;
}

}
