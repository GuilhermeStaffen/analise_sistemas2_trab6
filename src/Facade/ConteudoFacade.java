package Facade;

import Entities.ConteudoEntity;
import Entities.DisciplinaEntity;
import Entities.Interfaces.IArquivo;
import Entities.PerfilEntity;
import Entities.SerieEntity;
import Factory.Interfaces.IMidiaFactory;
import Repositories.ConteudoRepository;
import java.util.ArrayList;
import java.util.List;

public class ConteudoFacade {

    private ConteudoRepository _conteudoRepository;
    private List<ConteudoEntity> conteudos;

    public ConteudoFacade() {
        this._conteudoRepository = new ConteudoRepository();
        this.conteudos = new ArrayList<>();
    }

    public ConteudoEntity criarConteudo(String nome, Boolean ativo) throws Exception {
        ConteudoEntity conteudo = new ConteudoEntity(nome, ativo);
        this.conteudos.add(conteudo);
        this._conteudoRepository.persistirConteudo(conteudo);
        return conteudo;
    }

    public void atribuirPerfil(ConteudoEntity conteudo, PerfilEntity perfil) {
        List<PerfilEntity> perfilAtribuidos = conteudo.getPerfis();
        if (perfilAtribuidos.contains(perfil)) {
            System.out.println("Perfil " + perfil.getNome() + " já foi adicionado ao conteudo " + conteudo.getNome());
        } else {
            perfilAtribuidos.add(perfil);
            _conteudoRepository.persistirPerfilConteudo(conteudo);
        }
    }

    public void atribuirSerie(ConteudoEntity conteudo, SerieEntity serie) {
        List<SerieEntity> serieAtribuidos = conteudo.getSeries();
        if (serieAtribuidos.contains(serie)) {
            System.out.println("Serie " + serie.getNome() + " já foi adicionado ao conteudo " + conteudo.getNome());
        } else {
            serieAtribuidos.add(serie);
            _conteudoRepository.persistirSerieConteudo(conteudo);
        }
    }

    public void atribuirDisciplina(ConteudoEntity conteudo, DisciplinaEntity disciplina) {
        List<DisciplinaEntity> disciplinaAtribuidos = conteudo.getDisciplinas();
        if (disciplinaAtribuidos.contains(disciplina)) {
            System.out.println(
                    "Discplina " + disciplina.getNome() + " já foi adicionado ao conteudo " + conteudo.getNome());
        } else {
            disciplinaAtribuidos.add(disciplina);
            _conteudoRepository.persistirSerieConteudo(conteudo);
        }
    }

    public void listarConteudos() {
        System.out.println("CONTEUDOS CADASTRADOS");
        for (ConteudoEntity conteudo : conteudos) {
            if (conteudo.getStatus()) {
                System.out.println(
                        "===========================================================================================================================");
                System.out.println("Conteudo: " + conteudo.getNome());
                System.out.print("Perfis: ");
                for (PerfilEntity perfil : conteudo.getPerfis()) {
                    System.out.print(perfil.getNome() + ", ");
                }
                System.out.print("\nSeries: ");
                for (SerieEntity serie : conteudo.getSeries()) {
                    System.out.print(serie.getNome() + ", ");
                }
                System.out.print("\nDisciplinas: ");
                for (DisciplinaEntity disciplina : conteudo.getDisciplinas()) {
                    System.out.print(disciplina.getNome() + ", ");
                }
                IArquivo arquivo = conteudo.getArquivo();
                System.out.println("\nArquivo: " + arquivo.getNome() + " URL: "+ arquivo.getURL());

            }
        }
        System.out.println("");
    }

    public void armazenarMidia(ConteudoEntity conteudo, IMidiaFactory fabrica, String nomeArquivo, String detalhe) {
        IArquivo midia = fabrica.criarMidia(nomeArquivo, detalhe);
        conteudo.atribuirArquivo(midia);
    }

}
