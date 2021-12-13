package br.com.vinnom.display.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;

import br.com.vinnom.data.repository.ReferenceDomainRepositoryImpl;
import br.com.vinnom.domain.model.ReferenceDomain;

public class RandomQuoteViewModel extends ViewModel {

    private final ReferenceDomainRepositoryImpl repository;

    public RandomQuoteViewModel(ReferenceDomainRepositoryImpl repository) {
        this.repository = repository;
    }

    public LiveData<ReferenceDomain> getReferenceRandom() {
        return repository.getDomainLiveData();
    }
}
