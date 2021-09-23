package com.alin.titi.model.articalpic;

import java.util.List;

public class BannerAllResponse {
    private Integer totalCount;
    private List<BannerResponse> bannerResponseList;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    public List<BannerResponse> getBannerResponseList() {
        return bannerResponseList;
    }

    public void setBannerResponseList(List<BannerResponse> bannerResponseList) {
        this.bannerResponseList = bannerResponseList;
    }
}
