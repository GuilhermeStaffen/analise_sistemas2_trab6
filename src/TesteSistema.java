
import Entities.ConteudoEntity;
import Entities.DisciplinaEntity;
import Entities.PerfilEntity;
import Entities.SerieEntity;
import Entities.UsuarioEntity;
import Facade.ConteudoFacade;
import Facade.DisciplinaFacade;
import Facade.PerfilFacade;
import Facade.SerieFacade;
import Facade.UsuarioFacade;
import Factory.PDFFactory;
import Factory.VideoFactory;

public class TesteSistema {
    public static void main(String[] args) throws Exception {

        // #region Iniciando as fabricas
        PDFFactory pdfFactory = new PDFFactory();
        VideoFactory videoFactory = new VideoFactory();
        // #endregion

        // #region Iniciando fachadas
        SerieFacade serieFacade = new SerieFacade();
        PerfilFacade perfilFacade = new PerfilFacade();
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        ConteudoFacade conteudoFacade = new ConteudoFacade();
        DisciplinaFacade disciplinaFacade = new DisciplinaFacade();
        // #endregion

        // #region Iniciando os pefis, series e disciplinas
        perfilFacade.listarPerfis();
        PerfilEntity professor = perfilFacade.buscarPerfil("Professor");
        PerfilEntity aluno = perfilFacade.buscarPerfil("Aluno");
        SerieEntity primeiraSerie = serieFacade.buscarSerie(1);
        DisciplinaEntity matematica = disciplinaFacade.buscarDisciplina("Matematica");
        // #endregion



        
        // #region Criando os usuarios
        UsuarioEntity usuario1 = usuarioFacade.criarUsuario("Guilherme", "guilhermestaffen@gmail.com", "123456789","1200681", true);
        usuarioFacade.atribuirPerfil(usuario1, aluno);
        usuarioFacade.atribuirSerie(usuario1, primeiraSerie);

        UsuarioEntity usuario2 = usuarioFacade.criarUsuario("Patrick", "patrick@gmail.com", "123456789", "1200682",true);
        usuarioFacade.atribuirPerfil(usuario2, professor);
        usuarioFacade.atribuirSerie(usuario2, primeiraSerie);
        usuarioFacade.listarUsuarios();
        // #endregion




        // #region Criando conteudos
        ConteudoEntity videoTrigonometria = conteudoFacade.criarConteudo("Video Aula Sobre Trigonometria", true);
        conteudoFacade.atribuirDisciplina(videoTrigonometria, matematica);
        conteudoFacade.atribuirPerfil(videoTrigonometria, aluno);
        conteudoFacade.atribuirSerie(videoTrigonometria, primeiraSerie);
        conteudoFacade.armazenarMidia(videoTrigonometria, videoFactory, "Video_Trigonometria.mp4", "xpto");

        ConteudoEntity pdfLivroAdicao = conteudoFacade.criarConteudo("Ebook sobre adição", true);
        conteudoFacade.atribuirDisciplina(pdfLivroAdicao, matematica);
        conteudoFacade.atribuirPerfil(pdfLivroAdicao, aluno);
        conteudoFacade.atribuirPerfil(pdfLivroAdicao, professor);
        conteudoFacade.atribuirSerie(pdfLivroAdicao, primeiraSerie);
        conteudoFacade.armazenarMidia(pdfLivroAdicao, pdfFactory, "Adição_um_mundo_lindo.pdf", "110");

        conteudoFacade.listarConteudos();
        // #endregion 

    }
}
