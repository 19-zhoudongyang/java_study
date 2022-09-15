package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxydemo {
    Object object;

    public Proxydemo() {
    }

    public Proxydemo(Object object) {
        this.object = object;
    }

    public Person userProxy(){
        return (Person)Proxy.newProxyInstance(Proxydemo.class.getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法执行前的增强部分");
                Object invoke = method.invoke(object, args);
                System.out.println("方法执行后的增强部分");
                return invoke;
            }
        });

    }
}
