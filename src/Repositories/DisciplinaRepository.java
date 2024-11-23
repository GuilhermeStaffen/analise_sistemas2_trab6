package Repositories;

//Classe ficticia para simular uma classe de persistencia de dados

import Entities.DisciplinaEntity;
import java.util.ArrayList;
import java.util.List;


public class DisciplinaRepository {

    //Método ficticio de persistencia de disciplina
    public void persistirDisciplina(DisciplinaEntity disciplina){
        System.out.println("GRAVANDO DISCIPLINA NO BANCO DE DADOS...");
    }

    //Método ficticio de busca de disciplinas
    public List<DisciplinaEntity> buscarDisciplinas(){
        System.out.println("BUSCANDO DISCIPLINA NO BANCO DE DADOS...");
        List<DisciplinaEntity> disciplinas = new ArrayList<>();
        DisciplinaEntity disciplina1 = new DisciplinaEntity("Matematica");
        DisciplinaEntity disciplina2 = new DisciplinaEntity("Portugues");
        DisciplinaEntity disciplina3 = new DisciplinaEntity("Filosofia");
        disciplinas.add(disciplina1);
        disciplinas.add(disciplina2);
        disciplinas.add(disciplina3);
        return disciplinas;
    }
}
