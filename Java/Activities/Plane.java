package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Plane {

    public List<String> passengers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;

    public Plane(int maxPassengers) {
        this.maxPassengers=maxPassengers;
        this.passengers=new ArrayList<>();
    }

    public void onboard(String passenger)
    {
      this.passengers.add(passenger);
    }

    public void land()
    {
      this.lastTimeLanded = new Date();
      this.passengers.clear();
    }
    public Date takeoff()
    {
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }

    public Date getLastTimeLanded()
    {
      return lastTimeLanded;
    }
    public List<String> getPassengers()
    {
        return passengers;
    }

}
