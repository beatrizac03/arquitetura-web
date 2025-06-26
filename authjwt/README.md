# 🛡️ AuthJWT API

API SpringBoot de autenticação com JWT. Inclui integração com banco de dados em memória H2, documentação via Swagger e testes de carga com Apache JMeter.

---

## ✅ Requisitos para executar
- Java 17+
- Maven 3.6+
- H2 Driver
- IDE (ex: IntelliJ, VSCode ou Eclipse)
- Extensões VSCode: SpringBoot Extension Pack, Java Extension Pack

---

## 🚀 Como clonar o projeto

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

---

## Executar aplicação
1. Usar Maven
```bash
mvn spring-boot:run
```

2. Rodar na IDE
    - Localize a classe com @SpringBootApplication e clique no botão  "Run" / "▶️"

3. Springboot Dashboard Extension

---

## Executar testes de carga com JMeter
1. Baixe o Apache JMeter:
https://jmeter.apache.org/download_jmeter.cgi

2. Abra o JMeter:
Execute bin/jmeter.bat (Windows) ou bin/jmeter (Linux/Mac)

3. Abra o arquivo login_stress_test.jmx, localizado na pasta /jmeter-tests

---

## Acessar Documentação do Swagger
1. Execute a API
2. Acesse: http://localhost:8080/swagger-ui/index.html#/
