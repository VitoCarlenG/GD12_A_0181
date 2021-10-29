package com.example.gd8_x_yyyy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gd8_x_yyyy.api.ApiClient;
import com.example.gd8_x_yyyy.api.ApiInterface;
import com.example.gd8_x_yyyy.models.Mahasiswa;
import com.example.gd8_x_yyyy.models.MahasiswaResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditActivity extends AppCompatActivity {

    private static final String[] FAKULTAS_LIST = new String[]{"FTI", "FT", "FTB", "FBE", "FISIP", "FH"};
    private static final String[] PRODI_LIST = new String[]{"Informatika", "Arsitektur", "Biologi", "Manajemen", "Ilmu Komunikasi", "Ilmu Hukum"};
    private static final String[] JENIS_KELAMIN_LIST = new String[]{"Laki-laki", "Perempuan"};

    private ApiInterface apiService;
    private EditText etName, etNpm;
    private AutoCompleteTextView edFakultas, edProdi, edJenisKelamin;
    private LinearLayout layoutLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        etName = findViewById(R.id.et_nama);
        etNpm = findViewById(R.id.et_npm);
        edFakultas = findViewById(R.id.ed_fakultas);
        edProdi = findViewById(R.id.ed_prodi);
        edJenisKelamin = findViewById(R.id.ed_jenis_kelamin);
        layoutLoading = findViewById(R.id.layout_loading);

        ArrayAdapter<String> adapterFakultas =
                new ArrayAdapter<>(this, R.layout.item_list, FAKULTAS_LIST);
        edFakultas.setAdapter(adapterFakultas);

        ArrayAdapter<String> adapterProdi =
                new ArrayAdapter<>(this, R.layout.item_list, PRODI_LIST);
        edProdi.setAdapter(adapterProdi);

        ArrayAdapter<String> adapterJenisKelamin =
                new ArrayAdapter<>(this, R.layout.item_list, JENIS_KELAMIN_LIST);
        edJenisKelamin.setAdapter(adapterJenisKelamin);

        Button btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnSave = findViewById(R.id.btn_save);
        TextView tvTitle = findViewById(R.id.tv_title);
        long id = getIntent().getLongExtra("id", -1);

        if (id == -1) {
            tvTitle.setText(R.string.tambah_mahasiswa);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    createMahasiswa();
                }
            });
        } else {
            tvTitle.setText(R.string.edit_mahasiswa);
            getMahasiswaById(id);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateMahasiswa(id);
                }
            });
        }
    }

    private void getMahasiswaById(long id) {
        setLoading(true);
        Call<MahasiswaResponse> call = apiService.getMahasiswaById(id);

        call.enqueue(new Callback<MahasiswaResponse>() {
            @Override
            public void onResponse(Call<MahasiswaResponse> call,
                                   Response<MahasiswaResponse> response) {
                if (response.isSuccessful()) {
                    Mahasiswa mahasiswa = response.body().getMahasiswaList().get(0);

                    etName.setText(mahasiswa.getNama());
                    etNpm.setText(mahasiswa.getNpm());
                    edFakultas.setText(mahasiswa.getFakultas(), false);
                    edProdi.setText(mahasiswa.getProdi(), false);
                    edJenisKelamin.setText(mahasiswa.getJenisKelamin(), false);
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(AddEditActivity.this,
                                jObjError.getString("message"), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(AddEditActivity.this,
                                e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                setLoading(false);
            }

            @Override
            public void onFailure(Call<MahasiswaResponse> call, Throwable t) {
                Toast.makeText(AddEditActivity.this,
                        "Network error", Toast.LENGTH_SHORT).show();
                setLoading(false);
            }
        });
    }

    private void createMahasiswa() {
        setLoading(true);

        Mahasiswa mahasiswa = new Mahasiswa(
                etName.getText().toString(),
                etNpm.getText().toString(),
                edJenisKelamin.getText().toString(),
                edFakultas.getText().toString(),
                edProdi.getText().toString());

        Call<MahasiswaResponse> call = apiService.createMahasiswa(mahasiswa);

        call.enqueue(new Callback<MahasiswaResponse>() {
            @Override
            public void onResponse(Call<MahasiswaResponse> call,
                                   Response<MahasiswaResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AddEditActivity.this,
                            response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    Intent returnIntent = new Intent();
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(AddEditActivity.this,
                                jObjError.getString("message"), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(AddEditActivity.this,
                                e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                setLoading(false);
            }

            @Override
            public void onFailure(Call<MahasiswaResponse> call, Throwable t) {
                Toast.makeText(AddEditActivity.this,
                        t.getMessage(), Toast.LENGTH_SHORT).show();
                setLoading(false);
            }
        });
    }

    private void updateMahasiswa(long id) {
        setLoading(true);

        Mahasiswa mahasiswa = new Mahasiswa(
                etName.getText().toString(),
                etNpm.getText().toString(),
                edJenisKelamin.getText().toString(),
                edFakultas.getText().toString(),
                edProdi.getText().toString());

        Call<MahasiswaResponse> call = apiService.updateMahasiswa(id, mahasiswa);

        call.enqueue(new Callback<MahasiswaResponse>() {
            @Override
            public void onResponse(Call<MahasiswaResponse> call,
                                   Response<MahasiswaResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AddEditActivity.this,
                            response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    Intent returnIntent = new Intent();
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(AddEditActivity.this,
                                jObjError.getString("message"), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(AddEditActivity.this,
                                e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                setLoading(false);
            }

            @Override
            public void onFailure(Call<MahasiswaResponse> call, Throwable t) {
                Toast.makeText(AddEditActivity.this,
                        t.getMessage(), Toast.LENGTH_SHORT).show();
                setLoading(false);
            }
        });
    }

    // Fungsi untuk menampilkan layout loading
    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.VISIBLE);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.INVISIBLE);
        }
    }
}