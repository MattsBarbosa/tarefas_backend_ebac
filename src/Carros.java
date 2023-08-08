public abstract class Carros {
    public void acelerar() {
        System.out.println("Carro acelerando");
    }
    public void freiar() {
        System.out.println("Carro freiando");
    }

    abstract void printaModeloDoCarro();
}
