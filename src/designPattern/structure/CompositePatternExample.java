package designPattern.structure;

import java.util.ArrayList;
import java.util.List;

public class CompositePatternExample {
    public static void main(String[] args) {
        Graphic rectangle1 = new Rectangle();
        Graphic rectangle2 = new Rectangle();
        Graphic circle1 = new Circle();
        Graphic circle2 = new Circle();

        Picture bigPicture = new Picture();
        bigPicture.addGraphic(rectangle1);

        Picture innerPicture = new Picture();
        innerPicture.addGraphic(rectangle2);
        innerPicture.addGraphic(circle1);
        innerPicture.addGraphic(circle2);

        bigPicture.addGraphic(innerPicture);
        bigPicture.draw();
    }
}

interface Graphic{
    void draw();
}

class Rectangle implements Graphic{
    @Override
    public void draw() {
        System.out.println("Rectangle draw");
    }
}
class Circle implements Graphic{
    @Override
    public void draw() {
        System.out.println("Circle draw");
    }
}

class Picture implements Graphic{
    List<Graphic> graphicList = new ArrayList<>();
    @Override
    public void draw() {
        for (Graphic graphic: graphicList) {
            graphic.draw(); //Delegation
        }
    }
    public void addGraphic(Graphic graphic){
        graphicList.add(graphic);
    }
    public void removeGraphic(Graphic graphic){
        graphicList.remove(graphic);
    }
}