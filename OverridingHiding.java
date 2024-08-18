public class OverridingHiding {

    public static void main(String[] args) {
        // 각 클래스에 동일한 static 메소드가 있더라도 구분되어 호출된다
        Car.printCompany();    // General Auto Co.LTD
        Truck.printCompany();  // General Auto Truck Division

        Car car = new Car("소나라", "General Auto", 3000);
        Truck truck = new Truck("Volvo", "General Auto",5000, 10);

        // 각 클래스의 인스턴스 참조를 이용하여 메소드를 호출한다(각 클래스의 메소드가 호출됨)
        car.printInfo();       // Car 클래스의 printInfo() 호출됨
        truck.printInfo();     // Truck의 printInfo() 호출됨

        // 각 클래스의 참조를 통해 static 메소드를 호출하면 각 클래스 안에 선언된 printCompany()가 호출됨
        car.printCompany();    // General Auto Co.LTD
        truck.printCompany();  // General Auto Truck Division

        // 참조를 부모형으로 캐스팅하여 메소드를 호출하더라도 자식이 오버라이딩한 메소드가 호출됨
        Car c = (Car)truck;
        c.printInfo();         // Car의 참조를 통해 호출하지만 Truck의 printInfo()가 호출됨
    }
}

class Car {
    String carName;
    String company;
    int price;

    Car(String carName, String company, int price) {
        this.carName = carName;
        this.company = company;
        this.price = price;
    }

    public static void printCompany() {
        System.out.println("General Auto Co.LTD");

    }

    public void printInfo() {
        System.out.printf("%n차종:%s \t제조사:%s \t가격:%d \t", carName,company,price);
    }
}

class Truck extends Car {
    int maxLoad;

    Truck(String carName, String company, int price, int maxLoad) {
        super(carName, company, price);
        this.maxLoad = maxLoad;
    }
    // 부모 클래스의 printCompany() 메소드를 가린다(Hiding)
    public static void printCompany() {
        System.out.println("General Auto Truck Division");

    }

    @Override  // 부모의 메소드를 오버라이딩
    public void printInfo() {
        super.printInfo();
        System.out.printf("적재중량:%d %n", maxLoad);
    }
}