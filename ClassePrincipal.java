package jogodaVelha;

import entreDados.Console;

/**
 * Esta classe principal controla a execução do jogo, permitindo ao jogador
 * escolher entre jogar uma partida única ou uma série "melhor de três".
 * @author Júlia Dambrós
 * @version 5.0
 */
public class ClassePrincipal {
    /**
     * Método principal que inicia o jogo da velha.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        String nomeJogador1 = Console.lerString("Digite o nome do jogador X:");
        String nomeJogador2 = Console.lerString("Digite o nome do jogador O:");

        int escolha = Console.lerInt("Digite 1 para jogar uma partida ou 3 para jogar melhor de três:");

        Jogo jogo = new Jogo(nomeJogador1, nomeJogador2);

        if (escolha == 3) {
            jogo.jogarMelhorDeTres();
        } else {
            jogo.jogar();
        }

        Console.fechar();
    }
}

// Funcionalidade extra: Esta funcionalidade permite ao usuário escolher entre jogar
// uma partida única ou uma série "melhor de três". Na série "melhor de três", os jogadores
// competem em três partidas consecutivas. O jogador que ganhar duas das três partidas é
// considerado o vencedor. Se houver um empate (ambos os jogadores ganharem uma partida cada),
// ninguém pontua na série.
//
//Justificativa da Escolha da Funcionalidade:
//A inclusão da opção "melhor de três" adiciona variedade e desafio ao jogo da velha.
// Em vez de uma única partida rápida, os jogadores têm a oportunidade de recuperar de uma
// derrota inicial e demonstrar consistência ao longo de várias partidas.
// Isso aumenta a profundidade estratégica do jogo.