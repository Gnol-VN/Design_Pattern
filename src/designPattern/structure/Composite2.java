package designPattern.structure;

import java.util.ArrayList;
import java.util.List;

public class Composite2 {
    public static void main(String[] args) {
        IResizable eclipse1 = new Eclipse(10, 10);
        IResizable eclipse2 = new Eclipse(15, 15);
        IResizable triangle1 = new Triangle(20, 20);
        IResizable triangle2 = new Triangle(25, 25);

        GroupObjects groupObjects1 = new GroupObjects();
        groupObjects1.addObject(eclipse1);

        GroupObjects groupObjects2 = new GroupObjects();
        groupObjects2.addObject(eclipse2);
        groupObjects2.addObject(triangle1);
        groupObjects2.addObject(triangle2);

        groupObjects1.addObject(groupObjects2);

        groupObjects1.resize(2);
    }
}

interface IResizable {
    void resize(int percentage);
}

abstract class Shape implements IResizable {
    int height;
    int width;

    public Shape(int height, int width) {
        this.height = height;
        this.width = width;
    }

}

class Eclipse extends Shape {

    public Eclipse(int height, int width) {
        super(height, width);
    }
    @Override
    public void resize(int percentage) {
        this.height = this.height * percentage;
        this.width = this.width * percentage;
        System.out.println("Height: " + height + ", width: " + width);
    }
}

class Triangle extends Shape {
    public Triangle(int height, int width) {
        super(height, width);
    }
    @Override
    public void resize(int percentage) {
        this.height = this.height * percentage;
        this.width = this.width * percentage;
        System.out.println("Height: " + height + ", width: " + width);
    }
}

class GroupObjects implements IResizable {
    List<IResizable> resizableList = new ArrayList<>();
    @Override
    public void resize(int percentage) {
        for (IResizable object : resizableList) {
            object.resize(percentage); //Delegation
        }
    }
    public void addObject(IResizable iResizable) {
        resizableList.add(iResizable);
    }
    public void removeObject(IResizable iResizable) {
        resizableList.remove(iResizable);
    }
}