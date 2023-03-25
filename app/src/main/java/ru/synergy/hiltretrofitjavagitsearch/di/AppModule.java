package ru.synergy.hiltretrofitjavagitsearch.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.synergy.hiltretrofitjavagitsearch.network.RetroServiceInterface;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    String baseURL = "https://api.github.com/search/"; //repositories?q=network


    @Singleton
    @Provides

    public RetroServiceInterface getRetroServiceInterface (Retrofit retrofit2){

        return retrofit2.create(RetroServiceInterface.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
