package com.example.gd8_x_yyyy.UnitTesting;

import com.example.gd8_x_yyyy.api.ApiClient;
import com.example.gd8_x_yyyy.api.ApiInterface;
import com.example.gd8_x_yyyy.models.Profil;
import com.example.gd8_x_yyyy.models.ProfilResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilService {

    //    TODO 6: silahkan salin code ProfilService
    public void profil(final ProfilView view, Profil profil, final ProfilCallback callback)
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ProfilResponse> profilDAOCall = apiService.createProfil(profil);
        profilDAOCall.enqueue(new Callback<ProfilResponse>() {
            @Override
            public void onResponse(Call<ProfilResponse> call, Response<ProfilResponse> response) {

                if(response.body().getMessage().equalsIgnoreCase("berhasil daftar")){
                    callback.onSuccess(true, response.body().getProfilList().get(0));
                }
                else{
                    callback.onError();
                    view.showProfilError(response.body().getMessage());
                }
            }
            @Override
            public void onFailure(Call<ProfilResponse> call, Throwable t) {
                view.showErrorResponse(t.getMessage());
                callback.onError();
            }
        });
    }

    public Boolean getValid(final ProfilView view, Profil profil) {
        final Boolean[] bool = new Boolean[1];
        profil(view, profil, new ProfilCallback() {
            @Override
            public void onSuccess(boolean value, Profil profil) {
                bool[0] = true;
            }
            @Override
            public void onError() {
                bool[0] = false;
            }
        });
        return bool[0];
    }
}
