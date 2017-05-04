package hu.bme.iemqra.mobsoft.myapplication.test.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.BuildConfig;
import hu.bme.iemqra.mobsoft.myapplication.utils.RobolectricDaggerTestRunner;
import hu.bme.iemqra.mobsoft.myapplication.ui.browse.BrowsePresenter;
import hu.bme.iemqra.mobsoft.myapplication.ui.browse.BrowseScreen;

import static hu.bme.iemqra.mobsoft.myapplication.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BrowseTest {
    @RunWith(RobolectricDaggerTestRunner.class)
    @Config(constants = BuildConfig.class, sdk = 21)
    public class MainTest {
        private BrowsePresenter browsePresenter;
        private BrowseScreen browseScreen;

        @Before
        public void setup() throws Exception {
            setTestInjector();
            browseScreen = mock(BrowseScreen.class);
            browsePresenter = new BrowsePresenter();
            browsePresenter.attachScreen(browseScreen);
        }

        @Test
        public void testRefreshRecipes() {
            browsePresenter.refreshDrinks();

            ArgumentCaptor<List> drinksCaptor = ArgumentCaptor.forClass(List.class);
            verify(browseScreen).showDrinks(drinksCaptor.capture());
            assertTrue(drinksCaptor.getValue().size() > 0);
        }

        @After
        public void tearDown() {
            browsePresenter.detachScreen();
        }
    }
}
