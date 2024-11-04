package demo2genericity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class genericDemo1 {
    public static void main(String[] args) {
        //目标：认识泛型，搞清楚泛型类的好处。
        ArrayList<String> List = new ArrayList<String>();
        List.add("hello");
       // List.add(123);
       // List.add(true);
       // List.add('a');

        //获取数据
        for (int i = 0; i < List.size(); i++){
            //    object rs = List.get(i);
            // 把数据处理
            // String s = (String) rs;
            // System.out.println(s);
            String s = List.get(i);
            System.out.println(s);
        }
    }
}
