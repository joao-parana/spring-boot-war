Sample Spring Boot Web Application with JSP
====

Building and running
---

Execute no Terminal:

    mvn clean spring-boot:run

Ou da forma clássica:

    mvn clean package
    ls -la target
    java -jar target/target/spring-boot-war-1.0-SNAPSHOT

> Observação: Na versão mais nova do Spring Boot (1.4.0.RELEASE) o acesso ao JSP retornou erro 404 do HTTP. Para funcionar usei a versão 1.2.7.RELEASE. Veja o segmento do POM

Com erro 404:

```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.RELEASE</version>
        <relativePath/>
    </parent>
```

Sem erro:

```
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.2.7.RELEASE</version>
        <relativePath/>
    </parent>
```

