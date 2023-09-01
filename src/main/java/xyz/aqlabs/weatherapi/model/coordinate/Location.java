package xyz.aqlabs.weatherapi.model.coordinate;

public record Location(
     String name,
     String country,
     String region,
     String lat,
     String lon,
     String timezone_id,
     String localtime,
     int localtime_epoch,
     String utc_offset

) {
}
