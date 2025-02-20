package RHL.calculation.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class VehicleDetailGetAllResponse {
    private int statusCode;
    private String message;
    private List<VehicleDetailsData> data;
}
