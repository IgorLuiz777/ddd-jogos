package br.com.ddd_jogos.testes;

import br.com.ddd_jogos.entity.Developer;
import br.com.ddd_jogos.entity.Genre;
import br.com.ddd_jogos.entity.Jogo;
import br.com.ddd_jogos.services.RawgService;

import java.util.List;
import java.util.Scanner;

public class TesteBuscaJogo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RawgService consulta = new RawgService();
        Jogo jogo = new Jogo();

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
            } else {
                System.out.println("Jogo não encontrado.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}
