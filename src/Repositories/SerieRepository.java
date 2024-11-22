package Repositories;

//Classe ficticia para simular uma classe de persistencia de dados

import Entities.SerieEntity;
import java.util.ArrayList;
import java.util.List;


public class SerieRepository {

    //Método ficticio de persistencia de serie
    public void persistirSerie(SerieEntity serie){
        System.out.println("GRAVANDO SERIE NO BANCO DE DADOS...");
    }

    //Método ficticio de busca de series
    public List<SerieEntity> buscarSeries(){
        System.out.println("BUSCANDO SERIES NO BANCO DE DADOS...");
        List<SerieEntity> series = new ArrayList<>();
        SerieEntity serie1 = new SerieEntity(1, "Primeiro ano");
        SerieEntity serie2 = new SerieEntity(2, "Segundo ano");
        SerieEntity serie3 = new SerieEntity(3, "Terceiro ano");
        series.add(serie1);
        series.add(serie2);
        series.add(serie3);
        return series;
    }
}
