# 📅 Système de Réservation — Full-Stack (Angular + Spring Boot)

![Angular](https://img.shields.io/badge/Angular-17-DD0031?logo=angular&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg)

Application full-stack de gestion de réservations de sessions (avec utilisateurs, membres de
jury et réservations). **Front-end Angular** consommant une **API REST Spring Boot**.

---

## 🗂️ Structure

```
.
├── frontend/   # Application Angular 17 (UI : users, sessions, réservations, jury)
└── backend/    # API REST Spring Boot 3.3 (JPA, MySQL/H2)
```

---

## 🧩 Modèle de données (backend)

| Entité | Description |
|--------|-------------|
| `User` | Utilisateur (nom, email, `Role`) |
| `Session` | Session réservable (date, horaires, capacité) |
| `Reservation` | Réservation reliant un `User` à une `Session` (`ReservationStatus`) |
| `JuryMember` | Membre du jury rattaché à une session |

### Endpoints REST

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| `GET` | `/users` | Liste des utilisateurs |
| `GET` | `/Sessions` | Liste des sessions |
| `GET` | `/Reservations` | Liste des réservations |
| `GET` | `/JuryMembers` | Liste des membres du jury |

---

## 🚀 Démarrage

### Backend (port 8087)

```bash
cd backend
./mvnw spring-boot:run          # Windows : mvnw.cmd spring-boot:run
```
Nécessite **MySQL** (base `reservation_system` créée automatiquement). H2 est inclus pour
les tests (`./mvnw test`, aucun MySQL requis).

### Frontend

```bash
cd frontend
npm install
ng serve
```
Application disponible sur <http://localhost:4200>.

---

## 🛠️ Corrections & améliorations apportées

- 🗜️ **Suppression des archives binaires** `backend.zip` / `frontend.zip` (mal nommées :
  `frontend.zip` contenait en réalité le backend, `backend.zip` un dump du front avec
  caches). Le code source est désormais versionné directement dans `backend/` et `frontend/`.
- 🐛 **Bug de schéma** : les entités `User` et `Session` utilisaient des **mots réservés**
  comme noms de table → échec de création du schéma (H2 et autres SGBD). Ajout de
  `@Table(name = "users")` / `@Table(name = "sessions")`. **Le backend compile et ses tests
  passent désormais** (base H2 en mémoire).
- 🧹 Restructuration claire `frontend/` + `backend/`, ajout de `.gitignore`, `LICENSE` et README.

---

## 👤 Auteur

**EL HAKKI Ossama** — Master SDIA, ENSET.

## 📄 Licence

Distribué sous licence **MIT**. Voir [`LICENSE`](LICENSE).
