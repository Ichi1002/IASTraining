package com.co.ias.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import java.util.Date;

public class ServiceStartDate {

    Date date;

    public ServiceStartDate(Date date) {
        Validate.notNull(date,"Starting date can not be null");
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ServiceStartDate{" +
                "date=" + date +
                '}';
    }
}
