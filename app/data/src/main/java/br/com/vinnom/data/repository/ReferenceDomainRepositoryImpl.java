package br.com.vinnom.data.repository;

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

    private ReferenceDataService service = new RetrofitImpl().getReferenceDataService();

    @Override
    public ReferenceDomain getReferenceRandom() {
        final ReferenceData[] data = {null};

        service.getReferenceDataRandom().enqueue(new Callback<ReferenceData>() {
            @Override
            public void onResponse(Call<ReferenceData> call, Response<ReferenceData> response) {
                if (response.isSuccessful()){
                    data[0] = response.body();
                }
            }

            @Override
            public void onFailure(Call<ReferenceData> call, Throwable t) {

            }
        });

        return new ReferenceMapper().fromReferenceDataToDomain(data[0]);
    }
}
