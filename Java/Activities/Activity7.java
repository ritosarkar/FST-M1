package activities;

interface BicycleParts {
    public int gears = 0;
    public int speed = 0;
}

interface BicycleOperations {
    public void applyBrake(int decrement);

    public void speedUp(int increment);
}

class Bicycle implements BicycleOperations, BicycleParts {

    public int gears;
    public int speed;

    public Bicycle(int gears, int speed) {
        this.gears = gears;
        this.speed = speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
        System.out.println("Current speed: " + speed);
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Current speed: " + speed);
    }

    public String bicycleDesc() {
        return ("No of gears are " + gears + "\nSpeed of bicycle is " + speed);
    }

}

class MountainBike extends Bicycle {

    public int seatHeight;

    public MountainBike(int gears, int speed, int seatHeight) {
        super(gears, speed);
        //this.seatHeight=seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

    @Override
    public String bicycleDesc()
    {
      return (super.bicycleDesc()+ "\nheight of the seat is "+seatHeight);
    }
}

public class Activity7 {
    public static void main(String[] args)
    {
     MountainBike mountainBike = new MountainBike(3, 0, 25);
     System.out.println(mountainBike.bicycleDesc());
     mountainBike.speedUp(20);
     mountainBike.applyBrake(5);
    }
}
