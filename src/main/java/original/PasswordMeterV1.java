package original;

public class PasswordMeterV1 {

    public int score;
    private String password;
    public String sComplexity = "Too Short";

    // Results
    private int bonusLength, countLength;
    private int bonusAlphaUC, countAlphaUC;
    private int bonusAlphaLC, countAlphaLC;
    private int bonusNumber, countNumber;
    private int bonusSymbol, countSymbol;
    private int bonusMidChar, countMidChar;
    private int bonusRequirements, countRequirements;
    private int bonusAlphasOnly, countAlphasOnly;
    private int bonusNumbersOnly, countNumbersOnly;
    private int bonusRepChar, countRepChar;
    private int bonusConsecutiveAlphaUC, countConsecutiveAlphaUC;
    private int bonusConsecutiveAlphaLC, countConsecutiveAlphaLC;
    private int bonusConsecutiveNumber, countConsecutiveNumber;
    private int bonusSeqAlpha, countSeqAlpha;
    private int bonusSeqNumber, countSeqNumber;
    private int bonusSeqSymbol, countSeqSymbol;

    private String[] levelsOfMandatoryItems = new String[5];
    private String[] levelsOfBonusItems = new String[2];
    private String[] levelsOfSuggestedItems = new String[9];
    private double incrementDeductionOfRepeatedChars = 0;

    public void checkPassword(String candidate) {
        password = candidate;

        int multiplierLength = 4;
        score = password.length() * multiplierLength;
        countLength = password.length();

        verificaRepeticaoDeCaracteres();
        verificaSequenciaDeLetras();
        verificaSequenciaDeNumeros();
        verificaSequenciaDeSimbolos();
        calculaPontuacaoInicial();
        calculaDeducaoInicial();
        verificaBonusAplicados();
        validaComplexidadeDaSenha();
    }

    private void validaComplexidadeDaSenha() {
        /* Determine complexity based on overall score */
        if (score > 100) {
            score = 100;
        } else if (score < 0) {
            score = 0;
        }

        if (score < 20) {
            sComplexity = "Very Weak";
        } else if (score < 40) {
            sComplexity = "Weak";
        } else if (score < 60) {
            sComplexity = "Good";
        } else if (score < 80) {
            sComplexity = "Strong";
        } else {
            sComplexity = "Very Strong";
        }
    }

    private void verificaBonusAplicados() {

        /* Determine if mandatory requirements have been met and set image indicators accordingly */
        int[] arrChars = {countLength, countAlphaUC, countAlphaLC, countNumber, countSymbol};
        String[] arrCharsIds = {"countLength", "countAlphaUC", "countAlphaLC", "countNumber", "countSymbol"};
        var arrCharsLen = arrChars.length;
        int MINIMUM_LENGTH = 8;
        for (int i = 0; arrCharsLen > i; i++) {

            int minVal = arrCharsIds[i].equals("countLength") ? MINIMUM_LENGTH - 1 : 0;
            if (arrChars[i] == minVal + 1) {
                countRequirements++;
                levelsOfMandatoryItems[i] = "sufficient";
            } else if (arrChars[i] > minVal + 1) {
                countRequirements++;
                levelsOfMandatoryItems[i] = "exceptional";
            } else {
                levelsOfMandatoryItems[i] = "failure";
            }
        }

        int nMinReqChars = password.length() >= MINIMUM_LENGTH ? 3 : 4;
        if (countRequirements > nMinReqChars) {  // One or more required characters exist
            score = score + countRequirements * 2;
            bonusRequirements = countRequirements * 2;
        }

        /* Determine if additional bonuses need to be applied and set image indicators accordingly */
        arrChars = new int[]{countMidChar, countRequirements};
        arrCharsIds = new String[]{"countMidChar", "countRequirements"};
        arrCharsLen = arrChars.length;
        for (var c = 0; c < arrCharsLen; c++) {
            int minVal = arrCharsIds[c].equals("countRequirements") ? nMinReqChars : 0;
            if (arrChars[c] == minVal + 1) {
                levelsOfBonusItems[c] = "sufficient";
            } else if (arrChars[c] > minVal + 1) {
                levelsOfBonusItems[c] = "exceptional";
            } else {
                levelsOfBonusItems[c] = "failure";
            }
        }

        /* Determine if suggested requirements have been met and set image indicators accordingly */
        arrChars = new int[]{countAlphasOnly, countNumbersOnly, countRepChar, countConsecutiveAlphaUC,
                countConsecutiveAlphaLC, countConsecutiveNumber, countSeqAlpha, countSeqNumber, countSeqSymbol};
        arrCharsLen = arrChars.length;
        for (var c = 0; c < arrCharsLen; c++) {
            levelsOfSuggestedItems[c] = arrChars[c] > 0 ? "warning" : "sufficient";
        }
    }

    private void calculaDeducaoInicial() {
        /* Point deductions for poor practices */
        if ((countAlphaLC > 0 || countAlphaUC > 0) && countSymbol == 0 && countNumber == 0) {  // Only Letters
            score = score - countLength;
            countAlphasOnly = countLength;
            bonusAlphasOnly = countLength;
        }
        if (countAlphaLC == 0 && countAlphaUC == 0 && countSymbol == 0 && countNumber > 0) {  // Only Numbers
            score = score - countLength;
            countNumbersOnly = countLength;
            bonusNumbersOnly = countLength;
        }
        if (countRepChar > 0) {  // Same character exists more than once
            score = score - (int) incrementDeductionOfRepeatedChars;
            bonusRepChar = (int) incrementDeductionOfRepeatedChars;
        }
        if (countConsecutiveAlphaUC > 0) {  // Consecutive Uppercase Letters exist
            int multiplierConsecutiveAlphaUC = 2;
            score = score - countConsecutiveAlphaUC * multiplierConsecutiveAlphaUC;
            bonusConsecutiveAlphaUC = countConsecutiveAlphaUC * multiplierConsecutiveAlphaUC;
        }
        if (countConsecutiveAlphaLC > 0) {  // Consecutive Lowercase Letters exist
            int multiplierConsecutiveAlphaLC = 2;
            score = score - countConsecutiveAlphaLC * multiplierConsecutiveAlphaLC;
            bonusConsecutiveAlphaLC = countConsecutiveAlphaLC * multiplierConsecutiveAlphaLC;
        }
        if (countConsecutiveNumber > 0) {  // Consecutive Numbers exist
            int multiplierConsecutiveNumber = 2;
            score = score - countConsecutiveNumber * multiplierConsecutiveNumber;
            bonusConsecutiveNumber = countConsecutiveNumber * multiplierConsecutiveNumber;
        }
        if (countSeqAlpha > 0) {  // Sequential alpha strings exist (3 characters or more)
            int multiplierSeqAlpha = 3;
            score = score - countSeqAlpha * multiplierSeqAlpha;
            bonusSeqAlpha = countSeqAlpha * multiplierSeqAlpha;
        }
        if (countSeqNumber > 0) {  // Sequential numeric strings exist (3 characters or more)
            int multiplierSeqNumber = 3;
            score = score - countSeqNumber * multiplierSeqNumber;
            bonusSeqNumber = countSeqNumber * multiplierSeqNumber;
        }
        if (countSeqSymbol > 0) {  // Sequential symbol strings exist (3 characters or more)
            int multiplierSeqSymbol = 3;
            score = score - countSeqSymbol * multiplierSeqSymbol;
            bonusSeqSymbol = countSeqSymbol * multiplierSeqSymbol;
        }
    }

    private void calculaPontuacaoInicial() {
        /* General point assignment */
        bonusLength = score;
        if (countAlphaUC > 0 && countAlphaUC < countLength) {
            score = score + (countLength - countAlphaUC) * 2;
            bonusAlphaUC = (countLength - countAlphaUC) * 2;
        }
        if (countAlphaLC > 0 && countAlphaLC < countLength) {
            score = score + (countLength - countAlphaLC) * 2;
            bonusAlphaLC = (countLength - countAlphaLC) * 2;
        }
        if (countNumber > 0 && countNumber < countLength) {
            int multiplierNumber = 4;
            score = score + countNumber * multiplierNumber;
            bonusNumber = countNumber * multiplierNumber;
        }
        if (countSymbol > 0) {
            int multiplierSymbol = 6;
            score = score + countSymbol * multiplierSymbol;
            bonusSymbol = countSymbol * multiplierSymbol;
        }
        if (countMidChar > 0) {
            int multiplierMidChar = 2;
            score = score + countMidChar * multiplierMidChar;
            bonusMidChar = countMidChar * multiplierMidChar;
        }
    }

    private void verificaRepeticaoDeCaracteres() {
        Integer nTmpAlphaUC = null, nTmpAlphaLC = null, nTmpNumber = null;

        String[] arrPwd = password.replaceAll("\\s+", "").split("\\s*");

        for (int i = 0; i < arrPwd.length; i++) {
            if (arrPwd[i].matches("[A-Z]")) {
                if (nTmpAlphaUC != null) {
                    if (nTmpAlphaUC + 1 == i) {
                        countConsecutiveAlphaUC++;
                    }
                }
                nTmpAlphaUC = i;
                countAlphaUC++;
            } else if (arrPwd[i].matches("[a-z]")) {
                if (nTmpAlphaLC != null) {
                    if (nTmpAlphaLC + 1 == i) {
                        countConsecutiveAlphaLC++;
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
                        countConsecutiveNumber++;
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
                incrementDeductionOfRepeatedChars = countUniqueCharacters != 0 ?
                        Math.ceil(incrementDeductionOfRepeatedChars / countUniqueCharacters) :
                        Math.ceil(incrementDeductionOfRepeatedChars);
            }
        }

    }

    private void verificaSequenciaDeLetras() {

        /* Check for sequential alpha string patterns (forward and reverse) */
        for (int i = 0; i < 23; i++) {
            String ALPHAS = "abcdefghijklmnopqrstuvwxyz";
            String sFwd = ALPHAS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().contains(sFwd) || password.toLowerCase().contains(sRev)) {
                countSeqAlpha++;
            }
        }

    }

    private void verificaSequenciaDeNumeros() {

        /* Check for sequential numeric string patterns (forward and reverse) */
        for (int i = 0; i < 8; i++) {
            String DIGITS = "01234567890";
            String sFwd = DIGITS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().contains(sFwd) || password.toLowerCase().contains(sRev)) {
                countSeqNumber++;
            }
        }
    }

    private void verificaSequenciaDeSimbolos() {
        /* Check for sequential symbol string patterns (forward and reverse) */
        for (int i = 0; i < 8; i++) {
            String SYMBOLS = ")!@#$%^&*()";
            String sFwd = SYMBOLS.substring(i, i + 3);
            String sRev = new StringBuilder(sFwd).reverse().toString();
            if (password.toLowerCase().contains(sFwd) || password.toLowerCase().contains(sRev)) {
                countSeqSymbol++;
            }
        }
    }

    @Override
    public String toString() {
        return "Password: " + password
                + "\nScore: " + score
                + "\nComplexity: " + sComplexity

                + "\nAddictions"
                + "\n[C: " + countLength + " | B: " + bonusLength + "] Number of Characters"
                + "\n[C: " + countAlphaUC + " | B: " + bonusAlphaUC + "] Uppercase Letters"
                + "\n[C: " + countAlphaLC + " | B: " + bonusAlphaLC + "] Lowercase Letters"
                + "\n[C: " + countNumber + " | B: " + bonusNumber + "] Numbers"
                + "\n[C: " + countSymbol + " | B: " + bonusSymbol + "] Symbols"
                + "\n[C: " + countMidChar + " | B: " + bonusMidChar + "] Middle Numbers or Symbols"
                + "\n[C: " + countRequirements + " | B: " + bonusRequirements + "] Requirements"

                + "\nDeductions"
                + "\n[C: " + countAlphasOnly + " | B: " + bonusAlphasOnly + "] Letters Only"
                + "\n[C: " + countNumbersOnly + " | B: " + bonusNumbersOnly + "] Numbers Only"
                + "\n[C: " + countRepChar + " | B: " + bonusRepChar + "] Repeat Characters (Case Insensitive)"
                + "\n[C: " + countConsecutiveAlphaUC + " | B: " + bonusConsecutiveAlphaUC + "] Consecutive Uppercase Letters"
                + "\n[C: " + countConsecutiveAlphaLC + " | B: " + bonusConsecutiveAlphaLC + "] Consecutive Lowercase Letters"
                + "\n[C: " + countConsecutiveNumber + " | B: " + bonusConsecutiveNumber + "] Consecutive Numbers"
                + "\n[C: " + countSeqAlpha + " | B: " + bonusSeqAlpha + "] Sequential Letters"
                + "\n[C: " + countSeqNumber + " | B: " + bonusSeqNumber + "] Sequential Numbers"
                + "\n[C: " + countSeqSymbol + " | B: " + bonusSeqSymbol + "] Sequential Symbols";
    }
}