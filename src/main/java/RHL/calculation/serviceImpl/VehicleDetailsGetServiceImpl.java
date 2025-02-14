package RHL.calculation.serviceImpl;

import RHL.calculation.dto.request.VehicleDetailsGetRequest;
import RHL.calculation.dto.response.VehicleDetailsGetResponse;
import RHL.calculation.repo.VehicleDetailsRepo;
import RHL.calculation.service.VehicleDetailsGetService;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleDetailsGetServiceImpl implements VehicleDetailsGetService {
    @Autowired
    VehicleDetailsRepo vehicleDetailsRepo;

    @Override
    public VehicleDetailsGetResponse vehicleDetailsGet(VehicleDetailsGetRequest request) {
        VehicleDetailsGetResponse response = new VehicleDetailsGetResponse();
        try {

        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
