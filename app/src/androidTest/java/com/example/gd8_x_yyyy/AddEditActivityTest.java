package com.example.gd8_x_yyyy;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.gd8_x_yyyy.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddEditActivityTest {

    @Rule
    public ActivityTestRule<AddEditActivity> mActivityTestRule = new ActivityTestRule<>(AddEditActivity.class);

    @Test
    public void addEditActivityTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton.perform(click());

        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.et_nama),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_nama),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText.perform(replaceText("Vito Carlen Giovanni"), closeSoftKeyboard());



        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton2.perform(click());

        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.et_npm),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("19"), closeSoftKeyboard());



        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton3.perform(click());

        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.et_npm), withText("19"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText3.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.et_npm), withText("19"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("190710181"));

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.et_npm), withText("190710181"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText5.perform(closeSoftKeyboard());



        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton4.perform(click());

        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.et_npm), withText("190710181"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText6.perform(click());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.et_npm), withText("190710181"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText7.perform(replaceText("1907101815"));

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.et_npm), withText("1907101815"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText8.perform(closeSoftKeyboard());



        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton5.perform(click());

        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.et_npm), withText("1907101815"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText9.perform(click());

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.et_npm), withText("1907101815"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText10.perform(replaceText("190710181"));

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.et_npm), withText("190710181"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText11.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText12 = onView(
                allOf(withId(R.id.et_npm), withText("190710181"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText12.perform(click());

        ViewInteraction textInputEditText13 = onView(
                allOf(withId(R.id.et_npm), withText("190710181"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText13.perform(replaceText("230710181"));

        ViewInteraction textInputEditText14 = onView(
                allOf(withId(R.id.et_npm), withText("230710181"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_npm),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText14.perform(closeSoftKeyboard());



        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton6.perform(click());

        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction materialAutoCompleteTextView = onView(
                allOf(withId(R.id.ed_fakultas),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_prodi),
                                        0),
                                1),
                        isDisplayed()));
        materialAutoCompleteTextView.perform(click());

        onView(withText("FTI"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton7.perform(click());

        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction materialAutoCompleteTextView2 = onView(
                allOf(withId(R.id.ed_prodi),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_description),
                                        0),
                                1),
                        isDisplayed()));
        materialAutoCompleteTextView2.perform(click());

        onView(withText("Informatika"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton8.perform(click());

        onView(isRoot()).perform(waitFor(3000));

        ViewInteraction materialAutoCompleteTextView3 = onView(
                allOf(withId(R.id.ed_jenis_kelamin),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_jenis_kelamin),
                                        0),
                                1),
                        isDisplayed()));
        materialAutoCompleteTextView3.perform(click());

        onView(withText("Laki-laki"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        materialButton9.perform(click());

        onView(isRoot()).perform(waitFor(3000));
    }

    private static Matcher<View> childAtPosition(

            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public static ViewAction waitFor(long delay) {
        return new ViewAction() {
            @Override public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override public String getDescription() {
                return "wait for " + delay + "milliseconds";
            }

            @Override public void perform(UiController uiController, View view) {
                uiController.loopMainThreadForAtLeast(delay);
            }
        };
    }
}
