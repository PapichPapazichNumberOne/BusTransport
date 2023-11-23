import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BusSystem busSystem = new BusSystem();

        busSystem.addBus(1, Arrays.asList("Остановка А", "Остановка Б", "Остановка В","Остановка Г","Остановка Д"));
        busSystem.addBus(2, Arrays.asList("Остановка А", "Остановка Б", "Остановка В","Остановка Г","Остановка Д"));
        busSystem.addBus(3, Arrays.asList("Остановка А", "Остановка Б", "Остановка В","Остановка Г","Остановка Д"));

        busSystem.addBusStop("Остановка А");
        busSystem.addBusStop("Остановка Б");
        busSystem.addBusStop("Остановка В");
        busSystem.addBusStop("Остановка Г");
        busSystem.addBusStop("Остановка Д");
        busSystem.addBusStop("Остановка Е");


        busSystem.setSchedule();


        busSystem.showBusSchedule();
    }
}
