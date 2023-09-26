package br.com.ddd_jogos.testes;

import br.com.ddd_jogos.entity.Jogo;
import br.com.ddd_jogos.services.RawgService;

import java.util.Scanner;

public class TesteBuscaJogo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RawgService consulta = new RawgService();
        Jogo jogo = new Jogo();

        System.out.println("Digite o nome do Jogo: ");
        var titulo = input.nextLine();
        try {
            jogo = consulta.buscarJogo(titulo);
            System.out.println(jogo);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

    }
}
