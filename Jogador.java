package jogodaVelha;

/**
 * Classe que representa um jogador no jogo da velha.
 * @author Júlia Dambrós
 * @version 5.0
 */
public class Jogador {
    private String nome;
    private char tipo;
    private int pontuacao;

    /**
     * Construtor para a classe Jogador.
     * @param nome Nome do jogador.
     * @param tipo Tipo de jogada (X ou O).
     */
    public Jogador(String nome, char tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.pontuacao = 1;    //pra começar com 1 se não ficava com 0 mesmo tendo ganhado
    }

    /**
     * Obtém o nome do jogador.
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o tipo de jogada (X ou O).
     * @return O tipo de jogada.
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * Obtém a pontuação do jogador.
     * @return A pontuação do jogador.
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Adiciona pontos à pontuação do jogador.
     * @param pontos Pontos a serem adicionados.
     */
    public void adicionarPontos(int pontos) {
        this.pontuacao += pontos;
    }

    @Override
    public String toString() {
        return nome + " " + tipo + " " + pontuacao;
    }
}






