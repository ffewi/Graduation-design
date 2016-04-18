package com.cs.liwei.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cs.liwei.beans.DeptForm;
import com.cs.liwei.pojo.Dept;
import com.cs.liwei.service.AdminManager;
import com.opensymphony.xwork2.ActionSupport;
@Controller(value = "adminAction")
@Scope(value = "prototype")
public class AdminAction extends ActionSupport {
    @Resource(name="adminManagerImpl")
    private AdminManager admin;
    private List<Dept> list;
    private DeptForm deptForm;
    /**
     * 
     */
    private static final long serialVersionUID = -7243750676583760197L;

    public String exampleMethod() {

        return "pageName";
    }
    
    public String getAllDeptList(){
//        list = admin.getAllByPage(deptForm.getPageNo(), deptForm.getPageSize());
        list = admin.getAllByPage(0, 4);
        System.out.println(list.size());
        return "dept";
    }

    /**
     * @return the list
     */
    public List<Dept> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Dept> list) {
        this.list = list;
    }

    /**
     * @return the deptForm
     */
    public DeptForm getDeptForm() {
        return deptForm;
    }

    /**
     * @param deptForm the deptForm to set
     */
    public void setDeptForm(DeptForm deptForm) {
        this.deptForm = deptForm;
    }
    
    
}
