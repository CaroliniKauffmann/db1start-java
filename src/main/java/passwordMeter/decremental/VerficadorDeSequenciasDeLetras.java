package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerficadorDeSequenciasDeLetras extends Verificador {

    public VerficadorDeSequenciasDeLetras(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        score = obterContagem() * 3;
    }

    @Override
    public long obterContagem() {

        int countSeqAlpha = 0;

        /* Check for sequential alpha string patterns (forward and reverse) */
        for (int i = 0; i < 23; i++) {
            String ALPHAS = "abcdefghijklmnopqrstuvwxyz";
            String sFwd = ALPHAS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {

                countSeqAlpha++;
            }
        }
        return countSeqAlpha;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}



