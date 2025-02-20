package RHL.calculation.dto.response;

import lombok.Data;

@Data
public class VehicleDetailsData {
    private String vehicleType;
    private String vehicleSegment;
    private String description;
    private String lengthOfContainer; //in feet
    private String widthOfContainer; // in feet
    private String maxLoadCapacity; // in ton
    private String palletSizeWidth; //in feet
    private String palletSizeHeight; //in feet
    private String palletAdjustmentLength;
    private String palletAdjustmentWidth;
    private String palletSpaceInVehicle;
    private String freeSpaceInLength;
    private String freeSpaceInWidth;
    private String vehicleMillage;
    private String palletPrice;
}
