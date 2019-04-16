package org.bigjava.util;

import com.opensymphony.xwork2.ActionContext;

public class Page {
	private boolean hasmore; //更多
	private int pageNow; //当前页
	private int totalSize; //总条数
	private int totalPage; //总页数
	private int pageSize; //每页显示条数
	private boolean hasPre; //是否有上一页解码/
	private boolean hasNext; //是否有下一页
	private boolean hasFirst; //是否有首页
	private boolean hasLast; //是否有尾页
	 
	public Page(){};
	
	public Page(int pageNow,int pageSize,int totalSize) {
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	//得到总页数
	public int getTotalPage() {
		totalPage = this.getTotalSize()/this.getPageSize();
		if(this.getTotalSize()%this.getPageSize() != 0){
			totalPage++;	
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//判断是否有上一页
	public boolean isHasPre() {
		if(this.isHasFirst()){
			return true;
		}
		return false;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	
	//判断是否有下一页
	public boolean isHasNext() {
		if(this.isHasLast()){
			return true; 
		}
		return false;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	//判断是否有首页	
	public boolean isHasFirst() {
		if(this.pageNow == 1){
			return false;
		}
		return true;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	//判断是否有尾页
	public boolean isHasLast() {
		if(pageNow == this.getTotalPage()){
			return false;
		}
		return true;
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

	public boolean isHasmore() {
		int type_id = (int) ActionContext.getContext().getSession().get("type_id");
		if(type_id == 0){
			return false;
		}
		return true;
	}

	public void setHasmore(boolean hasmore) {
		this.hasmore = hasmore;
	}


}
