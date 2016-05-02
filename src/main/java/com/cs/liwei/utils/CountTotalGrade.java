package com.cs.liwei.utils;

public class CountTotalGrade {
    private static CountTotalGrade instance = null;

    // 限制产生多个对象
    private CountTotalGrade() {
    }

    // 通过该方法获得实例对象
    public static CountTotalGrade getSingleton() {
        synchronized (instance) {
            if (instance == null) {
                instance = new CountTotalGrade();
            }
        }
        return instance;
    }
    /**
     * 
     * @param s1 平时成绩
     * @param s2 测试成绩
     * @return
     */
    public static int finalScore(int s1,int s2){
        int result = s1+ (int)Math.round(s2*0.7);
        return result;
    }
    public static void main(String[] args) {
        int ss = CountTotalGrade.finalScore(30, 45);
        System.out.println(ss);
    }
}
