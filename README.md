# Projet_SegaBank
Trello: https://trello.com/b/SXLogO0M/projet-segabank

Gestion de comptes bancaires - SegaBank


                                   **Préambule**
								   
L’objectif de ce mini-projet est dans un premier de temps, de vous permettre de montrer vos
compétences et connaissance en Java et en programmation objet.

Avec ces connaissances et compétences acquises lors des dernières sessions Java, vous allez
développer l’application suivante une première fois. Ensuite au fur et à mesure lors la session
« Architecture » vous referez le projet en prenant en compte les nouvelles notions vues.


                                   **Le projet**
								   
SegaBank est un nouvel établissement financier qui permet à des particuliers de placer leurs deniers
personnels et bénéficier d’avantages incroyables. Vous devez développer la première version de leur
application « console » en Java avec JPA pour l’accès aux données.

Vous devez donc créer une application qui permet de manipuler différents types de comptes
bancaires : les comptes simples, les comptes épargnes et les comptes payants.

Tous les types de comptes sont caractérisés par :
- Un identifiant et un solde ;
- Un compte peut subir les opérations de versement et de retrait.
- Pour ces deux opérations, il faut connaître le montant de l'opération ;
- Pour consulter un compte on peut faire appel à sa méthode « toString() ».

Un compte simple est un compte qui possède un découvert. Ce qui signifie que ce compte peut être
débiteur jusqu'à la valeur du découvert.

Un compte Epargne est un compte bancaire qui possède en plus un champ « tauxInteret » et une
méthode « calculIntérêt() » qui permet de mettre à jour le solde en tenant compte des intérêts.

Un Compte payant est un compte bancaire pour lequel chaque opération de retrait et de versement
est payante et vaut 5 % du montant de l'opération.

Chaque compte est administré par une et une seule agence. Les agences sont définies par id, un code
et une adresse.


                                    **Travail à faire**
								   
- Analyser et concevoir le modèle objets de cette application ;
- Concevoir une base de données pour stoker les informations ;
- Développez une application Java (console) en implémentant les différentes classes et les
méthodes demandées comme sur l’exemple « book » ;
- Créer un menu "console" avec la gestion des différentes entités (CRUD).
- Implémenter une fonctionnalité d’export en csv des opérations d'un compte.

Ce cahier des charges reste volontairement partiel et ouvert. Le but recherché est de connaître ce
que vous connaissez déjà en développement java et d’établir avec vos solutions, les
éléments/notions (architecture, design-patterns, ..) qui seront travaillés sur le reste de votre
formation et de vous faire travailler ensuite sur ces nouvelles notions. Soyez imaginatifs, créatifs et
inventifs.
