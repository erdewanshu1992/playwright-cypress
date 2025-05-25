package com.flipkart.utils;

public class Human {
    public String name;
    private int age;

//    public  String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
////        this.name = name;
//
//    public void setName(String name) {
//        this.name = name;
//    }
    Human (String name){
        this.name=name;
    }

}
class A{
   // static Human h1=new Human("Shashank");
    static Human h2=new Human("RAdha");
    //static Human h3=new Human("Shashank",26);

    public static void main(String[] args) {
//        h2.setAge(26);
//        h2.setName("Dewanshu");
        System.out.println(h2.name);
    }

}




















/*
package com.flipkart.utils;

public class Human {
    String name;
    int age;
    // Constructor with only name
    Human(String name){
        this.name = name;
    }

    // Constructor with only age
    Human(int age){
        this.age = age;
    }

    // Constructor with name and age
    Human(String name, int age){
        this.name = name;
        this.age = age;
    }
}
class A{
    static Human h1=new Human("Shashank");
    static Human h2=new Human(26);
    static Human h3=new Human("Shashank",26);

    public static void main(String[] args) {
        System.out.println(h3.name + " "+ h3.age);
    }

}


 */