package com.cn.tju.pojo;

import lombok.ToString;

import java.util.Date;

@ToString
public class Alarm {
    private Integer id;

    private String sensorId;

    private String alarmNote;

    private Date alarmTime;

    public Alarm(Integer id, String sensorId, String alarmNote, Date alarmTime) {
        this.id = id;
        this.sensorId = sensorId;
        this.alarmNote = alarmNote;
        this.alarmTime = alarmTime;
    }

    public Alarm() {
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

    public String getAlarmNote() {
        return alarmNote;
    }

    public void setAlarmNote(String alarmNote) {
        this.alarmNote = alarmNote == null ? null : alarmNote.trim();
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }
}