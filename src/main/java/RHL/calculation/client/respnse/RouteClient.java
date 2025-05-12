package RHL.calculation.client.respnse;

import lombok.Data;

@Data
public class RouteClient {
    public int distanceMeters;
    public String duration;
    public PolylineClient polyline;
}
