package passwordMeter.decremental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passwordMeter.ResultadoDeAnalise;
import passwordMeter.Suficiencia;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeNumerosConsecutivosTest {


    VerificadorDeNumerosConsecutivos verificadorDeNumerosConsecutivos;

    @BeforeEach
    void setUp() {
        verificadorDeNumerosConsecutivos = new VerificadorDeNumerosConsecutivos("111ddd");

    }

    @Test
    void verificar() {
        verificadorDeNumerosConsecutivos.verificar();
        ResultadoDeAnalise resultadoDeAnalise = verificadorDeNumerosConsecutivos.obterResultadoDeAnalise();
        Assertions.assertEquals(4, resultadoDeAnalise.getPontos());
        Assertions.assertEquals(Suficiencia.FALHA, resultadoDeAnalise.getSuficiencia());
    }
}