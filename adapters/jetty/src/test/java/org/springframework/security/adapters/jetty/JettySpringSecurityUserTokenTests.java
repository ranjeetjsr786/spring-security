/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.adapters.jetty;

import junit.framework.TestCase;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;


/**
 * Tests {@link JettySpringSecurityUserToken}.
 *
 * @author Ben Alex
 * @version $Id:JettySpringSecurityUserTokenTests.java 2151 2007-09-22 11:54:13Z luke_t $
 */
public class JettySpringSecurityUserTokenTests extends TestCase {
    //~ Constructors ===================================================================================================

    public JettySpringSecurityUserTokenTests() {
    }

    public JettySpringSecurityUserTokenTests(String arg0) {
        super(arg0);
    }

    //~ Methods ========================================================================================================

    public void testGetters() throws Exception {
        JettySpringSecurityUserToken token = new JettySpringSecurityUserToken("my_password", "Test", "Password",
                new GrantedAuthority[] {new GrantedAuthorityImpl("ROLE_ONE"), new GrantedAuthorityImpl("ROLE_TWO")});
        assertEquals("Test", token.getPrincipal());
        assertEquals("Password", token.getCredentials());
        assertEquals("my_password".hashCode(), token.getKeyHash());
        assertEquals("Test", token.getName());
    }

    public void testNoArgsConstructor() {
        try {
            new JettySpringSecurityUserToken();
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertTrue(true);
        }
    }
}