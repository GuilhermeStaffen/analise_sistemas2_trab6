package Factory.Interfaces;

import Entities.Interfaces.IArquivo;

public interface IMidiaFactory {
    IArquivo criarMidia(String titulo, String detalhe);
}