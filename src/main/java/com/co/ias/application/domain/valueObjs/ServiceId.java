package com.co.ias.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ServiceId {

    private final String id;

    public ServiceId(String id) {
        Validate.notNull(id,"Service id can not be null");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ServiceId{" +
                "id='" + id + '\'' +
                '}';
    }
}
