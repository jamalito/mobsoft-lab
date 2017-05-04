package hu.bme.iemqra.mobsoft.myapplication.test.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import hu.bme.iemqra.mobsoft.myapplication.BuildConfig;
import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.ui.newdrink.NewDrinkPresenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.newdrink.NewDrinkScreen;
import hu.bme.iemqra.mobsoft.myapplication.utils.RobolectricDaggerTestRunner;

/**
 * Created by jamalito on 2017.05.04..
 */
@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class NewDrinkTest {
    public class NewDrink {
        private NewDrinkPresenter newDrinkPresenter;
        private NewDrinkScreen newDrinkScreen;

        @Before
        public void setup() throws Exception {
            setTestInjector();
            newDrinkScreen = mock(NewDrinkScreen.class);
            newDrinkPresenter = new NewDrinkPresenter();
            newDrinkPresenter.attachScreen(newDrinkScreen);
        }

        @Test
        public void testAddNewDrink() {
            newDrinkPresenter.addNewDrink(new hu.bme.iemqra.mobsoft.myapplication.model.api.NewDrink());

            ArgumentCaptor<Drink> DrinkCaptor = ArgumentCaptor.forClass(Drink.class);
            //verify(newDrinkScreen).showNewDrink(DrinkCaptor.capture());
            assertTrue(DrinkCaptor.getValue() != null);
        }

        @After
        public void tearDown() {
            newDrinkPresenter.detachScreen();
        }
    }


}
