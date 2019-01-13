package designPattern.behavior;

import java.util.ArrayList;
import java.util.List;

public class MediatorPatternExample {
    public static void main(String[] args) {
        IMediate GUI = new GUI();
        IButton fastSpeed = new Button("Fast");
        IButton mediumSpeed = new Button("Medium");
        IButton lowSpeed = new Button("Low");

        GUI.addColleague(fastSpeed);
        GUI.addColleague(mediumSpeed);
        GUI.addColleague(lowSpeed);

        fastSpeed.click(GUI);
        mediumSpeed.click(GUI);
        lowSpeed.click(GUI);
    }
}

interface IMediate{
    void mediate(IButton iButton);
    void addColleague(IButton iButton);
}

interface IButton {
    void click(IMediate mediator);
    void enable();
    void disable();
    String getName();
}

class GUI implements IMediate{
    List<IButton> buttonList = new ArrayList<>();

    @Override
    public void mediate(IButton iButton) {
        for (IButton button: buttonList) {
            button.enable();
        }
        iButton.disable();
        for (IButton button: buttonList) {
            Button concreteButton = (Button) button;
            System.out.println(concreteButton.getName()+ " visibility: " +concreteButton.enable);
        }
        System.out.println("\n");
    }

    @Override
    public void addColleague(IButton iButton) {
        buttonList.add(iButton);
    }
}

class Button implements IButton {
    boolean enable;
    String name;

    public Button(String name) {
        this.name = name;
        enable = true;
    }

    @Override
    public void click(IMediate mediator) {
        System.out.println("Clicked "+ "'"+name+"'");
        mediator.mediate(this);
    }

    @Override
    public void enable() {
        this.enable = true;
    }

    @Override
    public void disable() {
        this.enable = false;
    }

    public String getName() {
        return name;
    }

}