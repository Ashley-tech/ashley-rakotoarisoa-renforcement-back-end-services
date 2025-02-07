Noms des projets -> Fonctions :
exosch -> Microservice des écoles (school)
exostu -> Microservice des étudiants (students)
exogateway -> Service d'API Gateway
eureka -> Service d'Eureka
oauth -> Service d'authentication

Sur PGAdmin (pour PostgreSQL), créer une base de données appelé "scho".
Sur MongoDB Compass (pour MongoDB), créer une base de données appelé "school".

Une fois toutes les configurations ci-dessus faites, tu peux démarrer ces 5 services.

Ordre de démarrage des services (Commande "mvn spring-boot:run") :
eureka - exostu - exosch - exogateway - oauth
