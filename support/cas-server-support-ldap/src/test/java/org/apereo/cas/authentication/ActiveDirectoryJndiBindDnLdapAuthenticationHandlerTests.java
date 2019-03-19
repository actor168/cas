package org.apereo.cas.authentication;

import org.apereo.cas.util.junit.EnabledIfContinuousIntegration;
import org.springframework.test.context.TestPropertySource;

/**
 * Unit test for {@link LdapAuthenticationHandler}.
 * This test demonstrates using the AD type with the JNDI Provider.
 * This allows for a dnFormat that the UnboundID provider would not allow since it is not a valid DN.
 * It isn't clear this is
 * @author Hal Deadman
 * @since 6.1.0
 */
@TestPropertySource(properties = {
    "cas.authn.ldap[0].type=AD",
    "cas.authn.ldap[0].bindDn=CN=Administrator,CN=Users,DC=cas,DC=example,DC=org",
    "cas.authn.ldap[0].bindCredential=" + BaseActiveDirectoryLdapAuthenticationHandlerTests.AD_ADMIN_PASSWORD,
    "cas.authn.ldap[0].ldapUrl=" + BaseActiveDirectoryLdapAuthenticationHandlerTests.AD_LDAP_URL,
    "cas.authn.ldap[0].useSsl=false", // no ssl due to JDK-8217606 so JndiProvider will work
    "cas.authn.ldap[0].useStartTls=false", // no ssl due to JDK-8217606 so JndiProvider will work
    "cas.authn.ldap[0].subtreeSearch=true",
    "cas.authn.ldap[0].baseDn=cn=Users,dc=cas,dc=example,dc=org",
    "cas.authn.ldap[0].dnFormat=%s@cas.example.org",
    "cas.authn.ldap[0].principalAttributeList=sAMAccountName,cn",
    "cas.authn.ldap[0].enhanceWithEntryResolver=true",
    "cas.authn.ldap[0].minPoolSize=0",
    "cas.authn.ldap[0].searchFilter=(userPrincipalName={user})",
    "cas.authn.ldap[0].providerClass=org.ldaptive.provider.jndi.JndiProvider",
    "cas.authn.ldap[0].trustStore=file:/tmp/adcacerts.jks",
    "cas.authn.ldap[0].trustStoreType=JKS",
    "cas.authn.ldap[0].hostnameVerifier=DEFAULT"
    })
@EnabledIfContinuousIntegration
public class ActiveDirectoryJndiBindDnLdapAuthenticationHandlerTests extends BaseActiveDirectoryLdapAuthenticationHandlerTests {

}


