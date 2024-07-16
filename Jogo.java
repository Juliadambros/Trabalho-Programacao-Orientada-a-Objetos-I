package jogodaVelha;

import entreDados.Console;
import armazenamento.GerenciaJogadores;
import armazenamento.GerenciaJogadoresArquivo;

/**
 * Classe que representa o jogo da velha.
 * Oferece métodos para jogar uma partida única ou uma série "melhor de três".
 * @author Júlia Dambrós
 * @author Ana Júlia Orlovski
 * @version 5.0
 */
public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private GerenciaJogadores gerenciaJogadores;

    /**
     * Construtor para a classe Jogo.
     * @param nomeJogador1 Nome do jogador 1.
     * @param nomeJogador2 Nome do jogador 2.
     */
    public Jogo(String nomeJogador1, String nomeJogador2) {
        tabuleiro = new Tabuleiro();
        jogador1 = new Jogador(nomeJogador1, 'X');
        jogador2 = new Jogador(nomeJogador2, 'O');
        jogadorAtual = jogador1;
        gerenciaJogadores = new GerenciaJogadoresArquivo();
    }

    public void jogar() {
        boolean jogoEmAndamento = true;
        tabuleiro.exibir();

        while (jogoEmAndamento) {
            try {
                realizarJogada();
                tabuleiro.exibir();
                if (verificarVencedor()) {
                    System.out.println("Jogador " + jogadorAtual.getNome() + " venceu!");
                    gerenciaJogadores.gravarJogador(jogadorAtual);
                    jogoEmAndamento = false;
                } else if (tabuleiro.estaCheio()) {
                    System.out.println("Empate!");
                    jogoEmAndamento = false;
                } else {
                    alternarJogador();
                }
            } catch (PosicaoInvalidaException | PosicaoOcupadaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * O jogador que ganhar duas das três partidas é considerado o vencedor da série.
     */
    public void jogarMelhorDeTres() {
        int vitoriasJogador1 = 0;
        int vitoriasJogador2 = 0;

        for (int i = 0; i < 3; i++) {
            tabuleiro = new Tabuleiro();
            jogadorAtual = jogador1;
            boolean jogoEmAndamento = true;
            tabuleiro.exibir();

            while (jogoEmAndamento) {
                try {
                    realizarJogada();
                    tabuleiro.exibir();
                    if (verificarVencedor()) {
                        System.out.println("Jogador " + jogadorAtual.getNome() + " venceu a partida " + (i + 1) + "!");
                        if (jogadorAtual == jogador1) {
                            vitoriasJogador1++;
                        } else {
                            vitoriasJogador2++;
                        }
                        jogoEmAndamento = false;
                    } else if (tabuleiro.estaCheio()) {
                        System.out.println("Empate na partida " + (i + 1) + "!");
                        jogoEmAndamento = false;
                    } else {
                        alternarJogador();
                    }
                } catch (PosicaoInvalidaException | PosicaoOcupadaException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if (vitoriasJogador1 > vitoriasJogador2) {
            System.out.println("Jogador " + jogador1.getNome() + " venceu a melhor de três!");
            gerenciaJogadores.gravarJogador(jogador1);
        } else if (vitoriasJogador2 > vitoriasJogador1) {
            System.out.println("Jogador " + jogador2.getNome() + " venceu a melhor de três!");
            gerenciaJogadores.gravarJogador(jogador2);
        } else {
            System.out.println("Empate na melhor de três!");
        }
    }

    /**
     * Realiza uma jogada no tabuleiro.
     * @throws PosicaoInvalidaException Se a posição escolhida for inválida.
     * @throws PosicaoOcupadaException Se a posição escolhida já estiver ocupada.
     */
    private void realizarJogada() throws PosicaoInvalidaException, PosicaoOcupadaException {
        int linha = Console.lerChar("Jogador " + jogadorAtual.getNome() + ", escolha a linha (1-3): ") - '0';
        int coluna = Console.lerChar("Jogador " + jogadorAtual.getNome() + ", escolha a coluna (1-3): ") - '0';

        Jogada jogada = new Jogada(linha, coluna, jogadorAtual.getTipo());
        tabuleiro.realizarJogada(jogada);
    }

    /**
     * Verifica se há um vencedor no jogo.
     * @return true se há um vencedor, false caso contrário.
     */
    private boolean verificarVencedor() {
        return tabuleiro.verificarVencedor(jogadorAtual.getTipo());
    }

    private void alternarJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
        } else {
            jogadorAtual = jogador1;
        }
    }
}



