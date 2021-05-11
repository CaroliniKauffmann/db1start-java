package original;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMeterTest {

    private PasswordMeter passwordMeter;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        passwordMeter = new PasswordMeter();
    }


    @org.junit.jupiter.api.Test
    void checkPasswordStrong() {
        String senhaForte = "!@#rtyA1265";
        passwordMeter.checkPassword(senhaForte);
        assertEquals("Very Strong", passwordMeter.sComplexity);
    }

    @org.junit.jupiter.api.Test
    void checkPasswordWeak() {
        String senhaFraca = "12345";
        passwordMeter.checkPassword(senhaFraca);
        assertEquals("Very Weak", passwordMeter.sComplexity);
    }
}