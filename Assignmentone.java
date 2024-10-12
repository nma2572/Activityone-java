package project;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Natnael-Argaw(399006831)
 * Created the interfaces, the Airplane abstract class and the class for each plane 
 * 
 * Abebe-Endalemie
 * implemented teh file handling class*/

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

        public abstract void displayDetails();  // Metho that is gone be implemented by children
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

        // using methods from cargo
        @Override
        public float getCargoWeight() {
            return cargoWeight;
        }

        @Override
        public void setCargoWeight(float weight) {
            this.cargoWeight = weight;
        }

        // abstract method from airPlane
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
    }

    // privateplane implementing Airplane and Private
    public class PrivatePlane extends Airplane implements Private {
        private String ownername;

        public PrivatePlane(String flightNumber, String make, String type, String departureTime, String landingTime, double flightDuration, String ownername) {
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

        @Override
        public void displayDetails() {
            System.out.println("Flight Number: " + flightnumber +
                               ", Make: " + make +
                               ", Type: " + type +
                               ", Departure Time: " + departuretime +
                               ", Landing Time: " + landingtime +
                               ", Flight Duration: " + flightduration +
                               ", Owner Name: " + ownername);
        }
    }

    // commerciallane class implementing Airplane and Commercial
    public class CommercialPlane extends Airplane implements Commercial {
        private int numberofpassengers;

        public CommercialPlane(String flightNumber, String make, String type, String departureTime, String landingTime, double flightDuration, int numberofpassengers) {
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

        @Override
        public void displayDetails() {
            System.out.println("Flight Number: " + flightnumber +
                               ", Make: " + make +
                               ", Type: " + type +
                               ", Departure Time: " + departuretime +
                               ", Landing Time: " + landingtime +
                               ", Flight Duration: " + flightduration +
                               ", Number of Passengers: " + numberofpassengers);
        }
    }

    // FileHandling class to write airplane schedule to a file and load flights
    public class FileHandling {

        
        public void addSchedule(String filePath, Airplane[] airplanes) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(filePath);

                
                writer.append("flightNumber,airplaneMake,type,departureTime,landingTime,flightDuration\r\n");

                
                for (Airplane plane : airplanes) {
                    writer.append(plane.flightnumber).append(",")
                          .append(plane.make).append(",")
                          .append(plane.type).append(",")
                          .append(plane.departuretime).append(",")
                          .append(plane.landingtime).append(",")
                          .append(String.valueOf(plane.flightduration)).append("\r\n");

                    if (plane instanceof CargoPlane) {
                        CargoPlane cargoplane = (CargoPlane) plane;
                        writer.append(String.valueOf(cargoplane.getCargoWeight())).append(" kilo of cargo");
                    } else if (plane instanceof PrivatePlane) {
                        PrivatePlane privateplane = (PrivatePlane) plane;
                        writer.append(privateplane.getOwnerName());
                    } else if (plane instanceof CommercialPlane) {
                        CommercialPlane commercialplane = (CommercialPlane) plane;
                        writer.append(String.valueOf(commercialplane.getnumberofpassengers())).append(" Passengres");
                    }
                }

                writer.append("\r\n");

                
                writer.flush();
                System.out.println("Flight is successfully written to file.");

            } catch (IOException e) {
                System.out.println("An error occurred  writing to the file: " + e.getMessage());
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException ex) {
                    System.out.println("Error closing the writer: " + ex.getMessage());
                }
            }
        }

        // Loading dligts from fiels
        public List<Airplane> loadFlight(String filepath) {
            List<Airplane> airplane = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String line;
                br.readLine(); // to skip header line

                while ((line = br.readLine()) != null) {
                    String[] detail = line.split(",");   Splittting  using comma

                    String flightnumber = detail[0];
                    String make = detail[1];
                    String type = detail[2];
                    String departuretime = detail[3];
                    String landingtime = detail[4];
                    double flightduration = Double.parseDouble(detail[5]);

                    if (type.equals("Cargo")) {
                        float cargoWeight = Float.parseFloat(detail[6].replace("kilos of cargo", ""));
                        airplane.add(new CargoPlane(flightnumber, make, type, departuretime, landingtime, flightduration, cargoWeight));
                    } else if (type.equals("Private")) {
                        String ownerName = detail[6];
                        airplane.add(new PrivatePlane(flightnumber, make, type, departuretime, landingtime, flightduration, ownerName));
                    } else if (type.equals("Commercial")) {
                        int numberOfPassengers = Integer.parseInt(detail[6].replace(" Passengers", ""));
                        airplane.add(new CommercialPlane(flightnumber, make, type, departuretime, landingtime, flightduration, numberOfPassengers));
                    } else {
                        System.out.println("Unknown airplane type: " + type);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error while reading the file: " + e.getMessage());
            }
            return airplane;
        }
    }

    // Main method
    public static void main(String[] args) {
        Assignmentone system = new Assignmentone();
        FileHandling filehandler = system.new FileHandling(); 
       
        List<Airplane> departureFlights = filehandler.loadFlight("C:\\Users\\nhatt\\OneDrive\\Documents\\python\\DataStructure\\depratureFlights.csv");
        List<Airplane> landingFlights = filehandler.loadFlight("C:\\Users\\nhatt\\OneDrive\\Documents\\python\\DataStructure\\landingFlights.csv");

        
        for (Airplane plane : landingFlights) {
            plane.displayDetails();
        }
        
        for (Airplane plane : departureFlights) {
            plane.displayDetails();
        }

        
    }

    }

        


