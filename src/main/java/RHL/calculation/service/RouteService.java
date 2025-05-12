package RHL.calculation.service;

import RHL.calculation.dto.request.RouteRequest;
import RHL.calculation.dto.response.RouteResponse;

public interface RouteService {
    RouteResponse route(RouteRequest routeRequest);
}
