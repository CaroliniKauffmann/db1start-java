package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.*;

import static org.junit.Assert.assertEquals;

class VerficadorDeSequenciasDeLetrasTest {

    VerficadorDeSequenciasDeLetras verificadorDeSequenciasDeLetras;

    @BeforeEach
    void setUp() {
        verificadorDeSequenciasDeLetras = new VerficadorDeSequenciasDeLetras("abcabcdef");

    }

    @Test
    void verificar() {
        verificadorDeSequenciasDeLetras.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificadorDeSequenciasDeLetras.obterResultadoDeAnalise();
        Assertions.assertEquals(12, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.FALHA, resultadoDeAnalise.getSuficiencia());
    }
}