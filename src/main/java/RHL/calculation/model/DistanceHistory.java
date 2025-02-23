package RHL.calculation.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "DistanceHistory")
public class DistanceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupLocation;
    private String dropLocation;
    private String travelDistance;
    private String travelTime;
    private String vehicleMileage;
    private String fuelCost;
    private String perKmCost;
    private String totalCost;
    private Date createdDate;
}
