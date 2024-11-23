package Entities;


//Entidade de disciplina
public class DisciplinaEntity {
    private String nome;


    public DisciplinaEntity(String nome) {
        this.nome = nome;
    };

    public String getNome(){
        return this.nome; 
    }


}
