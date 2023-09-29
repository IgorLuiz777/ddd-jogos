package br.com.ddd_jogos.dao;

import br.com.ddd_jogos.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexao;
    public void inserir(Usuario usuario) throws SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSql =  null;
        String sql = "INSERT INTO usuario (id, nome, email, senha) values(?,?,?,?)";
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setInt(1, usuario.getId());
        comandoSql.setString(2, usuario.getNome());
        comandoSql.setString(3, usuario.getEmail());
        comandoSql.setString(4, usuario.getSenha());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }
    public void alterar(Usuario usuario) throws  SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQl = null;
        String sql = "UPDATE usuario SET email = ?, senha = ? WHERE id = ?";
        comandoSQl = conexao.prepareStatement(sql);

        comandoSQl.setString(1, usuario.getEmail());
        comandoSQl.setString(2, usuario.getSenha());
        comandoSQl.setInt(3, usuario.getId());
        comandoSQl.executeUpdate();
        conexao.close();
        comandoSQl.close();
    }
    public void excluir(int id) throws SQLException{
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQl = null;
        String sql = "DELETE FROM usuario WHERE id = ?";

        comandoSQl = conexao.prepareStatement(sql);
        comandoSQl.setInt(1, id);
        comandoSQl.executeUpdate();
        conexao.close();
        comandoSQl.close();
    }
    public Usuario consultar(int id) throws  SQLException{
        Usuario usuario = new Usuario();
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;
        String sql = "SELECT * FROM usuario WHERE id = ?";

        comandoSQL = conexao.prepareStatement(sql);
        comandoSQL.setInt(1, id);

        ResultSet rs = comandoSQL.executeQuery();

        if (rs.next()) {
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
        }
        return usuario;
    }
}
