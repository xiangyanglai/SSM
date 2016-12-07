package com.cn.tju.pojo;

public class EnergySecond {
    private Integer energysecondId;

    private String energysecondName;

    private Integer energyfirstId;

    public EnergySecond(Integer energysecondId, String energysecondName, Integer energyfirstId) {
        this.energysecondId = energysecondId;
        this.energysecondName = energysecondName;
        this.energyfirstId = energyfirstId;
    }

    public EnergySecond() {
        super();
    }

    public Integer getEnergysecondId() {
        return energysecondId;
    }

    public void setEnergysecondId(Integer energysecondId) {
        this.energysecondId = energysecondId;
    }

    public String getEnergysecondName() {
        return energysecondName;
    }

    public void setEnergysecondName(String energysecondName) {
        this.energysecondName = energysecondName == null ? null : energysecondName.trim();
    }

    public Integer getEnergyfirstId() {
        return energyfirstId;
    }

    public void setEnergyfirstId(Integer energyfirstId) {
        this.energyfirstId = energyfirstId;
    }
}