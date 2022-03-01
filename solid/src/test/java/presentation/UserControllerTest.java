package presentation;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import service.User;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    void register_allow_validator() {
        //GIVEN
        UserService userService = mock(UserService.class);
        NameValidator nameValidatorOk = mock(NameValidator.class);
        when(nameValidatorOk.isValid(anyString())).thenReturn(true);

        List<NameValidator> nameValidatorArrayList = new ArrayList<>();
        nameValidatorArrayList.add(nameValidatorOk);

        UserController userController = new UserController(userService, nameValidatorArrayList);

        String userName = "input";

        //WHEN
        boolean rv = userController.register(userName);

        //THEN
        assertTrue(rv);
        verify(userService, times(1)).save(ArgumentMatchers.<User>any());
    }

    @Test
    void register_no_validator() {
        //GIVEN
        UserService userService = mock(UserService.class);
        NameValidator nameValidatorOk = mock(NameValidator.class);
        when(nameValidatorOk.isValid(anyString())).thenReturn(true);

        List<NameValidator> nameValidatorArrayList = new ArrayList<>();

        UserController userController = new UserController(userService, nameValidatorArrayList);

        String userName = "input";

        //WHEN
        boolean rv = userController.register(userName);

        //THEN
        assertTrue(rv);
        verify(userService, times(1)).save(ArgumentMatchers.<User>any());
    }

    @Test
    void register_deny_validator() {
        //GIVEN
        UserService userService = mock(UserService.class);
        NameValidator nameValidatorDany = mock(NameValidator.class);
        when(nameValidatorDany.isValid(anyString())).thenReturn(false);

        List<NameValidator> nameValidatorArrayList = new ArrayList<>();
        nameValidatorArrayList.add(nameValidatorDany);

        UserController userController = new UserController(userService, nameValidatorArrayList);

        String userName = "input";

        //WHEN
        boolean rv = userController.register(userName);

        //THEN
        assertFalse(rv);
        verify(userService, times(0)).save(ArgumentMatchers.<User>any());
    }

    @Test
    void register_misc_validator() {
        //GIVEN
        UserService userService = mock(UserService.class);
        NameValidator nameValidatorOk = mock(NameValidator.class);
        when(nameValidatorOk.isValid(anyString())).thenReturn(false);

        NameValidator nameValidatorDany = mock(NameValidator.class);
        when(nameValidatorDany.isValid(anyString())).thenReturn(false);

        List<NameValidator> nameValidatorArrayList = new ArrayList<>();
        nameValidatorArrayList.add(nameValidatorOk);
        nameValidatorArrayList.add(nameValidatorDany);

        UserController userController = new UserController(userService, nameValidatorArrayList);

        String userName = "input";

        //WHEN
        boolean rv = userController.register(userName);

        //THEN
        assertFalse(rv);
        verify(userService, times(0)).save(ArgumentMatchers.<User>any());
    }
}