package com.ids.isilrent.controller;

import com.ids.isilrent.model.Vehiculo;
import com.ids.isilrent.repository.JdbcVehiculoRepository;
import com.ids.isilrent.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehiculoController {

    @Autowired
    JdbcVehiculoRepository jdbcVehiculoRepository;

    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/vehiculos")
    public String getVehiculolist(Model model){
        model.addAttribute("vehiculos", jdbcVehiculoRepository.findAll());
        return "listaautos";
    }

    @GetMapping("/vehiculo/add")
    public String addVehiculo(Model model){
        model.addAttribute("vehiculo", new Vehiculo());
        return "vehiculo-add";
    }

    @PostMapping("/vehiculo/save")
    public String saveVehiculo(Vehiculo vehiculo, Model model){

        jdbcVehiculoRepository.create(vehiculo);
        model.addAttribute("vehiculos", jdbcVehiculoRepository.findAll());
        return "listaautos";
    }

    @GetMapping("/vehiculo/edit/{id}")
    public String getVehiculoForEdit(@PathVariable Integer id,
                                    Model model){
        model.addAttribute("vehiculo",
                jdbcVehiculoRepository.findById(id));
        return "vehiculo-edit";
    }

    @PostMapping("/vehiculo/update/{id}")
    public String updateVehiculo(@PathVariable Integer id, Model model){
        jdbcVehiculoRepository.update(jdbcVehiculoRepository.findById(id));
        model.addAttribute("vehiculos",
                jdbcVehiculoRepository.findAll());
        return "listaautos";
    }
    @GetMapping("/vehiculo/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model){

        jdbcVehiculoRepository.delete(id);
        model.addAttribute("vehiculos", jdbcVehiculoRepository.findAll());
        return "listaautos";
    }

}
