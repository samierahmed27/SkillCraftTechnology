import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    // Method to convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    // Method to convert Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    // Method to convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Method to convert Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("---------------------");
        System.out.println("Choose the scale you are converting from:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the temperature value: ");
        double temp = scanner.nextDouble();

        switch (choice) {
            case 1: // Celsius
                System.out.println(temp + "°C = " + celsiusToFahrenheit(temp) + "°F");
                System.out.println(temp + "°C = " + celsiusToKelvin(temp) + "K");
                break;

            case 2: // Fahrenheit
                System.out.println(temp + "°F = " + fahrenheitToCelsius(temp) + "°C");
                System.out.println(temp + "°F = " + fahrenheitToKelvin(temp) + "K");
                break;

            case 3: // Kelvin
                System.out.println(temp + "K = " + kelvinToCelsius(temp) + "°C");
                System.out.println(temp + "K = " + kelvinToFahrenheit(temp) + "°F");
                break;

            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }

        scanner.close();
    }
}