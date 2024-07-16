package jogodaVelha;

/**
 * Classe que representa uma jogada no jogo da velha.
 * @author Júlia Dambrós
 * @author Ana Júlia Orlovski
 * @version 5.0
 */
public class Jogada {
    private int linha;
    private int coluna;
    private char tipo;

    /**
     * Construtor para a classe Jogada.
     * @param linha Linha da jogada.
     * @param coluna Coluna da jogada.
     * @param tipo Tipo de jogada (X ou O).
     */
    public Jogada(int linha, int coluna, char tipo) {
        this.linha = linha;
        this.coluna = coluna;
        this.tipo = tipo;
    }

    /**
     * Obtém a linha da jogada.
     * @return A linha da jogada.
     */
    public int getLinha() {
        return linha;
    }

    /**
     * Obtém a coluna da jogada.
     * @return A coluna da jogada.
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * Obtém o tipo de jogada (X ou O).
     * @return O tipo de jogada.
     */
    public char getTipo() {
        return tipo;
    }
}





