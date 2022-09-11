package solid.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JsInjectionValidatorTest {

    @Test
    public void testNotValidWithNull() {
        JsInjectionValidator jsInjectionValidator = new JsInjectionValidator();

        assertFalse(jsInjectionValidator.isValid(null));
    }

    @Test
    public void testIsValidWithEmptyString() {
        JsInjectionValidator jsInjectionValidator = new JsInjectionValidator();

        assertTrue(jsInjectionValidator.isValid(""));
    }

    @Test
    public void testIsValidWithEvilInput() {
        JsInjectionValidator jsInjectionValidator = new JsInjectionValidator();

        assertFalse(jsInjectionValidator.isValid("sdfasdf<script>"));
    }

    @Test
    public void testIsValidWithValidInput() {
        JsInjectionValidator jsInjectionValidator = new JsInjectionValidator();

        assertTrue(jsInjectionValidator.isValid("asdfasdf<adfg>sdfasdf"));
    }

}