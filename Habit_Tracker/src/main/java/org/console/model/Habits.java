package org.console.model;


import java.time.LocalDateTime;

public class Habits {
    private int habitId=0;
    private int userId;
    private String habitName;
    private boolean status;
    private LocalDateTime DateTime;

    public Habits(int userId, String habitName) {
        this.habitId=++habitId;
        this.userId = userId;
        this.habitName = habitName;
        this.status = false;
        DateTime = LocalDateTime.now();
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
