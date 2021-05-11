package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerficadorDeSequenciasDeSimbolos extends Verificador {

    public VerficadorDeSequenciasDeSimbolos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        score = obterContagem() * 3;

    }

    @Override
    public long obterContagem() {

        int countSeqSymbol = 0;

        for (int i = 0; i < 8; i++) {
            String SYMBOLS = ")!@#$%^&*()";
            String sFwd = SYMBOLS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {

                countSeqSymbol++;
            }
        }
        return countSeqSymbol;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
