package hu.bme.iemqra.mobsoft.myapplication.interactor.drinks.event;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import java.util.List;
/**
 * Created by jamalito on 2017.04.19..
 */

public class GetDrinksEvent {
    private int code;
    private List<Drink> drink;
    private Throwable throwable;

    public GetDrinksEvent(){
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Drink> getDrink() {
        return drink;
    }

    public void setDrink(List<Drink> drink) {
        this.drink = drink;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }


}
