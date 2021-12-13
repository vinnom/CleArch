package br.com.vinnom.display.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.io.IOException;

import br.com.vinnom.data.repository.ReferenceDomainRepositoryImpl;
import br.com.vinnom.display.R;
import br.com.vinnom.display.viewmodel.RandomQuoteViewModel;
import br.com.vinnom.display.viewmodel.RandomQuoteViewModelFactory;

public class RandomQuoteActivity extends AppCompatActivity {

    private final ReferenceDomainRepositoryImpl repository = new ReferenceDomainRepositoryImpl();
    private final RandomQuoteViewModelFactory factory =
            new RandomQuoteViewModelFactory(RandomQuoteViewModel.class, repository);
    private MaterialButton buttonGetRandomQuote;
    private MaterialTextView animeTextView;
    private MaterialTextView characterTextView;
    private MaterialTextView quoteTextView;
    private RandomQuoteViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_quote);
        viewModel = new ViewModelProvider(this, factory).get(RandomQuoteViewModel.class);
        this.initView();
    }

    @Override
    protected void onResume() {
        super.onResume();

        buttonGetRandomQuote.setOnClickListener(v -> {
            if (animeTextView.getText().length() != 0
                    || characterTextView.getText().length() != 0
                    || quoteTextView.getText().length() != 0) {
                animeTextView.setText(null);
                characterTextView.setText(null);
                quoteTextView.setText(null);
            }


            viewModel.getReferenceRandom().observe(this, referenceDomain -> {
                if (referenceDomain != null){
                    animeTextView.setText(referenceDomain.getAnime());
                    characterTextView.setText(referenceDomain.getCharacter());
                    quoteTextView.setText(referenceDomain.getQuote());
                }
            });
        });
    }


    private void initView() {
        buttonGetRandomQuote = findViewById(R.id.randomQuote_getRandomQuote_buttom);
        animeTextView = findViewById(R.id.randomQuote_animeTextView_text);
        characterTextView = findViewById(R.id.randomQuote_characterTextView_text);
        quoteTextView = findViewById(R.id.randomQuote_quoteTextView_text);
    }
}