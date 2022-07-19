package com.co.ias.application.services;

import com.co.ias.application.domain.OrderService;
import com.co.ias.application.ports.input.GetServiceByTechnicalIdAndNumberWeekUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetServiceByTechnicalIdAndNumberWeekService implements GetServiceByTechnicalIdAndNumberWeekUseCase {

    @Override
    public List<OrderService> execute(List<String> strings) {
        return null;
    }
}
