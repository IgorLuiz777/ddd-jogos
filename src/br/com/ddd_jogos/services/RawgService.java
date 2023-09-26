package br.com.ddd_jogos.services;

import br.com.ddd_jogos.entity.Jogo;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.PreparedStatement;

public class RawgService {

    public Jogo buscarJogo(String titulo) {
        try{
            String endereco = "https://rawg.io/api/games/" + titulo + "?key=1ac5fa1fe3064d9bb748fe2fa0561161";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco)).build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Jogo.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
