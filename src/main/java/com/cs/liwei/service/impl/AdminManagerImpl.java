package com.cs.liwei.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cs.liwei.beans.CourseForm;
import com.cs.liwei.beans.DeptForm;
import com.cs.liwei.beans.ProForm;
import com.cs.liwei.dao.IAdminDao;
import com.cs.liwei.pojo.Admin;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.pojo.Profession;
import com.cs.liwei.service.AdminManager;

@Service
public class AdminManagerImpl implements AdminManager {
    /**
     * 注入 dao
     * 
     * @resource daoName private dao
     */
    @Resource(name = "adminDaoImpl")
    private IAdminDao dao;

    @Override
    public void example() {
        /*
         * 一些逻辑方法，并调用dao层 进行数据分析
         */
    }

    @Override
    public List<Dept> getAllByPage(int pageNo, int pageSize) {
        List<Dept> list = dao.getDeptByPage(pageNo, pageSize);
        return list;
    }

    @Override
    public boolean checkLogin(Admin admin) {
        boolean msg = dao.checkUser(admin);
        if (msg) {
            return true;
        }
        return false;
    }

    @Override
    public List<Dept> queryByName(String name) {
        List<Dept> list = dao.getDeptByNameForLike(name);
        return list;
    }

    @Override
    public List<Dept> updateDeptByID(DeptForm deptMsg) {
        Dept d= new Dept();
        d.setDeptNo(deptMsg.getDeptNo());
        d.setDeptName(deptMsg.getDeptName());
        //进行dept更新操作
        Dept result = dao.updateDeptByID(d);
        if (result==null) {
            return null;
        }else {
            List<Dept> list = new ArrayList<Dept>();
            list.add(result);
            return list;
        }
    }

    @Override
    public void delDeptById(int deptNo) {
        dao.delDeptById(deptNo);
    }

    @Override
    public List<Dept> addDept(String deptName) {
        //调用 添加
        Dept d = new Dept();
        d.setDeptName(deptName);
        Integer id = dao.save(d);
        d.setDeptNo(id);
        List<Dept>  list = new ArrayList<Dept>();
        list.add(d);
        //返回数据
        return list;
    }

    @Override
    public List<ProForm> getProByPage(int pageNo, int pageSize) {
        //获取 profession 数据，并且 与dept数据做加工
        List<ProForm> list = dao.getProByPage(pageNo, pageSize);
        return list;
    }

	@Override
	public List<Dept> getAllDept() {
		// TODO Auto-generated method stub
		Dept obj = null;
		obj = new Dept();
		List<Object> r1 = dao.findAll(obj);
		List<Dept> list = new ArrayList<Dept>();
		for (Object o1 : r1) {
			obj=new Dept();
			obj = (Dept)o1;
			list.add(obj);
		}
		return list;
	}

	@Override
	public List<ProForm> updateProByID(ProForm proMsg) {
		Profession pro = new Profession();
		pro.setProfessionNo(proMsg.getProfessionNo());
		pro.setProfessionName(proMsg.getProfessionName());
//		Object s = proMsg.getSelectArr()[0];
//		pro.setDeptNo(Integer.parseInt(proMsg.getSelectArr()[0].toString()));
		//修改过后的下拉选项值
		pro.setDeptNo(proMsg.getSelectArr()[0]);
		//进行profession更新
		Profession result = dao.updateProByID(pro);
		Dept dept = new Dept();
		//获取dept名字 整合 返回数据
		dept =(Dept) dao.findByID(dept, pro.getDeptNo());
		if (result==null) {
            return null;
        }else {
        	List<ProForm> list = new ArrayList<ProForm>();
        	proMsg.setDeptNo(dept.getDeptNo());
        	proMsg.setDeptName(dept.getDeptName());
        	list.add(proMsg);
            return list;
        }
	}

    @Override
    public List<ProForm> addPro(ProForm proForm) {
        //逻辑代码，传入的值只有 院系编号proForm.getSelectArr()[0]，和专业名称proForm.getProfessionName;
        //自动封装专业id  先更具院系编号查询专业条数，进行拼接
        int deptId = proForm.getSelectArr()[0] ;
        int num = dao.countProByDeptId(deptId);
        int proNo = deptId*1000+num;
        Profession pro = new Profession();
        Object obj = dao.findByID(pro, proNo);
        //如果存在该条记录 ，那么就将proNo从1开始 找没有的空位插入
        if (obj!=null) {
            //将proNo值置为（院系编号+000）的结构
            proNo -=num;
        }
        while (obj!=null) {
            proNo++;
            obj = dao.findByID(pro, proNo);
        }
//        System.out.println(obj==null+"查找不到有这条数据");
        pro.setProfessionNo(proNo);
        pro.setProfessionName(proForm.getProfessionName());
        pro.setDeptNo(deptId);
        boolean isOk = dao.savePro(pro);
        //添加成功 返回添加后的加工数据
        if (isOk) {
            List<ProForm> list = new ArrayList<ProForm>();
            Dept d = new Dept();
            d=(Dept) dao.findByID(d, deptId);
            proForm.setProfessionNo(proNo);
            proForm.setDeptName(d.getDeptName());
            list.add(proForm);
            return list;
        }
        return null;
    }

    @Override
    public List<ProForm> queryByProName(String name) {
        //模糊查询 专业管理页面内容返回
        List<ProForm> list = dao.getProByNameForLike(name);
        return list;
    }

    @Override
    public List<CourseForm> getCourseByPage(int pageNo, int pageSize) {
        //获取course默认进去初始数据
        List<CourseForm> list = dao.getCourseByPage(pageNo, pageSize);
        return list;
    }

}
