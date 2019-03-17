package org.apereo.cas;

import org.apereo.cas.authentication.ActiveDirectoryBindDnLdapAuthenticationHandlerTests;
import org.apereo.cas.authentication.ActiveDirectoryBindDnSSLLdapAuthenticationHandlerTests;
import org.apereo.cas.authentication.ActiveDirectoryLdapAuthenticationHandlerTests;
import org.apereo.cas.authentication.AuthenticatedLdapAuthenticationHandlerTests;
import org.apereo.cas.authentication.DirectLdapAuthenticationHandlerTests;
import org.apereo.cas.authentication.LdapPasswordSynchronizationAuthenticationPostProcessorTests;
import org.apereo.cas.authentication.principal.PersonDirectoryPrincipalResolverLdaptiveTests;

import org.junit.platform.suite.api.SelectClasses;

/**
 * Test suite to run all LDAP tests.
 *
 * @author Misagh Moayyed
 * @since 4.1.0
 */
@SelectClasses({
    ActiveDirectoryBindDnLdapAuthenticationHandlerTests.class,
    ActiveDirectoryBindDnSSLLdapAuthenticationHandlerTests.class,
    ActiveDirectoryLdapAuthenticationHandlerTests.class,
    AuthenticatedLdapAuthenticationHandlerTests.class,
    PersonDirectoryPrincipalResolverLdaptiveTests.class,
    DirectLdapAuthenticationHandlerTests.class,
    LdapPasswordSynchronizationAuthenticationPostProcessorTests.class
})
public class AllLdapTestsSuite {
}
