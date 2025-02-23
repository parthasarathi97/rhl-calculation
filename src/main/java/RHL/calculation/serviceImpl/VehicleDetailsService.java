package RHL.calculation.serviceImpl;

import RHL.calculation.model.VehicleDetails;
import RHL.calculation.repo.VehicleDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleDetailsService {
    @Autowired
    private VehicleDetailsRepo repository;

    public VehicleDetails saveOrUpdateVehicle(VehicleDetails newVehicle) {
        Optional<VehicleDetails> existingVehicle = repository.findByVehicleType(newVehicle.getVehicleType());

        if (existingVehicle.isPresent()) {
            VehicleDetails vehicle = existingVehicle.get();
            vehicle.setVehicleSegment(newVehicle.getVehicleSegment());
            vehicle.setDescription(newVehicle.getDescription());
            vehicle.setLengthOfContainer(newVehicle.getLengthOfContainer());
            vehicle.setWidthOfContainer(newVehicle.getWidthOfContainer());
            vehicle.setMaxLoadCapacity(newVehicle.getMaxLoadCapacity());
            vehicle.setPalletSizeWidth(newVehicle.getPalletSizeWidth());
            vehicle.setPalletSizeHeight(newVehicle.getPalletSizeHeight());
            vehicle.setPalletAdjustmentLength(newVehicle.getPalletAdjustmentLength());
            vehicle.setPalletAdjusmentWidth(newVehicle.getPalletAdjusmentWidth());
            vehicle.setPalletSpaceInVehicle(newVehicle.getPalletSpaceInVehicle());
            vehicle.setFreeSpaceInLength(newVehicle.getFreeSpaceInLength());
            vehicle.setFreeSpaceInWidth(newVehicle.getFreeSpaceInWidth());
            vehicle.setVehicleMillage(newVehicle.getVehicleMillage());
            vehicle.setPalletPrice(newVehicle.getPalletPrice());
            vehicle.setPalletMaxLoad(newVehicle.getPalletMaxLoad());
            return repository.save(vehicle);
        } else {
            return repository.save(newVehicle);
        }
    }
}
