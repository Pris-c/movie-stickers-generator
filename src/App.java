
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
        
        public static void printMovie(Map<String,String> filme){

            System.out.println("\u001b[33m" + filme.get("rank") +"ª " + " " + filme.get("title"));
            System.out.print("Nota: " + filme.get("imDbRating") + " ");
            
                Double ratingDouble = Double.parseDouble(filme.get("imDbRating"));
                int ratingInt = (int) Math.round(ratingDouble);
                for(int i=0; i< ratingInt; i++ ){
                    System.out.print("💛");
            }
            
            System.out.println("\nClique para acessar poster: \u001b[1m\u001b[0m \n" + "\u001b[3m" + filme.get("image")  + "\n");
        }


        public static void main (String[] args) throws Exception {
            
            //Fazer uma conexão http e buscar os top 250 filmes
            //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
            
            //Desafio 1: Consumir uma API diferente 
            String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

            URI endereco = URI.create(url);
            HttpClient client =  HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); 		
    
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            //System.out.println(body);
            
                        
            // Extrair os dados de interesse: Título, postes e classificação.   -Parsear os dados
            var parser = new JsonParser();
            List<Map<String, String>> listaDeFilmes = parser.parse(body);
            //System.out.println(listaDeFilmes);

            //Exibir e manipular os dados
            System.out.println("The Best Movies Ever");
            for (Map<String,String> filme : listaDeFilmes) {
                printMovie(filme);
            }
                       
        }  //Fim main
        
    } // Fim App
            