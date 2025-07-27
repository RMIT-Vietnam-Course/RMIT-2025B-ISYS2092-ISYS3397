import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class LoginServiceTest {
    private LoginService loginService;

    @Before
    public void setUp() {
        loginService = new LoginService();
    }

    @After
    public void tearDown() {
        loginService = null;
    }

    @Test
    public void shouldLoginSuccessfullyWithValidCredentials() {
        boolean result = loginService.login("admin", "admin123");
        assertTrue("Login should succeed with correct credentials.", result);
    }

    @Test
    public void shouldRejectLoginWithInvalidPassword() {
        boolean result = loginService.login("admin", "wrongpass");
        assertFalse("Login should fail with incorrect password.", result);
    }

    @Test
    public void shouldShowErrorWhenUsernameIsEmpty() {
        boolean result = loginService.login("", "admin123");
        assertFalse("Login should fail when username is empty.", result);
    }

    @Test
    public void shouldShowErrorWhenPasswordIsEmpty() {
        boolean result = loginService.login("admin", "");
        assertFalse("Login should fail when password is empty.", result);
    }
}