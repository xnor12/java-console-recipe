package resep.models;

public class User{
    private String nama, email, username, password;
    private boolean isLogin;
    
    public User(String nama,String email,String username, String password) {
        this.nama = nama;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isLogin = false;
    }

    public boolean login(String uName, String pWord) {
        if(this.username.equals(uName) && this.password.equals(pWord)){
            this.isLogin = true;
            return true;
        } else {
            this.isLogin = false;
            return false;
        }
    }

    public void logout() {
        isLogin = false;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
