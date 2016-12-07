package com.cn.tju.pojo;

import lombok.ToString;

import java.util.Date;

@ToString
public class WeatherLog {
    private Integer id;

    private String sensorId;

    private Float weatherTemprature;

    private Float weatherHumidity;

    private Float weatherIrradiancy;

    private Date datetime;

    public WeatherLog(Integer id, String sensorId, Float weatherTemprature, Float weatherHumidity, Float weatherIrradiancy, Date datetime) {
        this.id = id;
        this.sensorId = sensorId;
        this.weatherTemprature = weatherTemprature;
        this.weatherHumidity = weatherHumidity;
        this.weatherIrradiancy = weatherIrradiancy;
        this.datetime = datetime;
    }

    public WeatherLog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId == null ? null : sensorId.trim();
    }

    public Float getWeatherTemprature() {
        return weatherTemprature;
    }

    public void setWeatherTemprature(Float weatherTemprature) {
        this.weatherTemprature = weatherTemprature;
    }

    public Float getWeatherHumidity() {
        return weatherHumidity;
    }

    public void setWeatherHumidity(Float weatherHumidity) {
        this.weatherHumidity = weatherHumidity;
    }

    public Float getWeatherIrradiancy() {
        return weatherIrradiancy;
    }

    public void setWeatherIrradiancy(Float weatherIrradiancy) {
        this.weatherIrradiancy = weatherIrradiancy;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}