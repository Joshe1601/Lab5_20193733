package com.example.lab5_20193733.Controller;


import com.example.lab5_20193733.Entity.Viajes;
import com.example.lab5_20193733.Repository.LugaresRepository;
import com.example.lab5_20193733.Repository.MascotasRepository;
import com.example.lab5_20193733.Repository.PersonaRepository;
import com.example.lab5_20193733.Repository.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViajesController {

    final ViajesRepository viajesRepository;
    final PersonaRepository personaRepository;
    final MascotasRepository mascotasRepository;
    final LugaresRepository lugaresRepository;

    public ViajesController(ViajesRepository viajesRepository, PersonaRepository personaRepository, MascotasRepository mascotasRepository, LugaresRepository lugaresRepository) {
        this.viajesRepository = viajesRepository;
        this.personaRepository = personaRepository;
        this.mascotasRepository = mascotasRepository;
        this.lugaresRepository = lugaresRepository;
    }

    @GetMapping(value = {"/", "/viajes"})
    public String listarViajes(Model model) {

        List<Viajes> listaViajes = viajesRepository.findAll();
        model.addAttribute("listaViajes", listaViajes);
        return "lista-viajes";
    }

    @GetMapping(value = "/viajes/nuevo")
    public String crearViaje(Model model) {
        model.addAttribute("listaPersonas", personaRepository.findAll());
        model.addAttribute("listaLugares", lugaresRepository.findAll());
        return "nuevo-viaje";
    }

    @GetMapping(value = "/viajes/borrar")
    public String borrarViaje(Integer id) {

        if (viajesRepository.findById(id).isPresent()) {
            viajesRepository.deleteById(id);
        }
        return "redirect:/viajes";
    }

    @GetMapping(value = "/viajes/guardar")
    public String guardarViaje(Viajes viajes) {
        viajesRepository.save(viajes);
        return "redirect:/viajes";
    }





}
