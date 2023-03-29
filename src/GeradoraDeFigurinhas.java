import javax.imageio.ImageIO;
import java.io.File;
import java.text.Format;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;



public class GeradoraDeFigurinhas {

    public void cria() throws Exception{

        //Leitura de imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));   //**Add throw declaration

        //Cria imagem de transparencia com novo tamanho (em relação à imagem lida)
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();

        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);



        //Copia imagem original para novaImagem (transparente) criada
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();            //Caneta da imagem
        graphics.drawImage(imagemOriginal, 0, 0, null);            //Escrever imagem antiga (poster) na nova (transparente)


        //Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);
        graphics.setColor(Color.MAGENTA);

        //Escrever uma frase na novaImagem
        graphics.drawString("Figurinha 1", 0, novaAltura-100);


        //Desafio 1 - Aula 2: Criar diretório de saída se este ainda não existe
        if (!new File("saida").exists()) {
            new File("saida").mkdir();
        }
        //Escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
        }



        public static void main(String[] args) throws Exception {
            var geradora = new GeradoraDeFigurinhas();
            geradora.cria();
        }

}
