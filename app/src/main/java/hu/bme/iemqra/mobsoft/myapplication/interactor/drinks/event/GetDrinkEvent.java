package hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event;

import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;

/**
 * Created by jamalito on 2017.05.04..
 */

public class GetDrinkEvent {
    private int code;
    private Drink drink;
    private Throwable throwable;

    public GetDrinkEvent() {
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
