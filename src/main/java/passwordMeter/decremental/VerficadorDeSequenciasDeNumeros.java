package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerficadorDeSequenciasDeNumeros extends Verificador {

    public VerficadorDeSequenciasDeNumeros(String senha) {
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

        int contadorSequenciaDeNumeros = 0;

        for (int i = 0; i < 8; i++) {
            String NUMEROS = "01234567890";
            String sFwd = NUMEROS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (senha.toLowerCase().contains(sFwd) || senha.toLowerCase().contains(sRev)) {

                contadorSequenciaDeNumeros++;
            }
        }
        return contadorSequenciaDeNumeros;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
