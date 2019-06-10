package com.hks.exercise;

public class A<T> {

    public T a(String a, boolean b) {
        return null;
    }


    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(A.class.getMethods()[1].toString());

        System.out.println(A.class.getMethods()[1].toGenericString());
    }
}
class  B extends A<String> {

}
