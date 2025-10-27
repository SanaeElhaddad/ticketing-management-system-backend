# Ticketing Management System - Backend

Ce backend fait partie d’une application de gestion des tickets développée dans le cadre d’un projet académique de 4ème année.  
Il gère l’ensemble de la logique métier, la sécurité, ainsi que l'exposition des APIs REST consommées par le frontend Angular.

---

## Architecture du projet

L’architecture est basée sur une séparation claire des couches :
src/main/java/com/GestionTicket
│
├── Controller → Expose les endpoints REST
├── Service → Contient la logique métier
├── Repository → Accès aux données (JPA/Hibernate)
├── DTO → Objets d’échange entre couches
├── Entitie → Modèles persistants (mapping BD)
└── config → Sécurité / configuration applicative

---

## Sécurité

- Authentification via **Spring Security + JWT**
- Protection des endpoints selon le rôle (Client / Manager / Consultant)
- Filtre JWT appliqué à chaque requête entrante

---

## Stack Technique

| Technologie     | Rôle                          |
|----------------|-------------------------------|
| Spring Boot     | Framework backend principal   |
| Spring Security | Sécurisation des endpoints    |
| JWT             | Gestion des sessions          |
| JPA / Hibernate | Accès & mapping BD            |
| Maven           | Build & dépendances           |
| Git             | Versioning                    |

---

## Fonctionnalités côté Backend

- Création / suivi des tickets
- Attribution selon le rôle
- Gestion des statuts / priorités
- Sécurisation des accès
- APIs REST pour communication front/back

---

## Méthodologie Agile

Le développement a été réalisé en mode **Scrum** :
- Découpage fonctionnel en user stories
- Sprints planifiés avec Jira
- Daily stand-up meetings
- Revue & rétrospective à la fin de chaque sprint

---

## Lancer le projet

```bash
mvn spring-boot:run
L’API sera disponible sur :
http://localhost:8080/


