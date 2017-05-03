package hu.bme.iemqra.mobsoft.myapplication.ui.browse;

import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.model.Drink;

public interface BrowseScreen {
    void showMessage(String text);
    void showDrinks(List<Drink> drinkList);
}
