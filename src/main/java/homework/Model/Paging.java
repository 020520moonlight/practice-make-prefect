package homework.Model;

import java.io.Serializable;
import java.util.List;

public class Paging<D> implements Serializable {
    private static final long serialVersionUID = 233465456865L;

    private int pageSize;
    private int pageNum;
    private long totalCount;
    private int totalPageNum;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public List<D> getData() {
        return data;
    }

    public void setData(List<D> data) {
        this.data = data;
    }

    private List<D> data;

    public Paging(int pageSize, int pageNum, long totalCount, int totalPageNum, List<D> data) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalCount = totalCount;
        this.totalPageNum = totalPageNum;
        this.data = data;
    }
}
