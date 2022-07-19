package com.co.ias.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import java.util.Date;

public class ServiceEndDate {

    Date date;

    public ServiceEndDate(Date date) {
        Validate.notNull(date,"Ending date can not be null");
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ServiceEndDate{" +
                "date=" + date +
                '}';
    }
}

