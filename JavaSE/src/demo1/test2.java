package demo1;

public class test2 {
    public static void main(String[] args) {
        Person1 teacher = new Teacher();
        teacher = (Teacher)teacher;
    }
    static void sout(Person1 p){
        p.eat();
    }
}
abstract class Person1 {
    abstract void eat();
}

class Teacher extends Person1{
    static int p = 10;
    @Override
    void eat() {
        System.out.println("��ʦ�Է�");
    }
    void walk(){
        System.out.println("��·");
    }
}
class Student extends Teacher{
    void t(){
        System.out.println(p);
    }
}