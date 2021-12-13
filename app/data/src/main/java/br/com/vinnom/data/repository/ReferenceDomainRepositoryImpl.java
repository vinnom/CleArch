package br.com.vinnom.data.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import br.com.vinnom.data.config.RetrofitImpl;
import br.com.vinnom.data.mapper.ReferenceMapper;
import br.com.vinnom.data.model.ReferenceData;
import br.com.vinnom.data.service.ReferenceDataService;
import br.com.vinnom.domain.model.ReferenceDomain;
import br.com.vinnom.domain.repository.ReferenceDomainRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReferenceDomainRepositoryImpl implements ReferenceDomainRepository {

    final private ReferenceDataService service = new RetrofitImpl().getReferenceDataService();
    private final MutableLiveData<ReferenceDomain> domainLiveData = new MutableLiveData<>();

    private void getReferenceDataRandom(RespositoryListener listener) {
        service.getReferenceDataRandom().enqueue(new Callback<ReferenceData>() {
            @Override
            public void onResponse(@NonNull Call<ReferenceData> call, @NonNull Response<ReferenceData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ReferenceData> call, @NonNull Throwable t) {
                Log.d("ReferenceDomainRepository", "onFailure: " + t.getMessage());
            }
        });
    }

    public LiveData<ReferenceDomain> getDomainLiveData() {
        this.getReferenceRandom();
        return domainLiveData;
    }

    @Override
    public void getReferenceRandom() {
        this.getReferenceDataRandom(data ->
                domainLiveData.setValue(new ReferenceMapper().fromReferenceDataToDomain(data)));
    }

    interface RespositoryListener {
        void onSuccess(ReferenceData data);
    }
}