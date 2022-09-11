package solid.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    static class TestUserServiceImplementation implements UserService {

        private User parameterOfLastMethodCall;

        @Override
        public void save(User user) {
            parameterOfLastMethodCall = user;
        }

        public User getParameterOfLastMethodCall() {
            return parameterOfLastMethodCall;
        }
    }

    static class TestValidatorImplementation implements Validator {

        private final boolean returnValueOfIsValid;

        private String parameterOfLastMethodCall;

        public TestValidatorImplementation(boolean returnValueOfIsValid) {
            this.returnValueOfIsValid = returnValueOfIsValid;
        }

        @Override
        public boolean isValid(String userName) {
            parameterOfLastMethodCall = userName;
            return returnValueOfIsValid;
        }

        public String getParameterOfLastMethodCall() {
            return parameterOfLastMethodCall;
        }

    }

    @Test
    public void testCreateUserWithValidUserName() {

        final String validUsername = "123456";
        List<Validator> validators = new ArrayList<>();
        TestValidatorImplementation dummyTrueValidator = new TestValidatorImplementation(true);
        validators.add(dummyTrueValidator);

        TestUserServiceImplementation userService = new TestUserServiceImplementation();

        UserController userController = new UserController(userService, validators);
        userController.createUser(validUsername);

        assertEquals(validUsername, dummyTrueValidator.getParameterOfLastMethodCall());
        assertNotNull(userService.getParameterOfLastMethodCall());
        assertEquals(validUsername, userService.getParameterOfLastMethodCall().getLoginName());
    }


    @Test
    public void testCreateUserWithInvalidUserName() {

        final String invalidUsername = "123 456";
        List<Validator> validators = new ArrayList<>();
        TestValidatorImplementation dummyFalseValidator = new TestValidatorImplementation(false);
        validators.add(dummyFalseValidator);

        TestUserServiceImplementation userService = new TestUserServiceImplementation();

        UserController userController = new UserController(userService, validators);
        userController.createUser(invalidUsername);

        assertNull(userService.getParameterOfLastMethodCall());
    }

    @Test
    public void testCreateUserWithInvalidUserNameMultipleValidators() {

        final String input = "asdasd";
        List<Validator> validators = new ArrayList<>();
        Validator dummyTrueValidator = new TestValidatorImplementation(true);
        validators.add(dummyTrueValidator);
        Validator dummyFalseValidator = new TestValidatorImplementation(false);
        validators.add(dummyFalseValidator);

        TestUserServiceImplementation userService = new TestUserServiceImplementation();

        UserController userController = new UserController(userService, validators);
        userController.createUser(input);

        assertNull(userService.getParameterOfLastMethodCall());
    }
}