package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerficadorDeSequenciasDeNumeros extends Verificador {

    public VerficadorDeSequenciasDeNumeros(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        score = obterContagem() * 3;

    }

    @Override
    public long obterContagem() {

        int countSeqNumber = 0;

        for (int i = 0; i < 8; i++) {
            String DIGITS = "01234567890";
            String sFwd = DIGITS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {

                countSeqNumber++;
            }
        }
        return countSeqNumber;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
