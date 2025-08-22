package com.itgroup.bean;

public class market {
    private int nom;
    private String post;
    private int price;
    private String kind;
    private String seller;
    private int onoff;


    public market() {
    }

    public market(int nom, String post, int price, String kind, String seller, int onoff) {
        this.nom = nom;
        this.post = post;
        this.price = price;
        this.kind = kind;
        this.seller = seller;
        this.onoff = onoff;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getOnoff() {
        return onoff;
    }

    public void setOnoff(int onoff) {
        this.onoff = onoff;
    }
}
