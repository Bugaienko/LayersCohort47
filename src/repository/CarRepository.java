package repository;
/*
@date 24.06.2024
@author Sergey Bugaienko
*/

import model.Car;
import util.MagicList;
import util.MyList;

import java.util.concurrent.atomic.AtomicInteger;
/*
CRUD - операции.
- Create (Создание) - добавление новых данных
- Read (Чтение) - получение или чтение данных
- Update (Обновление) - изменение существующих данных
- Delete (Удаление) - удаление данных
 */

public class CarRepository {

    private final MyList<Car> cars;
    //объект, отвечающий за генерацию уникальных id
    private final AtomicInteger currentId = new AtomicInteger(1);


    public CarRepository() {
        this.cars = new MagicList<>();
    }

    //Create - add
    public void addCar(String model, int year, int power) {
        //currentId.getAndIncrement() - получение текущего id и увеличение его на +1
        Car car = new Car(currentId.getAndIncrement(), model, year, power);
        cars.add(car);
    }

    // READ
    public MyList<Car> getAllCars() {
        return cars;
    }

    public Car getCarById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public MyList<Car> getAllFreeCars() {
        MyList<Car> freeCars = new MagicList<>();
        //Логика перебора, проверки и добавление "подходящих" мышин в список
        return freeCars;
    }

    public MyList<Car> getCarsByModel(String model) {
        MyList<Car> carsList = new MagicList<>();
        // Логика добавления "подходящих" машин
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                carsList.add(car);
            }
        }

        return carsList;
    }

    //UPDATE
    public boolean updateCarModel(int carId, String newModel) {
        Car car = getCarById(carId);
        if (car != null && newModel != null) {
            car.setModel(newModel);
            return true;
        }

        return false;
    }

    public boolean takeCar(int carId) {
        Car car = getCarById(carId);
        if (car == null || car.isBusy()) return false;

        car.setBusy(true);
        return true;
    }

    //DELETE
    public Car removeCar(int carId) {
        Car car = getCarById(carId);
        if (car == null) return null;
        cars.remove(car);
        return car;
    }
}
