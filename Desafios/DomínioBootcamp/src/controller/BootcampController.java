package controller;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Bootcamp;
import model.Conteudo;
import model.Curso;
import model.Dev;
import model.Mentoria;

public class BootcampController {
private static BootcampController instance;

private BootcampController() {
	
}	

public static BootcampController getInstance() {
	if (instance == null) {
		instance = new BootcampController();
	}
	return instance;
}
	
public void adicionarMentoriaAoBootcamp(String titulo, String descricao, LocalDate data, Bootcamp bootcamp) {
	if (titulo == null || descricao == null || bootcamp == null || data == null || data.isAfter(bootcamp.getData_final()))
		return;
	bootcamp.getConteudo().add(new Mentoria(titulo, descricao, data));
}

public void adicionarCursoBootcamp(String titulo, String descricao, int cargaHoraria, Bootcamp bootcamp) {
	if (titulo == null || descricao == null || bootcamp == null || LocalDate.now().isAfter(bootcamp.getData_final()))
		return;
	bootcamp.getConteudo().add(new Curso(titulo, descricao, cargaHoraria));
}
public void removerConteudoBootcamp(Conteudo conteudo, Bootcamp bootcamp) {
	if (conteudo == null)
		return;
	bootcamp.getConteudo().removeIf(n -> n.equals(conteudo));
} 

public void desinscreverDev(Dev dev, Bootcamp bootcamp) {
	if (dev == null || bootcamp == null) {
		System.out.println("Falha: dados incorretos.");
		return;
	}
		
	bootcamp.getAlunos().removeIf(n -> n.equals(dev));
	dev.getConteudoInscrito().removeIf(n -> bootcamp.getConteudo().contains(n));
}

public void inscreverDev(Dev dev, Bootcamp bootcamp ) {
	if (dev != null && bootcamp != null && !LocalDate.now().isAfter(bootcamp.getData_final())) {
	dev.getConteudoInscrito().addAll(bootcamp.getConteudo());
	bootcamp.getAlunos().add(dev);	
	}
	else 
		System.out.println("Falha na inscrição: dados incorretos.");	
}


public void participarDevMentoria(Dev dev, Mentoria mentoria, Bootcamp bootcamp) {
	if (dev == null || mentoria == null || LocalDate.now().isAfter(bootcamp.getData_final()))
		return;
	System.out.println(dev.getNome() + " concluiu o conteudo " + mentoria.toString());
	dev.setXPs(dev.getXPs()+mentoria.calcularXP());
	dev.getConteudoConcluido().add(mentoria);
}

public void concluirConteudo(Dev dev, Conteudo conteudo, Bootcamp bootcamp) {
	if (conteudo == null || bootcamp == null || dev == null || LocalDate.now().isAfter(bootcamp.getData_final()))
		return;
	System.out.println(dev.getNome() + " concluiu o conteudo " + conteudo.toString() + " do BootCamp " + bootcamp.getNome());
	dev.getConteudoConcluido().add(conteudo);
	dev.getConteudoInscrito()
	.removeIf(n->n.equals(conteudo));
	bootcamp.getConteudo()
	.stream()
	.filter(n->n.equals(conteudo))
	.collect(Collectors.toSet())
	.forEach(n->dev.setXPs(dev.getXPs()+n.calcularXP()));
}

public Conteudo procurarCursoPorTitulo(Bootcamp b, String titulo) {
	Optional<Conteudo> conteudo = b.getConteudo().stream().filter(n->n.getTitulo().equals(titulo)).findAny();
	if (conteudo.isEmpty()) {
		return null;

	}
	return conteudo.get();
}

public Mentoria procurarMentoriaPorTitulo(Bootcamp b, String titulo) {	
	Optional<Conteudo> conteudo = b.getConteudo().stream()
			.filter(n-> n instanceof Mentoria)
			.filter(n->n.getTitulo().equals(titulo))
			.findAny();
	if (conteudo.isEmpty()) {
		return null;
	}
	return (Mentoria)conteudo.get();
}


}
