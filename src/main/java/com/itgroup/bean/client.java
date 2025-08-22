package com.itgroup.bean;

public class client {
    private String cid;
    private String cname;
    private String cpassword;
    private String cby;
    private int total;
    private String membership;
    private String basket;

    public client() {
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCby() {
        return cby;
    }

    public void setCby(String cby) {
        this.cby = cby;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getBasket() {
        return basket;
    }

    public void setBasket(String basket) {
        this.basket = basket;
    }

    public client(String cid, String cname, String cpassword, String cby, int total, String membership, String basket) {
        this.cid = cid;
        this.cname = cname;
        this.cpassword = cpassword;
        this.cby = cby;
        this.total = total;
        this.membership = membership;
        this.basket = basket;
    }
}
