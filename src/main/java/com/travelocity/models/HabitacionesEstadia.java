package com.travelocity.models;

public class HabitacionesEstadia {

    private final String habitacion;
    private final String adultos;
    private final String jovenes;

    public HabitacionesEstadia(String habitacion, String adultos, String jovenes) {
        this.habitacion = habitacion;
        this.adultos = adultos;
        this.jovenes = jovenes;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public String getAdultos() {
        return adultos;
    }

    public String getJovenes() {
        return jovenes;
    }
}