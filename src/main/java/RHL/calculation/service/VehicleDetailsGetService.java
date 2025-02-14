package RHL.calculation.service;

import RHL.calculation.dto.request.VehicleDetailsGetRequest;
import RHL.calculation.dto.response.VehicleDetailsGetResponse;

public interface VehicleDetailsGetService {
    VehicleDetailsGetResponse vehicleDetailsGet(VehicleDetailsGetRequest vehicleDetailsGetRequest);
}
