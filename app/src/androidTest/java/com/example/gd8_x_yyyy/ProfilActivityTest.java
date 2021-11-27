package com.example.gd8_x_yyyy;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
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
public class ProfilActivityTest {

    @Rule
    public ActivityTestRule<ProfilActivity> mActivityTestRule = new ActivityTestRule<>(ProfilActivity.class);

    @Test
    public void profilActivityTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.etFirstName),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_firstname),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText.perform(replaceText("T"), closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.etLastName),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_lastname),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("T"), closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.etSemester),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_semester),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("0"), closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.etSemester), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_semester),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.etSemester), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_semester),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("10"));

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.etSemester), withText("10"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_semester),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText6.perform(closeSoftKeyboard());

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.etSemester), withText("10"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_semester),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText7.perform(click());

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.etSemester), withText("10"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_semester),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText8.perform(replaceText("7"));

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.etSemester), withText("7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_semester),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText9.perform(closeSoftKeyboard());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.etTanggalLahir),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_tanggallahir),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText10.perform(replaceText("10"), closeSoftKeyboard());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.etTanggalLahir), withText("10"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_tanggallahir),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText11.perform(replaceText("1011009"));

        ViewInteraction textInputEditText12 = onView(
                allOf(withId(R.id.etTanggalLahir), withText("1011009"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_tanggallahir),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText12.perform(closeSoftKeyboard());

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction textInputEditText13 = onView(
                allOf(withId(R.id.etTanggalLahir), withText("1011009"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_tanggallahir),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText13.perform(replaceText("101100"));

        ViewInteraction textInputEditText14 = onView(
                allOf(withId(R.id.etTanggalLahir), withText("101100"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.layout_tanggallahir),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText14.perform(closeSoftKeyboard());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.btn_save), withText("Simpan"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton10.perform(click());
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
}
