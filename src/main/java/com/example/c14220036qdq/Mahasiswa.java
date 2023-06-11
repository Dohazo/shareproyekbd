package com.example.c14220036qdq;

public class Mahasiswa {
    private String NRP;
    private String NAMA;
    private String EMAIL;

    public Mahasiswa(String NRP, String NAMA, String EMAIL) {
        this.NRP = NRP;
        this.NAMA = NAMA;
        this.EMAIL = EMAIL;
    }

    public String getNRP() {
        return NRP;
    }

    public void setNRP(String NRP) {
        this.NRP = NRP;
    }

    public String getNAMA() {
        return NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
