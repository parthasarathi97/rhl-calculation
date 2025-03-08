package RHL.calculation.serviceImpl;

import RHL.calculation.dto.request.VehicleDetailsGetRequest;
import RHL.calculation.dto.response.VehicleDetailsData;
import RHL.calculation.dto.response.VehicleDetailsGetResponse;
import RHL.calculation.model.VehicleDetails;
import RHL.calculation.repo.VehicleDetailsGetRepo;
import RHL.calculation.service.VehicleDetailsGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleDetailsGetServiceImpl implements VehicleDetailsGetService {
    @Autowired
    VehicleDetailsGetRepo vehicleDetailsGetRepo;

    @Override
    public VehicleDetailsGetResponse vehicleDetailsGet(VehicleDetailsGetRequest request) {
        VehicleDetailsGetResponse response = new VehicleDetailsGetResponse();
        try {
            VehicleDetailsData data = new VehicleDetailsData();
            VehicleDetails vehicle = vehicleDetailsGetRepo.findByVehicleType(request.getVehicleType());
            if (vehicle == null) {
                response.setStatusCode(400);
                response.setMessage("Data Not Found");
            } else {
                data.setVehicleType(vehicle.getVehicleType());
                data.setVehicleSegment(vehicle.getVehicleSegment());
                data.setDescription(vehicle.getDescription());
                data.setLengthOfContainer(vehicle.getLengthOfContainer());
                data.setWidthOfContainer(vehicle.getWidthOfContainer());
                data.setMaxLoadCapacity(vehicle.getMaxLoadCapacity());
                data.setPalletSizeWidth(vehicle.getPalletSizeWidth());
                data.setPalletSizeHeight(vehicle.getPalletSizeHeight());
                data.setPalletAdjustmentLength(vehicle.getPalletAdjustmentLength());
                data.setPalletAdjustmentWidth(vehicle.getPalletAdjusmentWidth());
                data.setPalletSpaceInVehicle(vehicle.getPalletSpaceInVehicle());
                data.setFreeSpaceInLength(vehicle.getFreeSpaceInLength());
                data.setFreeSpaceInWidth(vehicle.getFreeSpaceInWidth());
                data.setVehicleMillage(vehicle.getVehicleMillage());
                data.setPalletPrice(vehicle.getPalletPrice());
                data.setPalletMaxLoadCapacity(vehicle.getPalletMaxLoad());

                response.setStatusCode(200);
                response.setMessage("fetched successfully");
                response.setData(data);
            }
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
