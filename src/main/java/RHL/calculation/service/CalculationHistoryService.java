package RHL.calculation.service;

import RHL.calculation.dto.request.CalculationHistoryRequest;
import RHL.calculation.dto.response.CalculationHistoryResponse;

public interface CalculationHistoryService {
    CalculationHistoryResponse calculationHistory(CalculationHistoryRequest calculationHistoryRequest);
}
