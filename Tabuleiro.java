package jogodaVelha;

/**
 * Classe que representa o tabuleiro do jogo da velha.
 * @author Júlia Dambrós
 * @version 5.0
 */
public class Tabuleiro {
    private char[][] tabuleiro;
    private static final int TAMANHO = 3;

    /**
     * Construtor para a classe Tabuleiro.
     */
    public Tabuleiro() {
        tabuleiro = new char[TAMANHO][TAMANHO];
        inicializar();
    }


    private void inicializar() {
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void exibir() {
        System.out.println("  1 2 3");
        for (int i = 0; i < TAMANHO; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < TAMANHO; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < TAMANHO - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < TAMANHO - 1) {
                System.out.println("  -----");
            }
        }
    }

    /**
     * Realiza uma jogada no tabuleiro.
     * @param jogada A jogada a ser realizada.
     * @throws PosicaoOcupadaException Se a posição já estiver ocupada.
     * @throws PosicaoInvalidaException Se a posição for inválida.
     */
    public void realizarJogada(Jogada jogada) throws PosicaoOcupadaException, PosicaoInvalidaException {
        int linha = jogada.getLinha() - 1;
        int coluna = jogada.getColuna() - 1;

        if (linha < 0 || linha >= TAMANHO || coluna < 0 || coluna >= TAMANHO) {
            throw new PosicaoInvalidaException("Posição inválida! Escolha uma posição dentro do tabuleiro.");
        }

        if (tabuleiro[linha][coluna] != ' ') {
            throw new PosicaoOcupadaException("Esta posição já está ocupada! Escolha outra posição.");
        }

        tabuleiro[linha][coluna] = jogada.getTipo();
    }

    /**
     * Verifica se há um vencedor no tabuleiro.
     * @param tipo O tipo de jogada (X ou O).
     * @return true se há um vencedor, false caso contrário.
     */
    public boolean verificarVencedor(char tipo) {
        // Verificar linhas e colunas
        for (int i = 0; i < TAMANHO; i++) {
            if (tabuleiro[i][0] == tipo && tabuleiro[i][1] == tipo && tabuleiro[i][2] == tipo) {
                return true; // Linhas
            }
            if (tabuleiro[0][i] == tipo && tabuleiro[1][i] == tipo && tabuleiro[2][i] == tipo) {
                return true; // Colunas
            }
        }
        // Verificar diagonais
        if (tabuleiro[0][0] == tipo && tabuleiro[1][1] == tipo && tabuleiro[2][2] == tipo) {
            return true; // Diagonal principal
        }
        if (tabuleiro[0][2] == tipo && tabuleiro[1][1] == tipo && tabuleiro[2][0] == tipo) {
            return true; // Diagonal secundária
        }
        return false;
    }

    /**
     * Verifica se o tabuleiro está cheio.
     * @return true se o tabuleiro está cheio, false caso contrário.
     */
    public boolean estaCheio() {
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}



