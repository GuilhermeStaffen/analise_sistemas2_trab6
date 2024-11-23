package Entities;

import Entities.Interfaces.IArquivo;
import java.util.ArrayList;
import java.util.List;

//Entidade de usuario
public class ConteudoEntity {
    private String nome;
    private Boolean ativo;
    private IArquivo arquivo;
    private List<PerfilEntity> perfis;
    private List<SerieEntity> series;
    private List<DisciplinaEntity> disciplinas;


    public ConteudoEntity(String nome, Boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
        this.perfis = new ArrayList<>();
        this.series = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    };

    
    public String getNome(){
        return this.nome; 
    }

    public Boolean getStatus(){
        return this.ativo; 
    }

    public List<PerfilEntity> getPerfis(){
        return perfis;
    }

    public List<SerieEntity> getSeries(){
        return series;
    }

    public List<DisciplinaEntity> getDisciplinas(){
        return disciplinas;
    }

    public void atribuirArquivo(IArquivo arquivo){
        this.arquivo = arquivo;
    }

    public IArquivo getArquivo(){
        return this.arquivo;
    }

    public void definirPerfil(PerfilEntity perfil){
        perfis.add(perfil);
    }

    public void definirSerie(SerieEntity serie){
        series.add(serie);
    }

    public void definirDisciplina(DisciplinaEntity disciplina){
        disciplinas.add(disciplina);
    }

}
