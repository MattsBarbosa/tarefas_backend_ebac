import java.text.DecimalFormat;

public class Factory2 extends AbstractCarFactory{

    private static String FormatPrice(Double number){
        int zerosAfterDecimal = 3;

        String pattern = "#." + "0".repeat(zerosAfterDecimal);
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
    }
    @Override
    void deliverCar(Car car, String message) {
        System.out.println(message);
        System.out.println("*****Car info*****");
        System.out.println("Car brand: " + car.getBrand());
        System.out.println("Car Fuel type: " + car.getFuelSource());
        System.out.println("Car color: " + car.getColor());
        System.out.println("Car price: R$ " + FormatPrice(car.getPrice()));
        System.out.println("******************");
    }
}
