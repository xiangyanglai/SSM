package test.batis;

/**
 * Created by search on 2016/10/14.
 */

//parent
 class ParentStatic {
    public static void print(){
        System.out.println("************parent**************");
    }

}
//child
 class ChildStatic extends ParentStatic{

    public static void print(){
        System.out.println("*******************child******************");
//      ParentStatic.print();
        //print(); //error occur,stack overflow
    }
}

public class Sington {
    private static class SingletonHolder{
        //静态初始化器，由JVM来保证线程安全
        private static Sington instance=new Sington();
    }
    public void print()
    {
        System.out.println("hello");
    }

    //私有化构造方法
    private Sington(){

    }

    public static Sington getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        getInstance().print();
//        ChildStatic demo = new ChildStatic();
//        demo.print();
    }
}
