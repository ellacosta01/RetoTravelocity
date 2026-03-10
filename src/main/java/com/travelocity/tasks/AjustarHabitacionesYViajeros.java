package com.travelocity.tasks;

import com.travelocity.models.HabitacionesEstadia;
import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

public class AjustarHabitacionesYViajeros implements Task {

    private final List<HabitacionesEstadia> listaHabitacionesEstadia;

    public AjustarHabitacionesYViajeros(List<HabitacionesEstadia> listaHabitacionesEstadia) {
        this.listaHabitacionesEstadia = listaHabitacionesEstadia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (HabitacionesEstadia habitacionesEstadia : listaHabitacionesEstadia) {

            if (HomeConsultaHotelPageObject.DIV_HABITACION
                    .of(habitacionesEstadia.getHabitacion())
                    .resolveAllFor(actor).isEmpty()) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_HABITACION));
            }

            int indiceHabitacion = Integer.parseInt(habitacionesEstadia.getHabitacion()) - 1;
            String habitacionIndex = String.valueOf(indiceHabitacion);

            int adultosEsperados = Integer.parseInt(habitacionesEstadia.getAdultos());
            int jovenesEsperados = Integer.parseInt(habitacionesEstadia.getJovenes());

            int adultosActuales = Integer.parseInt(
                    HomeConsultaHotelPageObject.LBL_ADULTOS
                            .of(habitacionIndex).resolveFor(actor).getValue()
            );

            int jovenesActuales = Integer.parseInt(
                    HomeConsultaHotelPageObject.LBL_JOVENES
                            .of(habitacionIndex).resolveFor(actor).getValue()
            );

            while (adultosActuales < adultosEsperados) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_ADULTO.of(habitacionIndex)));
                adultosActuales = Integer.parseInt(
                        HomeConsultaHotelPageObject.LBL_ADULTOS
                                .of(habitacionIndex).resolveFor(actor).getValue()
                );
            }

            while (adultosActuales > adultosEsperados) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_RETIRAR_ADULTO.of(habitacionIndex)));
                adultosActuales = Integer.parseInt(
                        HomeConsultaHotelPageObject.LBL_ADULTOS
                                .of(habitacionIndex).resolveFor(actor).getValue()
                );
            }

            while (jovenesActuales < jovenesEsperados) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_JOVEN.of(habitacionIndex)));
                jovenesActuales = Integer.parseInt(
                        HomeConsultaHotelPageObject.LBL_JOVENES
                                .of(habitacionIndex).resolveFor(actor).getValue()
                );
            }

            while (jovenesActuales > jovenesEsperados) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_RETIRAR_JOVEN.of(habitacionIndex)));
                jovenesActuales = Integer.parseInt(
                        HomeConsultaHotelPageObject.LBL_JOVENES
                                .of(habitacionIndex).resolveFor(actor).getValue()
                );
            }
        }

        actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_VIAJEROS_DONE));
    }

    public static AjustarHabitacionesYViajeros deHotel(List<HabitacionesEstadia> listaHabitacionesEstadia) {
        return Tasks.instrumented(AjustarHabitacionesYViajeros.class, listaHabitacionesEstadia);
    }
}