public class Mechanic {

    private CarAlgorithm carAlgorithm=null;

    public void setCarAlgorithm(CarAlgorithm carAlgorithm) {
        this.carAlgorithm = carAlgorithm;
    }

    public void disassembleCar(){
        carAlgorithm.performAlgorithm();
    }
}
