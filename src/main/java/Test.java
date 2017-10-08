import java.util.*;

/**
 * Created by Pc on 24.09.2017.
 */
public class Test {
    public static void main(String[] args) {

        Set<A> set = new HashSet();

        set.add(new A(2));
        set.add(new A(1));
        set.add(new A(2));
        for (A a : set) {
            System.out.println(a);
        }

        Tail t = new Tail();
        Cat cat = new Cat();
        Cat cat1 = new Cat();
        cat.setTail1(t);
        cat1.setTail1(t);
        cat = null;
    }
}
class A{
    int i;

    public A(int i) {
        this.i = i;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        return i == a.i;
    }

    @Override
    public int hashCode() {
        return i;
    }*/
}

class Tail{


}
class Cat{
    Tail tail = new Tail();//
    Tail tail1;

    public void setTail1(Tail tail1) {
        this.tail1 = tail1;
    }


}

class Base {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABC";
        String s3 = new String("DEF");
        String s4 = "DEF";

        System.out.println(s1.equalsIgnoreCase(s2));
        //System.out.println(s1.intern("s2));
        System.out.println(s1.equals(s2));
        System.out.println( s3==s4);



    }



    /*Base(){
        System.out.println();
    }*/

    Base(int i) {
        System.out.println("Base");
    }
}
class Derived extends Base {
    Derived(){
        super(5);
    }
    public static void main(String[] argv) {
        Derived d = new Derived();
    }
    void Derived() {
        System.out.println("Derived");
    }

    class Cat{
        Tail tail = new Tail();
        Tail tail1;


        public void setTail1(Tail tail1) {
            this.tail1 = tail1;
        }
    }
    class Tail{

    }
}