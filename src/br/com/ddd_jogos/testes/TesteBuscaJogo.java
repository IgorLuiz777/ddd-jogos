package br.com.ddd_jogos.testes;

import br.com.ddd_jogos.entity.Developer;
import br.com.ddd_jogos.entity.Genre;
import br.com.ddd_jogos.entity.Jogo;
import br.com.ddd_jogos.services.RawgService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TesteBuscaJogo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RawgService consulta = new RawgService();
        Jogo jogo = new Jogo();

        lerArquivo();

        System.out.println("Digite o nome do Jogo: ");
        var titulo = input.nextLine().replace(" ", "-");
        try {
            jogo = consulta.buscarJogo(titulo);
            if (jogo.getName() != null) {
                System.out.println("Informações do Jogo:");
                System.out.println("Título: " + jogo.getName());
                System.out.println("Data de Lançamento: " + jogo.getDate());
                List<Genre> genres = jogo.getGenres();
                System.out.print("Gêneros: ");
                int tamanhoLista1 = genres.size();
                for (int i = 0; i < tamanhoLista1; i++) {
                    String generos = genres.get(i).getName();
                    System.out.print(generos);
                    if (i < tamanhoLista1 - 1) {
                        System.out.print(" e ");
                    }
                }
                List<Developer> developers = jogo.getDevelopers();
                System.out.print("\nDesenvolvedores: ");
                int tamanhoLista = developers.size();
                for (int i = 0; i < tamanhoLista; i++) {
                    String desenvolvedores = developers.get(i).getName();
                    System.out.print(desenvolvedores);
                    if (i < tamanhoLista - 1) {
                        System.out.print(" e ");
                    }
                }
                System.out.println("\nID: " + jogo.getId());

                salvarResultadosEmArquivo(jogo);
            } else {
                System.out.println("Jogo não encontrado.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }

    private static void salvarResultadosEmArquivo(Jogo jogo) {
        try (FileWriter writer = new FileWriter("jogo.txt", true)) {
            writer.write("Informações do Jogo:\n");
            writer.write("Título: " + jogo.getName() + "\n");
            writer.write("Data de Lançamento: " + jogo.getDate() + "\n");
            List<Genre> genres = jogo.getGenres();
            writer.write("Gêneros: ");
            int tamanhoLista1 = genres.size();
            for (int i = 0; i < tamanhoLista1; i++) {
                String generos = genres.get(i).getName();
                writer.write(generos);
                if (i < tamanhoLista1 - 1) {
                    writer.write(" e ");
                }
            }
            List<Developer> developers = jogo.getDevelopers();
            writer.write("\nDesenvolvedores: ");
            int tamanhoLista = developers.size();
            for (int i = 0; i < tamanhoLista; i++) {
                String desenvolvedores = developers.get(i).getName();
                writer.write(desenvolvedores);
                if (i < tamanhoLista - 1) {
                    writer.write(" e ");
                }
            }
            writer.write("\nID: " + jogo.getId() + "\n");
            System.out.println("Resultados salvos em jogo.txt");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os resultados em arquivo: " + e.getMessage());
        }
    }
    private static void lerArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("jogo.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
