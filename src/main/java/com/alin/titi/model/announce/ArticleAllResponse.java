package com.alin.titi.model.announce;

import java.util.List;

public class ArticleAllResponse {

    private Integer pageTotalCount;
    private Long totalCount;
    private List<ArticleResponse> responses;

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }


    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<ArticleResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<ArticleResponse> responses) {
        this.responses = responses;
    }
}
