package org.console.model;

public class Reward {
    static final int PTS_DAILY_COMPLETE= 10;
    static final int PTS_WEEKLY_COMPLETE= 15;
    static final int PTS_MONTHLY_COMPLETE= 20;

    public int pointFor(String fre){
          return switch (fre){
             case "weekly" -> PTS_WEEKLY_COMPLETE;
             case "monthly" -> PTS_MONTHLY_COMPLETE;
             default ->  PTS_DAILY_COMPLETE;
        };
    }
}
