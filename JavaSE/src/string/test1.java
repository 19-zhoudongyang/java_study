package string;

public class test1 {
    public static void main(String[] args) {
        String str = "qqq";
//        System.out.println(str);
        String str1 = "1231daddads123a23123sdd123";
        String str2 = str1.replaceAll("\\d+","br");
        boolean matches = str1.matches("\\d+");
        String[] str3 = str1.split("\\d+",3);
        System.out.println(matches);
        for (Object s : str3) {
            System.out.println(s);
        }
    }
}
