package service;
/*
@date 24.06.2024
@author Sergey Bugaienko
*/

import model.Car;
import model.User;
import repository.CarRepository;
import repository.UserRepository;
import util.MyList;

public class CarService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private User activeUser;

    public CarService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }


    public User registerUser(String email, String password) {
        // Добавить валидацию email и пароль

        if (userRepository.isEmailExists(email)) return null;

        User user = userRepository.addUser(email, password);
        return user;
    }

    public boolean login(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if (user == null) return false;

        if (!user.getPassword().equals(password)) {
            return false;
        }
        activeUser = user;
        return true;
    }

    public boolean logout() {
        if (activeUser == null) return false;
        activeUser = null;
        return true;
    }

    public Car getCarById(int carId) {
        return carRepository.getCarById(carId);
    }

    public MyList<Car> getAllCars() {
        return carRepository.getAllCars();
    }
}
