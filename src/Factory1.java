public class Factory1 extends AbstractCarFactory{
    @Override
    void deliverCar(Car car, String message) {
        System.out.println(message);
    }
}
