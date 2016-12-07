package com.cn.tju.pojo;

import lombok.ToString;

import java.util.Date;

@ToString
public class Hot {
    private Integer id;

    private String sensorId;

    private Float hotOuttem;

    private Float hotIntem;

    private Float hotFlow;

    private Float hotTotal;

    private Date datetime;

    public Hot(Integer id, String sensorId, Float hotOuttem, Float hotIntem, Float hotFlow, Float hotTotal, Date datetime) {
        this.id = id;
        this.sensorId = sensorId;
        this.hotOuttem = hotOuttem;
        this.hotIntem = hotIntem;
        this.hotFlow = hotFlow;
        this.hotTotal = hotTotal;
        this.datetime = datetime;
    }

    public Hot() {
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

    public Float getHotOuttem() {
        return hotOuttem;
    }

    public void setHotOuttem(Float hotOuttem) {
        this.hotOuttem = hotOuttem;
    }

    public Float getHotIntem() {
        return hotIntem;
    }

    public void setHotIntem(Float hotIntem) {
        this.hotIntem = hotIntem;
    }

    public Float getHotFlow() {
        return hotFlow;
    }

    public void setHotFlow(Float hotFlow) {
        this.hotFlow = hotFlow;
    }

    public Float getHotTotal() {
        return hotTotal;
    }

    public void setHotTotal(Float hotTotal) {
        this.hotTotal = hotTotal;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}