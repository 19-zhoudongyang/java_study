package ProxyDemo;

import java.lang.reflect.Proxy;

public class demo1 {
    public static void main(String[] args) {
        Proxydemo proxydemo = new Proxydemo(new User());
        Person person = proxydemo.userProxy();
        person.add();

    }
}
