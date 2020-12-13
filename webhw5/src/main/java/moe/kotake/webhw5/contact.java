package moe.kotake.webhw5;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String tel;
    public String email;
    public String qq;
    public String addr;
    public String bir;

    public contact(Long id, String name, String tel, String email, String qq, String addr, String bir) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.qq = qq;
        this.addr = addr;
        this.bir = bir;
    }

    public contact() {
    }

    public contact(Long id) {
        this.id = id;
    }

    public Long getID() {

        return id;
    }


    public void setId(Long id) {

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
