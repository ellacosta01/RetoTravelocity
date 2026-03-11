package com.travelocity.questions;

import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class LaUbicacionDelHotel implements Question<Boolean> {

    private final String destino;

    public LaUbicacionDelHotel(String destino) {
        this.destino = destino;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        List<WebElementFacade> ubicaciones =
                HomeConsultaHotelPageObject.LBL_UBICACION_DE_HOTEL.resolveAllFor(actor);

        return ubicaciones.stream()
                .map(WebElementFacade::getText)
                .anyMatch(textoUbicacion -> textoUbicacion.contains(destino));
    }

    public static LaUbicacionDelHotel apareceEnAlMenosUnResultado(String destino) {
        return new LaUbicacionDelHotel(destino);
    }
}