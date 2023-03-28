
	/* IMDb Top 250 Movies
	
		1) Fazer uma conexão http e buscar os top 250 filmes

		2) Extrais os dados de interesse: Título, postes e classificação.   -Parsear os dados

		3) Exibir e manipular os dados

	*/
	   

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
    
    
    
    
    public class App{
        
        public static void main (String[] args) throws Exception {
    
            
            
            //Fazer uma conexão http e buscar os top 250 filmes
    
            
            String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
            
            URI endereco = URI.create(url);
            
            HttpClient client =  HttpClient.newHttpClient();
    
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); 		
    
    
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            
            String body = response.body();
            
            System.out.println(body);
            
            
            
            // Extrais os dados de interesse: Título, postes e classificação.   -Parsear os dados
            var parser = new JsonParser();
            List< Map<String, String> > listaDeFilmes = parser.parse(body);
            System.out.println(listaDeFilmes);

            //Exibir e manipular os dados
            for (Map<String,String> filme : listaDeFilmes) {
                System.out.println("Posição: " + filme.get("rank"));
                System.out.println("Nota:  " + filme.get("imDbRating"));
                System.out.println("Filme: " + filme.get("title"));
                System.out.println("Acessar poster:\n" + filme.get("image")  + "\n");
                System.out.println("\u2B50");
               
            }
           
            
        }  //Fim main
        
        
        
        } // Fim App
            