package com.co.ias.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class ServiceEndDate {

    LocalDateTime date;


    public ServiceEndDate(LocalDateTime date) {
        Validate.notNull(date,"Date can not be null");

        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ServiceEndDate{" +
                "date=" + date +
                '}';
    }
}
