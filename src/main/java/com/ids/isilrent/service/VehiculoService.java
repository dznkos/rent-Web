package com.ids.isilrent.service;

import com.ids.isilrent.model.Vehiculo;
import com.ids.isilrent.repository.JdbcVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class VehiculoService {

    JdbcVehiculoRepository jdbcVehiculoRepository = new JdbcVehiculoRepository();

    //AtomicInteger id = new AtomicInteger();

    /*
    List<Vehiculo> vehiculos = new ArrayList<>(
            Arrays.asList(
                    new Vehiculo(id.getAndIncrement(), "nissan","panc"),
                    new Vehiculo(id.getAndIncrement(), "toyota","corolla"),
                    new Vehiculo(id.getAndIncrement(), "kia","fast"),
                    new Vehiculo(id.getAndIncrement(), "ford","summit"),
                    new Vehiculo(id.getAndIncrement(), "mazda","familia")
            )
    );*/

    public List<Vehiculo> getAll() {
        return jdbcVehiculoRepository.findAll();
    }



    /*
    public void saveProduct(Vehiculo pago) {

        pago.setNumeroPago(numeroPago.incrementAndGet());

        products.add(pago);
    }*/
}
