package hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;

/**
 * Created by jamalito on 2017.04.19..
 */

public class AddDrinkEvent {
    private int code;
    private Drink drink;
    private Throwable throwable;

    public AddDrinkEvent() {
    }

    public AddDrinkEvent(int code, Drink drink, Throwable throwable) {
        this.code = code;
        this.drink = drink;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
