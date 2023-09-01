package xyz.aqlabs.weatherapi.model.coordinate;

public record Request(
     String type,
     String query,
     String language,
     String unit
) {
}
