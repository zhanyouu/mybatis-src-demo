package org.apache.ibatis.test.page;

import lombok.Data;

@Data
public class Page {
  private Integer total;
  private Integer pageSize;
  private Integer pageNo;

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  private int getOffset() {
    return pageSize * (pageNo - 1);
  }
}
