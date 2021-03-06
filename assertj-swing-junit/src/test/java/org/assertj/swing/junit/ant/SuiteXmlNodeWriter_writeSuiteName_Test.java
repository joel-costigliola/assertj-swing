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
package org.assertj.swing.junit.ant;

import static org.apache.tools.ant.taskdefs.optional.junit.XMLConstants.ATTR_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.junit.xml.XmlAttribute.name;
import static org.easymock.EasyMock.expectLastCall;

import org.apache.tools.ant.taskdefs.optional.junit.JUnitTest;
import org.fest.mocks.EasyMockTemplate;
import org.junit.Test;

/**
 * Tests for <code>{@link SuiteXmlNodeWriter#writeSuiteName(org.assertj.swing.junit.xml.XmlNode, JUnitTest)}</code>.
 * 
 * @author Alex Ruiz
 */
public class SuiteXmlNodeWriter_writeSuiteName_Test extends SuiteXmlNodeWriter_TestCase {

  @Test
  public void should_Write_Suite_Name_As_Attribute() {
    final JUnitTest suite = new JUnitTest("Hello");
    new EasyMockTemplate(targetNode) {
      @Override
      protected void expectations() throws Exception {
        targetNode.addAttribute(name(ATTR_NAME).value("Hello"));
        expectLastCall().once();
      }

      @Override
      protected void codeToTest() {
        assertThat(writer.writeSuiteName(targetNode, suite)).isSameAs(writer);
      }
    }.run();
  }

  @Test
  public void should_Write_Word_Unknown_As_Attribute_If_Suite_Does_Not_Have_Name() {
    final JUnitTest suite = new JUnitTest(null);
    new EasyMockTemplate(targetNode) {
      @Override
      protected void expectations() throws Exception {
        targetNode.addAttribute(name(ATTR_NAME).value("unknown"));
      }

      @Override
      protected void codeToTest() {
        assertThat(writer.writeSuiteName(targetNode, suite)).isSameAs(writer);
      }
    }.run();
  }

}
