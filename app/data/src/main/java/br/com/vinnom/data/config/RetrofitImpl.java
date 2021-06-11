package br.com.vinnom.data.config;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

import androidx.annotation.NonNull;

import br.com.vinnom.data.BuildConfig;
import br.com.vinnom.data.service.ReferenceDataService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitImpl {

    private static final String URL_BASE = BuildConfig.URL_BASE;
    private final Retrofit retrofit;

    public RetrofitImpl() {
        OkHttpClient client = configuraHttpClient();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @NonNull
    private OkHttpClient configuraHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BODY);
        return new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build();
    }

    public ReferenceDataService getReferenceDataService() {
        return retrofit.create(ReferenceDataService.class);
    }
}
