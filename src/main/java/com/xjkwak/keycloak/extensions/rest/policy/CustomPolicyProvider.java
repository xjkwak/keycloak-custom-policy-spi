package com.xjkwak.keycloak.extensions.rest.policy;

import org.jboss.logging.Logger;
import org.keycloak.authorization.attribute.Attributes;
import org.keycloak.authorization.identity.Identity;
import org.keycloak.authorization.policy.evaluation.Evaluation;
import org.keycloak.authorization.policy.evaluation.EvaluationContext;
import org.keycloak.authorization.policy.provider.PolicyProvider;

public class CustomPolicyProvider implements PolicyProvider {
    private static final String DESCENDANT_DELIMITER = "/";
    private static final Logger log = Logger.getLogger(CustomPolicyProvider.class);

    @Override
    public void evaluate(Evaluation evaluation) {
        EvaluationContext context = evaluation.getContext();
        Identity identity = context.getIdentity();
        Attributes attributes = identity.getAttributes();

        String username = attributes.getValue("preferred_username").asString(0);

        // If the username starts with keycloak we will grant access
        if (username.startsWith("keycloak")) {
            evaluation.grant();
        } else {
            evaluation.deny();
        }
    }

    @Override
    public void close() { }
}
