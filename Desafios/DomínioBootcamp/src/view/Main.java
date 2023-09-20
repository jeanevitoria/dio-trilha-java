package view;
import java.time.LocalDate;

import controller.BootcampController;
import model.Bootcamp;
import model.Curso;
import model.Dev;
import model.Mentoria;

public class Main {
    public static void main(String[] args) {
        // Criação de instâncias de cursos e mentorias
        BootcampController bootcampController = BootcampController.getInstance();
        
        // Criação de um bootcamp
        Bootcamp bootcamp = new Bootcamp("Santander DEV", "Bootcamp de Desenvolvimento");

        // Criação de cursos
        bootcampController.adicionarCursoBootcamp("Curso de Java", "Aprenda Java", 40, bootcamp);
        bootcampController.adicionarCursoBootcamp("Curso de Python", "Aprenda Python", 30, bootcamp);
        bootcampController.adicionarCursoBootcamp("Curso de JavaScript", "Aprenda JavaScript", 35, bootcamp);

        // Criação de mentorias
        bootcampController.adicionarMentoriaAoBootcamp("Mentoria de Carreira", "Dicas para sua carreira", LocalDate.of(2023, 9, 20), bootcamp);
        bootcampController.adicionarMentoriaAoBootcamp("Mentoria de Desenvolvimento", "Técnicas de programação", LocalDate.of(2023, 9, 25), bootcamp);
        bootcampController.adicionarMentoriaAoBootcamp("Mentoria de Front-end", "Desenvolvimento web", LocalDate.of(2023, 9, 30), bootcamp);

        // Criação de mais desenvolvedores
        Dev dev1 = new Dev("João");
        Dev dev2 = new Dev("Maria");
        
        // Inscrição dos desenvolvedores no bootcamp
        bootcampController.inscreverDev(dev1, bootcamp);
        bootcampController.inscreverDev(dev2, bootcamp);

        // Imprimindo as informações do bootcamp
        System.out.println(bootcamp.toString());
        System.out.println("Conteudos: ");
        bootcamp.getConteudo().forEach(System.out::println);
        System.out.println("Devs inscritos: ");
        bootcamp.getAlunos().forEach(System.out::println);
        
        // Participação dos desenvolvedores em cursos e mentorias
        Curso cursoJava = (Curso) bootcampController.procurarCursoPorTitulo(bootcamp, "Curso de Java");
        if (cursoJava != null) {
            bootcampController.concluirConteudo(dev1, cursoJava, bootcamp);
        }

        Mentoria mentoriaCarreira = bootcampController.procurarMentoriaPorTitulo(bootcamp, "Mentoria de Carreira");
        if (mentoriaCarreira != null) {
            bootcampController.participarDevMentoria(dev1, mentoriaCarreira, bootcamp);
            bootcampController.participarDevMentoria(dev2, mentoriaCarreira, bootcamp);
        }

        // Exibição do XP dos desenvolvedores
        System.out.println("XP de " + dev1.getNome() + ": " + dev1.getXPs());
        System.out.println("XP de " + dev2.getNome() + ": " + dev2.getXPs());
    }
}
