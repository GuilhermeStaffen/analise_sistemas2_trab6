
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

        //Iniciando os pefis 
        PerfilFacade perfilFacade = new PerfilFacade();
        perfilFacade.listarPerfis();
        PerfilEntity professor = perfilFacade.buscarPerfil("Professor");
        PerfilEntity aluno = perfilFacade.buscarPerfil("Aluno");

        //Iniciando as series 
        SerieFacade serieFacade = new SerieFacade();
        SerieEntity primeiraSerie = serieFacade.buscarSerie(1);

        DisciplinaFacade disciplinaFacade = new DisciplinaFacade();
        DisciplinaEntity matematica = disciplinaFacade.buscarDisciplina("Matematica");

        //Criando os usuarios
        UsuarioFacade usuarioFacade = new UsuarioFacade();
        UsuarioEntity usuario1 = usuarioFacade.criarUsuario("Guilherme", "guilhermestaffen@gmail.com", "123456789", "1200681", true);
        usuarioFacade.atribuirPerfil(usuario1, aluno);    
        usuarioFacade.atribuirSerie(usuario1, primeiraSerie);
        UsuarioEntity usuario2 = usuarioFacade.criarUsuario("Patrick", "patrick@gmail.com", "123456789", "1200682", true);
        usuarioFacade.atribuirPerfil(usuario2, professor);   
        usuarioFacade.atribuirSerie(usuario2, primeiraSerie); 
        usuarioFacade.listarUsuarios();

        //Criando conteudos
        ConteudoFacade conteudoFacade = new ConteudoFacade();
        PDFFactory pdfFactory = new PDFFactory();
        VideoFactory videoFactory = new VideoFactory();
        ConteudoEntity videoTrigonometria = conteudoFacade.criarConteudo("Video Aula Sobre Trigonometria", true);
        conteudoFacade.atribuirPerfil(videoTrigonometria, aluno);
        conteudoFacade.atribuirSerie(videoTrigonometria, primeiraSerie);
        conteudoFacade.atribuirDisciplina(videoTrigonometria, matematica);
        conteudoFacade.armazenarMidia(videoTrigonometria, videoFactory, "Video_Trigonometria.mp4", "xpto");
        ConteudoEntity pdfLivroAdicao = conteudoFacade.criarConteudo("Ebook sobre adição", true);
        conteudoFacade.atribuirPerfil(pdfLivroAdicao, aluno);
        conteudoFacade.atribuirPerfil(pdfLivroAdicao, professor);
        conteudoFacade.atribuirSerie(pdfLivroAdicao, primeiraSerie);
        conteudoFacade.atribuirDisciplina(pdfLivroAdicao, matematica);
        conteudoFacade.armazenarMidia(pdfLivroAdicao, pdfFactory, "Adição_um_mundo_lindo.pdf", "110");
        conteudoFacade.listarConteudos();
        

    }
}
