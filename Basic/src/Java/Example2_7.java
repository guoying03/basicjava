package com.company;

import java.util.Arrays;

public class Example2_7 {
    public static void main(String args[]){
        int[]a={12,34,9,23,45,6,45,90,123,19,34};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int number=45;
        int index=Arrays.binarySearch(a,number);
        if(index>=0){
            System.out.println(number+"和数组中索引为"+index+"的元素的值相同");

        }
    }
}
