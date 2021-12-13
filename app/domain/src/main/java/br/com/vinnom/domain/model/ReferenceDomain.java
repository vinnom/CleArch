package br.com.vinnom.domain.model;

public class ReferenceDomain {

    private final String anime;
    private final String character;
    private final String quote;
    public ReferenceDomain(String anime, String character, String quote) {
        this.anime = anime;
        this.character = character;
        this.quote = quote;
    }

    public String getAnime() {
        return anime;
    }

    public String getCharacter() {
        return character;
    }

    public String getQuote() {
        return quote;
    }

}