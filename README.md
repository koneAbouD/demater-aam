# Application Jeu Promo boutique totalEnergies

<p>
TotalEnergies Côte d’Ivoire, filiale du groupe TotalEnergies est présent sur le marché pétrolier Ivoirien
depuis 1947 et cotée à la Bourse Régionale des Valeurs Mobilières (BRVM). Première entreprise de
distribution de produits pétroliers, Elle dispose d’un bon maillage national de stations-service au design «
TAIR », comptant des centaines de stations minutieusement bâties dans le but d’améliorer le quotidien des
Ivoiriens.
</p>

<p>
Dans le cadre de ses jeux promotionnels, TotalEnergies souhaite mettre en place une solution qui permettra
de piloter les différentes opérations de jeux promotionnels en stations.
Une opération de jeu promotionnel a lieu lorsque : <br>
- le client achète un produit ou service de TotalEnergies selon un montant à paramétrer <br>
- le client a ensuite la tablette où se trouve le jeu (l’application mobile) <br>
- le client accède au jeu en remplissant les champs qui lui sont proposés <br>
Pour ce fait, TotalEnegies souhaite avoir deux (02) plateformes : <br>
- une plateforme web (back office) qui leur permettra de faire le paramétrage et le suivi du jeu <br>
- une plateforme mobile qui permettra aux gérants de suivre leur stock de gadgets et de faire jouer les
clients en station. <br>
</p>

## Installation de l'application

### i. Installation de la Base de données
```bash
database: jeupromototalenergies
user: jeupromototalenergies
password: jeupromototalenergies
```

Pour installer la base nous exécutons les commandes suivantes :

```bash
psql -Upostgres
CREATE database jeupromototalenergies template template0;
CREATE ROLE jeupromototalenergies WITH PASSWORD 'jeupromototalenergies' NOCREATEDB LOGIN VALID UNTIL 'infinity';
\c jeupromototalenergies
ALTER schema public owner to jeupromototalenergies;
```

### ii. Lancer le projet

```bash
mvn clean spring-boot:run
```

Vous pouvez accéder à l’api depuis: http://localhost:9080/api/v1/swagger-ui/index.html

### iii. Lancer les tests

```bash
mvn clean build
```
