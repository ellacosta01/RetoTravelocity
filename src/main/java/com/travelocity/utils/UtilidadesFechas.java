package com.travelocity.utils;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class UtilidadesFechas {

    public static boolean estaLaFechaPresente(List<WebElementFacade> listaFechas, String fechaEsperada) {
        return listaFechas.stream()
                .anyMatch(fecha -> fecha.getText().equals(fechaEsperada));
    }
}