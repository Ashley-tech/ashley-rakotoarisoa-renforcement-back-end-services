Noms des projets -> Fonctions :
exosch -> Microservice des écoles (school)
exostu -> Microservice des étudiants (students)
exogateway -> Service d'API Gateway
eureka -> Service d'Eureka
oauth -> Service d'authentication

Sur PGAdmin (pour PostgreSQL), créer une base de données appelé "scho". Pense aussi à modifier "spring.datasource.username" et "spring.datasource.password" du fichier application.properties avec ton nom d'utilisateur et ton mot de passe PostgreSQL.
Sur MongoDB Compass (pour MongoDB), créer une base de données appelé "school". Une collection "school" devrait se générer si elle n'existe pas dans cette base de données quand tu lanceras le microservice des étudiants

Une fois toutes les configurations ci-dessus faites, tu peux démarrer ces 5 services.

Commandes à executer dans les répetoires (Commandes (depuis le terminal interne d'un IDE) : cd eureka/eureka - cd exogateway/exogateway - cd exosch/exosch - cd exostu/exostu - cd oauth/oauth) et ce dans l'ordre :
-mvn compile (pour installer les dépendances et compiler le projet)
-mvn spring-boot:run (pour démarrer le service)

Ordre de démarrage des services (Commande "mvn spring-boot:run") :
eureka - exostu - exosch - exogateway - oauth
