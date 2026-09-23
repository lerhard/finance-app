# finance-app

Personal finance app — a monorepo with a Spring Boot API and a Flutter client.

I built this as the vehicle for moving from .NET to the **Java/Spring** ecosystem, and to have a real application to deploy, secure and monitor on AWS instead of throwaway tutorials.

> Work in progress — the API has its foundation in place; the mobile app is still a scaffold.

## Structure

```
apps/
  api/finance-api   Spring Boot REST API
  mobile            Flutter client
```

## `apps/api/finance-api`

**Stack:** Java 25 · Spring Boot 4.1 · Spring Web MVC · Spring Security · **jOOQ** · **Flyway** · PostgreSQL · Actuator

**Decisions and why**

- **jOOQ instead of JPA.** I come from Dapper on .NET and wanted explicit control over the SQL being generated — no hidden lazy loading, no surprises in the query plan. jOOQ gives type-safe queries while keeping the SQL visible.
- **Flyway from day one.** Schema changes are versioned files, not a diff of entities. Starting this habit early is what makes a migration safe to roll back later.
- **Security and validation as starters.** The API is locked down and validates input at the boundary from the first endpoint, rather than being retrofitted.
- **Actuator included deliberately.** Health and metrics endpoints exist so the service can actually be deployed, health-checked and observed on AWS — that's the next milestone.

**Run it**

```bash
cd apps/api/finance-api
./mvnw spring-boot:run     # requires a PostgreSQL instance
```

## `apps/mobile`

Flutter client (Dart SDK ^3.13). Currently a scaffold — `lib/main.dart` only.

```bash
cd apps/mobile
flutter run
```

## Roadmap

- [x] API foundation: persistence, versioned migrations, security, validation, health checks
- [ ] Domain model and first endpoints
- [ ] Flutter screens wired to the API
- [ ] Container image + CI pipeline
- [ ] Deploy to AWS with infrastructure as code

## Note on the language bar

GitHub reports this repo as predominantly C++ — that's the Flutter platform scaffolding (`linux/`, `windows/`, `macos/`), not application code. The actual work is under `apps/api/finance-api` (Java) and `apps/mobile/lib` (Dart).
