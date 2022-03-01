package presentation;

import service.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final UserService userService;
    private final List<NameValidator> nameValidatorArrayList;
    public static int MAX_NAME_LENGTH = 6;

    public UserController(UserService userService, List<NameValidator> nameValidatorArrayList) {
        this.userService = userService;
        this.nameValidatorArrayList = nameValidatorArrayList;
    }

    public boolean register(String name) {
        if (this.isValid(name)) {
            userService.save(new User());
            return true;
        } else {
            return false;
        }
    }

    private boolean isValid(String userName) {
        for (NameValidator nameValidator: nameValidatorArrayList) {
            if (!nameValidator.isValid(userName)) {
                return false;
            }
        }
        return true;
    }
}
