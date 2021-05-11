package passwordMeter.incremental;

import org.junit.jupiter.api.Test;
import passwordMeter.Verificador;
import passwordMeter.incremental.VerificadorDeQuantidadeDeCaracteres;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorDeQuantidadeDeCaracteresTest {

    Verificador verificador;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        verificador = new VerificadorDeQuantidadeDeCaracteres("abcdefgh");
    }

    @Test
    void verificarSenhaMaior() {
        verificador.verificar();
        assertEquals(32, verificador.score);
    }

    @Test
    void verificarSenhaMenor() {
        verificador.senha = "abcdeh";
        verificador.verificar();
        assertEquals(24, verificador.score);
    }
}