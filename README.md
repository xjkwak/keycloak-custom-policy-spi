# Custom Policy SPI

This is a custom policy SPI sample

## Build
```sh
mvn clean compile package
```

## Deploying the SPI
To use this SPI in your Keycloak service, mount the output jar (`custom-policy-spi-1.0.0.jar`) to `/opt/jboss
/keycloak/standalone/deployments/custom-policy-spi-1.0.0.jar` 
Restarting Keycloak should not be necessary.

## Using the SPI
### Creating the Descendant Group Policy
It is only possible through the following endpoint:

```sh
curl --location --request POST 'http://localhost:8080/auth/admin/realms/myrealm/clients/1d7fe657-0184-4449-afe1
-44146776c6b9/authz/resource-server/policy' \
--header 'Authorization: Bearer eyJ...' \
--header 'Content-Type: application/json' \
--data-raw '{"name":"My custom policy enforcer","type":"customPolicy"}'
```
Where: `1d7fe657-0184-4449-afe1-44146776c6b9` is the uuid of the realm client which contains the Authorization
 configuration