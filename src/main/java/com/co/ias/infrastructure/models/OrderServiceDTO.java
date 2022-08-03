package com.co.ias.infrastructure.models;


import com.co.ias.application.domain.OrderService;
import com.co.ias.application.domain.valueObjs.ServiceEndDate;
import com.co.ias.application.domain.valueObjs.ServiceId;
import com.co.ias.application.domain.valueObjs.ServiceStartDate;
import com.co.ias.application.domain.valueObjs.TechnicalId;

import java.time.LocalDateTime;

public class OrderServiceDTO {

    private String technicalId;

    private String serviceId;

    private LocalDateTime serviceStartDate;

    private LocalDateTime serviceEndDate;

    public OrderServiceDTO(String technicalId, String serviceId, LocalDateTime serviceStartDate, LocalDateTime serviceEndDate) {
        this.technicalId = technicalId;
        this.serviceId = serviceId;
        this.serviceStartDate = serviceStartDate;
        this.serviceEndDate = serviceEndDate;
    }

    public OrderServiceDTO() {
    }

    public OrderService toDomain(){
        return new OrderService(
                new TechnicalId(technicalId),
                new ServiceId(serviceId),
                new ServiceStartDate(serviceStartDate),
                new ServiceEndDate(serviceEndDate));
    }

    public static OrderServiceDTO fromDomain(OrderService orderService){
        OrderServiceDTO orderServiceDTO = new OrderServiceDTO();

        orderServiceDTO.setTechnicalId(orderService.getTechnicalId().getId());
        orderServiceDTO.setServiceId(orderService.getServiceId().getId());
        orderServiceDTO.setServiceStartDate(orderService.getServiceStartDate().getDate());
        orderServiceDTO.setServiceEndDate(orderService.getServiceEndDate().getDate());

        return orderServiceDTO;

    }

    public String getTechnicalId() {
        return technicalId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public LocalDateTime getServiceStartDate() {
        return serviceStartDate;
    }

    public LocalDateTime getServiceEndDate() {
        return serviceEndDate;
    }

    public void setTechnicalId(String technicalId) {
        this.technicalId = technicalId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setServiceStartDate(LocalDateTime serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public void setServiceEndDate(LocalDateTime serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    @Override
    public String toString() {
        return "OrderServiceDTO{" +
                "technicalId='" + technicalId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", serviceStartDate=" + serviceStartDate +
                ", serviceEndDate=" + serviceEndDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderServiceDTO that = (OrderServiceDTO) o;

        if (technicalId != null ? !technicalId.equals(that.technicalId) : that.technicalId != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (serviceStartDate != null ? !serviceStartDate.equals(that.serviceStartDate) : that.serviceStartDate != null)
            return false;
        return serviceEndDate != null ? serviceEndDate.equals(that.serviceEndDate) : that.serviceEndDate == null;
    }

}
