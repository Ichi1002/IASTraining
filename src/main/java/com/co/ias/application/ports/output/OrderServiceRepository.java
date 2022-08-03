package com.co.ias.application.ports.output;

import com.co.ias.infrastructure.models.OrderServiceDTO;


import java.util.List;

public interface OrderServiceRepository {

    OrderServiceDTO store(OrderServiceDTO orderService);

    List<OrderServiceDTO> get(String technicalId, String weekNumber);

    List<OrderServiceDTO> findAllBytechnicalId(String technicalId);

}
