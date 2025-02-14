package RHL.calculation.dto.response;

import lombok.Data;

@Data
public class VehicleDetailsGetResponse {
    private int statusCode;
    private String message;
    private VehicleDetailsData data;
}
