public class User {

    String email;
    String password;

    /**
     * @param email which user's inputs;
     * @param password which user's inputs;
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
