package com.cs.liwei.pojo;

import java.io.Serializable;
/**
 * 
 * 类/接口注释
 * 对应 数据库中表的各个字段数据
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public class Score implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7956612943753678033L;

    /*
     * some propertype  属性
     */
    /**
     * 学生学号
     */
    private Integer studentNo;
    /**
     * 课程编号
     */
    private Integer courseNo;
    /**
     * 考试类型
     */
    private String examType;
    /**
     * 平时成绩
     */
    private int pingshiScore;
    /**
     * 考试成绩
     */
    private int examScore;
    /**
     * 期末最终成绩
     */
    private int finalScore;
    /**
     * 绩点
     */
    private float gradePoint;
    /**
     * @return the studentNo
     */
    public Integer getStudentNo() {
        return studentNo;
    }
    /**
     * @param studentNo the studentNo to set
     */
    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }
    /**
     * @return the courseNo
     */
    public Integer getCourseNo() {
        return courseNo;
    }
    /**
     * @param courseNo the courseNo to set
     */
    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }
    /**
     * @return the examType
     */
    public String getExamType() {
        return examType;
    }
    /**
     * @param examType the examType to set
     */
    public void setExamType(String examType) {
        this.examType = examType;
    }
    /**
     * @return the pingshiScore
     */
    public int getPingshiScore() {
        return pingshiScore;
    }
    /**
     * @param pingshiScore the pingshiScore to set
     */
    public void setPingshiScore(int pingshiScore) {
        this.pingshiScore = pingshiScore;
    }
    /**
     * @return the examScore
     */
    public int getExamScore() {
        return examScore;
    }
    /**
     * @param examScore the examScore to set
     */
    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }
    /**
     * @return the finalScore
     */
    public int getFinalScore() {
        return finalScore;
    }
    /**
     * @param finalScore the finalScore to set
     */
    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
    /**
     * @return the gradePoint
     */
    public float getGradePoint() {
        return gradePoint;
    }
    /**
     * @param gradePoint the gradePoint to set
     */
    public void setGradePoint(float gradePoint) {
        this.gradePoint = gradePoint;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
        result = prime * result + ((courseNo == null) ? 0 : courseNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Score other = (Score) obj;
        if (studentNo == null)
        {
            if (other.studentNo != null)
                return false;
        }
        else if (!studentNo.equals(other.studentNo))
            return false;
        if (courseNo == null)
        {
            if (other.courseNo != null)
                return false;
        }
        else if (!courseNo.equals(other.courseNo))
            return false;
        return true;
    }
}
