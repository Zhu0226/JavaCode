package demo2genericity;

import javax.swing.*;

public class MyArrayList {
    public void add(String hello) {
    }

    //自定义泛型类
    public static class ArrayList<E>{
        private ArrayList List = new ArrayList();

        public boolean add(E e){
            return List.add(e);
        }
        public boolean remove(E e){
            return List.remove(e);
        }

        public String toString() {
            return List.toString();
        }
        }
    }

