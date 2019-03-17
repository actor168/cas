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
    "cas.authn.ldap[0].ldapUrl=ldap://localhost:10390",
    "cas.authn.ldap[0].useSsl=false",
    "cas.authn.ldap[0].useStartTls=false",
    "cas.authn.ldap[0].subtreeSearch=true",
    "cas.authn.ldap[0].baseDn=cn=Users,dc=cas,dc=example,dc=org",
    "cas.authn.ldap[0].dnFormat=CAS\\\\%s",
    "cas.authn.ldap[0].principalAttributeList=sAMAccountName,cn",
    "cas.authn.ldap[0].enhanceWithEntryResolver=false",
//    "cas.authn.ldap[0].providerClass=org.ldaptive.provider.unboundid.UnboundIDProvider",
    "cas.authn.ldap[0].providerClass=org.ldaptive.provider.jndi.JndiProvider",
    "cas.authn.ldap[0].trustStore=file:/tmp/adcacerts.jks",
    "cas.authn.ldap[0].trustStoreType=JKS",
    "cas.authn.ldap[0].hostnameVerifier=ANY"
})
@EnabledIfContinuousIntegration
public class ActiveDirectorySAMAccountNameLdapAuthenticationHandlerTests extends BaseActiveDirectoryLdapAuthenticationHandlerTests {

    /**
     * This dnFormat can authenticate but it isn't bringing back any attributes.
     */
    @Override
    protected String[] getPrincipalAttributes() {
        return new String[0];
    }

}


