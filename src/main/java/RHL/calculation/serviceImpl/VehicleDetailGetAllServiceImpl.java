package RHL.calculation.serviceImpl;

import RHL.calculation.dto.response.VehicleDetailGetAllResponse;
import RHL.calculation.dto.response.VehicleDetailsData;
import RHL.calculation.model.VehicleDetails;
import RHL.calculation.repo.VehicleDetailsGetRepo;
import RHL.calculation.service.VehicleDetailGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class VehicleDetailGetAllServiceImpl implements VehicleDetailGetAllService {
    @Autowired
    VehicleDetailsGetRepo vehicleDetailsGetRepo;

    @Override
    public VehicleDetailGetAllResponse getAllVehicles() {
        VehicleDetailGetAllResponse response = new VehicleDetailGetAllResponse();
        try {
            List<VehicleDetails> vehicles = vehicleDetailsGetRepo.findAll();
            if (vehicles.isEmpty()) {
                response.setStatusCode(400);
                response.setMessage("data not found");
            } else {
                List<VehicleDetailsData> vehicleDetailsDataList = vehicles.stream().map(vehicle -> {
                    VehicleDetailsData data = new VehicleDetailsData();
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
                    return data;
                }).collect(Collectors.toList());

                response.setStatusCode(200);
                response.setMessage("fetched successfully");
                response.setData(vehicleDetailsDataList);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
