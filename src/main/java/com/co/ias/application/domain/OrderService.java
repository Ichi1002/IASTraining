package com.co.ias.application.domain;

import com.co.ias.application.domain.valueObjs.ServiceEndDate;
import com.co.ias.application.domain.valueObjs.ServiceId;
import com.co.ias.application.domain.valueObjs.ServiceStartDate;
import com.co.ias.application.domain.valueObjs.TechnicalId;

public class OrderService {

    private final TechnicalId technicalId;
    private final ServiceId serviceId;
    private final ServiceStartDate serviceStartDate;
    private final ServiceEndDate serviceEndDate;

    public OrderService(TechnicalId technicalId, ServiceId serviceId, ServiceStartDate serviceStartDate, ServiceEndDate serviceEndDate) {
        this.technicalId = technicalId;
        this.serviceId = serviceId;
        this.serviceStartDate = serviceStartDate;
        this.serviceEndDate = serviceEndDate;
    }

    public TechnicalId getTechnicalId() {
        return technicalId;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public ServiceStartDate getServiceStartDate() {
        return serviceStartDate;
    }

    public ServiceEndDate getServiceEndDate() {
        return serviceEndDate;
    }

    @Override
    public String toString() {
        return "Service{" +
                "technicalId=" + technicalId +
                ", serviceId=" + serviceId +
                ", serviceStartDate=" + serviceStartDate +
                ", serviceEndDate=" + serviceEndDate +
                '}';
    }
}
