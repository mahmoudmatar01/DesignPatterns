public abstract class CommonUi {
    public OperatingSystem os;

    public CommonUi(OperatingSystem os){
        this.os=os;
    }
    public abstract void click();
}
