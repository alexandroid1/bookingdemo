package romaniancoder.booking;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Александр on 26.07.2017.
 */
@RestController
@RequestMapping(value = "/bookings")
@Api(
        name = "Hotel Booking API",
        description = "Provides a list of methods that manage hotel bookings",
        stage = ApiStage.RC)
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel booking from the database")
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }

    // using java 8 Streams filter() and collect()
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings where the price per night " +
            "is less than the provided value")
    public List<HotelBooking> getAffordable(@ApiPathParam(name = "price")  @PathVariable double price){
        return  bookingRepository.findFirstByPricePerNightIsLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a hotel booking and save it to the database")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
       bookingRepository.save(hotelBooking);

       return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove the hotel booking with the provided ID")
    public List<HotelBooking> remove(@ApiPathParam(name="id")@PathVariable long id){
        bookingRepository.delete(id);

        return bookingRepository.findAll();
    }
}
