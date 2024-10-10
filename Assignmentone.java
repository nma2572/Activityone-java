package project;

/** Natnael Argaw(399006831)
 * Created the interfaces, the Airplane abstract class and the class for each plane - */
public class Assignmentone {

    // Abstract class Airplane
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

    // Cargo interface
    public interface Cargo {
        float getCargoWeight();
        void setCargoWeight(float weight);
    }

    // Private interface
    public interface Private {
        String getOwnerName();
        void setOwnerName(String name);
    }

    // Commercial interface
    public interface Commercial {
        int getnumberofpassengers();
        void setnumberofpassengers(int passengers);
    }

    // CargoPlane class implementing Airplane and Cargo
    public class CargoPlane extends Airplane implements Cargo {
        private float cargoWeight;

        public CargoPlane(String flightnumber, String make, String type, String departuretime, String landingtime, double flightduration, float cargoWeight) {
            super(flightnumber, make, type, departuretime, landingtime, flightduration);
            this.cargoWeight = cargoWeight;
        }

        // Implementing methods from Cargo interface
        @Override
        public float getCargoWeight() {
            return cargoWeight;
        }
        
        
        @Override
        public void setCargoWeight(float weight) {
            this.cargoWeight = weight;
        }

        // Implementing the abstract method from Airplane
        @Override
        public void displayDetails() {
            System.out.println("Flight Number: " + flightnumber + 
                               ", Make: " + make + 
                               ", Type: " + type + 
                               ", Departure Time: " + departuretime + 
                               ", Landing Time: " + landingtime + 
                               ", Flight Duration: " + flightduration + 
                               ", Cargo Weight: " + cargoWeight);
        }
        
        public class PrivatePlane extends Airplane implements Private {
            private String ownername;

            public PrivatePlane(String flightNumber, String make, String type, String departureTime, String landingTime, int flightDuration, String ownerName) {
                super(flightNumber, make, type, departureTime, landingTime, flightDuration);
                this.ownername = ownername;
            }

            @Override
            public String getOwnerName() {
                return this.ownername;
            }

            @Override
            public void setOwnerName(String name) {
                this.ownername = name;
            }

            public void displayDetails() {
                System.out.println("Flight Number: " + flightnumber + 
                                   ", Make: " + make + 
                                   ", Type: " + type + 
                                   ", Departure Time: " + departuretime + 
                                   ", Landing Time: " + landingtime + 
                                   ", Flight Duration: " + flightduration + 
                                   ", Cargo Weight: " + ownername);

    }    public class Commercialplane extends Airplane implements Commercial {
        private int numberofpassengers;

        public Commercialplane(String flightNumber, String make, String type, String departureTime, String landingTime, int flightDuration, String ownerName) {
            super(flightNumber, make, type, departureTime, landingTime, flightDuration);
            this.numberofpassengers = numberofpassengers;
        }

        @Override
        public int getnumberofpassengers() {
            return this.numberofpassengers;
        }

        @Override
        public void setnumberofpassengers(int numberofpassengers) {
            this.numberofpassengers = numberofpassengers;
        }

        public void displayDetails() {
            System.out.println("Flight Number: " + flightnumber + 
                               ", Make: " + make + 
                               ", Type: " + type + 
                               ", Departure Time: " + departuretime + 
                               ", Landing Time: " + landingtime + 
                               ", Flight Duration: " + flightduration + 
                               ", Cargo Weight: " + numberofpassengers);
        }
        
        }
    }
        }
    }
