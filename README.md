# AlgoDatProjectGame

Ein textbasiertes Roguelike-Adventure mit Sci-Fi-Setting, Seed-basierter Zufallswelt, rundenbasierten Kämpfen und einem modularen Inventar- und Encounter-System. Entwickelt im Rahmen eines AlgoDat-Projekts zur praktischen Anwendung von Datenstrukturen, OOP und Spielmechaniken.

---

## Spielübersicht

In einer dystopischen Zukunft begibst du dich durch zufallsgenerierte Räume. Dort triffst du auf verschiedenste Charaktere – manche freundlich, andere feindlich oder neutral. Deine Entscheidungen und dein Inventar bestimmen, ob du überlebst oder untergehst.

---

## Spiel starten

### Voraussetzungen

- Java 8 oder höher
- Terminal / Konsole

### Ausführung

```bash
git clone https://github.com/JanoDasHuhn/AlgoDatProjectGame.git
cd AlgoDatProjectGame
javac -d out src/**/*.java
java -cp out GameLoop
```

Beim Start kannst du einen Seed eingeben oder zufällig generieren lassen.

---

## Features

- Seed-basierte Welt: Jeder Durchlauf ist anders
- Rundenbasierte Kämpfe mit Waffenstats, Gegnerverhalten und Lebenspunkten
- Inventarsystem mit Boosts, Waffen und Story-Items
- Über 30 verschiedene Begegnungen mit Charakteren (gut, neutral, feindlich)
- Modularer Aufbau: Räume, Items, Kämpfe und Dialoge sind klar getrennt

---

## Beispielhafter Ablauf

```text
Raum: 2
Raum Links: Neon-Basar (INDUSTRIAL)
Raum Rechts: Ruinierte Kirche (RELIGIOUS)
(-) Neon-Basar (1) Ruinierte Kirche
> 1

Cyber-Ninja

Aus dem Schatten springt ein Cyber-Ninja mit Klingenarmen.

Was willst du machen?
(1) Kämpfen (2) Inventar anschauen
```

---

## Items und Entity-Typen

### Entity-Typen

- GOOD: Gibt dem Spieler ein Item
- NEUTRAL: Erlaubt Entscheidungen oder Kämpfe
- EVIL: Feindlich, es kommt zum Kampf

### Item-Arten

- Waffen: Schaden, Genauigkeit, Angriffsgeschwindigkeit
- Boosts: Heilung oder Buffs
- Story-Items: Schlüssel, Hinweise, Weltinteraktion

Raritäten: COMMON → UNCOMMON → RARE → EPIC → LEGENDARY → MYTHIC

---

## Erweiterungsmöglichkeiten

- Benutzeroberfläche mit JavaFX
- Levelsystem und XP
- Speicher- und Ladesystem
- Fortschrittsanzeige und Karten
- erweitertes Kampfsystem

---

## Beitrag leisten

1. Repository forken
2. Neuen Branch erstellen (`git checkout -b feature/neues-feature`)
3. Änderungen pushen und Pull Request eröffnen

---

## Lizenz

MIT License – siehe [`LICENSE`](LICENSE)

---

## Autor

Janis – AlgoDat Projekt  
GitHub: [JanoDasHuhn/AlgoDatProjectGame](https://github.com/JanoDasHuhn/AlgoDatProjectGame)

---

