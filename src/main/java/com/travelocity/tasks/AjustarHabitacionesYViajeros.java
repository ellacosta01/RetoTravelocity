package com.travelocity.tasks;

import com.travelocity.models.HabitacionesEstadia;
import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

public class AjustarHabitacionesYViajeros implements Task {

    private final List<HabitacionesEstadia> habitacionesEstadiaList;

    public AjustarHabitacionesYViajeros(List<HabitacionesEstadia> habitacionesEstadiaList) {
        this.habitacionesEstadiaList = habitacionesEstadiaList;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (HabitacionesEstadia habitacion : habitacionesEstadiaList) {
            ensureRoomExists(actor, habitacion);

            String roomIndex = getRoomIndex(habitacion);
            int expectedAdults = Integer.parseInt(habitacion.getAdultos());
            int expectedChildren = Integer.parseInt(habitacion.getJovenes());

            adjustAdults(actor, roomIndex, expectedAdults);
            adjustChildren(actor, roomIndex, expectedChildren);
        }

        actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_VIAJEROS_DONE));
    }

    private <T extends Actor> void ensureRoomExists(T actor, HabitacionesEstadia habitacion) {
        boolean roomExists = !HomeConsultaHotelPageObject.DIV_HABITACION
                .of(habitacion.getHabitacion())
                .resolveAllFor(actor)
                .isEmpty();

        if (!roomExists) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_HABITACION));
        }
    }

    private String getRoomIndex(HabitacionesEstadia habitacion) {
        int roomNumber = Integer.parseInt(habitacion.getHabitacion());
        return String.valueOf(roomNumber - 1);
    }

    private <T extends Actor> void adjustAdults(T actor, String roomIndex, int expectedAdults) {
        int currentAdults = getCurrentAdults(actor, roomIndex);

        while (currentAdults < expectedAdults) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_ADULTO.of(roomIndex)));
            currentAdults = getCurrentAdults(actor, roomIndex);
        }

        while (currentAdults > expectedAdults) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_RETIRAR_ADULTO.of(roomIndex)));
            currentAdults = getCurrentAdults(actor, roomIndex);
        }
    }

    private <T extends Actor> void adjustChildren(T actor, String roomIndex, int expectedChildren) {
        int currentChildren = getCurrentChildren(actor, roomIndex);

        while (currentChildren < expectedChildren) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_JOVEN.of(roomIndex)));
            currentChildren = getCurrentChildren(actor, roomIndex);
        }

        while (currentChildren > expectedChildren) {
            actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_RETIRAR_JOVEN.of(roomIndex)));
            currentChildren = getCurrentChildren(actor, roomIndex);
        }
    }

    private <T extends Actor> int getCurrentAdults(T actor, String roomIndex) {
        return Integer.parseInt(
                HomeConsultaHotelPageObject.LBL_ADULTOS
                        .of(roomIndex)
                        .resolveFor(actor)
                        .getValue()
        );
    }

    private <T extends Actor> int getCurrentChildren(T actor, String roomIndex) {
        return Integer.parseInt(
                HomeConsultaHotelPageObject.LBL_JOVENES
                        .of(roomIndex)
                        .resolveFor(actor)
                        .getValue()
        );
    }

    public static AjustarHabitacionesYViajeros deHotel(List<HabitacionesEstadia> habitacionesEstadiaList) {
        return Tasks.instrumented(AjustarHabitacionesYViajeros.class, habitacionesEstadiaList);
    }
}