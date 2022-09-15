package StreamAPI;

import java.util.ArrayList;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        ArrayList<Like> objects = new ArrayList<>();
        Stream<Like> stream = objects.stream();
        Stream<Like> stream1 = stream.filter(e -> {
            return e.getI() != 1;
        });
        System.out.println(stream1);
    }
}
