package Facade;

import Entities.DisciplinaEntity;
import Repositories.DisciplinaRepository;
import java.util.List;

public class DisciplinaFacade {

    private List<DisciplinaEntity> disciplinas;
    private DisciplinaRepository _disciplinaRepository;

    public DisciplinaFacade() {
        this._disciplinaRepository = new DisciplinaRepository();
        this.disciplinas = _disciplinaRepository.buscarDisciplinas();
    }

    public DisciplinaEntity criarDisciplina(String nome) throws Exception {
        DisciplinaEntity disciplina = new DisciplinaEntity(nome);
        this.disciplinas.add(disciplina);
        this._disciplinaRepository.persistirDisciplina(disciplina);
        return disciplina;
    }

    public void listarDisciplinas() {
        System.out.println("DISCIPLINA CADASTRADOS");
        for (DisciplinaEntity disciplina : disciplinas) {
            System.out.println("Nome: " + disciplina.getNome());
        }
        System.out.println("");
    }

    public List<DisciplinaEntity> buscarDisciplinas() {
        return disciplinas;
    }

    public DisciplinaEntity buscarDisciplina(String nome) throws Exception {
        DisciplinaEntity disciplinaDesejado = disciplinas.stream()
                .filter(disciplina -> disciplina.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        if (disciplinaDesejado != null) {
            return disciplinaDesejado;
        } else {
            throw new Exception("Disciplina com nome " + nome + " não encontrado.");
        }
    }

}
