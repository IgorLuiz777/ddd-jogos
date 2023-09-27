package br.com.ddd_jogos.dao;

import br.com.ddd_jogos.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexao;
    public void inserir(Usuario usuario) throws SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSql =  null;
        String sql = "insert into usuario (id, nome, email, senha) values(?,?,?,?)";
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setInt(1, usuario.getId());
        comandoSql.setString(2, usuario.getNome());
        comandoSql.setString(3, usuario.getEmail());
        comandoSql.setString(4, usuario.getSenha());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }
}
