/*
 * Copyright (C) 2022-2023 David C. Harrison. All right reserved.
 *
 * You may not use, distribute, publish, or modify this code without
 * the express written permission of the copyright holder.
 */

package edu.ucsc.cse118.assignment2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.util.HumanReadables
import androidx.test.espresso.util.TreeIterables
import org.hamcrest.Matcher
import java.util.concurrent.TimeoutException

// https://www.repeato.app/espresso-wait-for-view/
fun waitForView(viewId: Int, timeout: Long): ViewAction {
  return object : ViewAction {
    override fun getConstraints(): Matcher<View> {
      return ViewMatchers.isRoot()
    }

    override fun getDescription(): String {
      return "wait for a specific view with id $viewId; during $timeout millis."
    }

    override fun perform(uiController: UiController, rootView: View) {
      uiController.loopMainThreadUntilIdle()
      val startTime = System.currentTimeMillis()
      val endTime = startTime + timeout
      val viewMatcher = ViewMatchers.withId(viewId)

      do {
        // Iterate through all views on the screen and see if the view we are looking for is there already
        for (child in TreeIterables.breadthFirstViewTraversal(rootView)) {
          // found view with required ID
          if (viewMatcher.matches(child)) {
            return
          }
        }
        // Loops the main thread for a specified period of time.
        // Control may not return immediately, instead it'll return after the provided delay has passed and the queue is in an idle state again.
        uiController.loopMainThreadForAtLeast(100)
      } while (System.currentTimeMillis() < endTime) // in case of a timeout we throw an exception -> test fails
      throw PerformException.Builder()
        .withCause(TimeoutException())
        .withActionDescription(this.description)
        .withViewDescription(HumanReadables.describe(rootView))
        .build()
    }
  }
}

fun scrollRecyclerViewTo(text: String) {
  Espresso.onView(ViewMatchers.withId(R.id.recyclerview))
    .perform(
      RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
        ViewMatchers.hasDescendant(ViewMatchers.withText(text))
      )
    )
}

fun assertNotDisplayed(text: String) {
  Espresso.onView(ViewMatchers.withText(text)).check(ViewAssertions.doesNotExist())
}