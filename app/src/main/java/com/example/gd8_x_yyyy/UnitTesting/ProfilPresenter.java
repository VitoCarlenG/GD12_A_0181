package com.example.gd8_x_yyyy.UnitTesting;

    //    TODO 9: double click ProfilPresenter -> klik kanan, show context actions, create test,
    //     JUnit4, pilih setup/@Before , dan pilih lokasi 2 (lokasi 1 untuk instrumented test)

    //    TODO 10: nanti akan terbuat kelas ProfilPresenterTest.

//TODO 11: [TODO INI PINDAHKAN KE KELAS ProfilPresenterTest];
// Jangan lupa perhatikan diatas public clas blabla ada tambahan code, code deklarasi, dan di void SetUp(),
// Kemudian pindahkan code selanjutnya untuk melakukan pengujian

//TODO 12: [TODO INI PINDAHKAN KE KELAS ProfilPresenterTest];
// Kalian boleh coba pengujian secara menyeluruh dengan pilih icon play di public class ProfilPresenterTest
// Atau uji salah satu prosedur (lihat contohnya di modul)

import com.example.gd8_x_yyyy.models.Profil;

public class ProfilPresenter {
    //    TODO 8: silahkan salin code ProfilPresenter

    private ProfilView view;
    private ProfilService service;
    private ProfilCallback callback;
    private Profil profil;
    public ProfilPresenter(ProfilView view, ProfilService service) {
        this.view = view;
        this.service = service;
    }
    public void onProfilClicked() {
        String regex = "[1-9]+";
        String regex1 = "[a-zA-Z]";
// Sumber pattern:
        https://developer.android.com/reference/java/util/regex/Pattern
        if (view.getFirstName().isEmpty()) {
            view.showFirstNameError("Nama Depan tidak boleh kosong");
            return;
        } else if (view.getLastName().isEmpty()) {
            view.showLastNameError("Nama Belakang tidak boleh kosong");
            return;
        } else if(view.getSemester().isEmpty()){
            view.showSemesterError("Semester tidak boleh kosong");
            return;
        } else if(!(view.getSemester().matches(regex))){
            view.showSemesterError("Format Semester harus berupa angka 1 sampai 9");
            return;
        } else if(view.getTanggalLahir().isEmpty()){
            view.showTanggalLahirError("Tanggal Lahir tidak boleh kosong");
            return;
        } else if(view.getTanggalLahir().length() < 6){
            view.showTanggalLahirError("Tanggal Lahir tidak boleh kurang dari 6 digit");
            return;
        } else if(view.getTanggalLahir().length() > 6){
            view.showTanggalLahirError("Tanggal Lahir tidak boleh lebih dari 6 digit");
            return;
        } else {
            service.profil(view, profil, new ProfilCallback() {
                @Override
                public void onSuccess(boolean value, Profil profil)
                {
                    view.startMainProfil();
                }
                @Override
                public void onError() {

                }
            });
            return;
        }
    }
}