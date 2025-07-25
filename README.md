# API RendezVous - Spring Boot

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.4-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green)

## 📋 Description

API RESTful développée avec Spring Boot pour la gestion des rendez-vous. Cette application permet de créer, lire, modifier et supprimer des rendez-vous avec une interface Swagger intégrée pour la documentation et les tests.

## 🚀 Fonctionnalités

- ✅ **CRUD complet** : Créer, Lire, Modifier, Supprimer des rendez-vous
- 📅 **Gestion des dates** : Support des dates au format ISO (yyyy-MM-dd)
- 📖 **Documentation API** : Interface Swagger UI intégrée
- 🗄️ **Base de données** : Support MySQL avec JPA/Hibernate
- 🔧 **Hot Reload** : Spring Boot DevTools pour le développement
- 📦 **Lombok** : Réduction du code boilerplate

## 🛠️ Technologies utilisées

- **Framework** : Spring Boot 3.3.4
- **Langage** : Java 17
- **Base de données** : MySQL
- **ORM** : Spring Data JPA / Hibernate
- **Documentation** : SpringDoc OpenAPI (Swagger)
- **Build** : Maven
- **Annotations** : Lombok

## 📦 Structure du projet

```
src/
├── main/
│   ├── java/com/example/app_sprint_boot/
│   │   ├── AppSprintBootApplication.java    # Classe principale
│   │   ├── controller/
│   │   │   └── controller.java              # Contrôleur REST
│   │   ├── models/
│   │   │   └── RendezVous.java              # Entité RendezVous
│   │   ├── service/
│   │   │   └── serviceRendezVous.java       # Logique métier
│   │   ├── resposity/
│   │   │   └── rendezVousResposity.java     # Repository JPA
│   │   └── Exception/
│   │       └── RendezVousException.java     # Exceptions personnalisées
│   └── resources/
│       └── application.properties           # Configuration
└── test/
    └── java/
        └── AppSprintBootApplicationTests.java
```

## ⚙️ Configuration

### Prérequis

- Java 17 ou supérieur
- Maven 3.6+
- MySQL 8.0+

### Base de données

1. Créez une base de données MySQL :
```sql
CREATE DATABASE rvsdb;
```

2. Configurez les paramètres dans `application.properties` :
```properties
# Configuration du serveur
server.port=8081

# Configuration de la base de données
spring.datasource.url=jdbc:mysql://localhost:3306/rvsdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=

# Configuration JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

## 🚀 Installation et démarrage

### 1. Cloner le projet
```bash
git clone https://github.com/kanebassirou/app_sprint_boot_api_rendezVous.git
cd app_sprint_boot_api_rendezVous
```

### 2. Installer les dépendances
```bash
./mvnw clean install
```
ou sur Windows :
```cmd
mvnw.cmd clean install
```

### 3. Lancer l'application
```bash
./mvnw spring-boot:run
```
ou sur Windows :
```cmd
mvnw.cmd spring-boot:run
```

L'application sera accessible sur : `http://localhost:8081`

## 📚 Documentation API

### Swagger UI
Une fois l'application démarrée, accédez à la documentation interactive :
- **Swagger UI** : `http://localhost:8081/swagger-ui.html`
- **OpenAPI JSON** : `http://localhost:8081/javainuse-openapi`

### Endpoints disponibles

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| `GET` | `/rendezvous/` | Page de bienvenue |
| `GET` | `/rendezvous/liste` | Lister tous les rendez-vous |
| `GET` | `/rendezvous/{id}` | Obtenir un rendez-vous par ID |
| `POST` | `/rendezvous/ajouter` | Créer un nouveau rendez-vous |
| `PUT` | `/rendezvous/modifier/{id}` | Modifier un rendez-vous |
| `DELETE` | `/rendezvous/supprimer/{id}` | Supprimer un rendez-vous |

### Exemple de payload JSON

#### Créer un rendez-vous
```json
{
  "codeRV": "RV001",
  "description": "Consultation médicale",
  "lieu": "Cabinet médical Dr. Martin",
  "date": "2025-08-15"
}
```

#### Réponse
```json
{
  "id": 1,
  "codeRV": "RV001",
  "description": "Consultation médicale",
  "lieu": "Cabinet médical Dr. Martin",
  "date": "2025-08-15"
}
```

## 🧪 Tests

Exécuter les tests unitaires :
```bash
./mvnw test
```

## 📝 Modèle de données

### Entité RendezVous

| Champ | Type | Description | Contraintes |
|-------|------|-------------|-------------|
| `id` | Long | Identifiant unique | Auto-généré, Non null |
| `codeRV` | String | Code du rendez-vous | Non null, Non modifiable |
| `description` | String | Description du rendez-vous | - |
| `lieu` | String | Lieu du rendez-vous | - |
| `date` | LocalDate | Date du rendez-vous | Format: yyyy-MM-dd |

## 🔧 Développement

### Hot Reload
Le projet utilise Spring Boot DevTools pour le rechargement automatique pendant le développement.

### Lombok
Les annotations Lombok sont utilisées pour réduire le code boilerplate :
- `@Data` : Génère getters, setters, toString, equals, hashCode

## 🤝 Contribution

1. Forkez le projet
2. Créez une branche pour votre fonctionnalité (`git checkout -b feature/AmazingFeature`)
3. Committez vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Pushez vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request

## 📄 Licence

Ce projet est sous licence [MIT](LICENSE).

## 👨‍💻 Auteur

**Bassirou Kane**
- GitHub: [@kanebassirou](https://github.com/kanebassirou)

## 📞 Support

Pour toute question ou problème, n'hésitez pas à ouvrir une [issue](https://github.com/kanebassirou/app_sprint_boot_api_rendezVous/issues).

---

⭐ **N'hésitez pas à mettre une étoile si ce projet vous a été utile !**
