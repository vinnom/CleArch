package br.com.vinnom.data.service;

import br.com.vinnom.data.model.ReferenceData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ReferenceDataService {

    @GET("/random")
    Call<ReferenceData> getReferenceDataRandom();
}
