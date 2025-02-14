package RHL.calculation.serviceImpl;

import RHL.calculation.dto.request.VehicleDetailSaveRequest;
import RHL.calculation.dto.response.VehicleDetailSaveResponse;
import RHL.calculation.model.VehicleDetails;
import RHL.calculation.repo.VehicleDetailsRepo;
import RHL.calculation.service.VehicleDetailsSaveService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleDetailsSaveServiceImpl implements VehicleDetailsSaveService {
    @Autowired
    private VehicleDetailsRepo vehicleDetailsRepo;

    @Override
    public VehicleDetailSaveResponse vehicleDetailSave(VehicleDetailSaveRequest request) {
        VehicleDetailSaveResponse response = new VehicleDetailSaveResponse();
        try {
            Optional<VehicleDetails> existingVehicle = vehicleDetailsRepo.findByVehicleType(request.getVehicleType());
            VehicleDetails vehicleDetails;

            if (existingVehicle.isPresent()) {
                vehicleDetails = existingVehicle.get();
            } else {
                vehicleDetails = new VehicleDetails();
            }

            vehicleDetails.setVehicleType(request.getVehicleType());
            vehicleDetails.setVehicleSegment(request.getVehicleSegment());
            vehicleDetails.setDescription(request.getDescription());
            vehicleDetails.setLengthOfContainer(request.getLengthOfContainer());
            vehicleDetails.setWidthOfContainer(request.getWidthOfContainer());
            vehicleDetails.setMaxLoadCapacity(request.getMaxLoadCapacity());
            vehicleDetails.setPalletSizeWidth(request.getPalletSizeWidth());
            vehicleDetails.setPalletSizeHeight(request.getPalletSizeHeight());
            vehicleDetails.setPalletAdjustmentLength(request.getPalletAdjustmentLength());
            vehicleDetails.setPalletAdjusmentWidth(request.getPalletAdjustmentWidth());
            vehicleDetails.setPalletSpaceInVehicle(request.getPalletSpaceInVehicle());
            vehicleDetails.setFreeSpaceInLength(request.getFreeSpaceInLength());
            vehicleDetails.setFreeSpaceInWidth(request.getFreeSpaceInWidth());

            vehicleDetails = vehicleDetailsRepo.save(vehicleDetails);
            System.out.println("vehicle saved or update" + new Gson().toJson(vehicleDetails));

            response.setStatusCode(200);
            response.setMessage(existingVehicle.isPresent() ? "Vehicle details updated successfully" : "New vehicle details saved successfully");
        } catch (Exception e) {
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
