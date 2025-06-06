package RHL.calculation.serviceImpl;

import RHL.calculation.dto.request.CalculationHistoryRequest;
import RHL.calculation.dto.response.CalculationHistoryResponse;
import RHL.calculation.model.CalculationHistory;
import RHL.calculation.repo.CalculationHistoryRepo;
import RHL.calculation.service.CalculationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationHistoryServiceImpl implements CalculationHistoryService {
    @Autowired
    CalculationHistoryRepo calculationHistoryRepo;

    @Override
    public CalculationHistoryResponse calculationHistory(CalculationHistoryRequest request) {
        CalculationHistoryResponse response = new CalculationHistoryResponse();
        try {
            CalculationHistory data = CalculationHistory.builder()
                    .vehicleSegment(request.getVehicleSegment())
                    .vehicleType(request.getVehicleType())
                    .vehicleMileage(request.getVehicleMileage())
                    .lengthOfContainer(request.getLengthOfContainer())
                    .widthOfContainer(request.getWidthOfContainer())
                    .vehicleMaxLoadCapacity(request.getVehicleMaxLoadCapacity())
                    .totalCostOfVehicleLoadCapacity(request.getTotalCostOfVehicleLoadCapacity())
                    .palletWidth(request.getPalletWidth())
                    .palletHeight(request.getPalletHeight())
                    .palletSpaceInVehicle(request.getPalletSpaceInVehicle())
                    .palletPrice(request.getPalletPrice())
                    .palletMaxLoadCapacity(request.getPalletMaxLoadCapacity())
                    .pickupLocation(request.getPickupLocation())
                    .dropLocation(request.getDropLocation())
                    .shipmentType(request.getShipmentType())
                    .totalWeightBooked(request.getTotalWeightBooked())
                    .travelDistance(request.getTravelDistance())
                    .travelTime(request.getTravelTime())
                    .fuelCost(request.getFuelCost())
                    .shipmentTypeCost(request.getShipmentTypeCost())
                    .totalDistanceCost(request.getTotalDistanceCost())
                    .totalLoadCalculationCost(request.getTotalLoadCalculationCost())
                    .build();

            calculationHistoryRepo.save(data);//saved into calculation repo
            response.setStatusCode(200);
            response.setMessage("Calculation history saved successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
