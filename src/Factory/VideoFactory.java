package Factory;
import Entities.Interfaces.IArquivo;
import Entities.VideoEntity;
import Factory.Interfaces.IMidiaFactory;

public class VideoFactory implements IMidiaFactory {

    @Override
    public IArquivo criarMidia(String nome, String metadados) {
        
        // TODA IMPLEMENTAÇÃO SUBINDO ARQUIVO EM UM SERVIDOR (EX: YOUTUBE, VIMEO, ETC.)
        return new VideoEntity(nome, metadados, "https://video.com/"+nome);
    }
}