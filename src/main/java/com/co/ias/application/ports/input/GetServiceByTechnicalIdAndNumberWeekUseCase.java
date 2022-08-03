package com.co.ias.application.ports.input;

import com.co.ias.application.domain.OrderService;
import com.co.ias.commons.UseCase;
import com.co.ias.infrastructure.models.OrderServiceDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GetServiceByTechnicalIdAndNumberWeekUseCase extends UseCase<List<String>, Map<String,Double>> {
}
