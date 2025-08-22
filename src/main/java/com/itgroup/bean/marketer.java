package com.itgroup.bean;

public class marketer {
    private String mid;
    private String mname;
    private String mpassword;
    private int sell;
    private String mvolume;

    public marketer() {
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public String getMvolume() {
        return mvolume;
    }

    public void setMvolume(String mvolume) {
        this.mvolume = mvolume;
    }

    public marketer(String mid, String mname, String mpassword, int sell, String mvolume) {
        this.mid = mid;
        this.mname = mname;
        this.mpassword = mpassword;
        this.sell = sell;
        this.mvolume = mvolume;
    }
}
