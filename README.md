# TP13

# Exercice 1 - Sérialisation et désérialisation avec Serializable

- On apprend à transformer un objet Java en une suite d'octets pour le sauvegarder sur disque, puis à le reconstruire plus tard à partir de ce fichier.
- Pour qu'une classe puisse être sérialisée, elle doit implémenter l'interface Serializable. Un identifiant de version (serialVersionUID) est déclaré pour éviter des erreurs si la classe change plus tard.
- Un champ marqué transient est volontairement exclu du processus de sérialisation. C'est utile pour des informations sensibles, comme un mot de passe : après la désérialisation, ce champ revient simplement à sa valeur par défaut (null pour un texte).
- L'écriture se fait avec un ObjectOutputStream, qui convertit directement l'objet (ou une liste d'objets) en flux binaire. La lecture utilise l'opération inverse avec un ObjectInputStream, qui reconstruit l'objet à partir du fichier.
- Le tout est entouré d'un bloc try-with-resources, qui garantit que les flux se ferment correctement une fois l'opération terminée.

<img width="1280" height="665" alt="1" src="https://github.com/user-attachments/assets/edc456fc-5a62-411d-93e8-4c79092d6dc3" />

<img width="1279" height="673" alt="12" src="https://github.com/user-attachments/assets/0653442b-5654-40fd-9f20-2b42ff7f96f4" />

https://github.com/user-attachments/assets/1bd7734c-866d-46b1-8b83-4e5bfc95c430


# Exercice 2 - Sérialisation avancée avec Externalizable

- Cet exercice va plus loin que le précédent : au lieu de laisser Java décider automatiquement quoi écrire, on prend le contrôle total du processus grâce à l'interface Externalizable.
- Une classe qui implémente Externalizable doit obligatoirement avoir un constructeur sans arguments, et définir elle-même deux méthodes : une pour écrire ses données (writeExternal) et une pour les relire (readExternal).
- Dans la méthode d'écriture, on choisit précisément quels champs sauvegarder et dans quel ordre. Le champ transient (ici la longueur du message) n'est jamais écrit, il est recalculé après la lecture à partir des autres champs.
- Dans la méthode de lecture, on doit lire les champs exactement dans le même ordre qu'ils ont été écrits, sinon les données seraient mal interprétées.
- Cette approche donne plus de travail que Serializable, mais offre un contrôle total sur le format binaire, ce qui est utile si l'on veut optimiser la taille du fichier ou faire évoluer le format dans le temps tout en gardant la compatibilité avec d'anciennes versions.

<img width="1279" height="663" alt="2" src="https://github.com/user-attachments/assets/10721dcb-664a-4120-8add-bca101aab74e" />

<img width="1280" height="668" alt="21" src="https://github.com/user-attachments/assets/0c940f87-99c3-4c49-afdc-49ddee584263" />

https://github.com/user-attachments/assets/1cbc756a-6f01-499a-b66f-5153ad175d9f
