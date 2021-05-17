package passwordMeter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorDeForcaDeSenhaTest {

    ValidadorDeForcaDeSenha validadorDeForcaDeSenha;

    @BeforeEach
    void setUp() {
        validadorDeForcaDeSenha = new ValidadorDeForcaDeSenha("a1b2c3");
    }

    @Test
    void verificar() {
        validadorDeForcaDeSenha.verificar();
        assertEquals(60, validadorDeForcaDeSenha.getForcaDaSenha());
        assertEquals(Complexidade.FORTE, validadorDeForcaDeSenha.obterComplexidade());

    }

}