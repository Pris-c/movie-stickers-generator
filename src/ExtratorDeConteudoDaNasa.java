import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{

    public List<Conteudo> extraiConteudo(String json){

        // Extrair os dados de interesse: Título, postes e classificação.   -Parsear os dados
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();

        //popular lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {

            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo (titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
    
}
