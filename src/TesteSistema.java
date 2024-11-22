
import Entities.PerfilEntity;
import Entities.SerieEntity;
import Entities.UsuarioEntity;
import Facade.PerfilFacade;
import Facade.SerieFacade;
import Facade.UsuarioFacade;

public class TesteSistema {
    public static void main(String[] args) throws Exception {

        PerfilFacade perfilFacade = new PerfilFacade();
        perfilFacade.listarPerfis();
        PerfilEntity professor = perfilFacade.buscarPerfil("Professor");
        PerfilEntity aluno = perfilFacade.buscarPerfil("Aluno");

        SerieFacade serieFacade = new SerieFacade();
        SerieEntity primeira = serieFacade.buscarSerie(1);
        SerieEntity segunda = serieFacade.buscarSerie(2);

        UsuarioFacade usuarioFacade = new UsuarioFacade();
        UsuarioEntity usuario1 = usuarioFacade.criarUsuario("Guilherme", "guilhermestaffen@gmail.com", "123456789", "1200681", true);
        usuarioFacade.atribuirPerfil(usuario1, aluno);    
        usuarioFacade.atribuirSerie(usuario1, primeira);
        UsuarioEntity usuario2 = usuarioFacade.criarUsuario("Patrick", "patrick@gmail.com", "123456789", "1200682", true);
        usuarioFacade.atribuirPerfil(usuario2, professor);   
        usuarioFacade.atribuirSerie(usuario1, segunda); 
        usuarioFacade.listarUsuarios();


        

    }
}
