package Factory;
import Entities.Interfaces.IArquivo;
import Entities.PDFEntity;
import Factory.Interfaces.IMidiaFactory;

public class PDFFactory implements IMidiaFactory {
    @Override
    public IArquivo criarMidia(String nome, String quantidadePaginas) {

        // TODA IMPLEMENTAÇÃO SUBINDO ARQUIVO EM UM SERVIDOR (EX: ONE DRIVE, GOOGLE DRIVE, ETC.)
        
        return new PDFEntity(nome, Integer.parseInt(quantidadePaginas), "https://PDF.com/"+nome);
    }
}
