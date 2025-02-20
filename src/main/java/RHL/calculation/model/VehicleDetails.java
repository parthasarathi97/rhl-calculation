package RHL.calculation.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "VehicleDetails")
public class VehicleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleType;
    private String vehicleSegment;
    private String description;
    private String lengthOfContainer; // in feet
    private String widthOfContainer; // in feet
    private String maxLoadCapacity; // in ton
    private String palletSizeWidth; // in feet
    private String palletSizeHeight; // in feet
    private String palletAdjustmentLength;
    private String palletAdjusmentWidth;
    private String palletSpaceInVehicle;
    private String freeSpaceInLength;
    private String freeSpaceInWidth;
    private String vehicleMillage;
    private String palletPrice;
}
