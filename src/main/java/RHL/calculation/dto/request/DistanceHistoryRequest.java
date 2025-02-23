package RHL.calculation.dto.request;

import lombok.Data;

@Data
public class DistanceHistoryRequest {
    private String pickupLocation;
    private String dropLocation;
    private String travelDistance;
    private String travelTime;
    private String vehicleMileage;
    private String fuelCost;
    private String perKmCost;
    private String totalCost;
}
