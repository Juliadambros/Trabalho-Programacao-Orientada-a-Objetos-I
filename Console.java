package entreDados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe utilitária para leitura de dados do console.
 * @author Júlia Dambrós
 * @author Ana Júlia Orlovski
 * @version 3.0
 */
public class Console {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Lê uma string do console.
     * @param mensagem Mensagem a ser exibida ao usuário.
     * @return A string lida.
     */
    public static String lerString(String mensagem) {
        String valor = null;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                exibirMensagem(mensagem);
                valor = reader.readLine();
                entradaValida = true;
            } catch (IOException e) {
                exibirMensagem("Erro ao ler linha.");
            }
        }
        return valor;
    }

    /**
     * Lê um caractere do console.
     * @param mensagem Mensagem a ser exibida ao usuário.
     * @return O caractere lido.
     */
    public static char lerChar(String mensagem) {
        char valor = '\0';
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                exibirMensagem(mensagem);
                valor = (char) reader.read();
                reader.readLine(); // Limpar o buffer
                entradaValida = true;
            } catch (IOException e) {
                exibirMensagem("Erro ao ler caractere.");
            }
        }
        return valor;
    }

    /**
     * Lê um número inteiro do console.
     * @param mensagem Mensagem a ser exibida ao usuário.
     * @return O número inteiro lido.
     */
    public static int lerInt(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                exibirMensagem(mensagem);
                valor = Integer.parseInt(reader.readLine());
                entradaValida = true;
            } catch (IOException | NumberFormatException e) {
                exibirMensagem("Erro ao ler número inteiro.");
            }
        }
        return valor;
    }

    public static void fechar() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao fechar o leitor.");
        }
    }

    /**
     * Exibe uma mensagem no console.
     * @param mensagem A mensagem a ser exibida.
     */
    private static void exibirMensagem(String mensagem) {
        System.out.print(mensagem + " ");
    }
}




