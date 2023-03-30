import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App{

    static GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

    public static void main (String[] args) throws Exception {
        
    //Fazer uma conexão http e buscar os top 250 filmes
    //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
    String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
    ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

    
    //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-02-10&end_date=2023-02-14";
    //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();   
    var http = new ClienteHttp();
    String json = http.buscaDados(url);

    //Exibir e manipular os dados
    List<Conteudo> conteudos = extrator.extraiConteudo(json);


    //CRIAR FIGURINHA
    for (int j = 0; j<2; j++) {
        Conteudo conteudo = conteudos.get(j);

        InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
        String nomeArquivo = conteudo.getTitulo() + ".png";

        //int ratingInt = (int) Double.parseDouble(conteudo.get("imDbRating"));
        String textoFigurinha = "FIGURINHA";

        geradora.cria(inputStream, nomeArquivo, textoFigurinha);
        System.out.println(conteudo.getTitulo());
    }





    //IMPRIMIR
    /*for (int i = 0; i<10; i++) {
        //printMovie(conteudo);
        Map<String, String> conteudo  = listaDeConteudos.get(i);

        String titulo = conteudo.get("title");
        String nota = conteudo.get("imDbRating");

        System.out.println("\u001b[33m" + conteudo.get("rank") +"ª " + " " + titulo);
        System.out.print("Nota: " + nota + " ");
    
        Double ratingDouble = Double.parseDouble(nota);
        int ratingInt = (int) Math.round(ratingDouble);
        for(int y=0; y< ratingInt; y++ ){
            System.out.print("💛");
        }
        System.out.println("\nClique para acessar poster: \u001b[1m\u001b[0m \n" + "\u001b[3m" + conteudo.get("image")  + "\n");
    }*/

    
                    
    }
    
} 