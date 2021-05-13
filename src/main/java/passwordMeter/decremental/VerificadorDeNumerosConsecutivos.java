package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerificadorDeNumerosConsecutivos extends Verificador {

    public VerificadorDeNumerosConsecutivos(String senha) {
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

        int contadorDeNumerosConsecutivos = 0;
        Integer nTmpAlphaLC = null;

        String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[0-9]")) {

                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        contadorDeNumerosConsecutivos++;
                    }
                }
                nTmpAlphaLC = i;
            }
        }
        return contadorDeNumerosConsecutivos;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}