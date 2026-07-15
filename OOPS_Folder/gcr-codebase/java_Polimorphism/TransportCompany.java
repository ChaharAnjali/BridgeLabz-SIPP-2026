
class Vehicle {
    public double fuelCost(int km) {
        return 0;
    }
}

class Car extends Vehicle {
    @Override
    public double fuelCost(int km) {
        return km * 8;
    }
}

class Bus extends Vehicle {
    @Override
    public double fuelCost(int km) {
        return km * 15;
    }
}

class Bike extends Vehicle {
    @Override
    public double fuelCost(int km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {
    @Override
    public double fuelCost(int km) {
        return km * 2;
    }
}

public class TransportCompany {
    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car(),
                new Bus(),
                new Bike(),
                new ElectricCar()
        };

        int km = 100;

        for (Vehicle v : fleet) {

            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println("Car Fuel Cost = ₹" + c.fuelCost(km));
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println("Bus Fuel Cost = ₹" + b.fuelCost(km));
            } else if (v instanceof Bike) {
                Bike bk = (Bike) v;
                System.out.println("Bike Fuel Cost = ₹" + bk.fuelCost(km));
            } else if (v instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) v;
                System.out.println("Electric Car Cost = ₹" + ec.fuelCost(km));
            }
        }
    }
}