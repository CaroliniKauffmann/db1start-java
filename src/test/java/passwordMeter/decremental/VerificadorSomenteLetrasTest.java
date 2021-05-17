package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorSomenteLetrasTest {

    VerificadorSomenteLetras verificadorSomenteLetras;

    @BeforeEach
    void setUp() {
        verificadorSomenteLetras = new VerificadorSomenteLetras("c.fdugg");

    }

    @Test
    void verificar() {
        verificadorSomenteLetras.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificadorSomenteLetras.obterResultadoDeAnalise();
        Assertions.assertEquals(0, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.SUFICIENTE, resultadoDeAnalise.getSuficiencia());
    }
}