public class Car {
    private String brand;
    private String fuelSource;
    private String color;
    private Double price;

    public Car(String brand, String fuelSource, String color, Double price) {
        this.brand = brand;
        this.fuelSource = fuelSource;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", fuelSource='" + fuelSource + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getFuelSource() {
        return fuelSource;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void startEngine(){
        System.out.println(getClass().getSimpleName());
        System.out.println("Car On");
    }

    public void fuelCar(){
        System.out.println("Fuel type: " + this.fuelSource);
        System.out.println("The " + this.brand + " is fueled up." );
    }
}
