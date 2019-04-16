package org.bigjava.util;

import com.opensymphony.xwork2.ActionContext;

public class Page {
	private boolean hasmore; //����
	private int pageNow; //��ǰҳ
	private int totalSize; //������
	private int totalPage; //��ҳ��
	private int pageSize; //ÿҳ��ʾ����
	private boolean hasPre; //�Ƿ�����һҳ����/
	private boolean hasNext; //�Ƿ�����һҳ
	private boolean hasFirst; //�Ƿ�����ҳ
	private boolean hasLast; //�Ƿ���βҳ
	 
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
	
	//�õ���ҳ��
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
	//�ж��Ƿ�����һҳ
	public boolean isHasPre() {
		if(this.isHasFirst()){
			return true;
		}
		return false;
	}

	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	
	//�ж��Ƿ�����һҳ
	public boolean isHasNext() {
		if(this.isHasLast()){
			return true; 
		}
		return false;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	//�ж��Ƿ�����ҳ	
	public boolean isHasFirst() {
		if(this.pageNow == 1){
			return false;
		}
		return true;
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	//�ж��Ƿ���βҳ
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
