package bean;

import java.io.Serializable;

public class PageObject implements Serializable{
	//ÿҳ��ʾ���ܼ�¼��
	private int pageSize=15;
	//��¼����
	private int recordCount;
	//ҳ��
	private int pageCount;
	//��ǰҳ
	private int currentPage;
	//����
	private String opr;
	//��ʼλ��
	private int startPos;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		//����ҳ��
		pageCount = (int)Math.ceil((float)recordCount/(float)pageSize);
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getOpr() {
		return opr;
	}
	public void setOpr(String opr) {
		//�������
		if(opr.equals("first")){//��ҳ
			currentPage=1;
		}else if(opr.equals("last")){//ĩҳ
			currentPage=pageCount;
		}else if(opr.equals("piror")){//��һҳ
			if(currentPage>1){
				currentPage--;
			}else{
				currentPage=1;
			}
		}else if(opr.equals("next")){//��һҳ
			if(currentPage<pageCount){
				currentPage++;
			}else{
				currentPage=pageCount;
			}
		}else{
			currentPage=1;
		}
		this.opr = opr;
	}
	public int getStartPos() {
		startPos = (currentPage-1)*pageSize;
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	
}
