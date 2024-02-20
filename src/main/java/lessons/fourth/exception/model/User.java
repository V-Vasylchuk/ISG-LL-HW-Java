package lessons.fourth.exception.model;

public class User {
    private final String username;
    private String password;
    private boolean blocked;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.blocked = false;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
