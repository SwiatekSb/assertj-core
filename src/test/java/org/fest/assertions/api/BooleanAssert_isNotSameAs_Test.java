/*
 * Created on Oct 22, 2010
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
package org.fest.assertions.api;

import static java.lang.Boolean.*;
import static junit.framework.Assert.assertSame;
import static org.mockito.Mockito.*;

import org.fest.assertions.internal.Objects;
import org.junit.*;

/**
 * Tests for <code>{@link BooleanAssert#isNotSameAs(Boolean)}</code>.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class BooleanAssert_isNotSameAs_Test {

  private Objects objects;
  private BooleanAssert assertions;

  @Before public void setUp() {
    objects = mock(Objects.class);
    assertions = new BooleanAssert(TRUE);
    assertions.objects = objects;
  }

  @Test public void should_verify_that_actual_value_is_not_same_as_expected_value() {
    Boolean expected = FALSE;
    assertions.isNotSameAs(expected);
    verify(objects).assertNotSame(assertions.info, assertions.actual, expected);
  }

  @Test public void should_return_this() {
    BooleanAssert returned = assertions.isNotSameAs(TRUE);
    assertSame(assertions, returned);
  }
}
