package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorSomenteNumerosTest {

    VerificadorSomenteNumeros verificadorSomenteNumeros;

    @BeforeEach
    void setUp() {
        verificadorSomenteNumeros = new VerificadorSomenteNumeros("12345678");

    }

    @Test
    void verificar() {
        verificadorSomenteNumeros.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificadorSomenteNumeros.obterResultadoDeAnalise();
        Assertions.assertEquals(8, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.FALHA, resultadoDeAnalise.getSuficiencia());
    }
}