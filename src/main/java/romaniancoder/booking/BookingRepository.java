package romaniancoder.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Александр on 29.07.2017.
 */

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking,Long>{

    List<HotelBooking> findFirstByPricePerNightIsLessThan(double price);
}
