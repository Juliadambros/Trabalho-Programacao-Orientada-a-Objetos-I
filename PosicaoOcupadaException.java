package jogodaVelha;

/**
 * Exceção lançada quando uma posição já ocupada é escolhida no tabuleiro.
 * @author Júlia Dambrós
 * @author Ana Júlia Orlovski
 * @version 1.0
 */
public class PosicaoOcupadaException extends Exception {
    /**
     * Construtor para a classe PosicaoOcupadaException.
     * @param message A mensagem de erro.
     */
    public PosicaoOcupadaException(String message) {
        super(message);
    }
}


