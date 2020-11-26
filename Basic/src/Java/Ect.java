package com.company;

/**
 * @ClassName Ect
 * @Description TODO
 * @Author GYY
 * @Date 2020/10/14
 **/
public class Ect {

    double width,height,area;
    void setWidth(double width){
        if(width>0){
            this.width = width;
        }
    }
    void setHeight(double height){
        if(height>0){
            this.height = height;
        }
    }
    double getWidth(){
        return width;
    }
    double getArea(){
        area = width * height;
        return area;
    }
}
