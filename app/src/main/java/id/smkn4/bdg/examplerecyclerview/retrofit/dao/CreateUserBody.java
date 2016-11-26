package id.smkn4.bdg.examplerecyclerview.retrofit.dao;

/**
 * Created by root on 26/11/16.
 */

public class CreateUserBody {
    private String username, email, password;

    public CreateUserBody(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
