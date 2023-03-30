

//Classe não precisa de Setter, pois valores nao serao alterados após a criação

public class Conteudo {
    
    private final  String titulo;
    private final String urlImagem;

    public Conteudo(String titulo, String urlImagem){
        this.titulo = titulo;
        this.urlImagem = urlImagem;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getUrlImagem() {
        return urlImagem;
    }

    
}
