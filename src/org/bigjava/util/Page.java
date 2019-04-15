package org.bigjava.util;

public class Page {

	private int pageNow;//��ǰҳ
	private int totalSize;//������
	private int totalPage;//��ҳ��
	private int pageSize=10;//
	private boolean hasPre;//�Ƿ�����һҳ
	private  boolean hasNext;//�Ƿ�����һҳ
	private  boolean hasFirst;//�Ƿ�����ҳ
	private  boolean hasLast;//�Ƿ���βҳ
	
	public Page(int pageNow,int totalSize){
		//���췽��
		
		this.setPageNow(pageNow);
		this.setTotalSize(totalSize);	
	}
	public Page(int pageNow,int totalSize,int pageSize){//�ɶ�̬�ı�ÿҳ����
		//���췽��
		
		this.setPageNow(pageNow);
		this.setTotalSize(totalSize);	
		this.pageSize=pageSize;
	}
	public void setPageNow(int pageNow) {//�õ���ǰҳ
		this.pageNow = pageNow;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setTotalSize(int totalSize) {//������ 
		this.totalSize = totalSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setPageSize(int pageSize) {//ÿҳ��ʾ����
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getTotalPage() {//��ҳ�� = ������/ÿҳ��ʾ����
		totalPage=this.getTotalSize()/this.getPageSize();
		if(this.getTotalSize()%this.getPageSize()!=0){
			totalPage++; //������Ϊ��0 ��Ҫ���һҳ
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isHasPre() {//�Ƿ�����һҳ   ����һҳ���ⶼ����һҳ  ˵������ҳ�ľ�����һҳ
		if(this.isHasFirst()){
			return true;
		}else return false;
	}
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	public boolean isHasNext() {//�Ƿ�����һҳ   �����һҳ���ⶼ����һҳ  ˵����βҳ�ľ�����һҳ
		if(this.isHasLast()){
			return true;
		}
		else return false;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	
	public boolean isHasFirst() {   //�Ƿ�����ҳ ����һҳ���ⶼ����ҳ
		if(this.pageNow==1)   //�ǵ�һҳ��û����ҳ
			return false;
		else
			return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	public boolean isHasLast() {    //�Ƿ���βҳ  �����һҳ���ⶼ��βҳ
		if(pageNow==this.getTotalPage()){  //���һҳ
			return false;	
		}else return true;
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
}
