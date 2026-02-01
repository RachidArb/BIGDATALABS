# Lab1 : Programmation avec l'API HDFS

Ce projet contient des exemples de manipulation de fichiers sur **HDFS** (Hadoop Distributed File System) en utilisant l'API Java native.

## 🚀 Fonctionnalités
- **HadoopFileStatus** : Affiche les détails d'un fichier et permet de le renommer.
- **ReadHDFS** : Lit le contenu d'un fichier texte sur HDFS.
- **WriteHDFS** : Crée un nouveau fichier et écrit du texte à l'intérieur.

## 🛠️ Installation et Exécution

1. **Compiler le projet** (génère `hadoop-app.jar`) :
   ```bash
   mvn clean install
Copier le JAR dans le container Hadoop :

PowerShell
docker cp target/hadoop-app.jar hadoop-master:/tmp/
Exécuter les classes :

Bash
# Lecture des infos d'un fichier
hadoop jar /tmp/hadoop-app.jar edu.supmit.hadoop.HadoopFileStatus /chemin/nom_fichier nouveau_nom

# Lecture d'un fichier
hadoop jar /tmp/hadoop-app.jar edu.supmit.hadoop.ReadHDFS /chemin/fichier.txt

# Écriture dans un fichier
hadoop jar /tmp/hadoop-app.jar edu.supmit.hadoop.WriteHDFS /chemin/nouveau.txt "Message"
📋 Prérequis
Java 1.8

Maven

Cluster Hadoop (Docker)

