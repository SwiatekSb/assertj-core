/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.core.api.offsettime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.time.OffsetTime;
import java.time.ZoneOffset;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Only test String based assertion (tests with {@link java.time.OffsetTime} are already defined in assertj-core)
 *
 * @author Joel Costigliola
 * @author Marcin Zajączkowski
 */
@RunWith(Theories.class)
public class OffsetTimeAssert_isIn_Test extends OffsetTimeAssertBaseTest {

  @Theory
  public void test_isIn_assertion(OffsetTime referenceTime) {
    // WHEN
    assertThat(referenceTime).isIn(referenceTime, referenceTime.plusHours(1));
    assertThat(referenceTime).isIn(referenceTime.toString(), referenceTime.plusHours(1).toString());
    // THEN
    verify_that_isIn_assertion_fails_and_throws_AssertionError(referenceTime);
  }

  @Test
  public void test_isIn_assertion_error_message() {
    thrown.expectAssertionError("%n" +
                                "Expecting:%n" +
                                " <03:00:05Z>%n" +
                                "to be in:%n" +
                                " <[03:03:03Z]>%n");
    assertThat(OffsetTime.of(3, 0, 5, 0, ZoneOffset.UTC)).isIn("03:03:03Z");
  }

  @Test
  public void should_fail_if_offsetTimes_as_string_array_parameter_is_null() {
    expectException(IllegalArgumentException.class, "The given OffsetTime array should not be null");
    assertThat(OffsetTime.now()).isIn((String[]) null);
  }

  @Test
  public void should_fail_if_offsetTimes_as_string_array_parameter_is_empty() {
    expectException(IllegalArgumentException.class, "The given OffsetTime array should not be empty");
    assertThat(OffsetTime.now()).isIn(new String[0]);
  }

  private static void verify_that_isIn_assertion_fails_and_throws_AssertionError(OffsetTime reference) {
    try {
      assertThat(reference).isIn(reference.plusHours(1).toString(), reference.plusHours(2).toString());
    } catch (AssertionError e) {
      // AssertionError was expected
      return;
    }
    fail("Should have thrown AssertionError");
  }

}
