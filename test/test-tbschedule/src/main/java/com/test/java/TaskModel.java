package com.test.java;

/**
 * Created by qiaogu on 2016/10/21.
 */
public class TaskModel {

    private String times;
    private String  taskName;

    public TaskModel(String times, String taskName) {
        this.times = times;
        this.taskName = taskName;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
