package demo1;

public class test {
    public static void main(String[] args) {
        Like like = new Like(1);
        System.out.println();
    }
}
class Like {
    int i;

    public Like(){

    }
    public Like(int i){
        this.i=i;
        System.out.println(i);
    }
    {
        i=0;
    }

}
