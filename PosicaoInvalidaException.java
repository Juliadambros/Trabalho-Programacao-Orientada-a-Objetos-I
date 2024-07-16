package jogodaVelha;

/**
 * Exceção lançada quando uma posição inválida é escolhida no tabuleiro.
 * @author Júlia Dambrós
 * @author Ana Júlia Orlovski
 * @version 1.0
 */
public class PosicaoInvalidaException extends Exception {
    /**
     * Construtor para a classe PosicaoInvalidaException.
     * @param message A mensagem de erro.
     */
    public PosicaoInvalidaException(String message) {
        super(message);
    }
}


