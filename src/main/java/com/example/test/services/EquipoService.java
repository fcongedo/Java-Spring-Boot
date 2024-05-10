package com.example.test.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.models.Equipo;
import com.example.models.Jugador;


@Service
public class EquipoService implements IService {
	
	public List<Equipo> getTodos(){
		
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