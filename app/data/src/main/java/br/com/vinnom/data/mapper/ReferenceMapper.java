package br.com.vinnom.data.mapper;

import br.com.vinnom.data.model.ReferenceData;
import br.com.vinnom.domain.model.ReferenceDomain;

public class ReferenceMapper {

    public ReferenceDomain fromReferenceDataToDomain(ReferenceData data) {
        return new ReferenceDomain(data.getAnime(), data.getCharacter(), data.getQuote());
    }
}
