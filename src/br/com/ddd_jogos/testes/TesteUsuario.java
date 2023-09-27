package br.com.ddd_jogos.testes;

import br.com.ddd_jogos.dao.UsuarioDAO;
import br.com.ddd_jogos.entity.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class TesteUsuario {

    public void menu() {
        System.out.println(
                " Bem vindo a sua lista de filme\n" +
                        "---------------------------------\n" +
                        "Selecione uma opção:\n" +
                        " 1 - Cadastrar\n" +
                        " 2 - Alterar cadastro\n" +
                        " 3 - Excluir cadastro\n" +
                        " 4 - Consultar cadastro por id\n" +
                        "---------------------------------");
    }

    public static Usuario preencerDados(Usuario usuario) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        usuario.setNome(input.nextLine());

        System.out.println("Digite o seu email: ");
        usuario.setEmail(input.nextLine());

        System.out.println("Digite sua senha: ");
        usuario.setSenha(input.nextLine());

        System.out.println("Por fim, digite um id numérico de sua escolha: ");
        usuario.setId(input.nextInt());
        input.nextLine();

        return usuario;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDao = new UsuarioDAO();

        TesteUsuario testeUsuario = new TesteUsuario();

        testeUsuario.menu();
        opcao = input.nextInt();
        switch (opcao) {
            case 1:
                testeUsuario.preencerDados(usuario);
                try {
                    usuarioDao.inserir(usuario);
                    System.out.println("Usuário cadastrado!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
