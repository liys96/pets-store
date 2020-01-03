package edu.lys.entity;

import java.util.List;
/**
 * 设置了当前页的数量,就能够计算出查询的起始位置和结束位置
 * 设置了总记录数,就能够计算出总页数以及上一页和下一页,以及尾页
 * */
public class Page<T> {
	
	private int pageSize;   //每页显示的数目
	private int totalCount; //总记录数
	private int totalPage;  //总页数
	private int currentPage;//当前页
	private int firstPage = 1;  //首页
	private int lastPage;   //尾页
	private int forwardPage;//上一页
	private int nextPage;   //下一页
	private String startTimeStr;//模糊查询的起始时间
	private String endTimeStr;//模糊查询的结束时间
	private T entity;//查询的对象beean
	private List<T> list;//结果集
	private int startIndex;//模糊查询的起始位置
	private int endIndex;//模糊查询的结束位置

	
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = (currentPage - 1) * pageSize + 1;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = pageSize * currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public String getStartTimeStr() {
		return startTimeStr;
	}
	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}
	public String getEndTimeStr() {
		return endTimeStr;
	}
	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//设置总页数
		setTotalPage(totalCount);
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalCount) {
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :totalCount / pageSize + 1;
		//设置最后一页
		this.setLastPage(totalPage);
		//设置上一页和 下一页
		this.setForwardPage();
		this.setNextPage();
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		//设置起始位置
		this.setStartIndex(currentPage);
		this.setEndIndex(currentPage);
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getForwardPage() {
		return forwardPage;
	}
	public void setForwardPage() {
		if (this.currentPage <= 1) {
			this.forwardPage = 1;
		}else{
			this.forwardPage = this.currentPage - 1;
		}
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage() {
		if (this.currentPage >= this.lastPage) {
			this.nextPage = this.lastPage;
		}else{
			this.nextPage = this.currentPage + 1;
		}
	}
	
	
	
}
