package designPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(40, 80);
        weatherData.registerObserver(new Display1());
        weatherData.registerObserver(new Display2());
        weatherData.notifyAllObserver();
    }
}

interface Subject{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAllObserver();
}

class WeatherData implements Subject{
    List<Observer> observerList;
    int tempData;
    int humidData;
    public WeatherData(int tempData, int humidData) {
        this.observerList = new ArrayList<>();
        this.tempData = tempData;
        this.humidData = humidData;
    }
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }
    @Override
    public void notifyAllObserver() {
        for (Observer observer: observerList) {
            observer.update(tempData, humidData);
        }
    }
}

interface Observer{
    void update(int temp, int humididty);
}

class Display1 implements Observer{
    @Override
    public void update(int temp, int humididty) {
        System.out.println("Display 1 prints the temp data only: " + temp);
    }
}

class Display2 implements Observer{
    @Override
    public void update(int temp, int humididty) {
        System.out.println("Display 2 prints the humidity data only: " + humididty);
    }
}