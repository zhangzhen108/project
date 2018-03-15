package com.project.sdk.common.page;

/**
 * Created by zhangzhen on 2017/7/14.
 */
import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

    private final static int PAGEITEMCOUNT = 10;  //��ʾҳ����Ŀ������ҳ������������10��

    private List<T> list;
    private int totalRecord;
    private int pageSize = 5;
    private Integer totalPage;
    private int currentPage = 1;
    private int previousPage;
    private int nextPage;
    private int[] pageBar;
    private int startIndex;
    private int endIndex;

/*  public int getSelectEndIndex() {
        return this.getStartIndex()+this.pageSize - 1;
    }*/

    public int getStartIndex() {
        this.startIndex = (this.currentPage-1)*this.pageSize;
        return startIndex;
    }
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    public int getEndIndex() {
        int end = this.getStartIndex() + this.getPageSize();
        if(end>this.getTotalRecord()){
            end = this.getStartIndex() + (this.getTotalRecord()%this.getPageSize());
        }
        this.endIndex = end;
        return this.endIndex;
    }
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
    public int getTotalRecord() {
        return totalRecord;
    }
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalPage() {             //�õ���ҳ����
        if(this.totalRecord%this.pageSize==0){
            this.totalPage = this.totalRecord/this.pageSize;
        }else{
            this.totalPage = this.totalRecord/this.pageSize+1;
        }

        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPreviousPage() {
        if(this.currentPage-1<1){      //�����һҳС��1����˵����ǰҳ���Ѿ��ǵ�һҳ��
            this.previousPage = 1;
        }else{
            this.previousPage = this.currentPage-1;
        }
        return previousPage;
    }

    public int getNextPage() {
        if(this.currentPage+1>=this.totalPage){   //�����һҳ��������ҳ����˵����ǰҳ���Ѿ������һҳ��
            this.nextPage = this.totalPage;
        }else{
            this.nextPage = this.currentPage +1;
        }
        return nextPage;
    }

    public int[] getPageBar() {
        int startPage;      //��סҳ�����ʼλ��
        int endPage;        //��סҳ��Ľ���λ�ã���Ϊҳ����Ŀ�Ǽȶ��ģ���startpage��endpage��������ͨ��ѭ���Ϳ��Ե�ȫ��ҳ��
        int pageBar[] = null;
        if(this.getTotalPage() <= PAGEITEMCOUNT){    //����ҳ�벻�����ڼȶ�ҳ���Сʱ
            pageBar = new int[this.totalPage];
            startPage = 1;
            endPage = this.totalPage;
        }else{                  //����ҳ����ڼȶ�ҳ���Сʱ
            pageBar = new int[PAGEITEMCOUNT];
            startPage = this.currentPage - (PAGEITEMCOUNT/2-1);    //Ϊ�˱�֤��ǰҳ���м�
            endPage = this.currentPage + PAGEITEMCOUNT/2;

            if(startPage<1){
                startPage = 1;
                endPage = PAGEITEMCOUNT;
            }

            if(endPage>this.totalPage){
                endPage = this.totalPage;
                startPage = this.totalPage - (PAGEITEMCOUNT-1);
            }
        }

        int index = 0;
        for(int i=startPage;i<=endPage;i++){
            pageBar[index++] = i;
        }

        this.pageBar = pageBar;
        return this.pageBar;
    }
}
