package com.cs.liwei.beans;

/**
 * 
 * 类/接口注释
 * 
 * studentWelcomPage 此处 bean定义为页面与后台交互时数据 存储 的对象载体
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月25日
 *
 */
public class StudentDetail {

    private float avgPoint;
    private int totalXueFen;
    private int biXiuXueFen;
    private int xuanXiuXueFen;
    private int tongShiXueFen;
    private int sheHuiShiJian;

    public float getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(float avgPoint) {
        this.avgPoint = avgPoint;
    }

    public int getTotalXueFen() {
        return totalXueFen;
    }

    public void setTotalXueFen(int totalXueFen) {
        this.totalXueFen = totalXueFen;
    }

    public int getBiXiuXueFen() {
        return biXiuXueFen;
    }

    public void setBiXiuXueFen(int biXiuXueFen) {
        this.biXiuXueFen = biXiuXueFen;
    }

    public int getXuanXiuXueFen() {
        return xuanXiuXueFen;
    }

    public void setXuanXiuXueFen(int xuanXiuXueFen) {
        this.xuanXiuXueFen = xuanXiuXueFen;
    }

    public int getTongShiXueFen() {
        return tongShiXueFen;
    }

    public void setTongShiXueFen(int tongShiXueFen) {
        this.tongShiXueFen = tongShiXueFen;
    }

    public int getSheHuiShiJian() {
        return sheHuiShiJian;
    }

    public void setSheHuiShiJian(int sheHuiShiJan) {
        this.sheHuiShiJian = sheHuiShiJan;
    }

}
