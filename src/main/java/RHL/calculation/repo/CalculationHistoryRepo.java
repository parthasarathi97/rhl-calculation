package RHL.calculation.repo;

import RHL.calculation.model.CalculationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationHistoryRepo extends JpaRepository<CalculationHistory, Long> {
}
