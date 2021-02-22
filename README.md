# Payara(micro) OpenAPI enum with Schema annotation

---

This project is built with: `mvn package`.

To run it, download the payara-micro.jar (`mvn dependency:copy@download-payara`), and run it like this 

```
java -jar target/payara-micro.jar --deploy target/openapi-enum-schema-1.0-SNAPSHOT.war 
```
and access http://localhost:8080/openapi, This produces a stack trace on the payara console.

---

This exposes 2 problems with `enum` and `@Schema` when generating `openapi` documentation.

1. When a `enum` is annotated with `@Schema` api generation fails.
   * If the `@Schema` is removed from `ErrorCode.java` documentation is generated
1. When api is generated from an `enum` type, constants are included as values.
   * When `@Schema` is removed from `ErrorCode.java` you would expect this output
   ```
    ErrorCode:
      enum:
      - NOT_GOOD
      - BAD
      - REALLY_BAD
   ```
   but the `public static final String NAME` in also included, ie.
   ```
    ErrorCode:
      enum:
      - NOT_GOOD
      - BAD
      - REALLY_BAD
      - NAME
    ```
