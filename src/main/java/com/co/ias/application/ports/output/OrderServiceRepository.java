package com.co.ias.application.ports.output;

import com.co.ias.application.domain.OrderService;
import com.co.ias.application.domain.valueObjs.TechnicalId;

import java.util.List;

public interface OrderServiceRepository {

    OrderService store(OrderService orderService);

    List<OrderService> get(TechnicalId technicalId, Integer weekNumber);
}
