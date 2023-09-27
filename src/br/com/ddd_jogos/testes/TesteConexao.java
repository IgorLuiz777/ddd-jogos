package br.com.ddd_jogos.testes;

import br.com.ddd_jogos.dao.GerenciadorBD;

public class TesteConexao {
    public static void main(String[] args) {
        if (GerenciadorBD.obterConexao() == null) {
            System.out.printf("Erro em estabelecer a conexão");
        } else {
            System.out.println("Conexão concluída!");
        }
    }
}
