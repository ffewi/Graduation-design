package com.cs.liwei.pojo;

import java.io.Serializable;

/**
 * 
 * 类/接口注释 对应 数据库中表的各个字段数据
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月16日
 *
 */
public class Teaching implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3560377808486308244L;
    /*
     * some propertype 属性
     */
    /**
     * 课程编号
     */
    private Integer courseNo;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 教师编号
     */
    private Integer teacherNo;
    /**
     * 班级名称
     */
    private String className;
    /**
     * 专业编号
     */
    private Integer professionNo;
    /**
     * 开课周数
     */
    private Integer teachWeekNum;
    /**
     * 开课开始周数
     */
    private Integer teachWeekPoint;
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
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }
    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    /**
     * @return the teacherNo
     */
    public Integer getTeacherNo() {
        return teacherNo;
    }
    /**
     * @param teacherNo the teacherNo to set
     */
    public void setTeacherNo(Integer teacherNo) {
        this.teacherNo = teacherNo;
    }
    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }
    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }
    /**
     * @return the professionNo
     */
    public Integer getProfessionNo() {
        return professionNo;
    }
    /**
     * @param professionNo the professionNo to set
     */
    public void setProfessionNo(Integer professionNo) {
        this.professionNo = professionNo;
    }
    /**
     * @return the teachWeekNum
     */
    public Integer getTeachWeekNum() {
        return teachWeekNum;
    }
    /**
     * @param teachWeekNum the teachWeekNum to set
     */
    public void setTeachWeekNum(Integer teachWeekNum) {
        this.teachWeekNum = teachWeekNum;
    }
    /**
     * @return the teachWeekPoint
     */
    public Integer getTeachWeekPoint() {
        return teachWeekPoint;
    }
    /**
     * @param teachWeekPoint the teachWeekPoint to set
     */
    public void setTeachWeekPoint(Integer teachWeekPoint) {
        this.teachWeekPoint = teachWeekPoint;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((teacherNo == null) ? 0 : teacherNo.hashCode());
        result = prime * result + ((courseNo == null) ? 0 : courseNo.hashCode());
        result = prime * result + ((className == null) ? 0 : className.hashCode());
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
        Teaching other = (Teaching) obj;
        if (teacherNo == null)
        {
            if (other.teacherNo != null)
                return false;
        }
        else if (!teacherNo.equals(other.teacherNo))
            return false;
        if (courseNo == null)
        {
            if (other.courseNo != null)
                return false;
        }
        else if (!courseNo.equals(other.courseNo))
            return false;
        if (className == null)
        {
            if (other.className != null)
                return false;
        }
        else if (!className.equals(other.className))
            return false;
        return true;
    }
}
