package org.apereo.cas.authentication;

import org.apereo.cas.util.junit.EnabledIfContinuousIntegration;
import org.springframework.test.context.TestPropertySource;

/**
 * Unit test for {@link LdapAuthenticationHandler}.
 *
 * @author Hal Deadman
 * @since 6.1.0
 */
@TestPropertySource(properties = {
    "cas.authn.ldap[0].type=AD",
    "cas.authn.ldap[0].bindDn=CN=Administrator,CN=Users,DC=cas,DC=example,DC=org",
    "cas.authn.ldap[0].bindCredential=" + BaseActiveDirectoryLdapAuthenticationHandlerTests.AD_ADMIN_PASSWORD,
    "cas.authn.ldap[0].ldapUrl=ldap://localhost:10390",
    "cas.authn.ldap[0].useSsl=false", // no ssl due to JDK-8217606 so JndiProvider will work
    "cas.authn.ldap[0].useStartTls=false", // no ssl due to JDK-8217606 so JndiProvider will work
    "cas.authn.ldap[0].subtreeSearch=true",
    "cas.authn.ldap[0].baseDn=cn=Users,dc=cas,dc=example,dc=org",
    "cas.authn.ldap[0].dnFormat=%s@cas.example.org",
    "cas.authn.ldap[0].principalAttributeList=sAMAccountName,cn",
    "cas.authn.ldap[0].enhanceWithEntryResolver=true", // must be true based on dnFormat not being RDN
    "cas.authn.ldap[0].minPoolSize=0",
    "cas.authn.ldap[0].searchFilter=(sAMAccountName={user})",
// JndiProvider fails in ssl due to: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8217606
    "cas.authn.ldap[0].providerClass=org.ldaptive.provider.jndi.JndiProvider",
// This test fails with UnboundIDProvider due to Unable to parse string 'admin@cas.example.org' as a DN because it does not have an equal sign after RDN attribute 'admin@cas.example.org'
//    "cas.authn.ldap[0].providerClass=org.ldaptive.provider.unboundid.UnboundIDProvider",
    "cas.authn.ldap[0].trustStore=file:/tmp/adcacerts.jks",
    "cas.authn.ldap[0].trustStoreType=JKS",
    "cas.authn.ldap[0].hostnameVerifier=DEFAULT"
    })
@EnabledIfContinuousIntegration
public class ActiveDirectoryBindDnLdapAuthenticationHandlerTests extends BaseActiveDirectoryLdapAuthenticationHandlerTests {

}


