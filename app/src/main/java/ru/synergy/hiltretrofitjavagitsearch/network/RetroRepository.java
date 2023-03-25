package ru.synergy.hiltretrofitjavagitsearch.network;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.synergy.hiltretrofitjavagitsearch.models.RecyclerData;
import ru.synergy.hiltretrofitjavagitsearch.models.RecyclerList;

public class RetroRepository {

    private RetroServiceInterface retroServiceInterface;

    public RetroRepository(RetroServiceInterface retroServiceInterface) {
        this.retroServiceInterface = retroServiceInterface;
    }
    public void makeAPICall(String query, MutableLiveData<List<RecyclerData>> liveData){
        Call<RecyclerList> call = retroServiceInterface.getDataFromGithubApi(query);
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                // отправить данные в экран
                if (response.isSuccessful()){
                    liveData.postValue(response.body().getItems());
                } else {
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                // среагировать на ошибку
            liveData.postValue(null);
            }

        });
    }
}
