package RHL.calculation.service;

import RHL.calculation.dto.request.VehicleDetailSaveRequest;
import RHL.calculation.dto.response.VehicleDetailSaveResponse;

public interface VehicleDetailsSaveService {
    VehicleDetailSaveResponse vehicleDetailSave(VehicleDetailSaveRequest vehicleDetailSaveRequest);
}
