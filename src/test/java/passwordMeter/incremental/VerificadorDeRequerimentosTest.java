package passwordMeter.incremental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;
import passwordMeter.incremental.VerificadorDeRequerimentos;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeRequerimentosTest {

    VerificadorDeRequerimentos verificadorDeRequerimentos;

    @BeforeEach
    void setUp() {
        verificadorDeRequerimentos = new VerificadorDeRequerimentos("An4lui$4");

    }

    @Test
    void verificar() {
        verificadorDeRequerimentos.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificadorDeRequerimentos.obterResultadoDeAnalise();
        assertEquals(10, resultadoDeAnalise.getPontos());
        assertEquals(Suficiencia.SUFICIENTE, resultadoDeAnalise.getSuficiencia());
    }


}