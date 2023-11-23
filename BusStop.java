import java.util.*;
public class BusStop {
    private String address;
    private Map<Integer,String> schedule;

    public BusStop(String address) {
        this.address = address;
        this.schedule = new HashMap<>();
    }

  public  void addSchedule(int busNumber, String arrivalTime){
    schedule.put(busNumber,arrivalTime);
      }
      public  Map<Integer, String > getSchedule(){
        return  schedule;
    }
    public  String getAddress(){
        return  address;
    }
}