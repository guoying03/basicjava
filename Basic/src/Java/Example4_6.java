package com.company;

import java.util.concurrent.Callable;

/**
 * @ClassName Example4_6
 * @Description TODO
 * @Author GYY
 * @Date 2020/10/15
 **/
public class Example4_6 {
    static public class Circle{
        double radius;
        Circle(double r){
            radius = r;

        }
        double getArea(){
            return 3.14*radius*radius;
        }
        void setRadius(double r) {
            radius = r;
        }
            double getRadius(){
                return radius;
            }
        }
        static public class Circular{
            Circle bottom;
            double height;
            Circular(Circle c, double h){
                bottom = c;
                height = h;

            }
            double getVolme(){
                return bottom.getArea()*height/3.0;
            }
            double getBottmRadius(){
                return bottom.getRadius();
        }
        public void setBottmRadius(double r){
                bottom.setRadius(r);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println("main方法中circle的引用:" + circle);
        System.out.println("main方法中circle的半径" + circle.getRadius());
        Circular circular = new Circular(circle,20);
        System.out.println("circular圆锥的bottm的引用:" + circular.bottom);
        System.out.println("圆锥的bottom的半径:" + circular.getBottmRadius());
        System.out.println("圆锥的体积:" + circular.getVolme());
        double r = 8888;
        System.out.println("圆锥更改底圆bottom的半径:" + r);
        circular.setBottmRadius(r);
        System.out.println("圆锥的bottom的半径:" + circular.getBottmRadius());
        System.out.println("圆锥的体积:" + circular.getVolme());
        System.out.println("mian方法中circle的半径:" + circle.getRadius());
        System.out.println("main方法中circle的引用将发生变化");
        circle = new Circle(1000);
        System.out.println("现在main方法中circle的引用:" + circle);
        System.out.println("main方法中circle的半径:" + circle.getRadius());
        System.out.println("但是不影响circular圆锥的bottom的引用");
        System.out.println("circular圆锥的bottom的引用:" + circular.bottom);
        System.out.println("圆锥的bottom的半径:" + circular.getBottmRadius());


    }
}
