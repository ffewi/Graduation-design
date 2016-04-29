package com.cs.liwei.dao;

import java.util.List;

import com.cs.liwei.beans.ScoreForm;
import com.cs.liwei.beans.StuShowGrade;
import com.cs.liwei.beans.StudentDetail;
import com.cs.liwei.beans.StudentForm;
import com.cs.liwei.pojo.Score;
import com.cs.liwei.pojo.Student;

/**
 * 
 * 类/接口注释 DAO层 方法 定义
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月13日
 *
 */
public interface IStudentDao extends IBaseDao {
    /*
     * 增 删 改 查 定义一些其他特殊的操作
     */
    void searchAllExample();

    /**
     * 用户登录检查
     * 
     * @param stu
     * @return
     */
    Student checkUser(Student stu);

    /**
     * 通过班级号获得专业名称
     * 
     * @param proNo
     * @return
     */
    String getProNameByClassName(String className);

    /**
     * 更新数据，需要传入 studentNo,studentName,className,sex,四项
     * 
     * @param stu
     * @return
     */
    boolean updateStudent(Student stu);

    /**
     * 删除studentBy studentNo
     * 
     * @param studentNo
     * @return
     */
    boolean delStudent(int studentNo);

    /**
     * dao层 模糊查询学生名称
     * 
     * @param name
     * @return
     */
    List<StudentForm> getStudentByNameForLike(String name);

    /**
     * 查询学生有成绩的课程
     * 
     * @param studentNo
     * @return
     */
    List<ScoreForm> getScoreMsgIsHaveGrade(int studentNo);

    /**
     * 查询出有课程没有成绩的学生的课程下拉选项
     * 
     * @param studentNo
     * @return
     */
    List<ScoreForm> getIsNotHaveCoureIndex(int studentNo);

    /**
     * 
     * @param s
     * @return
     */
    boolean addScore(Score s);

    /**
     * 更新score
     * 
     * @param s
     * @return
     */
    boolean updateScore(Score s);

    /**
     * 删除score 通过 studentNo 和courseNo
     * 
     * @param s
     * @return
     */
    boolean delScore(Score s);
    /**
     * 获取平均绩点
     * @param studentNo
     * @return
     */
    float getAvgPoint(int studentNo);
    /**
     * 获取分类 学分统计
     * @param studentNo
     * @return
     */
    StudentDetail getXueFenCountByCourseType(int studentNo);
    /**
     * 获取 已经拥有的总学分
     * @param studentNo
     * @return
     */
    int getHadTotalXueFen(int studentNo);
    /**
     * 学生已经学过的学期
     * @param studentNo
     * @return
     */
    List<Integer> studentOwnTerm(int studentNo);
    /**
     * 根据学号，学期  分页信息 获取 页面数据量固定10
     * @param studentNo
     * @param term
     * @param pageNo
     * @return List<StuShowGrade>
     */
    List<StuShowGrade> getStuShowGradeByTerm(int studentNo,int term,int pageNo);
}
