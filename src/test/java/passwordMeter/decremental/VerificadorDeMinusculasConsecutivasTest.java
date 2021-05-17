package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeMinusculasConsecutivasTest {

    VerificadorDeMinusculasConsecutivas verificadorDeMinusculasConsecutivas;

    @BeforeEach
    void setUp() {
        verificadorDeMinusculasConsecutivas = new VerificadorDeMinusculasConsecutivas("aaaddd");

    }

    @Test
    void verificar() {
        verificadorDeMinusculasConsecutivas.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificadorDeMinusculasConsecutivas.obterResultadoDeAnalise();
        Assertions.assertEquals(6, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.FALHA, resultadoDeAnalise.getSuficiencia());
    }
}