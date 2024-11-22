package Validators;

import java.util.regex.Pattern;

public class UsuarioValidators {
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$";

    public Boolean dadosValidos(String nome, String email, String senha, String matricula, Boolean ativo) {

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
