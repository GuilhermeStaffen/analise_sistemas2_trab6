package Repositories;

import Entities.UsuarioEntity;

//Classe ficticia para simular uma classe de persistencia de dados

public class UsuarioRepository {

    //Método ficticio de persistencia de usuario
    public void persistirUsuario(UsuarioEntity usuario){
        System.out.println("GRAVANDO USUARIO " + usuario.getNome()+"\n");
    }

    public void persistirPerfilUsuario(UsuarioEntity usuario){
        System.out.println("GRAVANDO PERFIL USUARIO " + usuario.getNome()+"\n");
    }

    public void persistirSerieUsuario(UsuarioEntity usuario){
        System.out.println("GRAVANDO SERIE USUARIO " + usuario.getNome()+"\n");
    }
    
}
