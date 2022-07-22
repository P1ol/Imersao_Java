import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class GeradorDeFigurinha {
    

    public void cria(InputStream Input, String NomeArquivo) throws Exception {

        // Leitura da imagem
        //InputStream Input = new FileInputStream(new File("entrada/filmeGG.jpg"));
        //InputStream Input = new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg").openStream();
        BufferedImage ImagemOriginal = ImageIO.read(Input);


        // Criar nova imagem em memoria com transparencia e com tamanho novo
        int Largura = ImagemOriginal.getWidth();
        int Altura = ImagemOriginal.getHeight();
        int NovaAltura = Altura + 200;
        BufferedImage NovaImagem = new BufferedImage(Largura, NovaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original pra nova imagem(em memoria)
        Graphics2D graphics = (Graphics2D)NovaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, 0, 0, null);

        // Configurar a fonte
        Font Fonte = new Font("Comic Sans MS", Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(Fonte);

        // Escrever uma frase na nova imagem
        graphics.drawString( "TOPZERA", 100, NovaAltura - 50);

        // Escrever a nova imagem em um arquivo
        String Pasta = "Figurinhas";
        Path path = Paths.get(Pasta);
        if (!Files.exists(path)){   
        Files.createDirectory(path);
        }
        ImageIO.write(NovaImagem, "png", new File("Figurinhas/" + NomeArquivo));

    }
}
