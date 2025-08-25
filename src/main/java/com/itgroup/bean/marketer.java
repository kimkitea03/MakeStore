package com.itgroup.bean;

public class marketer {
    private String mid;
    private String mname;
    private String mpassword;
    private String sell;
    private int mvolume;

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

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public int getMvolume() {
        return mvolume;
    }

    public void setMvolume(int mvolume) {
        this.mvolume = mvolume;
    }

    public marketer(String mid, String mname, String mpassword, String sell, int mvolume) {
        this.mid = mid;
        this.mname = mname;
        this.mpassword = mpassword;
        this.sell = sell;
        this.mvolume = mvolume;
    }
}
