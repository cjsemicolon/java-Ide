package Validations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    @Test
    void testIsValidEmail() {
        assertTrue(Validation.isValidEmail("p.nwankwo@native.semicolon.africa"));
        assertFalse(Validation.isValidEmail("Praise.nwankwo@native.semicolon.africa"));
    }

    @Test
    void testIsValidPassword() {
        assertTrue(Validation.isValidPassword("praise@123"));
        assertFalse(Validation.isValidPassword("Praise123"));
    }

}