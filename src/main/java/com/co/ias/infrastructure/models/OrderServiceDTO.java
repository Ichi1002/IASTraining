package com.co.ias.infrastructure.models;


import com.co.ias.application.domain.OrderService;
import com.co.ias.application.domain.valueObjs.ServiceEndDate;
import com.co.ias.application.domain.valueObjs.ServiceId;
import com.co.ias.application.domain.valueObjs.ServiceStartDate;
import com.co.ias.application.domain.valueObjs.TechnicalId;

import java.util.Date;

public class OrderServiceDTO {

    private String technicalId;

    private String serviceId;

    private Date serviceStartDate;

    private Date serviceEndDate;

    public OrderServiceDTO(String technicalId, String serviceId, Date serviceStartDate, Date serviceEndDate) {
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

    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    public void setTechnicalId(String technicalId) {
        this.technicalId = technicalId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public void setServiceEndDate(Date serviceEndDate) {
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
}
