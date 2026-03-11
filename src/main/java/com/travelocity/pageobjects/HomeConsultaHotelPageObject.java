package com.travelocity.pageobjects;

import net.serenitybdd.screenplay.targets.Target;

public class HomeBusquedaHotelPage {

    private HomeBusquedaHotelPage() {
    }

    // Destino
    public static final Target BTN_DESTINATION_MENU =
            Target.the("Destination menu button")
                    .locatedBy("//button[@data-stid='location-field-destination-menu-trigger']");

    public static final Target TXT_DESTINATION =
            Target.the("Destination input field")
                    .locatedBy("//input[@id='location-field-destination']");

    // Fechas
    public static final Target BTN_CHECK_IN =
            Target.the("Check-in button")
                    .locatedBy("//button[@id='d1-btn']");

    public static final Target BTN_CHECK_OUT =
            Target.the("Check-out button")
                    .locatedBy("//button[@id='d2-btn']");

    public static final Target LBL_CALENDAR_MONTH_YEAR =
            Target.the("Calendar month and year label")
                    .locatedBy("//h2[@class='uitk-date-picker-month-name uitk-type-medium']");

    public static final Target BTN_CALENDAR_DAY =
            Target.the("Calendar day button")
                    .locatedBy("//button[@aria-label='{0}']");

    public static final Target BTN_NEXT_MONTH =
            Target.the("Next month button")
                    .locatedBy("//button[@data-stid='date-picker-paging'][2]");

    public static final Target BTN_APPLY_DATES =
            Target.the("Apply selected dates button")
                    .locatedBy("//button[@data-stid='apply-date-picker']");

    // Viajeros y habitaciones
    public static final Target BTN_TRAVELERS =
            Target.the("Travelers button")
                    .locatedBy("//button[@data-testid='travelers-field-trigger']");

    public static final Target DIV_ROOM_SECTION =
            Target.the("Room section")
                    .locatedBy("//div[contains(@data-testid,'room-{0}')]");

    public static final Target BTN_ADD_ROOM =
            Target.the("Add room button")
                    .locatedBy("//button[@data-testid='add-room-button']");

    public static final Target INPUT_ADULTS =
            Target.the("Adults input")
                    .locatedBy("//input[@id='adult-input-{0}']");

    public static final Target INPUT_CHILDREN =
            Target.the("Children input")
                    .locatedBy("//input[@id='child-input-{0}']");

    public static final Target BTN_ADD_ADULT =
            Target.the("Add adult button")
                    .locatedBy("//label[contains(@for,'adult-input-{0}')]/following-sibling::div/button[2]");

    public static final Target BTN_REMOVE_ADULT =
            Target.the("Remove adult button")
                    .locatedBy("//label[contains(@for,'adult-input-{0}')]/following-sibling::div/button[1]");

    public static final Target BTN_ADD_CHILD =
            Target.the("Add child button")
                    .locatedBy("//label[contains(@for,'child-input-{0}')]/following-sibling::div/button[2]");

    public static final Target BTN_REMOVE_CHILD =
            Target.the("Remove child button")
                    .locatedBy("//label[contains(@for,'child-input-{0}')]/following-sibling::div/button[1]");

    public static final Target BTN_APPLY_TRAVELERS =
            Target.the("Apply travelers button")
                    .locatedBy("//button[@data-testid='guests-done-button']");

    // Búsqueda
    public static final Target BTN_SEARCH_HOTEL =
            Target.the("Search hotel button")
                    .locatedBy("//button[@data-testid='submit-button']");

    // Resultados
    public static final Target LBL_HOTEL_LOCATION =
            Target.the("Hotel location label")
                    .locatedBy("//div[@data-test-id='content-hotel-neighborhood']");

    // Errores
    public static final Target DIV_TRAVELER_FORM_ERROR =
            Target.the("Traveler form error container")
                    .locatedBy("//div[contains(@aria-label,'Traveler')]/descendant::div[@data-testid='lob-error-summary']");

    public static final Target LBL_GENERIC_FORM_ERROR =
            Target.the("Generic form error message")
                    .locatedBy("//div[@data-testid='lob-error-summary']/descendant::h3");

    public static final Target DIV_HOTEL_SEARCH_FORM_ERROR =
            Target.the("Hotel search form error container")
                    .locatedBy("//form[contains(@id,'wizard-hotel-pwa-v2-1')]/descendant::div[@data-testid='lob-error-summary']");
}