package ru.synergy.hiltretrofitjavagitsearch.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import ru.synergy.hiltretrofitjavagitsearch.models.RecyclerData;
import ru.synergy.hiltretrofitjavagitsearch.network.RetroRepository;
import ru.synergy.hiltretrofitjavagitsearch.network.RetroServiceInterface;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {
    MutableLiveData<List<RecyclerData>> liveData;

    @Inject
    RetroServiceInterface retroServiceInterface;
    @Inject
    public MainActivityViewModel() {
        this.liveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<RecyclerData>> getLiveData() {
        return liveData;
    }

    public void makeAPICall(){
        RetroRepository retroRepository = new RetroRepository(retroServiceInterface);
        retroRepository.makeAPICall("hilt", liveData);

    }

}

