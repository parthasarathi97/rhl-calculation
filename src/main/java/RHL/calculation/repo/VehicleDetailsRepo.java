package RHL.calculation.repo;

import RHL.calculation.model.VehicleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleDetailsRepo extends JpaRepository<VehicleDetails, Long> {
    Optional<VehicleDetails> findByVehicleType(String vehicleType);
}