package passwordMeter;

public enum Complexidade {
    MUITO_FRACO, FRACO, BOM, FORTE, MUITO_FORTE;

    public static Complexidade obterComplexidade(long score){

        if (score > 100) {
            score = 100;
        } else if (score < 0) {
            score = 0;
        }

        if (score < 20) {
            return MUITO_FRACO;
        } else if (score < 40) {
            return FRACO;
        } else if (score < 60) {
            return BOM;
        } else if (score < 80) {
            return FORTE;
        } else {
            return MUITO_FORTE;
        }
    }
}