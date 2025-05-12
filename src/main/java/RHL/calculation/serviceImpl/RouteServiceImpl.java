package RHL.calculation.serviceImpl;

import RHL.calculation.client.GoogleRoutesClient;
import RHL.calculation.client.request.*;
import RHL.calculation.client.respnse.RouteClientResponse;
import RHL.calculation.dto.request.RouteRequest;
import RHL.calculation.dto.response.RouteResponse;
import RHL.calculation.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {
    @Value("${google.route.api.key}")
    private String apiKey;
    @Autowired
    private GoogleRoutesClient googleRoutesClient;
    @Value("${google.field.mask}")
    private String fieldMask;

    @Override
    public RouteResponse route(RouteRequest routeRequest) {
        RouteResponse response = new RouteResponse();
        try {
            LatLngClient originLatLngClient = new LatLngClient();
            originLatLngClient.latitude = Double.parseDouble(routeRequest.getOrigin().getLatitude());
            originLatLngClient.longitude = Double.parseDouble(routeRequest.getOrigin().getLongitude());

            LocationClient originLocation = new LocationClient();
            originLocation.setLatLng(originLatLngClient);

            OriginClient origin = new OriginClient();
            origin.setLocation(originLocation);

            LatLngClient destinationLatLngClient = new LatLngClient();
            destinationLatLngClient.latitude = Double.parseDouble(routeRequest.getDestination().getLatitude());
            destinationLatLngClient.longitude = Double.parseDouble(routeRequest.getDestination().getLongitude());

            LocationClient destinationLocation = new LocationClient();
            destinationLocation.setLatLng(destinationLatLngClient);

            DestinationClient destination = new DestinationClient();
            destination.setLocation(destinationLocation);

            RouteClientRequest clientRequest = new RouteClientRequest();
            clientRequest.origin = origin;
            clientRequest.destination = destination;
            clientRequest.travelMode = "DRIVE";
            clientRequest.routingPreference = "TRAFFIC_AWARE";
            clientRequest.computeAlternativeRoutes = false;
            clientRequest.routeModifiers = new RouteModifiersClient();
            clientRequest.languageCode = "en-US";
            clientRequest.units = "METRIC";

            RouteClientResponse routeClientResponse = googleRoutesClient.getRoute(apiKey, fieldMask, clientRequest);

            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Route request processed successfully");
            response.setData(routeClientResponse);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
