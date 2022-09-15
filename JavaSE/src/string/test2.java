package string;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class test2 {
    String str1 = "abcwerthelloyuiodef";
    String str2 = "cvhellobnm";

    public static void main(String[] args) {
//        char[] c = new char[5];
//        c[0] = '2';
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append('c');
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append('c');
//        System.out.println(stringBuilder.length());
//
//        Arrays.sort();
        for (Season value : Season.values()) {
            System.out.println(value);
            System.out.println(value.status);
        }
    }
}
enum Season{
    SUMMER("одлЛ","одхуявяв");
//    String season;
    String status;
    Season(String season, String status) {
//        this.season = season;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
