# Gestionnaire de Tâches - API REST (Spring Boot & Hibernate)

## Description
Ce projet est une API REST permettant de gérer des tâches efficacement. Construit avec **Spring Boot** et **Hibernate**, il permet d'effectuer des opérations CRUD sur les tâches, de gérer leur statut et de les organiser selon les besoins des utilisateurs.

## Fonctionnalités
- Création, mise à jour, suppression et consultation des tâches
- Attribution d'un statut à chaque tâche (TODO, EN COURS, TERMINÉE)
- Persistance des données avec MySQL
- Documentation automatique avec Swagger

## Technologies Utilisées
- **Java 17**
- **Spring Boot 3**
- **Hibernate & JPA**
- **MySQL**
- **Lombok**
- **Swagger UI**
- **Maven**

## Prérequis
Avant de lancer le projet, assure-toi d'avoir installé :
- **JDK 17**
- **Maven**
- **MySQL**

## Installation et Exécution
1. Clone le dépôt :
   ```sh
   git clone https://github.com/ton-projet.git
   ```
2. Configure la base de données dans `application.properties` :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db
   spring.datasource.username=root
   spring.datasource.password=ton_mot_de_passe
   ```
3. Compile et lance l'application :
   ```sh
   mvn spring-boot:run
   ```

## Documentation API
Une fois l'application lancée, accède à la documentation Swagger :
- [Swagger UI](http://localhost:8080/swagger-ui.html)

## Points d'Entrée de l'API
| Méthode | URL                | Description                |
|----------|-------------------|----------------------------|
| GET      | `/tasks`           | Récupérer toutes les tâches |
| GET      | `/tasks/{id}`      | Récupérer une tâche par ID |
| POST     | `/tasks`           | Créer une nouvelle tâche |
| PUT      | `/tasks/{id}`      | Mettre à jour une tâche |
| DELETE   | `/tasks/{id}`      | Supprimer une tâche |

## Contribution
Les contributions sont les bienvenues ! Forke le projet, crée une branche et soumets une pull request.

## Licence
Ce projet est sous licence MIT.

---

Développé par **Devalère KAMGUIA** 🚀
