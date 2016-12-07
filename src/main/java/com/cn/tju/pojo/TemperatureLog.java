package com.cn.tju.pojo;

import java.util.Date;

public class TemperatureLog {
    private Integer id;

    private String sensorId;

    private Float tempratureCurtem;

    private Date datetime;

    public TemperatureLog(Integer id, String sensorId, Float tempratureCurtem, Date datetime) {
        this.id = id;
        this.sensorId = sensorId;
        this.tempratureCurtem = tempratureCurtem;
        this.datetime = datetime;
    }

    public TemperatureLog() {
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

    public Float getTempratureCurtem() {
        return tempratureCurtem;
    }

    public void setTempratureCurtem(Float tempratureCurtem) {
        this.tempratureCurtem = tempratureCurtem;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}