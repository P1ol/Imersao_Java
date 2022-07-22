import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexao HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060"; //Link alternativo
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Estrair so os dados que interessam (Titulo, Poster, Classificacao)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // Cor de texto
        String Verde = "\u001B[32m";
        String Preto = "\u001B[30m";
        String Reset = "\u001B[0m";
        // Fundo do texto
        String Amarelo = "\u001B[43m";
        // Emojis UTF-8
        String Estrela = "\u2B50";
        
        
        //Exibir e manipular
        for (Map<String,String> filme : listaDeFilmes) {

            System.out.println(Verde + "Titulo:" + Reset + filme.get("title"));
            System.out.println(Verde + "Poster:" + Reset + filme.get("image"));
            System.out.println(Verde + "Classificacao:" + Reset + Amarelo + Preto + filme.get("imDbRating") + Estrela + Reset);
        }

    }
}