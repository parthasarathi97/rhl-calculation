package RHL.calculation.repo;

import RHL.calculation.model.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailsGetRepo extends JpaRepository<VehicleDetails, Long> {
    VehicleDetails findByVehicleType(String vehicleType);
}
