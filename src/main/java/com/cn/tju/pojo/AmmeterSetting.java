package com.cn.tju.pojo;

import lombok.ToString;

@ToString
public class AmmeterSetting {
    private String ammeterId;

    private String ammeterName;

    private String ammeterIp;

    private Integer ammeterPort;

    private Integer ammeterSlave;

    private Integer ammeterFirst;

    private Integer ammeterSecond;

    public AmmeterSetting(String ammeterId, String ammeterName, String ammeterIp, Integer ammeterPort, Integer ammeterSlave, Integer ammeterFirst, Integer ammeterSecond) {
        this.ammeterId = ammeterId;
        this.ammeterName = ammeterName;
        this.ammeterIp = ammeterIp;
        this.ammeterPort = ammeterPort;
        this.ammeterSlave = ammeterSlave;
        this.ammeterFirst = ammeterFirst;
        this.ammeterSecond = ammeterSecond;
    }

    public AmmeterSetting() {
        super();
    }

    public String getAmmeterId() {
        return ammeterId;
    }

    public void setAmmeterId(String ammeterId) {
        this.ammeterId = ammeterId == null ? null : ammeterId.trim();
    }

    public String getAmmeterName() {
        return ammeterName;
    }

    public void setAmmeterName(String ammeterName) {
        this.ammeterName = ammeterName == null ? null : ammeterName.trim();
    }

    public String getAmmeterIp() {
        return ammeterIp;
    }

    public void setAmmeterIp(String ammeterIp) {
        this.ammeterIp = ammeterIp == null ? null : ammeterIp.trim();
    }

    public Integer getAmmeterPort() {
        return ammeterPort;
    }

    public void setAmmeterPort(Integer ammeterPort) {
        this.ammeterPort = ammeterPort;
    }

    public Integer getAmmeterSlave() {
        return ammeterSlave;
    }

    public void setAmmeterSlave(Integer ammeterSlave) {
        this.ammeterSlave = ammeterSlave;
    }

    public Integer getAmmeterFirst() {
        return ammeterFirst;
    }

    public void setAmmeterFirst(Integer ammeterFirst) {
        this.ammeterFirst = ammeterFirst;
    }

    public Integer getAmmeterSecond() {
        return ammeterSecond;
    }

    public void setAmmeterSecond(Integer ammeterSecond) {
        this.ammeterSecond = ammeterSecond;
    }
}