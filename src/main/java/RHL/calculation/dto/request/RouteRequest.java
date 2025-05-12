package RHL.calculation.dto.request;

import lombok.Data;

@Data
public class RouteRequest {
    private Location origin;
    private Location destination;
}
