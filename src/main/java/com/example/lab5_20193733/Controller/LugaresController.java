package com.example.lab5_20193733.Controller;

import com.example.lab5_20193733.Entity.Lugares;
import com.example.lab5_20193733.Repository.LugaresRepository;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LugaresController {

    final LugaresRepository lugaresRepository;

    public LugaresController(LugaresRepository lugaresRepository) {
        this.lugaresRepository = lugaresRepository;
    }

    @GetMapping(value = "/lugares")
    public String listarLugares(Model model) {
        List<Lugares> listaLugares = lugaresRepository.findAll();
        model.addAttribute("listaLugares", listaLugares);
        return "lista-lugares";
    }

    @GetMapping(value = "/lugares/nuevo")
    public String crearLugar(Model model) {
        return "nuevo-lugar";
    }

    @GetMapping(value = "/lugares/borrar")
    public String borrarLugar(Integer id) {
        if (lugaresRepository.findById(id).isPresent()) {
            lugaresRepository.deleteById(id);
        }
        return "redirect:/lugares";
    }

    @GetMapping(value = "/lugares/guardar")
    public String guardarLugar(Lugares lugares) {
        lugaresRepository.save(lugares);
        return "redirect:/lugares";
    }
}