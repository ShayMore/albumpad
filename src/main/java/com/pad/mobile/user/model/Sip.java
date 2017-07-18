package com.pad.mobile.user.model;

/**
 * @author myl
 * Created by Administrator on 2017/7/17 0017.
 */
public class Sip {
    private String nid;
    private String sipNo;
    private String sipPw;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getSipNo() {
        return sipNo;
    }

    public void setSipNo(String sipNo) {
        this.sipNo = sipNo;
    }

    public String getSipPw() {
        return sipPw;
    }

    public void setSipPw(String sipPw) {
        this.sipPw = sipPw;
    }

    @Override
    public String toString() {
        return "Sip{" +
                "nid='" + nid + '\'' +
                ", sipNo='" + sipNo + '\'' +
                ", sipPw='" + sipPw + '\'' +
                '}';
    }
}
