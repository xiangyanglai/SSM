package test.batis;

/**
 * Created by search on 2016/10/22.
 */
public class IntergerTest {
    public static void main(String[] args) {
        Integer i01 = 200;
        int i02 =200;
        Integer i03 = Integer.valueOf(200);
        Integer i04 = new Integer(20);
        Integer i06 = new Integer(20);
        System.out.println(i01==i02);
        System.out.println(i01==i03);
        System.out.println(i03==i04);
        System.out.println(i04==i02);
    }
}
