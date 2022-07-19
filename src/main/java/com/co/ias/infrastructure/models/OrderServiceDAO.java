package com.co.ias.infrastructure.models;

import com.co.ias.application.domain.OrderService;
import com.co.ias.application.domain.valueObjs.ServiceEndDate;
import com.co.ias.application.domain.valueObjs.ServiceId;
import com.co.ias.application.domain.valueObjs.ServiceStartDate;
import com.co.ias.application.domain.valueObjs.TechnicalId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Document(collation = "OrderServices")
public class OrderServiceDAO {

    @Id
    private String id;

    private String technicalId;

    private String serviceId;

    private Date serviceStartDate;

    private Date serviceEndDate;

    public OrderServiceDAO(String technicalId, String serviceId, Date serviceStartDate, Date serviceEndDate) {
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
}
