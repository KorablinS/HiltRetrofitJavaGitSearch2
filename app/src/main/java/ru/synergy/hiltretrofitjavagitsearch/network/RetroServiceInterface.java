package ru.synergy.hiltretrofitjavagitsearch.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.synergy.hiltretrofitjavagitsearch.models.RecyclerList;

public interface RetroServiceInterface {
    @GET("repositories")
    Call<RecyclerList> getDataFromGithubApi(@Query("q") String query);

}
