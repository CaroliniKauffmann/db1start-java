package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerficadorDeSequenciasDeSimbolos extends Verificador {

    public VerficadorDeSequenciasDeSimbolos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        score = obterContagem() * 3;

    }

    @Override
    public long obterContagem() {

        int contadorSequenciaDeSimbolos = 0;

        for (int i = 0; i < 8; i++) {
            String SIMBOLOS = ")!@#$%^&*()";
            String sFwd = SIMBOLOS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {

                contadorSequenciaDeSimbolos++;
            }
        }
        return contadorSequenciaDeSimbolos;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
