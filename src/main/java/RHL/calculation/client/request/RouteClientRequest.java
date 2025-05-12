package RHL.calculation.client.request;

import lombok.Data;

@Data
public class RouteClientRequest {
    public OriginClient origin;
    public DestinationClient destination;
    public String travelMode;
    public String routingPreference;
    public boolean computeAlternativeRoutes;
    public RouteModifiersClient routeModifiers;
    public String languageCode;
    public String units;
}
