package br.com.ddd_jogos.testes;

import br.com.ddd_jogos.dao.UsuarioDAO;
import br.com.ddd_jogos.entity.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class TesteUsuario {

    public void menu() {
        System.out.println(
                "\n Bem vindo a sua lista de filme\n" +
                        "---------------------------------\n" +
                        " Selecione uma opção:\n" +
                        " 1 - Cadastrar\n" +
                        " 2 - Alterar cadastro\n" +
                        " 3 - Excluir cadastro\n" +
                        " 4 - Consultar cadastro\n" +
                        " 9 - Finalizar programa\n" +
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
        String sair;

        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDao = new UsuarioDAO();

        TesteUsuario testeUsuario = new TesteUsuario();

        do {
            testeUsuario.menu();
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    try {
                        testeUsuario.preencerDados(usuario);
                        usuarioDao.inserir(usuario);
                        System.out.println("Usuário cadastrado!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Digite o id do usuário que você deseja modificar: ");
                        usuario.setId(input.nextInt());
                        input.nextLine();

                        System.out.println("Digite o seu novo email: ");
                        usuario.setEmail(input.nextLine());

                        System.out.println("Digite sua nova senha: ");
                        usuario.setSenha(input.nextLine());
                        usuarioDao.alterar(usuario);
                        System.out.println("Usuário alterado!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Digite o id da conta que deseja excluir: ");
                        usuario.setId(input.nextInt());
                        input.nextLine();

                        usuarioDao.excluir(usuario.getId());
                        System.out.println("Usuário excluído!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Digite o id da conta que deseja consultar: ");
                        int id = input.nextInt();
                        input.nextLine();

                        usuario = usuarioDao.consultar(id);
                        System.out.println(usuario.toString());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    System.out.println("Obrigado, volte sempre!");
            }
        } while (opcao != 9);

    }
}
