package solid.base;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private final List<Validator> validators = new ArrayList<>();
    UserService userService;

    public UserController(UserService userService, List<Validator> validators) {
        this.userService = userService;
        this.validators.addAll(validators);
    }

    public void createUser(String username) {
        if (validUserName(username)) {
            userService.save(new User(username));
        }
    }

    private boolean validUserName(String userName) {
        return validators.stream()
                .allMatch(v -> v.isValid(userName));
    }

}
