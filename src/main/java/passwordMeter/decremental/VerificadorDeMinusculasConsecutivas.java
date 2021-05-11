package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerificadorDeMinusculasConsecutivas extends Verificador {

    public VerificadorDeMinusculasConsecutivas(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        score = obterContagem() * 2;
    }

    @Override
    public long obterContagem() {

        int countConsecutiveLowercaseLetters = 0;
        Integer nTmpAlphaLC = null;

        String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[a-z]")) {

                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        countConsecutiveLowercaseLetters++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
        return countConsecutiveLowercaseLetters;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
