package Repositories;

//Classe ficticia para simular uma classe de persistencia de dados

import Entities.PerfilEntity;
import java.util.ArrayList;
import java.util.List;


public class PerfilRepository {

    //Método ficticio de persistencia de perfil
    public void persistirPerfil(PerfilEntity perfil){
        System.out.println("GRAVANDO PERFIL NO BANCO DE DADOS...");
    }

    //Método ficticio de busca de perfis
    public List<PerfilEntity> buscarPerfis(){
        System.out.println("BUSCANDO PERFIS NO BANCO DE DADOS...");
        List<PerfilEntity> perfis = new ArrayList<>();
        PerfilEntity perfil1 = new PerfilEntity(1, "Administrador", "Publica conteudo na plataforma");
        PerfilEntity perfil2 = new PerfilEntity(2, "Professor", "Acessa conteudo de professor na plataforma");
        PerfilEntity perfil3 = new PerfilEntity(3, "Aluno", "Acessa conteudo de aluno na plataforma");
        perfis.add(perfil1);
        perfis.add(perfil2);
        perfis.add(perfil3);
        return perfis;
    }
}
