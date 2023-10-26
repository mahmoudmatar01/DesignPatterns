public class Button extends CommonUi{
    public Button(OperatingSystem os) {
        super(os);
    }

    @Override
    public void click() {
        os.doOperation();
    }
}
