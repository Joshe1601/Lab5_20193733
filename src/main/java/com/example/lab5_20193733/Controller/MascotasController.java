package com.example.lab5_20193733.Controller;


import com.example.lab5_20193733.Entity.Mascotas;
import com.example.lab5_20193733.Repository.MascotasRepository;
import com.example.lab5_20193733.Repository.PersonaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MascotasController {

    final MascotasRepository mascotasRepository;
    final PersonaRepository personaRepository;

    public MascotasController(MascotasRepository mascotasRepository, PersonaRepository personaRepository) {
        this.mascotasRepository = mascotasRepository;
        this.personaRepository = personaRepository;
    }

    @GetMapping(value = "/mascotas")
    public String listarMascotas(Model model) {

        List<Mascotas> listaMascotas = mascotasRepository.findAll();
        model.addAttribute("listaMascotas", listaMascotas);
        return "lista-mascotas";
    }

    @GetMapping(value = "/mascotas/nuevo")
    public String crearMascota(Model model) {
        model.addAttribute("listaPersonas", personaRepository.findAll());
        return "nueva-mascota";
    }

    @GetMapping(value = "/mascotas/borrar")
    public String borrarMascota(Integer id) {

        if (mascotasRepository.findById(id).isPresent()) {
            mascotasRepository.deleteById(id);
        }
        return "redirect:/mascotas";
    }

}
