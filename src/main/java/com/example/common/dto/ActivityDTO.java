package com.example.common.dto;

import java.util.Date;

/**
 * @author lvfeibiao
 * @date 上午11:45
 */
public class ActivityDTO {

    private String name;

    private Date startTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
