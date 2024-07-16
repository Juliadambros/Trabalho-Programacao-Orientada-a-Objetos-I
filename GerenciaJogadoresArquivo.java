package armazenamento;

import jogodaVelha.Jogador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe que implementa GerenciaJogadores para gravar jogadores em um arquivo.
 * @author Júlia Dambrós
 * @author Ana Júlia Orlovski
 * @version 3.0
 */
public class GerenciaJogadoresArquivo implements GerenciaJogadores {
    private static final String ARQUIVO_JOGADORES = "jogadores.txt";

    @Override
    public void gravarJogador(Jogador jogador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_JOGADORES, true))) {
            writer.write(jogador.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao gravar jogador: " + e.getMessage());
        }
    }
}






