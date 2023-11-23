
import java.util.*;

public class Bus {


    private int numberOfBus;

    private List<String> route;
    public Bus(){

    }

    public Bus(int numberOfBus, List<String> route) {
        this.numberOfBus = numberOfBus;
        this.route = route;

    }

    public int getNumberOfBus() {
        return numberOfBus;
    }

    public List<String> getRoute() {
        return route;
    }
}
