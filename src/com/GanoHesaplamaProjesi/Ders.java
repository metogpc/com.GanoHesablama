package com.GanoHesaplamaProjesi;

public class Ders {
    private String ad;
    private String harf;
    private int ects;

    public Ders(String ad, String harf, int ects) {
        this.ad = ad;
        this.harf = harf;
        this.ects = ects;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getHarf() {
        return harf;
    }

    public void setHarf(String harf) {
        this.harf = harf;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    @Override
    public String toString() {
        return getAd();
    }
}
