package ProxyDemo;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class demo1 {
//    byte[] array = new byte[1*1024];
    public static void main(String[] args) {
        ArrayList<demo1> list = new ArrayList<>();
        int count = 0;
        try{
            while(true){
                list.add(new demo1());
                count = count+1;
            }
        }catch (Exception e){
            System.out.println("count:"+count);
            e.printStackTrace();
        }
    }
}
