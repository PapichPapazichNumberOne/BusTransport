import java.util.*;
public class BusSystem extends Bus {

    private List<Bus> buses;
    private List<BusStop> busStops;

    public BusSystem() {
        this.buses = new ArrayList<>();
        this.busStops = new ArrayList<>();
    }

    public void addBus(int number, List<String> route) {
        Bus bus = new Bus(number, route);
        buses.add(bus);
    }

    public void addBusStop(String address) {
        BusStop busStop = new BusStop(address);
        busStops.add(busStop);
    }

    public void setSchedule() {

        Random random = new Random();
        for (BusStop stop : busStops) {
            for (Bus bus : buses) {
                if (bus.getRoute().contains(stop.getAddress())) {
                    int interval = random.nextInt(16) + 15;
                    int hours = 7;
                    int minutes = 0;
                    for (int i = 1; i <= 10; i++) {
                        if (hours >= 10) {
                            break;
                        }
                        String arrivalTime = String.format("%02d:%02d", hours, minutes);
                        stop.addSchedule(bus.getNumberOfBus(), arrivalTime);
                        minutes += interval;
                        if (minutes >= 60) {
                            hours++;
                            minutes -= 60;
                        }
                    }
                }
            }
        }
    }

    public void showBusSchedule() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер автобуса:");
        displayBusNumbers();

        int selectedBusNumber = scanner.nextInt();
        displayScheduleForBus(selectedBusNumber);

        scanner.nextLine();

        System.out.println("Введите адрес остановки для просмотра расписания прибытия:");
        displayBusStops();

        String selectedStopAddress = scanner.nextLine();
        displayScheduleForStop(selectedStopAddress);

        scanner.close();
    }

    public void displayBusNumbers() {
        for (Bus bus : buses) {
            System.out.println("Автобус №" + bus.getNumberOfBus());
        }
    }

    public void displayBusStops() {
        for (BusStop busStop : busStops) {
            System.out.println("Остановка: " + busStop.getAddress());
        }
    }

    public void displayScheduleForBus(int busNumber) {
        for (Bus bus : buses) {
            if (bus.getNumberOfBus() == busNumber) {
                List<String> route = bus.getRoute();
                for (String stop : route) {
                    for (BusStop busStop : busStops) {
                        if (busStop.getAddress().equals(stop)) {
                            Map<Integer, String> schedule = busStop.getSchedule();
                            System.out.println("Остановка: " + busStop.getAddress() +
                                    ", Время прибытия автобуса №" + bus.getNumberOfBus() +
                                    ": " + schedule.get(bus.getNumberOfBus()));
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

    public void displayScheduleForStop(String stopAddress) {
        for (BusStop busStop : busStops) {
            if (busStop.getAddress().equals(stopAddress)) {
                System.out.println("Остановка: " + busStop.getAddress());
                Map<Integer, String> schedule = busStop.getSchedule();
                for (Map.Entry<Integer, String> entry : schedule.entrySet()) {
                    System.out.println("Автобус №" + entry.getKey() +
                            ", Время прибытия: " + entry.getValue());
                }
                break;
            }
        }
    }
}