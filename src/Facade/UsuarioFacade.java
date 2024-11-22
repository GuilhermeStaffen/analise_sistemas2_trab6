package Facade;

import Entities.PerfilEntity;
import Entities.SerieEntity;
import Entities.UsuarioEntity;
import Repositories.UsuarioRepository;
import Validators.UsuarioValidators;
import java.util.ArrayList;
import java.util.List;

public class UsuarioFacade {

    private UsuarioValidators _usuarioValidator;
    private List<UsuarioEntity> usuarios;
    private UsuarioRepository _usuarioRepository;

    public UsuarioFacade() {
        _usuarioValidator = new UsuarioValidators();
        this._usuarioRepository = new UsuarioRepository();
        this.usuarios = new ArrayList<>();
    }

    public UsuarioEntity criarUsuario(String nome, String email, String senha, String matricula, Boolean ativo)
            throws Exception {
        if (!_usuarioValidator.dadosValidos(nome, email, senha, matricula, ativo)) {
            throw new Exception("Erro ao criar usuário: Dados inválidos");
        }
        UsuarioEntity usuario = new UsuarioEntity(nome, email, senha, matricula, ativo);
        _usuarioRepository.persistirUsuario(usuario);
        this.usuarios.add(usuario);
        return usuario;
    }

    public List<UsuarioEntity> getUsuarios() {
        return this.usuarios;
    }

    public void listarUsuarios() {
        System.out.println("USUARIOS CADASTRADOS");
        for (UsuarioEntity usuario : usuarios) {
            if (usuario.getStatus()) {
                System.out.println("===========================================================================================================================");
                System.out.println("Usuário: " + usuario.getNome() + ", email: " + usuario.getEmail() + ", matricula: "+ usuario.getMatricula());
                System.out.print("Perfis: ");
                for (PerfilEntity perfil : usuario.getPerfis()) {
                    System.out.print(perfil.getNome()+",");
                }
                System.out.print("\nSeries: ");
                for (SerieEntity serie : usuario.getSeries()) {
                    System.out.print(serie.getNome()+", ");
                }
                System.out.println(" ");

            }
        }
        System.out.println("");
    }

    public void atribuirPerfil(UsuarioEntity usuario, PerfilEntity perfil) {
        List<PerfilEntity> perfilAtribuidos = usuario.getPerfis();
        if (perfilAtribuidos.contains(perfil)) {
            System.out.println("Perfil "+perfil.getNome()+" já foi adicionado ao usuario "+usuario.getNome());
        } else {
            perfilAtribuidos.add(perfil);
            _usuarioRepository.persistirPerfilUsuario(usuario);
        }
    }

    public void atribuirSerie(UsuarioEntity usuario, SerieEntity serie) {
        List<SerieEntity> serieAtribuidos = usuario.getSeries();
        if (serieAtribuidos.contains(serie)) {
            System.out.println("Serie "+serie.getNome()+" já foi adicionado ao usuario "+usuario.getNome());
        } else {
            serieAtribuidos.add(serie);
            _usuarioRepository.persistirSerieUsuario(usuario);
        }
    }

}
