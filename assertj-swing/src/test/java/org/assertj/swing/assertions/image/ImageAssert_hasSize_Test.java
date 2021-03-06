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
package org.assertj.swing.assertions.image;

import static org.mockito.Mockito.verify;

import java.awt.Dimension;

import org.assertj.swing.assertions.ImageAssert;
import org.assertj.swing.assertions.ImageAssertBaseTest;
import org.junit.BeforeClass;

/**
 * Tests for <code>{@link ImageAssert#hasSize(Dimension)}</code>.
 * 
 * @author Yvonne Wang
 */
public class ImageAssert_hasSize_Test extends ImageAssertBaseTest {

  private static Dimension size;

  @BeforeClass
  public static void beforeOnce() {
    size = new Dimension(6, 8);
  }

  @Override
  protected ImageAssert invoke_api_method() {
    return assertions.hasSize(size);
  }

  @Override
  protected void verify_internal_effects() {
    verify(images).assertHasSize(getInfo(assertions), getActual(assertions), size);
  }
}
