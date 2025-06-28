# 🛒 EasyBuy - API de E-commerce

O **EasyBuy** é um sistema de E-commerce com autenticação JWT baseado em Spring Boot com foco em segurança, performance e observabilidade. A aplicação expõe endpoints REST protegidos, utiliza tokens JWT, e oferece um painel completo de monitoramento via Prometheus e Grafana.

---

## 🔐 Tecnologias principais

- **Spring Boot 3**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Actuator (para métricas e monitoramento)**
- **Prometheus (coletor de métricas)**
- **Grafana (painel de visualização)**
- **H2 Database (para ambiente de desenvolvimento)**
- **Swagger (documentação da API)**
- **Render (deploy)**

---

## 📦 Funcionalidades

- Cadastro e login de usuários (`/auth/register`, `/auth/login`)
- Proteção de rotas com tokens JWT
- Monitoramento de:
  - Uso de CPU, memória
  - Tempo de resposta HTTP
  - Sessões e performance do Tomcat
  - Requisições com erro
- Exportação de métricas no padrão Prometheus via `/actuator/prometheus`
- Dashboards interativos no Grafana

---

## 🚀 Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/easybuy.git
cd easybuy
```

### 2. Spring Boot Actuator
**O que é?**  
Dependência do Spring Boot que expõe endpoints para monitoramento da aplicação.

**Como usar:**

- Dependência adicionada no `pom.xml` e configurada no `application.yml`:

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### 3. Prometheus
**O que é?**  
Sistema open-source para coleta e armazenamento de métricas via HTTP.

**Como usar:**
- Baixe e extraia o Prometheus: `https://prometheus.io/download/`
- Edite o arquivo prometheus.yml para monitorar sua aplicação:

```yaml
scrape_configs:
  - job_name: 'spring-actuator'
    scrape_interval: 5s
    static_configs:
      - targets: ['localhost:8080']  # Porta da aplicação Spring Boot
```

- Execute o Prometheus no CMD
```bash
./prometheus --config.file=prometheus.yml
```
- Acesse em `localhost:9090`

### 4. Grafana
**O que é?**  
Ferramenta para criar dashboards customizados a partir de dados do Prometheus.

**Como usar:**
- Baixe e instale o Grafana:: `https://grafana.com/grafana/download`
- Execute o Grafana:

```bash
./bin/grafana-server web
```

- Acesse: `http://localhost:3000` (login padrão: admin/admin)
- Adicione o Prometheus como fonte de dados no Grafana:
        1. Vá em Configuration > Data Sources > Add data source
        2. Escolha Prometheus
        3. URL: `http://localhost:9090`
        4. Salvar > Dashboards > Criar Dashboard
        5. Adicione métricas no painel e salve no dashboard
        
---

## 🚀 Deploy Render

- Configuração do Dockerfile
- Disponível em: `https://arquitetura-web-c4hp.onrender.com`



