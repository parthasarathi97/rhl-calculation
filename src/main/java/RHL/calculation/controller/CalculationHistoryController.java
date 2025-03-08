package RHL.calculation.controller;

import RHL.calculation.dto.request.CalculationHistoryRequest;
import RHL.calculation.dto.response.CalculationHistoryResponse;
import RHL.calculation.service.CalculationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation")
public class CalculationHistoryController {
    @Autowired
    CalculationHistoryService calculationHistoryService;

    @PostMapping("/calculation/history")
    public CalculationHistoryResponse calculationHistory(@RequestBody CalculationHistoryRequest request) {
        CalculationHistoryResponse response = new CalculationHistoryResponse();
        try {
            response = calculationHistoryService.calculationHistory(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
