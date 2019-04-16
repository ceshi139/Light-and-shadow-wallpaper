package org.bigjava.util;

import com.opensymphony.xwork2.ActionContext;
public class Page {
	private boolean hasmore; //¸ü¶à
	private int pageNow; //µ±Ç°Ò³
	private int totalSize; //×ÜÌõÊý
	private int totalPage; //×ÜÒ³Êý
	private int pageSize; //Ã¿Ò³ÏÔÊ¾ÌõÊý
	private boolean hasPre; //ÊÇ·ñÓÐÉÏÒ»Ò³½âÂë/
	private boolean hasNext; //ÊÇ·ñÓÐÏÂÒ»Ò³
	private boolean hasFirst; //ÊÇ·ñÓÐÊ×Ò³
	private boolean hasLast; //ÊÇ·ñÓÐÎ²Ò³ 
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
	
	//ï¿½Ãµï¿½ï¿½ï¿½Ò³ï¿½ï¿½
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
	
	public boolean isHasPre() {
		if(this.isHasFirst()){
			return true;
		}
		return false;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	
	//ï¿½Ð¶ï¿½ï¿½Ç·ï¿½ï¿½ï¿½ï¿½ï¿½Ò»Ò³
	public boolean isHasNext() {
		if(this.isHasLast()){
			return true; 
		}
		return false;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	//ï¿½Ð¶ï¿½ï¿½Ç·ï¿½ï¿½ï¿½ï¿½ï¿½Ò³	
	public boolean isHasFirst() {
		if(this.pageNow == 1){
			return false;
		}
		return true;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	//ï¿½Ð¶ï¿½ï¿½Ç·ï¿½ï¿½ï¿½Î²Ò³
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
