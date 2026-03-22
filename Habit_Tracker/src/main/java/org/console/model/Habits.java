package org.console.model;


import java.time.LocalDateTime;


public class Habits {
    private static int count=0;
    private int habitId;
    private int userId;
    private String habitName;
    private String frequency;
    private boolean status;
    private LocalDateTime DateTime;

    public Habits(int userId, String habitName,String frequency) {
        this.habitId=++count;
        this.userId = userId;
        this.habitName = habitName;
        this.frequency = frequency;
        this.status = false;
        DateTime = LocalDateTime.now();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDateTime getDateTime() {
        return DateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        DateTime = dateTime;
    }

    public int getHabitId() {
        return habitId;
    }

    public void setHabitId(int habitId) {
        this.habitId = habitId;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
