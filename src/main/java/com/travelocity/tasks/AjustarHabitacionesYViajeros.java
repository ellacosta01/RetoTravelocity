package com.travelocity.tasks;

import com.travelocity.models.HabitacionesEstadia;
import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

public class AjustarHabitacionesYViajeros implements Task {

    List<HabitacionesEstadia> listaHabitacionesEstadia;

    public AjustarHabitacionesYViajeros(List<HabitacionesEstadia> listaHabitacionesEstadia) {
        this.listaHabitacionesEstadia = listaHabitacionesEstadia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (HabitacionesEstadia habitacionesEstadia : listaHabitacionesEstadia) {
            if (HomeConsultaHotelPageObject.DIV_HABITACION.
                    of(habitacionesEstadia.getHabitacion()).resolveAllFor(actor).size() == 0) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_HABITACION));
            }
            // Variable necesaria para algunas parametrizaciones
            String strHabitacionDesdeIndiceCero =
                    Integer.toString(Integer.parseInt(habitacionesEstadia.getHabitacion()) - 1);
            String adultosActualesEnHabitacion = HomeConsultaHotelPageObject.LBL_ADULTOS.
                    of(strHabitacionDesdeIndiceCero).resolveFor(actor).getValue();
            String jovenesActualesEnHabitacion = HomeConsultaHotelPageObject.LBL_JOVENES.
                    of(strHabitacionDesdeIndiceCero).resolveFor(actor).getValue();
            // Agregar adultos si el numero esperado es mayor
            while (Integer.parseInt(adultosActualesEnHabitacion)
                    < Integer.parseInt(habitacionesEstadia.getAdultos())) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_ADULTO.of(strHabitacionDesdeIndiceCero)));
                adultosActualesEnHabitacion = HomeConsultaHotelPageObject.LBL_ADULTOS.
                        of(strHabitacionDesdeIndiceCero).resolveFor(actor).getValue();
            }
            // Retirar adultos si el numero esperado es menor
            while (Integer.parseInt(adultosActualesEnHabitacion)
                    > Integer.parseInt(habitacionesEstadia.getAdultos())) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_RETIRAR_ADULTO.of(strHabitacionDesdeIndiceCero)));
                adultosActualesEnHabitacion = HomeConsultaHotelPageObject.LBL_ADULTOS.
                        of(strHabitacionDesdeIndiceCero).resolveFor(actor).getText();
            }
            // Agregar jovenes si el numero esperado es mayor
            while (Integer.parseInt(jovenesActualesEnHabitacion)
                    < Integer.parseInt(habitacionesEstadia.getJovenes())) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_AGREGAR_JOVEN.of(strHabitacionDesdeIndiceCero)));
                jovenesActualesEnHabitacion = HomeConsultaHotelPageObject.LBL_JOVENES.
                        of(strHabitacionDesdeIndiceCero).resolveFor(actor).getValue();
            }
            // Retirar jovenes si el numero esperado es menor
            while (Integer.parseInt(jovenesActualesEnHabitacion)
                    > Integer.parseInt(habitacionesEstadia.getJovenes())) {
                actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_RETIRAR_JOVEN.of(strHabitacionDesdeIndiceCero)));
                jovenesActualesEnHabitacion = HomeConsultaHotelPageObject.LBL_JOVENES.
                        of(strHabitacionDesdeIndiceCero).resolveFor(actor).getValue();
            }
        }
        actor.attemptsTo(Click.on(HomeConsultaHotelPageObject.BTN_VIAJEROS_DONE));
    }

    public static AjustarHabitacionesYViajeros deHotel(List<HabitacionesEstadia> listaHabitacionesEstadia) {
        return Tasks.instrumented(AjustarHabitacionesYViajeros.class, listaHabitacionesEstadia);
    }
}
