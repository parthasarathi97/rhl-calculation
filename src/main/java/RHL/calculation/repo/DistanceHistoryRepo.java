package RHL.calculation.repo;

import RHL.calculation.model.DistanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistanceHistoryRepo extends JpaRepository<DistanceHistory, Long> {
}
