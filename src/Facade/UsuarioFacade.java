package Facade;

import Entities.PerfilEntity;
import Entities.SerieEntity;
import Entities.UsuarioEntity;
import Repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UsuarioFacade {

    private List<UsuarioEntity> usuarios;
    private UsuarioRepository _usuarioRepository;

    public UsuarioFacade() {
        this._usuarioRepository = new UsuarioRepository();
        this.usuarios = new ArrayList<>();
    }

    public UsuarioEntity criarUsuario(String nome, String email, String senha, String matricula, Boolean ativo) throws Exception {
        if (!this.dadosValidos(nome, email, senha, matricula, ativo)) {
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
                System.out.println(
                        "===========================================================================================================================");
                System.out.println("Usuário: " + usuario.getNome() + ", email: " + usuario.getEmail() + ", matricula: "
                        + usuario.getMatricula());
                System.out.print("Perfis: ");
                for (PerfilEntity perfil : usuario.getPerfis()) {
                    System.out.print(perfil.getNome() + ",");
                }
                System.out.print("\nSeries: ");
                for (SerieEntity serie : usuario.getSeries()) {
                    System.out.print(serie.getNome() + ", ");
                }
                System.out.println(" ");

            }
        }
        System.out.println("");
    }

    public void atribuirPerfil(UsuarioEntity usuario, PerfilEntity perfil) {
        List<PerfilEntity> perfilAtribuidos = usuario.getPerfis();
        if (perfilAtribuidos.contains(perfil)) {
            System.out.println("Perfil " + perfil.getNome() + " já foi adicionado ao usuario " + usuario.getNome());
        } else {
            usuario.definirPerfil(perfil);
            _usuarioRepository.persistirPerfilUsuario(usuario);
        }
    }

    public void atribuirSerie(UsuarioEntity usuario, SerieEntity serie) {
        List<SerieEntity> serieAtribuidos = usuario.getSeries();
        if (serieAtribuidos.contains(serie)) {
            System.out.println("Serie " + serie.getNome() + " já foi adicionado ao usuario " + usuario.getNome());
        } else {
            usuario.definirSerie(serie);
            _usuarioRepository.persistirSerieUsuario(usuario);
        }
    }

    private Boolean dadosValidos(String nome, String email, String senha, String matricula, Boolean ativo) {
        String EMAIL_REGEX = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$";

        if (nome == null || nome.length() < 5) {
            return false;
        }
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            return false;
        }
        if (senha == null || senha.length() < 8) {
            return false;
        }
        if (matricula == null || matricula.length() < 3) {
            return false;
        }
        return true;
    }

}
