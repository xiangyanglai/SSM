package test.batis;

/**
 * Created by search on 2016/10/14.
 */

/**
 * effective java中推荐的内部类实现单例的写法 。
 */
class SingtonInstance{
    private SingtonInstance()
    {
        System.out.println("constructor");
    }
    private static class SingtonHolder{
        private static SingtonInstance instance = new SingtonInstance();
    }
    public static void beforeInvoke()
    {
        System.out.println("before invoke");
    }

    public static SingtonInstance getInstance()
    {
        /**
         * 此处最开始理解有点绕，但是经过我对象的一个提醒恍然明白，对于内部类的所有对象对于其
         * 外部类来说都是可见的，简直是霸气，否则private的可见范围是不允许直接访问的。
         */
        return SingtonHolder.instance;
    }
}

public class Test {
    public static void main(String[] args) {
        SingtonInstance.beforeInvoke();
        SingtonInstance.getInstance().beforeInvoke();
    }
}
