package RHL.calculation.serviceImpl;

import RHL.calculation.dto.request.DistanceHistoryRequest;
import RHL.calculation.dto.response.DistanceHstoryResponse;
import RHL.calculation.model.DistanceHistory;
import RHL.calculation.repo.DistanceHistoryRepo;
import RHL.calculation.service.DistanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class DistanceHistoryServiceImpl implements DistanceHistoryService {
    @Autowired
    DistanceHistoryRepo distanceHistoryRepo;
    @Override
    public DistanceHstoryResponse distanceHistory(DistanceHistoryRequest distanceHistoryRequest) {
        DistanceHstoryResponse response = new DistanceHstoryResponse();
        try{
            DistanceHistory data = new DistanceHistory();
            data.setPickupLocation(distanceHistoryRequest.getPickupLocation());
            data.setDropLocation(distanceHistoryRequest.getDropLocation());
            data.setTravelDistance(distanceHistoryRequest.getTravelDistance());
            data.setTravelTime(distanceHistoryRequest.getTravelTime());
            data.setVehicleMileage(distanceHistoryRequest.getVehicleMileage());
            data.setFuelCost(distanceHistoryRequest.getFuelCost());
            data.setPerKmCost(distanceHistoryRequest.getPerKmCost());
            data.setTotalCost(distanceHistoryRequest.getTotalCost());
            data.setCreatedDate(new Date());
            distanceHistoryRepo.save(data);
            response.setStatusCode(200);
            response.setMessage("Saved");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
