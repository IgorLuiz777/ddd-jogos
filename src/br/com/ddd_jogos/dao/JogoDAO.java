/**package br.com.ddd_jogos.dao;

import br.com.ddd_jogos.entity.Jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class JogoDAO {
    private Connection conexao;

    public void inserir(Jogo jogo) throws SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "INSERT INTO jogo (id, name, genres, released, developers, nota) VALUES (?, ?, ?, ?, ?, ?)";
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setInt(1, jogo.getId());
        comandoSql.setString(2, jogo.getName());
        comandoSql.setString(3, listaParaString(jogo.getGenres()));
        comandoSql.setString(4, jogo.getReleased());
        comandoSql.setString(5, listaParaString(jogo.getDevelopers()));
        comandoSql.setDouble(6, jogo.getNota());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }

    private String listaParaString(List<?> lista) {
        return lista.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
*/