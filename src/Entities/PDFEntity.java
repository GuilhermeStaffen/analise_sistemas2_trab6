package Entities;

import Entities.Interfaces.IArquivo;

public class PDFEntity implements IArquivo {

    private String nome;
    private int quantidadePaginas;
    private String url;

    public PDFEntity(String nome, int quantidadePaginas, String url){
        this.nome = nome;
        this.quantidadePaginas = quantidadePaginas;
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

    public int getQuantidadePaginas(){
        return this.quantidadePaginas;
    }
    
}
