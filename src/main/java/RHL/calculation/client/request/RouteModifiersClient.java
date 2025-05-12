package RHL.calculation.client.request;

import lombok.Data;

@Data
public class RouteModifiersClient {
    private boolean avoidTolls;
    private boolean avoidHighways;
    private boolean avoidFerries;
}
