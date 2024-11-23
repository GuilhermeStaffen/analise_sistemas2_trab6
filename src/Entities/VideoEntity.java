package Entities;

import Entities.Interfaces.IArquivo;

public class VideoEntity implements IArquivo {

    private String nome;
    private String metadados;
    private String url;

    public VideoEntity(String nome, String metadados, String url) {
        this.nome = nome;
        this.metadados = metadados;
        this.url = url;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getURL() {
        return this.url;
    }

}
