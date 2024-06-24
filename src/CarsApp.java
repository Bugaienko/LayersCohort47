/*
@date 24.06.2024
@author Sergey Bugaienko
*/

import repository.CarRepository;
import repository.UserRepository;
import service.CarService;
import view.Menu;

public class CarsApp {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        CarRepository carRepository = new CarRepository();

        CarService service = new CarService(carRepository, userRepository);
        Menu menu = new Menu(service);

        menu.run();
    }
}
