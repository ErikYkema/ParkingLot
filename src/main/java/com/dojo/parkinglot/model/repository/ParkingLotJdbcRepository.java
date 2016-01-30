package com.dojo.parkinglot.model.repository;

import com.dojo.parkinglot.model.ParkingLotProperties;
import com.dojo.parkinglot.tools.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.invoke.MethodHandles;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class ParkingLotJdbcRepository implements ParkingLotRepository {
    private final static Logger LOG =
            LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private JdbcTemplate template;
    private SimpleJdbcInsert insert;

    private static final String PROPERTIES_TABLE = "PARKINGLOTPROPERTIES";
    public static final String PARKING_LOT_NAME = "DanielDogShed";

    @Autowired
    ParkingLotProperties properties;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        template = new JdbcTemplate(dataSource);

        insert = new SimpleJdbcInsert(dataSource)
                .withTableName(PROPERTIES_TABLE)
                .usingColumns("name", "genericSize", "electricSize")
                .usingGeneratedKeyColumns("id");

    }

    public enum Feature {
        DROP_AND_CREATE,
        CREATE_TABLES_IF_NEEDED;
    }

    public void setup(Feature feature) {
        switch (feature) {
            case DROP_AND_CREATE:
                try {
                    template.execute("drop table " +PROPERTIES_TABLE);
                } catch (Exception ex) {
                    Exceptions.handle(ex, "X0Y32");
                }
                break;
            default:
                break;
        }

        try {
            template.execute("create table " + PROPERTIES_TABLE + " (id INT GENERATED ALWAYS AS IDENTITY, name VARCHAR(40), genericSize INT, electricSize INT)");
        } catch (Exception ex) {
            Exceptions.handle(ex, "X0Y32");
        }
    }

    public void seed() {
        template.execute("delete table " + PROPERTIES_TABLE);
        properties.setName(PARKING_LOT_NAME);
        properties.setGenericSize(10);
        properties.setGenericSize(3);
    }



    @Override
    public Integer saveProperties(ParkingLotProperties properties) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", properties.getName());
        parameters.put("genericSize", properties.getGenericSize());
        parameters.put("electricSize", properties.getElectricSize());

        Number key = insert.executeAndReturnKey(parameters);
        LOG.debug(String.format("Generated db key: %s", key));
        return key.intValue();
    }

    @Override
    public Collection<ParkingLotProperties> getAllProperties() {
        // TODO implement, as we may not know what the ID is
        return null;
    }

    class PropertiesRowMapper implements RowMapper<ParkingLotProperties> {

        @Override
        public ParkingLotProperties mapRow(ResultSet resultSet, int rowIndex) throws SQLException {
            ParkingLotProperties properties = new ParkingLotProperties();
            LOG.debug(String.format("Id: %s", resultSet.getInt("id")));
            properties.setId(resultSet.getInt("id"));
            properties.setName(resultSet.getString("name"));
            properties.setGenericSize(resultSet.getInt("genericSize"));
            properties.setElectricSize(resultSet.getInt("electricSize"));
            return properties;
        }
    }

    @Override
    public ParkingLotProperties getPropertiesById(int id) {
        return template.queryForObject("select * from " + PROPERTIES_TABLE + " where id=?"
                , new PropertiesRowMapper(), id);
    }

    @Override
    public ParkingLotProperties getPropertiesByName(String name) {
        return template.queryForObject("select * from " + PROPERTIES_TABLE + " where name=?"
                , new PropertiesRowMapper(), name);
    }
}




