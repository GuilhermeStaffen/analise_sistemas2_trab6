package Entities;

import java.util.ArrayList;
import java.util.List;

public class UsuarioEntity {
    private String nome;
    private String email;
    private String senha;
    private String matricula;
    private Boolean ativo;
    private List<PerfilEntity> perfis;
    private List<SerieEntity> series;

    public UsuarioEntity(String nome, String email, String senha, String matricula, Boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.matricula = matricula;
        this.ativo = ativo;
        this.perfis = new ArrayList<>();
        this.series = new ArrayList<>();
    };

    
    public String getNome(){
        return this.nome; 
    }

    public String getEmail(){
        return this.email; 
    }

    public String getMatricula(){
        return this.matricula; 
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

    public void definirPerfil(PerfilEntity perfil){
        perfis.add(perfil);
    }

    public void definirSerie(SerieEntity serie){
        series.add(serie);
    }

}
