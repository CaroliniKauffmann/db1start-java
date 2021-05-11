package passwordMeter.incremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerificadorDeQuantidadeDeCaracteres extends Verificador {

    public VerificadorDeQuantidadeDeCaracteres(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        score = obterContagem() * 4;
    }

    public long obterContagem() {
        return senha.length();
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.INCREMENTADOR;
    }
}
