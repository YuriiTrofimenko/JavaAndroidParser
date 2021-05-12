package tyaa.org.socparser;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import android.widget.ListView;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tyaa.org.socparser.entity.CityItem;

/**
 * Created by yurii on 24.08.17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private Integer testItemPos = 20;
    ListView listView = null;
    MainActivity activity = null;
    
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);
            // new ActivityTestRule(MainActivity.class, true, true);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testListView() {
        mActivityRule.getScenario().onActivity(activity -> {
            this.activity = activity;
            listView = activity.findViewById(R.id.listView);
        });
        Preconditions.checkNotNull(listView, "listView is null");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final int count = listView.getAdapter().getCount();
        Preconditions.checkPositionIndex(testItemPos, count, "No testItemPos index " + count + " size");
        CityItem obj = (CityItem)listView.getItemAtPosition(testItemPos);

        onData(anything())
                .inAdapterView(withId(R.id.listView))
                .atPosition(testItemPos)
                .perform(click());
                // Only for widgets inside ScrollView !!!
                //.perform(scrollTo(), click());

        onView(withText(obj.name))
                .inRoot(withDecorView(not(is(/* mActivityRule.getActivity() */activity
                        .getWindow()
                        .getDecorView()))))
                .check(matches(isDisplayed()));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}