package designPattern;

public class AdapterPatternExample {
    public static void main(String[] args) {
        IDisplayAdapter displayAdapter = new AnyToVga(new VgaDisplay());
        HDMI hdmi = new HDMI();
        //HDMI wants to display something, but it doesn't know what screen will display
        //Therefore, it delegates the work to the the adapter
        hdmi.display(displayAdapter);
    }
}

interface IDisplayAdapter {
    void display();
}

class AnyToVga implements IDisplayAdapter {
    VgaDisplay vgaDisplay;

    public AnyToVga(VgaDisplay vgaDisplay) {
        this.vgaDisplay = vgaDisplay;
    }

    @Override
    public void display() {
        vgaDisplay.display();
    }
}
class HDMI{
    public void display(IDisplayAdapter targetScreen) {
        targetScreen.display();
    }
}
class VgaDisplay{
    public void display(){
        System.out.println("VGA is displaying");
    }
}
