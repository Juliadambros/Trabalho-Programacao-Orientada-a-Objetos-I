package armazenamento;

import jogodaVelha.Jogador;

import java.util.ArrayList;

/**
 * Classe que implementa GerenciaJogadores para gravar jogadores em uma lista.
 * @author Júlia Dambrós
 * @author Ana Júlia Orlovski
 * @version 3.0
 */
public class GerenciaJogadoresArrayList implements GerenciaJogadores {
    private ArrayList<Jogador> jogadores;

    /**
     * Construtor para a classe GerenciaJogadoresArrayList.
     */
    public GerenciaJogadoresArrayList() {
        this.jogadores = new ArrayList<>();
    }

    @Override
    public void gravarJogador(Jogador jogador) {
        jogadores.add(jogador);
        System.out.println("Jogador " + jogador.getNome() + " gravado na lista.");
    }
}




