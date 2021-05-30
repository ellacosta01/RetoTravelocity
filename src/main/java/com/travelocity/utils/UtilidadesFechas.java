package com.travelocity.utils;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class UtilidadesFechas {

    public static boolean estaLaFechaPresente(List<WebElementFacade> listaFechas, String fechaEsperada) {
        return listaFechas.get(0).getText().equals(fechaEsperada) ||
                listaFechas.get(1).getText().equals(fechaEsperada);
    }
}
