public class Demo {

    public static void main(String[] args){
        Factory1 chingAutosBuilder = new Factory1();
        Factory2 mattsAutos = new Factory2();

        //Factory1 building code
        System.out.println("ChingAutosBuilder > Car building process Started");
        Car car1 = chingAutosBuilder.buildCar("Tesla", "power", null,180.000);
        chingAutosBuilder.paintCar(car1, "Dark grey");
        chingAutosBuilder.checkCar(car1);
        chingAutosBuilder.deliverCar(car1, "Your " + car1.getBrand() + " is being imported from China.");

        System.out.println("*************************************");

        //Factory2 building code
        System.out.println("MattsAutos > Car building process Started");
        Car car2 = mattsAutos.buildCar("Toyota", "gas", null,80.000);
        mattsAutos.paintCar(car2, "Light Green");
        mattsAutos.checkCar(car2);
        mattsAutos.deliverCar(car2, "New " + car2.getBrand() + " created and designed by MattsAutos.");
    }
}
