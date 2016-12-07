package com.cn.tju.pojo;

import lombok.ToString;

import java.util.Date;

@ToString
public class Ammeter {
    private Integer id;

    private String sensorId;

    private Float ammeterPower;

    private Float ammeterTotal;

    private Date datetime;

    public Ammeter(Integer id, String sensorId, Float ammeterPower, Float ammeterTotal, Date datetime) {
        this.id = id;
        this.sensorId = sensorId;
        this.ammeterPower = ammeterPower;
        this.ammeterTotal = ammeterTotal;
        this.datetime = datetime;
    }

    public Ammeter() {
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

    public Float getAmmeterPower() {
        return ammeterPower;
    }

    public void setAmmeterPower(Float ammeterPower) {
        this.ammeterPower = ammeterPower;
    }

    public Float getAmmeterTotal() {
        return ammeterTotal;
    }

    public void setAmmeterTotal(Float ammeterTotal) {
        this.ammeterTotal = ammeterTotal;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}