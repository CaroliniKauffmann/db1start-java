package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerficadorDeSequenciasDeNumerosTest {

    VerficadorDeSequenciasDeNumeros verficadorDeSequenciasDeNumeros;

    @BeforeEach
    void setUp() {
        verficadorDeSequenciasDeNumeros = new VerficadorDeSequenciasDeNumeros("123123456");

    }

    @Test
    void verificar() {
        verficadorDeSequenciasDeNumeros.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verficadorDeSequenciasDeNumeros.obterResultadoDeAnalise();
        Assertions.assertEquals(12, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.FALHA, resultadoDeAnalise.getSuficiencia());
    }
}