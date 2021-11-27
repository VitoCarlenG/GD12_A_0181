package com.example.gd8_x_yyyy;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gd8_x_yyyy.UnitTesting.ActiviyUtil;
import com.example.gd8_x_yyyy.UnitTesting.ProfilPresenter;
import com.example.gd8_x_yyyy.UnitTesting.ProfilService;
import com.example.gd8_x_yyyy.UnitTesting.ProfilView;
import com.example.gd8_x_yyyy.api.ApiClient;
import com.example.gd8_x_yyyy.api.ApiInterface;
import com.example.gd8_x_yyyy.models.Profil;
import com.example.gd8_x_yyyy.models.ProfilResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//    TODO 13: SELESAIKAN TODO 1-12 DULU; Ini sudah masuk ke instrumented test,
//     Double click ProfileActivity, klik kanan dan pilih More run/debug, lalu pilih Modify Run Config,
//     setelah itu klik oke dan pilih Run --> Record Espresso Test, nanti save namanya itu saja gapapa / bebas edit namanya yang penting jelas

//NOTE: Instrumented test harus menggunakan hp/emulator. silahkan baca kembali detail Preparation nomor 5
//      dan penjelasan di note nomor 2

// TODO 14: [TODO INI PINDAHKAN KE KELAS Instrumented test yang telah dibuat];
//  Silahkan hapus code pressback() karena telah ada fungsi closeSoftKeyboard() / Detail penjelasan di modul

// TODO 15: [TODO INI PINDAHKAN KE KELAS Instrumented test yang telah dibuat];
//  Done, silahkan jalankan dengan klik icon play di public class ... Kalau error, silahkan akses modul (penjelasan detail)

//    TODO 7.1: silahkan tambah implements ProfilView
public class ProfilActivity extends AppCompatActivity implements ProfilView {

    private ApiInterface apiService;
    private EditText etFirstName, etLastName, etSemester, etTanggalLahir;
    //    TODO 7.2: silahkan declare disini
    private ProfilPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        etFirstName= findViewById(R.id.etFirstName);
        etLastName= findViewById(R.id.etLastName);
        etSemester= findViewById(R.id.etSemester);
        etTanggalLahir= findViewById(R.id.etTanggalLahir);

        Button btnSave = findViewById(R.id.btn_save);
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(R.string.tambah_data);

        //TODO 7.3 : Tambahkan potongan code disini
        presenter = new ProfilPresenter(this, new ProfilService());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createProfil();
            }
        });

    }

    private void createProfil() {

        Profil profil = new Profil(
                etFirstName.getText().toString(),
                etLastName.getText().toString(),
                etTanggalLahir.getText().toString(),
                etSemester.getText().toString());

        Call<ProfilResponse> call = apiService.createProfil(profil);
        call.enqueue(new Callback<ProfilResponse>() {
            @Override
            public void onResponse(Call<ProfilResponse> call, Response<ProfilResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ProfilActivity.this, response.body().getMessage(), LENGTH_SHORT).show();

                    Intent returnIntent = new Intent();
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(ProfilActivity.this, jObjError.getString("message"), LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(ProfilActivity.this, e.getMessage(), LENGTH_SHORT).show();
                    }
                }

                //    TODO 7.4: silahkan panggil presenternya disini
//                presenter.onProfilClicked();

            }

            @Override
            public void onFailure(Call<ProfilResponse> call, Throwable t) {
                Toast.makeText(ProfilActivity.this,
                        t.getMessage(), LENGTH_SHORT).show();
            }
        });
    }

    //    TODO 7.5: silahkan tambahkan atribut baru disini

    @Override
    public String getFirstName() {
        return etFirstName.getText().toString();
    }
    @Override
    public void showFirstNameError(String message) {
        etFirstName.setError(message);
    }
    @Override
    public String getLastName() {
        return etLastName.getText().toString();
    }
    @Override
    public void showLastNameError(String message) {
        etLastName.setError(message);
    }
    @Override
    public String getTanggalLahir() {
        return etTanggalLahir.getText().toString();
    }
    @Override
    public void showTanggalLahirError(String message) {
        etTanggalLahir.setError(message);
    }
    @Override
    public String getSemester() {
        return etSemester.getText().toString();
    }
    @Override
    public void showSemesterError(String message) {
        etSemester.setError(message);
    }
    @Override
    public void startMainProfil() {
        new ActiviyUtil(this).startMainProfil();
    }
    @Override
    public void showProfilError(String message) {
        Toast.makeText(this, message, LENGTH_SHORT).show(); }
    @Override
    public void showErrorResponse(String message) {
        Toast.makeText(this, message, LENGTH_SHORT).show();
    }
}