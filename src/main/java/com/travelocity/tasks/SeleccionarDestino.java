package com.travelocity.tasks;

import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.Keys;

public class SeleccionarDestino {
    public static Task deHoteleria(String destino){
        return Task.where("{0} selecciona un destino de hoteleria",
                Click.on(HomeConsultaHotelPageObject.BTN_GOING_TO),
                Enter.theValue(destino).into(HomeConsultaHotelPageObject.TXT_DESTINO),
                Hit.the(Keys.ENTER).into(HomeConsultaHotelPageObject.TXT_DESTINO));
    }
}
