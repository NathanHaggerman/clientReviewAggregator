# Client Review Aggregator

A backend system for ingesting and searching customer reviews from multiple external sources (e.g., Google, Yelp, Facebook) on behalf of clients. Built using **Kotlin + Spring Boot**, backed by **MySQL**, and containerized with **Docker Compose**.

> Designed as both a system design interview prep project and a backend portfolio demo.

---

## Features

- Periodic ingestion of reviews from mock external APIs
- Stores reviews with metadata (source, client, timestamp, etc.)
- Full-text search via REST API: `GET /reviews?clientId=X&query=Y`
- Scalable architecture (diagrammed below)
- Dockerized and easy to run locally
- Cleanly structured Kotlin Spring Boot codebase

---

## System Architecture

![System Design Diagram](./docs/system-diagram.png) <!-- TODO: replace with Lucidchart export -->

**Components:**

- `ReviewIngestionService`: Pulls reviews from fake APIs and saves them to the DB
- `ReviewSearchController`: REST endpoint for searching reviews by client and keyword
- `MySQL`: Stores normalized review data with full-text indexing
- `Docker Compose`: Spins up app + DB for local dev

---

## Technologies

| Layer | Tech |
|--|--|
| Language | Kotlin |
| Framework | Spring Boot (Web, Scheduling, Data JPA) |
| Database | MySQL |
| Containerization | Docker, Docker Compose |
| Testing | JUnit, MockK |
| Documentation | Swagger / OpenAPI (via SpringDoc) |

---

## Example API Usage

### Get Reviews for a Client

