package Backend;

public class Stats {
    private int stats_id,booking_id;//, car_id, car_price;
//    private Date booking_date;
//    private String car_name;


    public Stats(int stats_id, int booking_id) {
        this.stats_id = stats_id;
        this.booking_id = booking_id;
    }

    //getters

    public int getStats_id() {
        return stats_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    // Setters
    public void setStats_id(int stats_id) {
        this.stats_id = stats_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }


    @Override
    public String toString() {
        return "Stats{" +
                "stats_id=" + stats_id +
                ", booking_id=" + booking_id +
                '}';
    }
}
