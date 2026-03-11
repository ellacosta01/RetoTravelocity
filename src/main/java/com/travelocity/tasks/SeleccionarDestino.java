package com.travelocity.tasks;

import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

public class SeleccionarDestino implements Task {

    private final String destino;

    public SeleccionarDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeConsultaHotelPageObject.BTN_GOING_TO),
                Enter.theValue(destino).into(HomeConsultaHotelPageObject.TXT_DESTINO),
                Hit.the(Keys.ENTER).into(HomeConsultaHotelPageObject.TXT_DESTINO)
        );
    }

    public static SeleccionarDestino deHoteleria(String destino) {
        return Tasks.instrumented(SeleccionarDestino.class, destino);
    }
}