package org.example.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassengerServiceTest {
    private PassengerService passengerService;

    @BeforeEach
    public void setup() {
        passengerService = new PassengerService();
    }

    // 1. Validar CPF válido
    @Test
    public void testarAceitarCpfValido() {
        boolean resultado = passengerService.validateCpf("05216102060");
        Assertions.assertTrue(resultado);
    }

    // 2. Recusar CPF inválido
    @Test
    public void testarRecusarCpfInvalido() {
        boolean resultado = passengerService.validateCpf("1111af111a1");
        Assertions.assertFalse(resultado);
    }

    // 3. Validar e-mail válido
    @Test
    public void testarAceitarEmailValido() {
        boolean resultado = passengerService.validateEmail("jose@email.com");
        Assertions.assertTrue(resultado);
    }

    // 4. Recusar e-mail inválido
    @Test
    public void testarRecusarEmailInvalido() {
        boolean resultado = passengerService.validateEmail("email");
        Assertions.assertFalse(resultado);
    }
}
