package project;

public class Assignmentone {
	public abstract class Airplane {
	    protected String flightnumber;
	    protected String make;
	    protected String type;
	    protected String departuretime;
	    protected String landingtime;
	    protected double flightduration;

	    public Airplane(String flightnumber, String make, String type, String departuretime, String landingtime, double flightduration) {
	        this.flightnumber = flightnumber;
	        this.make = make;
	        this.type = type;
	        this.departuretime = departuretime;
	        this.landingtime = landingtime;
	        this.flightduration = flightduration;
	    }

	    public abstract void displayDetails();
	}

	
	public interface Cargo {
	    double getCargoweight();
	    void setCargoweight(double weight);
	}
	
	public interface Private {
	    String getownername();
	    void setownername(String name);
	}
	
	public interface Commercial {
	    int getnumberofpassengers();
	    void setnumberfpassengers(int passengers);
	}
	
	




}
