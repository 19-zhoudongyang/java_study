package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<? super Person> list = new ArrayList<>();
        ArrayList<Object> list1 = new ArrayList<>();
        list = list1;
        list.add(new Student());
    }
}
