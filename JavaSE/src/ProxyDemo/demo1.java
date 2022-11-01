package ProxyDemo;

import java.lang.reflect.Proxy;

public class demo1 {
    public static void main(String[] args)  {
        int i=10;
        i = i++;
        System.out.println(i);
    }
}
