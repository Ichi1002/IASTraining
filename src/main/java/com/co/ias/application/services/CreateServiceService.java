package com.co.ias.application.services;

import com.co.ias.application.ports.input.CreateServiceUseCase;
import com.co.ias.application.ports.output.OrderServiceRepository;

import com.co.ias.infrastructure.models.OrderServiceDAO;
import com.co.ias.infrastructure.models.OrderServiceDTO;

import org.springframework.stereotype.Service;

@Service
public class CreateServiceService implements CreateServiceUseCase {

    private final OrderServiceRepository orderServiceRepository;

    public CreateServiceService (OrderServiceRepository orderServiceRepository) {
        this.orderServiceRepository = orderServiceRepository;
    }

    @Override
    public OrderServiceDTO execute(OrderServiceDTO orderServiceDTO) {

            if (orderServiceDTO.getServiceStartDate().isBefore(orderServiceDTO.getServiceEndDate())) {
                orderServiceRepository.store(orderServiceDTO);
                return orderServiceDTO;
            }else
                return new OrderServiceDTO();
    }
}


