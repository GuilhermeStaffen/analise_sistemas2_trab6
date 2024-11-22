package Facade;

import java.util.ArrayList;

import Entities.UsuarioEntity;
import Repositories.UsuarioRepository;
import Validators.UsuarioValidators;

public class ConteudoFacade {
    
    // public ConteudoFacade() {
    //     _usuarioValidator = new UsuarioValidators();
    //     this._usuarioRepository = new UsuarioRepository();
    //     this.usuarios = new ArrayList<>();
    // }

    // public UsuarioEntity criarConteudo(String nome, String email, String senha, String matricula, Boolean ativo)
    //         throws Exception {
    //     if (!_usuarioValidator.dadosValidos(nome, email, senha, matricula, ativo)) {
    //         throw new Exception("Erro ao criar usuário: Dados inválidos");
    //     }
    //     UsuarioEntity usuario = new UsuarioEntity(nome, email, senha, matricula, ativo);
    //     _usuarioRepository.persistirUsuario(usuario);
    //     this.usuarios.add(usuario);
    //     return usuario;
    // }

}
