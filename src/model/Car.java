package model;
/*
@date 24.06.2024
@author Sergey Bugaienko
*/

public class Car {
    private final int id;
    private String model;
    private final int year;
    private int power;
    private boolean isBusy;

    public Car(int id, String model, int year, int power) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", isBusy=" + isBusy +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
