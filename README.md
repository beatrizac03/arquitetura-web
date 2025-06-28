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
