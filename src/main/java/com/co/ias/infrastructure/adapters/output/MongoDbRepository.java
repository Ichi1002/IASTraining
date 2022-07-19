package com.co.ias.infrastructure.adapters.output;

import com.co.ias.application.domain.OrderService;
import com.co.ias.application.domain.valueObjs.TechnicalId;
import com.co.ias.application.ports.output.OrderServiceRepository;

import java.util.List;

public class MongoDbRepository implements OrderServiceRepository {
    @Override
    public OrderService store(OrderService orderService) {
        return null;
    }

    @Override
    public List<OrderService> get(TechnicalId technicalId, Integer weekNumber) {
        return null;
    }
}
