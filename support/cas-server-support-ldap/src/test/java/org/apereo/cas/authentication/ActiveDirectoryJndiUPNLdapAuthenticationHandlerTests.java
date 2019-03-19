package org.apereo.cas.authentication;

import org.apereo.cas.util.junit.EnabledIfContinuousIntegration;
import org.springframework.test.context.TestPropertySource;

/**
 * Unit test for {@link LdapAuthenticationHandler}.
 * This test uses the JNDIProvider and type AD where the user logs in with the userPrincipalName attribute.
 * The UnboundIDProvider would fail this due to its DN validation.
 * This test currently uses no SSL or startTls due to bug JDK-8217606, turn on startTls once it is fixed.
 * @author Hal Deadman
 * @since 6.1.0
 */
@TestPropertySource(properties = {
    "cas.authn.ldap[0].type=AD",
    "cas.authn.ldap[0].ldapUrl=" + BaseActiveDirectoryLdapAuthenticationHandlerTests.AD_LDAP_URL,
    "cas.authn.ldap[0].useSsl=false",
    "cas.authn.ldap[0].useStartTls=false",
    "cas.authn.ldap[0].subtreeSearch=true",
    "cas.authn.ldap[0].baseDn=cn=Users,dc=cas,dc=example,dc=org",
    //"cas.authn.ldap[0].dnFormat=%s@cas.example.org",
    "cas.authn.ldap[0].dnFormat=userPrincipalName=%s,cn=Users,dn=@cas.example.org",
    "cas.authn.ldap[0].principalAttributeList=sAMAccountName,cn",
    "cas.authn.ldap[0].enhanceWithEntryResolver=true",
    "cas.authn.ldap[0].searchFilter=(sAMAccountName={user})",
    "cas.authn.ldap[0].minPoolSize=0",
    "cas.authn.ldap[0].providerClass=org.ldaptive.provider.jndi.JndiProvider",
    "cas.authn.ldap[0].trustStore=file:/tmp/adcacerts.jks",
    "cas.authn.ldap[0].trustStoreType=JKS",
    "cas.authn.ldap[0].hostnameVerifier=ANY"
})
@EnabledIfContinuousIntegration
public class ActiveDirectoryJndiUPNLdapAuthenticationHandlerTests extends BaseActiveDirectoryLdapAuthenticationHandlerTests {

    /**
     * This dnFormat can authenticate but it isn't bringing back any attributes.
     */
    @Override
    protected String[] getPrincipalAttributes() {
        return new String[0];
    }

}


