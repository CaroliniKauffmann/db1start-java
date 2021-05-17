package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerficadorDeSequenciasDeSimbolosTest {

    VerficadorDeSequenciasDeSimbolos verficadorDeSequenciasDeSimbolos;

    @BeforeEach
    void setUp() {
        verficadorDeSequenciasDeSimbolos = new VerficadorDeSequenciasDeSimbolos("@#$@#$%ˆ");

    }

    @Test
    void verificar() {
        verficadorDeSequenciasDeSimbolos.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verficadorDeSequenciasDeSimbolos.obterResultadoDeAnalise();
        Assertions.assertEquals(6, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.FALHA, resultadoDeAnalise.getSuficiencia());
    }
}