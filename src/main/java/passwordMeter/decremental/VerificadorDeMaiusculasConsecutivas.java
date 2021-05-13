package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerificadorDeMaiusculasConsecutivas extends Verificador {

    public VerificadorDeMaiusculasConsecutivas(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        score = obterContagem() * 2;

    }

    @Override
    public long obterContagem() {

        int contagemDeMaiusculasConsecutivas = 0;
        Integer nTmpAlphaLC = null;

        String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {

                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        contagemDeMaiusculasConsecutivas++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
        return contagemDeMaiusculasConsecutivas;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
