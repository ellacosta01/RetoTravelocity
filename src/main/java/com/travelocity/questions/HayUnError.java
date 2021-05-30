package com.travelocity.questions;

import com.travelocity.pageobjects.HomeConsultaHotelPageObject;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class HayUnError {

    public static Question<Boolean> enElFormularioDeViajeros() {
        return actor ->
                HomeConsultaHotelPageObject.DIV_ERROR_FORMULARIO_VIAJERO.resolveFor(actor).isVisible();
    }

    public static Question<Boolean> enElFormularioDeBusquedaDeHotel() {
        return actor ->
                HomeConsultaHotelPageObject.DIV_ERROR_FORMULARIO_BUSQUEDA_HOTEL.resolveFor(actor).isVisible();
    }

    public static Question<String> conElMensaje() {
        return actor ->
                HomeConsultaHotelPageObject.LBL_ERROR_FORMULARIO_GENERICO.resolveFor(actor).getText();
    }
}
