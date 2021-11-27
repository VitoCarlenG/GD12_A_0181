package com.example.gd8_x_yyyy.UnitTesting;

public interface ProfilView {

    //    TODO 5: silahkan salin code ProfilView

    String getFirstName();
    void showFirstNameError(String message);
    String getLastName();
    void showLastNameError(String message);
    String getTanggalLahir();
    void showTanggalLahirError(String message);
    String getSemester();
    void showSemesterError(String message);
    void startMainProfil();
    void showProfilError(String message);
    void showErrorResponse(String message);
}
