package br.com.vinnom.data;

import android.os.AsyncTask;

import br.com.vinnom.data.config.RetrofitImpl;
import br.com.vinnom.data.model.ReferenceData;
import br.com.vinnom.data.service.ReferenceDataService;

public class RandomReferenceAsyncTask extends AsyncTask<Void, Void, ReferenceData> {

    private ReferenceDataService service = new RetrofitImpl().getReferenceDataService();

    @Override
    protected ReferenceData doInBackground(Void... voids) {


        return null;
    }

}
