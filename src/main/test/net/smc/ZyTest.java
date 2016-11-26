package net.smc;

/**
 * Created by 念梓  on 2016/11/25.
 * Email:sunmch@163.com
 * author: 念梓
 * des:
 */
public class ZyTest {

    public static void main(String[] args) {
        BB b = new BB();
        b.setUsername("ssss");
        b.setPassword("aaaaaaaa");
        System.out.println(b.getClass());
        AA a = (AA) b;
        System.out.println(a.getClass());

    }
}
