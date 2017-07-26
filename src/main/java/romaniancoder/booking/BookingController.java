package romaniancoder.booking;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 26.07.2017.
 */
@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private List<HotelBooking> bookings;

    public BookingController(){
        bookings = new ArrayList<>();

        bookings.add(new HotelBooking(
                "Marriot",
                200.50,
                3
        ));

        bookings.add(new HotelBooking(
                "Ibis",
                90,
                4
        ));

        bookings.add(new HotelBooking(
                "Novotell",
                140.74,
                1
        ));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll(){
        return bookings;
    }
}
