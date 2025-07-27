import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginServiceParameterTest {
    private final String username;
    private final String password;
    private final boolean expected;
    private LoginService service;

    public LoginServiceParameterTest(String username, String password, boolean expected) {
        this.username = username;
        this.password = password;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        service = new LoginService();
    }

    @Parameterized.Parameters(name = "{index}: login({0}, {1}) = {2}")
    public static Collection<Object[]> loginData() {
        return Arrays.asList(new Object[][] {
                // Valid cases.
                {"admin", "admin123", true},

                // Invalid cases.
                {"admin", "wrongpass", false},
                {"unknown", "admin123", false},

                // Edge cases.
                {"", "", false},
                {null, null, false},
                {"admin", "", false}
        });
    }

    @Test
    public void shouldLoginCorrectly() {
        boolean result = service.login(username, password);
        Assert.assertEquals("Login result mismatch for: " + username + ", " + password, expected, result);
    }
}