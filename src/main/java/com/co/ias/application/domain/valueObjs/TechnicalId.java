package com.co.ias.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class TechnicalId {

    private final String id;

    public TechnicalId(String id) {
        Validate.notNull("Technical Id can not be null");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TechnicalId{" +
                "id='" + id + '\'' +
                '}';
    }
}
