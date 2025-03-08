package RHL.calculation.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "CalculationHistory")
@Builder
public class CalculationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleSegment;
    private String vehicleType;
    private String vehicleMileage;
    private String lengthOfContainer;
    private String widthOfContainer;
    private String vehicleMaxLoadCapacity;
    private String totalCostOfVehicleLoadCapacity;
    private String palletWidth;
    private String palletHeight;
    private String palletSpaceInVehicle;
    private String palletPrice;
    private String palletMaxLoadCapacity;
    private String pickupLocation;
    private String dropLocation;
    private String shipmentType;
    private String totalWeightBooked;
    private String travelDistance;
    private String travelTime;
    private String fuelCost;
    private String shipmentTypeCost;
    private String totalDistanceCost;
    private String totalLoadCalculationCost;
}
