package com.cn.tju.pojo;

public class AmmeterVirtual {
    private String ammetervirtualId;

    private String ammetervirtualName;

    private Integer sensortypeId;

    private Integer energysecondId;

    private String sensorNote;

    public AmmeterVirtual(String ammetervirtualId, String ammetervirtualName, Integer sensortypeId, Integer energysecondId, String sensorNote) {
        this.ammetervirtualId = ammetervirtualId;
        this.ammetervirtualName = ammetervirtualName;
        this.sensortypeId = sensortypeId;
        this.energysecondId = energysecondId;
        this.sensorNote = sensorNote;
    }

    public AmmeterVirtual() {
        super();
    }

    public String getAmmetervirtualId() {
        return ammetervirtualId;
    }

    public void setAmmetervirtualId(String ammetervirtualId) {
        this.ammetervirtualId = ammetervirtualId == null ? null : ammetervirtualId.trim();
    }

    public String getAmmetervirtualName() {
        return ammetervirtualName;
    }

    public void setAmmetervirtualName(String ammetervirtualName) {
        this.ammetervirtualName = ammetervirtualName == null ? null : ammetervirtualName.trim();
    }

    public Integer getSensortypeId() {
        return sensortypeId;
    }

    public void setSensortypeId(Integer sensortypeId) {
        this.sensortypeId = sensortypeId;
    }

    public Integer getEnergysecondId() {
        return energysecondId;
    }

    public void setEnergysecondId(Integer energysecondId) {
        this.energysecondId = energysecondId;
    }

    public String getSensorNote() {
        return sensorNote;
    }

    public void setSensorNote(String sensorNote) {
        this.sensorNote = sensorNote == null ? null : sensorNote.trim();
    }
}