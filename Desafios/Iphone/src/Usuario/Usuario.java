package Usuario;

import Iphone.AparelhoTelefonico;
import Iphone.NavegadorNaInternet;
import Iphone.ReprodutorMusical;

public class Usuario {
    public static void main(String[] args) throws Exception {
        AparelhoTelefonico.Ligar(24142152);
        AparelhoTelefonico.Atender();
        AparelhoTelefonico.iniciarCorrerioVoz();
        NavegadorNaInternet.adicionarNovaAba();
        NavegadorNaInternet.atualizarPagina();
        NavegadorNaInternet.exibirPagina();
        ReprodutorMusical.selecionarMusica();
        ReprodutorMusical.Tocar();
        ReprodutorMusical.Pausar();
    }
}
