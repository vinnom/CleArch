package br.com.vinnom.display.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinnom.data.repository.ReferenceDomainRepositoryImpl;

public class RandomQuoteViewModelFactory implements ViewModelProvider.Factory {

    private final Class<RandomQuoteViewModel> viewModelClass;
    private final ReferenceDomainRepositoryImpl repository;

    public RandomQuoteViewModelFactory(Class<RandomQuoteViewModel> viewModelClass, ReferenceDomainRepositoryImpl repository) {
        this.viewModelClass = viewModelClass;
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        List<ViewModel> viewModels = new ArrayList<>();
        try {
            ViewModel viewModel = viewModelClass
                    .getConstructor(ReferenceDomainRepositoryImpl.class).newInstance(repository);
            viewModels.add(viewModel);
        } catch (IllegalAccessException | InstantiationException
                | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return (T) viewModels.get(0);
    }
}
