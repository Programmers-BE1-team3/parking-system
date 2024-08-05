package repositories;

import config.DataUtills;
import domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkRepositoryImpl implements ParkRepository{

    private static final ParkRepositoryImpl instance
            = new ParkRepositoryImpl();
    private ParkRepositoryImpl()    {}
    public static ParkRepositoryImpl getInstance() {
        return instance;
    }

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int update(Car car, int parking_slot_id) {
        int result = 0;

        String sql = "UPDATE park " +
                     "SET car_id = ?, is_parked = TRUE, " +
                     "entrance_time = NOW() " +
                     "WHERE parking_slot_id = ?";

        try {
            conn = DataUtills.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, car.getCar_id());
            ps.setInt(2, parking_slot_id);

            result = ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DataUtills.close(ps, conn);
        }

        return result;
    }

    @Override
    public int updateEntrance(Park park) {
        int result = 0;

        String sql = "UPDATE park " +
                     "SET car_id = ?, is_parked = TRUE, " +
                     "entrance_time = NOW() " +
                     "WHERE parking_slot_id = ?";

        try {
            conn = DataUtills.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, park.getCar_id());
            ps.setInt(2, park.getParking_slot_id());

            result = ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int updateExit(Park park) {
        int result = 0;

        String sql = "UPDATE park " +
                     "SET car_id = ?, is_parked = TRUE, " +
                     "entrance_time = NOW() " +
                     "WHERE parking_slot_id = ?";

        try {
            conn = DataUtills.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, park.getCar_id());
            ps.setInt(2, park.getParking_slot_id());

            result = ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Park selectBySlotId(int id) {
        String sql = "SELECT * FROM park " +
                     "WHERE parking_slot_id = " + id;
        Park park = null;

        try {
            conn = DataUtills.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next())
                park = mapToPark();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DataUtills.close(rs, ps, conn);
        }

        return park;
    }

    @Override
    public List<Park> selectAll() {
        String sql = "SELECT * FROM park";
        List<Park> parks = new ArrayList<>();

        try {
            conn = DataUtills.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next())
                parks.add(mapToPark());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DataUtills.close(rs, ps, conn);
        }

        return parks;
    }

    private Park mapToPark() throws SQLException {
        Park result = new Park();

        int parkingSlotId = rs.getInt("parking_slot_id");
        int car_id = rs.getInt("car_id");

        String is_parked = rs.getString("is_parked").toUpperCase();
        String parking_type = rs.getString("parking_type").toUpperCase();
        String parkable_size = rs.getString("parkable_size").toUpperCase();

        Timestamp entrance = rs.getTimestamp("entrance_time");
        Timestamp departure = rs.getTimestamp("departure_time");

        result.setParking_slot_id(parkingSlotId);
        result.setCar_id(car_id);

        result.setIs_parked(Is_parked.valueOf(is_parked));
        result.setParkingType(ParkingType.valueOf(parking_type));
        result.setParkableSize(ParkableSize.valueOf(parkable_size));

        if (entrance != null)
            result.setEntranceTime(entrance.toLocalDateTime());

        if (departure != null)
            result.setEntranceTime(departure.toLocalDateTime());

        return result;
    }
}
