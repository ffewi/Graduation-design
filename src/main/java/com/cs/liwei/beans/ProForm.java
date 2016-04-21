package com.cs.liwei.beans;

/**
 * 
 * 类/接口注释 此处 bean定义为页面与后台交互时数据 存储 的对象载体
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年4月20日
 *
 */
public class ProForm {
	/*
	 * 对应前台表单 传来的属性名字
	 */
	// 专业编号
	private int professionNo;
	// 专业名称
	private String professionName;
	// 院系编号
	private int deptNo;
	// 院系名称
	private String deptName;
	// 查询框 内容
	private String content;
	private int pageNo;
	private int pageSize;
	// 总共页数
	private int pageCount;
	//下拉选择框取值
	private int[] selectArr;

	public int[] getSelectArr() {
		return selectArr;
	}

	public void setSelectArr(int[] selectArr) {
		this.selectArr = selectArr;
	}

	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the deptNo
	 */
	public int getDeptNo() {
		return deptNo;
	}

	/**
	 * @param deptNo
	 *            the deptNo to set
	 */
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	/**
	 * @return the professionNo
	 */
	public int getProfessionNo() {
		return professionNo;
	}

	/**
	 * @param professionNo
	 *            the professionNo to set
	 */
	public void setProfessionNo(int professionNo) {
		this.professionNo = professionNo;
	}

	/**
	 * @return the professionName
	 */
	public String getProfessionName() {
		return professionName;
	}

	/**
	 * @param professionName
	 *            the professionName to set
	 */
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName
	 *            the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
