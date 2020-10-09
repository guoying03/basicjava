package com.company;

/**
 * @ClassName Example3_10
 * @Description TODO
 * @Author GYY
 * @Date 2020/10/9
 **/
public class Example3_10 {
    enum Friut{
        苹果,梨,香蕉,西瓜,芒果
    }
    public static void main(String args[]){
        double price = 0;
        boolean show = false;
        for(Friut firut:Friut.values()){
            switch(firut){
                case 苹果: price = 1.5;
                show = true;
                break;
                case 芒果: price = 6.8;
                show = true;
                break;
                case 香蕉: price = 2.8;
                show = true;
                break;
                default:show = false;
            }
            if(show){
                System.out.println( firut + "500克的价格：" + price+" 元 ");
            }
        }
    }
}
