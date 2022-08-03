package com.co.ias.infrastructure.models;

import com.co.ias.application.domain.OrderService;
import com.co.ias.application.domain.valueObjs.ServiceEndDate;
import com.co.ias.application.domain.valueObjs.ServiceId;
import com.co.ias.application.domain.valueObjs.ServiceStartDate;
import com.co.ias.application.domain.valueObjs.TechnicalId;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "OrderServices")
public class OrderServiceDAO{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String technicalId;

    private String serviceId;

    private LocalDateTime serviceStartDate;

    private LocalDateTime serviceEndDate;

    public OrderServiceDAO(String technicalId, String serviceId, LocalDateTime serviceStartDate, LocalDateTime serviceEndDate) {
        this.technicalId = technicalId;
        this.serviceId = serviceId;
        this.serviceStartDate = serviceStartDate;
        this.serviceEndDate = serviceEndDate;
    }

    public OrderServiceDAO() {
    }

    public OrderService toDomain(){
        return new OrderService(
                new TechnicalId(technicalId),
                new ServiceId(serviceId),
                new ServiceStartDate(serviceStartDate),
                new ServiceEndDate(serviceEndDate)
        );
    }

    public static OrderServiceDAO fromDomain(OrderService orderService){
        OrderServiceDAO orderServiceDAO = new OrderServiceDAO();

        orderServiceDAO.setTechnicalId(orderService.getTechnicalId().getId());
        orderServiceDAO.setServiceId(orderService.getServiceId().getId());
        orderServiceDAO.setServiceStartDate(orderService.getServiceStartDate().getDate());
        orderServiceDAO.setServiceEndDate(orderService.getServiceEndDate().getDate());

        return orderServiceDAO;
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

    }