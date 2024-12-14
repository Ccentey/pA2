
package com.example.pA2.controller;
import com.example.pA2.model.Reserva;
import com.example.pA2.repository.ReservaRepository;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    // Mostrar la lista de reservas
    @GetMapping
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "listaReservas";
    }

    // Mostrar el formulario para registrar una nueva reserva
    @GetMapping("/nuevo")
    public String mostrarFormularioDeReserva(Model model) {
         Reserva reserva = new Reserva();
    model.addAttribute("reserva", reserva);
    return "formReserva";
    }

    // Guardar una nueva reserva
    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    // Mostrar el formulario para editar una reserva
    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
      Reserva reserva = reservaRepository.findById(id).orElse(null);
    if (reserva != null) {
        // Formatear la fecha al formato yyyy-MM-dd
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("fechaReservaFormateada", sdf.format(reserva.getFechaReserva()));
    }
    model.addAttribute("reserva", reserva);
    return "formReserva";
    }

    // Actualizar una reserva existente
    @PostMapping("/actualizar")
    public String actualizarReserva(@ModelAttribute Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    // Eliminar una reserva
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaRepository.deleteById(id);
        return "redirect:/reservas";
    }  
    
    
}
