package passwordMeter.decremental;

import passwordMeter.TipoDeOperacao;
import passwordMeter.Verificador;

public class VerificadorDeCaracteresRepetidos extends Verificador {

    public VerificadorDeCaracteresRepetidos(String senha) {
        super(senha);
    }

    @Override
    public void verificar() {
        if (scoreFoiCalculado()) {
            return;
        }
        score = obterContagem();
    }

    @Override
    public long obterContagem() {

        int contadorDeMaiusculasConsecutivas = 0;
        int countAlphaUC = 0;
        int contadorDeMinusculasConsecutivas = 0;
        int countAlphaLC = 0;
        int countMidChar = 0;
        int contadoDeNumerosConsecutivos = 0;
        int countNumber = 0;
        int countSymbol = 0;
        int incrementDeductionOfRepeatedChars = 0;
        int countRepChar = 0;

        Integer nTmpAlphaUC = null, nTmpAlphaLC = null, nTmpNumber = null;

        String[] arrPwd = senha.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {

            if (arrPwd[i].matches("[A-Z]")) {
                if (nTmpAlphaUC != null) {
                    if (nTmpAlphaUC + 1 == i) {
                        contadorDeMaiusculasConsecutivas++;
                    }
                }
                nTmpAlphaUC = i;
                countAlphaUC++;
            } else if (arrPwd[i].matches("[a-z]")) {
                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        contadorDeMinusculasConsecutivas++;
                    }
                }
                nTmpAlphaLC = i;

                countAlphaLC++;
            } else if (arrPwd[i].matches("[0-9]")) {
                if (i > 0 && i < arrPwd.length - 1) {
                    countMidChar++;
                }
                if (nTmpNumber != null) {
                    if (nTmpNumber + 1 == i) {
                        contadoDeNumerosConsecutivos++;
                    }
                }
                nTmpNumber = i;

                countNumber++;
            } else if (arrPwd[i].matches("[^a-zA-Z0-9_]")) {
                if (i > 0 && i < arrPwd.length - 1) {
                    countMidChar++;
                }

                countSymbol++;
            }

            /* Internal loop through password to check for repeat characters */
            var bCharExists = false;

            for (int j = 0; j < arrPwd.length; j++) {
                if (arrPwd[i].equals(arrPwd[j]) && i != j) { /* repeat character exists */
                    bCharExists = true;

                    incrementDeductionOfRepeatedChars += Math.abs(arrPwd.length / (j - i));
                }
            }
            if (bCharExists) {

                countRepChar++;
                int countUniqueCharacters = arrPwd.length - countRepChar;
                incrementDeductionOfRepeatedChars = (int) (countUniqueCharacters != 0 ?
                        Math.ceil(incrementDeductionOfRepeatedChars / countUniqueCharacters) :
                        Math.ceil(incrementDeductionOfRepeatedChars));
            }
        }
        return incrementDeductionOfRepeatedChars;
    }

    @Override
    public TipoDeOperacao obterTipoDeOperacao() {
        return TipoDeOperacao.DECREMENTADOR;
    }
}
