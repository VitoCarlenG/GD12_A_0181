package com.example.gd8_x_yyyy.models;

public class Profil {

    private Long id;
    private String nama_depan;
    private String nama_belakang;
    private String tanggal_lahir;
    private String semester;

    public Profil(String nama_depan, String nama_belakang, String tanggal_lahir, String semester) {
        this.id = id;
        this.nama_depan = nama_depan;
        this.nama_belakang = nama_belakang;
        this.tanggal_lahir = tanggal_lahir;
        this.semester = semester;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNama_depan() { return nama_depan; }
    public void setNama_depan(String nama_depan) { this.nama_depan = nama_depan; }

    public String getNama_belakang() { return nama_belakang; }
    public void setNama_belakang(String nama_belakang) { this.nama_belakang = nama_belakang; }

    public String getTanggal_lahir() { return tanggal_lahir; }
    public void setTanggal_lahir(String tanggal_lahir) { this.tanggal_lahir = tanggal_lahir; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

}
