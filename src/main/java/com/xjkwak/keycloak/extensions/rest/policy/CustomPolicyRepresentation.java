package com.xjkwak.keycloak.extensions.rest.policy;

import org.jboss.logging.Logger;
import org.keycloak.representations.idm.authorization.GroupPolicyRepresentation;

public class CustomPolicyRepresentation extends GroupPolicyRepresentation {
    private static final Logger log = Logger.getLogger(CustomPolicyRepresentation.class);

    public CustomPolicyRepresentation() {
        log.debugf("A %s is being created", this.getClass().getSimpleName());
    }

    public String getType() {
        log.debugf("Getting the type of %s", this.getClass().getSimpleName());
        return "customPolicy";
    }
}