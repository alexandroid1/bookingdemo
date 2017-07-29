package romaniancoder.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Александр on 26.07.2017.
 */

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String hotelName;
    private double pricePerNight;
    private int nbOfNights;

    public HotelBooking() {
    }

    public HotelBooking(String hotelName, double pricePerNight, int nbOfNights){
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nbOfNights;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNbOfNights() {
        return nbOfNights;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getTotalPrice(){
        return pricePerNight * nbOfNights;
    }

    public long getId(){
        return id;
    }
}
