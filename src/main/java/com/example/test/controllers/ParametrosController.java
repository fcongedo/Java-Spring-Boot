package com.example.test.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Equipo;
import com.example.models.Jugador;

@Controller
public class ParametrosController {

	@GetMapping("/parametros")

	public String parametros(@RequestParam(defaultValue = "") String valor,
			@RequestParam(defaultValue = "", name = "valor_dos") String otroValor, Model model) {
		model.addAttribute("titulo", "Parametros");
		model.addAttribute("parametro", valor);
		model.addAttribute("otroValor", otroValor);

		return "parametros";
	}

	@GetMapping("/equipos/{nombre}/{numero}")
	public String parametrosPorPath(@PathVariable String nombre, @PathVariable("numero") Integer numero, Model model) {

		Optional<Equipo> equipoOptional = getEquipos().stream()
				.filter(equipo -> nombre.toLowerCase().equals(equipo.getNombreEquipo().toLowerCase())).findFirst();

		if (equipoOptional.isPresent()) {
			Optional<Jugador> jugadorOptional = equipoOptional.get().getPlantilla().stream()
					.filter(jugador -> numero == jugador.getNumero()).findFirst();
			if (jugadorOptional.isPresent()) {
				model.addAttribute("jugador", jugadorOptional.get());

			}
		}
		return "parametros";
	}

	private List<Equipo> getEquipos() {
		Equipo barcelona = new Equipo();
		barcelona.setNombreEquipo("Barcelona");
		barcelona.addJugador(new Jugador("TER STEGENT", 1));
		barcelona.addJugador(new Jugador("ARAJO", 4));
		barcelona.addJugador(new Jugador("BUSQUETS", 5));
		barcelona.addJugador(new Jugador("DEMBELE", 7));
		barcelona.addJugador(new Jugador("LEWANDOSKI", 9));

		Equipo realMadrid = new Equipo();
		realMadrid.setNombreEquipo("RealMadrid");
		realMadrid.addJugador(new Jugador("COURTOIS", 1));
		realMadrid.addJugador(new Jugador("CARVAJAL", 4));
		realMadrid.addJugador(new Jugador("MODRIC", 10));
		realMadrid.addJugador(new Jugador("HAZARD", 7));
		realMadrid.addJugador(new Jugador("BENZEMA", 9));

		return List.of(barcelona, realMadrid);

	}
}
