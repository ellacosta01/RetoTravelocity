package com.travelocity.questions;

import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class LaUbicacionDelHotel implements Question<Boolean> {
    String destino;

    public LaUbicacionDelHotel(String destino) {
        this.destino = destino;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> listaUbicaciones =
                HomeConsultaHotelPageObject.LBL_UBICACION_DE_HOTEL.resolveAllFor(actor);
        for (WebElementFacade ubicacionWeb : listaUbicaciones) {
            if (ubicacionWeb.getText().equals(destino)) {
                return true;
            }
        }
        return false;
    }

    public static LaUbicacionDelHotel apareceEnAlMenosUnResultado(String destino) {
        return new LaUbicacionDelHotel(destino);
    }
}
