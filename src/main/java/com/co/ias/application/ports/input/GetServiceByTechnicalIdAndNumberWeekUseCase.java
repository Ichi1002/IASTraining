package com.co.ias.application.ports.input;

import com.co.ias.application.domain.OrderService;
import com.co.ias.commons.UseCase;
import com.co.ias.infrastructure.models.OrderServiceDTO;

import java.util.List;

public interface GetServiceByTechnicalIdAndNumberWeekUseCase extends UseCase<List<String>, List<OrderService>> {
}
