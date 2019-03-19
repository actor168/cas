package org.apereo.cas.authentication;


public abstract class BaseActiveDirectoryLdapAuthenticationHandlerTests extends BaseLdapAuthenticationHandlerTests{

    public static final String AD_ADMIN_PASSWORD = "M3110nM3110n#1";

    public static final String AD_LDAP_URL = "ldap://localhost:10390";

    public static final String AD_LDAPS_URL = "ldap://localhost:10636";
/*
    public static final String AD_GC_URL = "ldap://localhost:13268";

    public static final String AD_GCS_URL = "ldap://localhost:13269";*/

    /**
     * Base class for Active Directory Ldap Unit tests for {@link LdapAuthenticationHandler}.
     *
     * @author Hal Deadman
     * @since 6.1.0
     */
    @Override
    protected String getSuccessPassword() {
        return "P@ssw0rd";
    }

    @Override
    protected String[] getPrincipalAttributes() {
        return new String[] {"cn", "sAMAccountName"};
    }

}
