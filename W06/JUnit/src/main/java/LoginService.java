public class LoginService {
    public boolean login(String username, String password) {
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;

        return username.equals("admin") && password.equals("admin123");
    }
}