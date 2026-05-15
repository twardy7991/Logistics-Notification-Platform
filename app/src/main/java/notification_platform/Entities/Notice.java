package notification_platform.Entities;

import java.util.HashMap;
import java.util.Map;

public class Notice implements Entity{
    
    private int clientId;
    private TimeBounds timeBounds;
    private int orderId;
    private int noticeId;

    public Notice(){};

    public Notice(char[] from, char[] to, int clientId, int orderId, int noticeId){
        this.clientId = clientId;
        this.orderId = orderId;
        this.noticeId = noticeId;
        this.timeBounds = new TimeBounds(from, to);
    };

    private record TimeBounds(char[] from, char[] to) {};

    public TimeBounds getTimeBounds(){
        return this.timeBounds;
    }

    @Override
    public String toString(){
        return "Notice by %i, from %s to %s".formatted(this.clientId, this.timeBounds.from, this.timeBounds.to);
    }

}

class DeliveryTime {

    private Map<String, Integer> timeFrame = new HashMap<>();

    private void initializeTimeFrame(){
        for (int i = 8; i < 20; i++){
            if (i % 2 == 0){
                timeFrame.put("%i:00".formatted(i), i);
            } else {
                timeFrame.put("%i:30".formatted(i), i);
            }
        }
    } 

    public DeliveryTime(String from, String to){
        initializeTimeFrame();
    };
}

