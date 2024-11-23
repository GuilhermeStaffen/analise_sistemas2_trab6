package Facade;

import Entities.PerfilEntity;
import Repositories.PerfilRepository;
import java.util.List;

public class PerfilFacade {

    private List<PerfilEntity> perfis;
    private PerfilRepository _perfilRepository;

    public PerfilFacade() {
        this._perfilRepository = new PerfilRepository();
        this.perfis = _perfilRepository.buscarPerfis();
    }

    public PerfilEntity criarPerfil(int codigo, String nome, String descricao) throws Exception {
        PerfilEntity perfil = new PerfilEntity(codigo, nome, descricao);

        this.perfis.add(perfil);
        this._perfilRepository.persistirPerfil(perfil);
        return perfil;
    }

    public void listarPerfis() {
        System.out.println("PERFIS CADASTRADOS");
        for (PerfilEntity perfil : perfis) {
            System.out.println("Codigo: " + perfil.getCodigo() + ", nome: " + perfil.getNome() + ", descrição: "
                    + perfil.getDescricao());
        }
        System.out.println("");
    }

    public List<PerfilEntity> buscarPerfis() {
        return perfis;
    }

    public PerfilEntity buscarPerfil(String nome) throws Exception {
        PerfilEntity perfilDesejado = perfis.stream()
                .filter(perfil -> perfil.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        if (perfilDesejado != null) {
            return perfilDesejado;
        } else {
            throw new Exception("Perfil com nome " + nome + " não encontrado.");
        }
    }

}
