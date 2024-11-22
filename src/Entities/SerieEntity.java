package Entities;



public class SerieEntity {
    private String nome;
    private int ano;


    public SerieEntity(int ano, String nome) {
        this.nome = nome;
        this.ano = ano;
    };

    public int getAno(){
        return this.ano; 
    }

    public String getNome(){
        return this.nome; 
    }


}
