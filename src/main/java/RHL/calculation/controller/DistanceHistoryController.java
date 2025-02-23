package RHL.calculation.controller;

import RHL.calculation.dto.request.DistanceHistoryRequest;
import RHL.calculation.dto.response.DistanceHstoryResponse;
import RHL.calculation.service.DistanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation")
public class DistanceHistoryController {
    @Autowired
    DistanceHistoryService distanceHistoryService;
    @PostMapping("/distance/history")
    public DistanceHstoryResponse distanceHstory(@RequestBody DistanceHistoryRequest request) {
        DistanceHstoryResponse response = new DistanceHstoryResponse();
        try {
            response = distanceHistoryService.distanceHistory(request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
