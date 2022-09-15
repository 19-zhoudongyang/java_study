package JDBC_1.com.zdy;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;

public class CustomersBean {
    Integer id;
    String name;
    String email;
    Date birth;
    Blob blob;

    @Override
    public String toString() {
        return "CustomersBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", blob=" + blob +
                '}';
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    public CustomersBean(Integer id, String name, String email, Date birth, Blob blob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.blob = blob;
    }

    public CustomersBean(Integer id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public CustomersBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

}
