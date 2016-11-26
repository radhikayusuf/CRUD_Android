package id.smkn4.bdg.examplerecyclerview.model;

/**
 * Created by root on 26/11/16.
 */

public class UserModel {
    private String id_user, username, password, email;

    public UserModel(String id_user, String username, String password, String email) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
