package com.ids.isilrent.repository;

import com.ids.isilrent.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcVehiculoRepository
        implements VehiculoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Vehiculo vehiculo) {
        final String sql = "insert into vehiculo(marca, modelo, preciorent) values (?, ?,?)";
        jdbcTemplate.update(sql, vehiculo.getMarca(), vehiculo.getModelo(),vehiculo.getPreciorent());
    }

    @Override
    public void update(Vehiculo vehiculo) {
        final String sql = "update vehiculo set marca = ?, modelo = ?, preciorent = ? where id = ?";
        jdbcTemplate.update(sql, vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getPreciorent(), vehiculo.getId());
    }

    @Override
    public void delete(Integer id) {
        final String sql = "delete vehiculo where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Vehiculo> findAll() {
        final String sql = "select * from vehiculo";
        return jdbcTemplate.query(sql,
                JdbcVehiculoRepository::VehiculoRowMapper);
    }

    @Override
    public Vehiculo findById(Integer id) {
        final String sql = "select * from vehiculo where id = ? ";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcVehiculoRepository::VehiculoRowMapper);
    }

    private static Vehiculo VehiculoRowMapper(ResultSet resultSet, int i) throws SQLException {
        int rsId = resultSet.getInt("id");
        String marca = resultSet.getString("marca");
        String modelo = resultSet.getString("modelo");
        String preciorent = resultSet.getString("preciorent");
        return new Vehiculo(rsId, marca, modelo, preciorent);
    }

}
