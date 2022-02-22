package activities;

import java.awt.*;

public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        Plane plane=new Plane(10);
        plane.onboard("Rito");
        plane.onboard("Chandra");
        plane.onboard("Sushma");
        plane.onboard("Ayushi");
        System.out.println("Ladies and gentlemen, flight had been took off at: "+plane.takeoff());
        System.out.println("Passengers on-boarded in the flight are"+ plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Dear passengers flight had been landed at: "+plane.getLastTimeLanded());

    }
}
