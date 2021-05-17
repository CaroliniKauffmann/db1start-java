package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeCaracteresRepetidosTest {

    VerificadorDeCaracteresRepetidos verificador;

    @BeforeEach
    void setUp() {
        verificador = new VerificadorDeCaracteresRepetidos("11223344");

    }

    @Test
    void verificar() {
        verificador.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificador.obterResultadoDeAnalise();
        Assertions.assertEquals(21, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.FALHA, resultadoDeAnalise.getSuficiencia());
    }

}