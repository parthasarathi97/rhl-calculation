package RHL.calculation.service;

import RHL.calculation.dto.request.DistanceHistoryRequest;
import RHL.calculation.dto.response.DistanceHstoryResponse;

public interface DistanceHistoryService {
    DistanceHstoryResponse distanceHistory(DistanceHistoryRequest distanceHistoryRequest);
}
