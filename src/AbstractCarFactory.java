public abstract class AbstractCarFactory {
    public Car buildCar(String brand, String fuelSource, String color, Double price) {
        return new Car(brand, fuelSource, color, price);
    }
    public void paintCar(Car car, String color) {
        car.setColor(color);
        System.out.println("The car was painted in " + car.getColor());
    }
    public void checkCar(Car car) {
        System.out.println("The " + car.getBrand() + " has been checked by the mechanic. Everything looks good!");
    }
    abstract void deliverCar(Car car, String message);
}
