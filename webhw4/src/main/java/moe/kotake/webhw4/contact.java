package moe.kotake.webhw4;

public class contact {
    public static int id;
    public int current_id;
    public String name;
    public String tel;
    public String email;
    public String qq;
    public String addr;
    public String bir;

    public contact(String name, String tel, String email, String qq, String addr, String bir) {
        this.current_id = id;
        id++;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.qq = qq;
        this.addr = addr;
        this.bir = bir;
    }

    public contact() {
        this.current_id = id;
    }

    public contact(int id) {
        this.id = id;
        this.current_id = id;
    }

    public int getId() {

        return id;
    }

    public int getCurrent_id() {

        return current_id;
    }

    public void setCurrent_id(int current_id) {

        this.current_id = current_id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTel() {

        return tel;
    }

    public String getEmail() {

        return email;
    }

    public String getQq() {

        return qq;
    }

    public String getAddr() {

        return addr;
    }

    public String getName() {

        return name;
    }

    public String getBir() {
        return bir;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setTel(String tel) {

        this.tel = tel;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setQq(String qq) {

        this.qq = qq;
    }

    public void setAddr(String addr) {

        this.addr = addr;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }
}
