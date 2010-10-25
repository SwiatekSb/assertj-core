/*
 * Created on Oct 24, 2010
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2010 the original author or authors.
 */
package org.fest.assertions.internal;

import static org.fest.assertions.test.ExpectedException.none;
import static org.mockito.Mockito.*;

import org.fest.assertions.core.*;
import org.fest.assertions.test.ExpectedException;
import org.junit.*;

/**
 * Tests for <code>{@link Floats#assertIsZero(AssertionInfo, Float)}</code>.
 *
 * @author Alex Ruiz
 */
public class Floats_assertIsZero_Test {

  private static WritableAssertionInfo info;

  @Rule public ExpectedException thrown = none();

  private Comparables comparables;
  private Floats floats;

  @BeforeClass public static void setUpOnce() {
    info = new WritableAssertionInfo();
  }

  @Before public void setUp() {
    comparables = mock(Comparables.class);
    floats = new Floats();
    floats.comparables = comparables;
  }

  @Test public void should_verify_that_actual_is_equal_to_zero() {
    floats.assertIsZero(info, 6f);
    verify(comparables).assertEqual(info, 6f, 0f);
  }
}
