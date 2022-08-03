package com.co.ias.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;
import java.time.LocalDateTime;


public class ServiceStartDate {

    LocalDateTime date;
     ServiceEndDate serviceEndDate;
    public ServiceStartDate(LocalDateTime date) {
        Validate.notNull(date,"Date can not be null");
        //if(date.isBefore(serviceEndDate.getDate()))
            this.date = date;
        //else
            //throw new IllegalArgumentException("Fecha de Inicio debe ser menor a la fecha final");
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ServiceStartDate{" +
                "date=" + date +
                '}';
    }
}
