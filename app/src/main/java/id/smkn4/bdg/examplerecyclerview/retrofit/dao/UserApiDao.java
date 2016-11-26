package id.smkn4.bdg.examplerecyclerview.retrofit.dao;

import java.util.List;

/**
 * Created by root on 26/11/16.
 */

public class UserApiDao extends BaseDao<List<UserApiDao.ResponseDao>>{

    public class ResponseDao{
        private String id_user, username, password, email;

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

//    public static class CreateUser{
//        private String username, email, password;
//
//        public CreateUser(String username, String email, String password) {
//            this.username = username;
//            this.email = email;
//            this.password = password;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//    }


}
