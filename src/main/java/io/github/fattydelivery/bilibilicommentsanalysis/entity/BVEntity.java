package io.github.fattydelivery.bilibilicommentsanalysis.entity;

import io.github.fattydelivery.bilibilicommentsanalysis.utils.Bvid2Cid;

/**
 * @program:bilibili-comments-analysis
 * @description
 * @author: Jayce(Bingjie Yan)
 * @create: 2020-12-23-15:43
 **/

public class BVEntity {
    private String bvid, cid;

    public BVEntity(String bvid) {
        this.bvid = bvid;
        this.cid = Bvid2Cid.getcid(bvid);
    }

    public BVEntity(String bvid, String cid) {
        this.bvid = bvid;
        this.cid = cid;
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getBvid() {
        return bvid;
    }

    public void setBvid(String bvid) {
        this.bvid = bvid;
    }
}
