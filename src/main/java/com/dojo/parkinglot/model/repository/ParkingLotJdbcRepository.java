package com.dojo.parkinglot.model.repository;

import com.dojo.parkinglot.model.ParkingLotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
// TODO find 4.2.4 spring alternative for simplejdbctemplate
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class ParkingLotJdbcRepository implements ParkingLotRepository {

    //private SimpleJdbcTemplate template;
    private SimpleJdbcInsert insert;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        //template = new SimpleJdbcTemplate(dataSource);

        insert = new SimpleJdbcInsert(dataSource)
                .withTableName("\"ParkingLotProperties\"")
                .usingColumns("name", "genericSize", "electricSize")
                .usingGeneratedKeyColumns("id");

    }

    @Override
    public Integer saveProperties(ParkingLotProperties properties) {
//        @Override
//        public Integer save(Person person) {
//
//            Map<String, Object> parameters = new HashMap<String, Object>();
//            parameters.put("name", person.getName());
//            parameters.put("email", person.getEmail());
//            return (Integer) insert.executeAndReturnKey(parameters);
//        }
        return null;
    }

    @Override
    public Collection<ParkingLotProperties> getAllProperties() {
        return null;
    }

    class PropertiesRowMapper implements RowMapper<ParkingLotProperties> {

        @Override
        public ParkingLotProperties mapRow(ResultSet resultSet, int rowIndex) throws SQLException {
            ParkingLotProperties properties = new ParkingLotProperties();
            properties.setId(resultSet.getInt("id"));
            properties.setName(resultSet.getString("name"));
            properties.setGenericSize(resultSet.getInt("genericSize"));
            properties.setElectricSize(resultSet.getInt("electricSize"));
            return properties;
        }
    }

    @Override
    public ParkingLotProperties getPropertiesById(int id) {
        return null;
//        return template.queryForObject("select * from \"ParkingLotProperties\" where id=?"
//                , new PropertiesRowMapper(), id);
    }
}




