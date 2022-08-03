package com.co.ias.infrastructure.adapters.output;

import com.co.ias.application.domain.OrderService;
import com.co.ias.application.ports.output.OrderServiceRepository;
import com.co.ias.infrastructure.configurations.JPAOrderService;
import com.co.ias.infrastructure.models.OrderServiceDAO;
import com.co.ias.infrastructure.models.OrderServiceDTO;


import java.util.List;
import java.util.stream.Collectors;


public class JPARepository implements OrderServiceRepository {

    final private JPAOrderService jpaOrderService;

    public JPARepository(JPAOrderService jpaOrderService) {
        this.jpaOrderService=jpaOrderService;
    }

    @Override
     public OrderServiceDTO store(OrderServiceDTO orderServiceDTO) {
       jpaOrderService.save(OrderServiceDAO.fromDomain( orderServiceDTO.toDomain()));
        return orderServiceDTO;
    }

    @Override
    public List<OrderServiceDTO> get(String technicalId, String weekNumber) {
        return null;
    }

    @Override
    public List<OrderServiceDTO> findAllBytechnicalId(String technicalId) {

        return  jpaOrderService.findAllByTechnicalId(technicalId).stream()
                .map(x-> OrderServiceDTO
                        .fromDomain(x
                                .toDomain()))
                .collect(Collectors.toList());
    }


}
