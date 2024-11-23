package Facade;

import Entities.SerieEntity;
import Repositories.SerieRepository;
import java.util.List;

public class SerieFacade {

    private List<SerieEntity> series;
    private SerieRepository _serieRepository;

    public SerieFacade() {
        this._serieRepository = new SerieRepository();
        this.series = _serieRepository.buscarSeries();
    }

    public SerieEntity criarSerie(int ano, String nome) throws Exception {
        SerieEntity serie = new SerieEntity(ano, nome);
        this.series.add(serie);
        this._serieRepository.persistirSerie(serie);
        return serie;
    }

    public void listarSeries() {
        System.out.println("SERIES CADASTRADOS");
        for (SerieEntity serie : series) {
            System.out.println("Ano: " + serie.getAno() + ", nome: " + serie.getNome());
        }
        System.out.println("");
    }

    public List<SerieEntity> buscarSeries() {
        return series;
    }

    public SerieEntity buscarSerie(int ano) throws Exception {
        SerieEntity serieDesejado = series.stream()
                .filter(serie -> serie.getAno() == ano)
                .findFirst()
                .orElse(null);

        if (serieDesejado != null) {
            return serieDesejado;
        } else {
            throw new Exception("Serie com ano "+ano+" não encontrado.");
        }
    }

}
