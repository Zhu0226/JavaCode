package demo2genericity;

public class genericDemo2 {
    public static void main(String[] args) {
        //目标：学会自定义泛型类
        //需求：请您模拟一个ArrayList集合，自定义以一个MyArrayList集合，
        //MyArrayList=new MyArrayList<String>();
        MyArrayList<String> mlist = new MyArrayList<>();
        mlist = new MyArrayList();
        mlist.add("hello");
        mlist.add("world");
        mlist.add("java");

        System.out.println(mlist.remove(e:"hello"));

        System.out.println(mlist);
    }
}
