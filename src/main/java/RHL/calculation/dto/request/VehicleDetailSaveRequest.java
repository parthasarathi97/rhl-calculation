package RHL.calculation.dto.request;

import lombok.Data;

@Data
public class VehicleDetailSaveRequest {
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
}
