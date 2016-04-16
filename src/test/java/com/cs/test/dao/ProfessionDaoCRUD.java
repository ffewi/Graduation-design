package com.cs.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cs.liwei.dao.IBaseDao;
import com.cs.liwei.pojo.Profession;

public class ProfessionDaoCRUD {
    @Resource(name="iBaseDaoImpl")
    private static IBaseDao dao;
    @Test
    public void testSave(){
        getCx();
        Profession obj = new Profession();
        obj.setProfessionNo(101010);
        obj.setProfessionName("测试数据");
        obj.setDeptNo(101);
        //此方法 主键无法设置， 只能自己在写一个方法
        Integer id = dao.save(obj);
        System.out.println(id);
        
    }
    @Test
    public void testUpdate(){
        getCx();
        Profession obj = new Profession();
        obj.setProfessionNo(105006);;
        obj.setProfessionName("改变数据");
        obj.setDeptNo(101);
        System.out.println(obj.getProfessionNo()+":"+obj.getProfessionName()+":"+obj.getDeptNo());
        dao.update(obj);
    }
    @Test
    public void testDelete(){
        getCx();
        Profession obj = new Profession();
//        obj=(Profession) dao.findByID(obj, 101001);
        obj.setProfessionNo(105005);;
//        obj.setProfessionName("测试数据");
//        obj.setDeptNo(101);
        System.out.println(obj.getProfessionNo()+":"+obj.getProfessionName()+":"+obj.getDeptNo());
        dao.delete(obj);
    }
    @Test
    public void testFind(){
        getCx();
      Profession obj = new Profession();
      obj=(Profession) dao.findByID(obj, 101001);
      System.out.println(obj==null);
      System.out.println(obj.getProfessionNo()+":"+obj.getProfessionName()+":"+obj.getDeptNo());
    }
    @Test
    public void testFindAll(){
       getCx();
       Profession obj = new Profession();
       List<Object> list = dao.findAll(obj);
       for (Object o1 : list) {
        obj = (Profession) o1;
        System.out.println(obj.getProfessionNo()+":"+obj.getProfessionName()+":"+obj.getDeptNo());
    }
       
    }
    
    public static void getCx(){
        ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("spring-hibernate.xml");
        dao=cx.getBean("iBaseDaoImpl", IBaseDao.class);
    }
}
