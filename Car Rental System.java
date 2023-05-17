package projects;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car 
{
    private String make;
    private String model;
    private boolean rented;

    public Car(String make, String model) 
    {
        this.make = make;
        this.model = model;
        this.rented = false;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel() 
    {
        return model;
    }

    public boolean isRented()
    {
        return rented;
    }

    public void rent() 
    {
        rented = true;
    }

    public void returnCar()
    {
        rented = false;
    }
}

class CarRentalSystem
{
    private List<Car> cars;

    public CarRentalSystem()
    {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) 
    {
        cars.add(car);
    }

    public void rentCar(int index) 
    {
        Car car = cars.get(index);
        if (!car.isRented())
        {
            car.rent();
            System.out.println("Car rented successfully.");
        } else
        {
            System.out.println("Car is already rented.");
        }
    }

    public void returnCar(int index) 
    {
        Car car = cars.get(index);
        if (car.isRented()) 
        {
            car.returnCar();
            System.out.println("Car returned successfully.");
        } else
        {
            System.out.println("Car is not currently rented.");
        }
    }

    public void displayAvailableCars() 
    {
        System.out.println("Available cars:");
        for (int i = 0; i < cars.size(); i++)
        {
            Car car = cars.get(i);
            if (!car.isRented())
            {
                System.out.println(i + ": " + car.getMake() + " " + car.getModel());
            }
        }
    }
}

public class Main
{
    public static void main(String[] args) 
    {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        rentalSystem.addCar(new Car("Toyota", "Camry"));
        rentalSystem.addCar(new Car("Honda", "Accord"));
        rentalSystem.addCar(new Car("Ford", "Mustang"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCar Rental System");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Display available cars");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    rentalSystem.displayAvailableCars();
                    System.out.print("Enter the car number to rent: ");
                    int rentIndex = scanner.nextInt();
                    rentalSystem.rentCar(rentIndex);
                    break;
                case 2:
                    rentalSystem.displayAvailableCars();
                    System.out.print("Enter the car number to return: ");
                    int returnIndex = scanner.nextInt();
                    rentalSystem.returnCar(returnIndex);
                    break;
                case 3:
                    rentalSystem.displayAvailableCars();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}