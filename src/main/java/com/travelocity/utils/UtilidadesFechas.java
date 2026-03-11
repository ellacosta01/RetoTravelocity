package com.travelocity.utils;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class UtilidadesFechas {

    private UtilidadesFechas() {
    }

    public static boolean estaLaFechaPresente(List<WebElementFacade> listaFechas, String fechaEsperada) {
        return listaFechas.stream()
                .map(WebElementFacade::getText)
                .anyMatch(fechaEsperada::equals);
    }
}