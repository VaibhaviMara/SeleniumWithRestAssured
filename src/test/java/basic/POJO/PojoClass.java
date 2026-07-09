package basic.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoClass {
     private  long id;
     private String username;
     private String email;
     private String password;
     private int userStatus;

     public PojoClass(){

     }
     public  PojoClass(long id, String username, String email, String password, int userStatus){
         this.id = id;
         this.username = username;
         this.email = email;
         this.password = password;
         this.userStatus = userStatus;

     }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }


}
