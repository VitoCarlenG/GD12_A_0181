package com.example.gd8_x_yyyy.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MahasiswaResponse {

    private String message;

    @SerializedName("mahasiswa")
    private List<Mahasiswa> mahasiswaList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }
}
