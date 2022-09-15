package Reflection;

import Collections.Person;
import java.lang.reflect.Field;

public class test1 {
    public static void main(String[] args) {
        Class<Like> clazz = Like.class;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}
