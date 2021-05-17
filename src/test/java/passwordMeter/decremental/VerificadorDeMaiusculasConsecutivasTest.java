package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;

import static org.junit.Assert.assertEquals;

class VerificadorDeMaiusculasConsecutivasTest {


    VerificadorDeMaiusculasConsecutivas verificadorDeMaiusculasConsecutivas;

    @BeforeEach
    void setUp() {
        verificadorDeMaiusculasConsecutivas = new VerificadorDeMaiusculasConsecutivas("ABCDddd");

    }

    @Test
    void verificar() {
        verificadorDeMaiusculasConsecutivas.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificadorDeMaiusculasConsecutivas.obterResultadoDeAnalise();
        Assertions.assertEquals(6, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.FALHA, resultadoDeAnalise.getSuficiencia());
    }

}