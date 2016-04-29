package com.cs.liwei.service;

import java.util.List;

import com.cs.liwei.beans.ScoreForm;
import com.cs.liwei.beans.StuShowGrade;
import com.cs.liwei.beans.StudentDetail;
import com.cs.liwei.beans.StudentForm;
import com.cs.liwei.pojo.Student;

public interface StudentManager {
    /**
     * some interface method
     */
    void example();

    /**
     * 登录检查 student 成功：Student 不成功：null
     * 
     * @param stu
     * @return
     */
    Student checkLogin(Student stu);

    /**
     * 添加student
     * 
     * @param stuForm
     * @return
     */
    List<StudentForm> addStudent(StudentForm stuForm);

    /**
     * 根据studentNo 更新
     * 
     * @param stuForm
     * @return
     */
    List<StudentForm> updateStudentByID(StudentForm stuForm);

    /**
     * 通过studentNo删除学生
     * 
     * @param studentNo
     * @return
     */
    boolean delStudentById(int studentNo);

    /**
     * 模糊查询 ，通过学生名称
     * 
     */
    List<StudentForm> queryByStudentName(String name);

    /**
     * 查询学生已经有成绩的的课程
     * 
     * @param studentNo
     * @return
     */
    List<ScoreForm> queryByStudentNoAndIsHaveGrade(int studentNo);

    /**
     * 查出学生有课，但是没有成绩的 课程
     * 
     * @param studentNo
     * @return
     */
    List<ScoreForm> getIsNotHaveCoureIndex(int studentNo);

    /**
     * 添加成绩
     * 
     * @param sf
     * @return
     */
    List<ScoreForm> addScoreByScore(ScoreForm sf);

    /**
     * 执行更新score
     * 
     * @param sf
     * @return
     */
    List<ScoreForm> exeUpdateScore(ScoreForm sf);

    /**
     * 执行删除score
     * 
     * @param sf
     * @return
     */
    boolean delScoreByStuAndCou(ScoreForm sf);

    /**
     * studentWelcomPage 获取学生 平均绩点 总学分 必修学分 通识学分 选修学分 社会实践
     * 
     * @param studentNo
     * @return
     */
    StudentDetail getStudentTotalCountDetail(int studentNo);

    /**
     * 获取term下拉选项
     * 
     * @param studentNo
     * @return
     */
    List<Integer> getTermdropDownMenu(int studentNo);

    /**
     * 返回值中的pageNum 用于统计 term下 是否分页
     * 
     * @param term
     * @param pageNo
     * @return List<StuShowGrade>
     */
    List<StuShowGrade> getStuMsgByTermAndByPageNo(int studentNo, int term, int pageNo);
}
