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
    "cas.authn.ldap[0].bindDn=Administrator@cas.example.org",
    "cas.authn.ldap[0].bindCredential=" + BaseActiveDirectoryLdapAuthenticationHandlerTests.AD_ADMIN_PASSWORD,
    "cas.authn.ldap[0].ldapUrl=ldap://localhost:10636",
    "cas.authn.ldap[0].useSsl=true",
    "cas.authn.ldap[0].useStartTls=false",
    "cas.authn.ldap[0].subtreeSearch=true",
    "cas.authn.ldap[0].baseDn=dc=cas,dc=example,dc=org",
    "cas.authn.ldap[0].dnFormat=%s@cas.example.org",
    "cas.authn.ldap[0].principalAttributeList=sAMAccountName,cn",
    "cas.authn.ldap[0].enhanceWithEntryResolver=false",
    "cas.authn.ldap[0].minPoolSize=0",
// JndiProvider fails due to: https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8217606
//    "cas.authn.ldap[0].providerClass=org.ldaptive.provider.jndi.JndiProvider",
    "cas.authn.ldap[0].providerClass=org.ldaptive.provider.unboundid.UnboundIDProvider",
    "cas.authn.ldap[0].trustStore=file:/tmp/adcacerts.jks",
    "cas.authn.ldap[0].trustStoreType=JKS",
    "cas.authn.ldap[0].hostnameVerifier=ANY"
    })
@EnabledIfContinuousIntegration
public class ActiveDirectoryBindDnSSLLdapAuthenticationHandlerTests extends BaseActiveDirectoryLdapAuthenticationHandlerTests {

}


