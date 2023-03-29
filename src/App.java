import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
    
    
    public class App{
        
        

        //Desafio 2 - Aula 1: Custumização
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


        static GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        public static void gerarFigurinha(Map<String,String> filme) throws Exception{

            //Buscando imagem de melhor qualidade
            String urlImagem = filme.get("image");
            String[] urlImagemSplited = urlImagem.split("._");
            String urlImagemMaior = urlImagemSplited[0] + ".png";

            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagemMaior).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);
        }

        public static void main (String[] args) throws Exception {
            
            //Fazer uma conexão http e buscar os top 250 filmes
            //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
            
            //Desafio 1 - Aula 1set: Consumir uma API diferente 
            String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

            /*Desafio 3 - Aula 1: Utilizar Variáveis de Ambiente
            String hideUrl = System.getenv("HIDE_URL");
            String url = ("https://mocki.io/v1/" + hideUrl);
            System.out.println(hideUrl);*/
            

            URI endereco = URI.create(url);
            HttpClient client =  HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); 		
    
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
                        
            // Extrair os dados de interesse: Título, postes e classificação.   -Parsear os dados
            var parser = new JsonParser();
            List<Map<String, String>> listaDeFilmes = parser.parse(body);
            //System.out.println(listaDeFilmes);

            //Exibir e manipular os dados
            System.out.println("The Best Movies Ever");

            for (Map<String,String> filme : listaDeFilmes) {
                //printMovie(filme);
                System.out.println(filme.get("title"));
                gerarFigurinha(filme);
            }
                       
        }
        
    } 