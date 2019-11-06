package com.nbd.models;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Table("accidents")
public class Accident {

    @PrimaryKey
    private @NotNull String accidentIndex;

    @Column("longitude")
    private double longitude;

    @Column("latitude")
    private double latitude;

    @Column("police_force")
    private @NotNull String policeForce;

    @Column("accident_severity")
    private @NotNull String accidentSeverity;

    @Column("number_of_vehicles")
    private @Min(value = 1) int numberOfVehicles;

    @Column("number_of_casualties")
    private @Min(value = 1) int numberOfCasualties;

    @Column("date")
    private @NotNull Date date;

    @Column("local_authority")
    private @NotNull String localAuthority;

    @Column("road_type")
    private @NotNull String roadType;

    @Column("speed_limit")
    private @Min(value = 1) int speedLimit;

    @Column("light_conditions")
    private @NotNull String lightConditions;

    @Column("weather_conditions")
    private @NotNull String weatherConditions;

    @Column("road_surface_conditions")
    private @NotNull String roadSurfaceConditions;

    @Column("urban_or_rural_area")
    private @NotNull String urbanOrRuralArea;

    @Column("did_police_officer_attend_scene_of_accident")
    private boolean didPoliceOfficerAttendSceneOfAccident;

    public Accident(@NotNull String accidentIndex, double longitude, double latitude, @NotNull String policeForce, @NotNull String accidentSeverity, @Min(value = 1) int numberOfVehicles, @Min(value = 1) int numberOfCasualties, @NotNull Date date, @NotNull String localAuthority, @NotNull String roadType, @Min(value = 1) int speedLimit, @NotNull String lightConditions, @NotNull String weatherConditions, @NotNull String roadSurfaceConditions, @NotNull String urbanOrRuralArea, boolean didPoliceOfficerAttendSceneOfAccident) {
        this.accidentIndex = accidentIndex;
        this.longitude = longitude;
        this.latitude = latitude;
        this.policeForce = policeForce;
        this.accidentSeverity = accidentSeverity;
        this.numberOfVehicles = numberOfVehicles;
        this.numberOfCasualties = numberOfCasualties;
        this.date = date;
        this.localAuthority = localAuthority;
        this.roadType = roadType;
        this.speedLimit = speedLimit;
        this.lightConditions = lightConditions;
        this.weatherConditions = weatherConditions;
        this.roadSurfaceConditions = roadSurfaceConditions;
        this.urbanOrRuralArea = urbanOrRuralArea;
        this.didPoliceOfficerAttendSceneOfAccident = didPoliceOfficerAttendSceneOfAccident;
    }

    public String getAccidentIndex() {
        return accidentIndex;
    }

    public void setAccidentIndex(String accidentIndex) {
        this.accidentIndex = accidentIndex;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getPoliceForce() {
        return policeForce;
    }

    public void setPoliceForce(String policeForce) {
        this.policeForce = policeForce;
    }

    public String getAccidentSeverity() {
        return accidentSeverity;
    }

    public void setAccidentSeverity(String accidentSeverity) {
        this.accidentSeverity = accidentSeverity;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public int getNumberOfCasualties() {
        return numberOfCasualties;
    }

    public void setNumberOfCasualties(int numberOfCasualties) {
        this.numberOfCasualties = numberOfCasualties;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocalAuthority() {
        return localAuthority;
    }

    public void setLocalAuthority(String localAuthority) {
        this.localAuthority = localAuthority;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String getLightConditions() {
        return lightConditions;
    }

    public void setLightConditions(String lightConditions) {
        this.lightConditions = lightConditions;
    }

    public String getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(String weatherConditions) {
        this.weatherConditions = weatherConditions;
    }

    public String getRoadSurfaceConditions() {
        return roadSurfaceConditions;
    }

    public void setRoadSurfaceConditions(String roadSurfaceConditions) {
        this.roadSurfaceConditions = roadSurfaceConditions;
    }

    public String getUrbanOrRuralArea() {
        return urbanOrRuralArea;
    }

    public void setUrbanOrRuralArea(String urbanOrRuralArea) {
        this.urbanOrRuralArea = urbanOrRuralArea;
    }

    public boolean isDidPoliceOfficerAttendSceneOfAccident() {
        return didPoliceOfficerAttendSceneOfAccident;
    }

    public void setDidPoliceOfficerAttendSceneOfAccident(boolean didPoliceOfficerAttendSceneOfAccident) {
        this.didPoliceOfficerAttendSceneOfAccident = didPoliceOfficerAttendSceneOfAccident;
    }
}
