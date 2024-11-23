package Entities;


//Entidade de perfil
public class PerfilEntity {
    private int codigo;
    private String nome;
    private String descricao;

    public PerfilEntity(int codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    };

    public int getCodigo(){
        return this.codigo; 
    }

    public String getNome(){
        return this.nome; 
    }

    public String getDescricao(){
        return this.descricao; 
    }

}
