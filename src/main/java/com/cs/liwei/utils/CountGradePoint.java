package com.cs.liwei.utils;

public class CountGradePoint {
    private static CountGradePoint instance = null;
    
    // 限制产生多个对象
    private CountGradePoint() {
    }
 
    // 通过该方法获得实例对象
    public static CountGradePoint getSingleton() {
        synchronized (instance) {
            if (instance == null) {
                instance = new CountGradePoint();
            }
        }
        return instance;
    }
    
    public static float countPoint(int fenshu){
        float index = 0;
        if (fenshu<60) {
            index = 0;
        }else if (fenshu>=60&&fenshu<65) {
            index = 1.0f;
        }else if (fenshu >=65&&fenshu<70) {
            index = 1.5f;
        }else if (fenshu >=70&&fenshu<75) {
            index = 2.0f;
        }else if (fenshu >=75&&fenshu<80) {
            index = 2.5f;
        }else if (fenshu >=80&&fenshu<85) {
            index = 3.0f;
        }else if (fenshu >=85&&fenshu<90) {
            index = 3.5f;
        }else if (fenshu >=90&&fenshu<=100) {
            index = 4.0f;
        }
        return index;
    }
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        float s = instance.countPoint(90);
        System.out.println(s);
    }
}
