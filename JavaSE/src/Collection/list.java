package Collection;

import java.util.*;

public class list  {


    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,1);
        ArrayList<Object> list = new ArrayList<>();
        list.add(123);
        list.clear();
        map.clear();
        System.out.println(map.isEmpty());
        System.out.println(list.isEmpty());
    }
}
