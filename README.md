# Programmieren-III-Testate

# Git-Richtlinien
Erstellung und Änderungsmaximum innerhalb von Branches: 1 Branch = 1 Aufgabe, z.B. : Hinzufügen einer Methode, Implementation über mehrere Klassen möglich, aber nicht mehr als eine neue Methode.  

Benennung von Branches: Fix/Add/Change/Delete-Methode-Klasse

Fix = Lösung eines Problems, Add = Hinzufügen von Code, Change = Änderungen am bestehenden Code, Delete = Löschung von Inhalt

Kommentare: Kurze, klare Beschreibung von den getroffenen Änderungen.

# Code-Richtlinien
Benennung von Methoden: englisch, camelCase, passend zu ihrer Funktion (z.B. : adoptAnimal)

Benennung von Variablen: englisch, camelCase 

# ER-Diagram:
<img width="1025" height="830" alt="image" src="https://github.com/user-attachments/assets/39d3fbf6-9297-4b38-9801-17c3e3379068" />


# Projektsteckbrief – Tierheim Verwaltungssystem

Fort. Programmierung SEM 3, Java-Projekt mit JDBC-Anbindung

Bearbeitet von Ariane von Fischern & Sally Braune

*Problem*: Ein Tierheim benötigt ein benutzerfreundliches Programm für die Verwaltung von Tieren und Lager. 

*Nutzen*: Das Programm soll die Aufnahme und den Adoptionsvorgang der Tiere mit Datenbankbezug dokumentieren. Des Weiteren sollen die Lagerbestände überwacht werden, indem Verbrauchsgüter ab einem bestimmten Mindestbestand auf eine Einkaufsliste gesetzt werden. Anhand der Gehege und der in ihnen vorhandenen Tiere, die jeweils unterschiedliche Produkte für die Versorgung benötigen, muss der Bedarf hier automatisch und zuverlässig berechnet werden. Die Bedieung erfolgt durch die Mitarbeiter des Tierheims, die ausgehend von denen ihn zugeteilten Rollen einen bestimmten Funktionsumfang zur Verfügung haben. Um sicherzugehen, dass kein unbefugter Zugriff stattfindet, wird ein Login mit einer Mitarbeiter-ID vorrausgesetzt. 

# Anwendungsfälle:

1.	Ein neues Tier wird in das Tierheim aufgenommen. Es muss:
   
  a.	Vollständig in die „Animal“ Tabelle eingetragen werden

  b.	Einem korrekten (der Spezies entsprechenden) Gehege zugewiesen werden

  c.	In die Berechnung der Lagerbestände einbezogen werden

  d.	Bei Adoption wieder vollständig aus dem System ausgetragen und in der „Adoption“-Tabelle hinterlegt werden


2.	Für den Folgemonat soll eine Einkaufsliste erstellt werden, die:
   
  a.	Den Gesamtbedarf aller Tiere im Tierheim auf einem Zeitraum von 30 Tagen berechnet

  b.	Die entsprechende Menge an benötigten Produkten auflistet
  
  c.	Als Beleg mit einem Datum und einer ID abgespeichert wird
  
  d.	Bei erfolgreicher Beschaffung der Produkte mit dem Status „abgeschlossen“ geupdated wird
  *BONUS*: Die Einkaufsliste soll auch auf eine Produkt-Kategorie oder Spezies bezogen berechnet werden können.
  

3.	Ein zur neige gehendes Produkt soll ab einem Mindestbestand, der vorher festgelegt wurde, eine entsprechende Meldung beim Login des Managers ausgeben, um diesen zu warnen.
   
  a.	Der Manager kann diese Meldung dann auf „erledigt“ setzen und wird aufgefordert, den Bestand mit einer neuen Zahl zu aktualisieren

  b.	Wird die Meldung ignoriert, erscheint sie beim nächsten Login erneut
  
  c.	Die Meldung kann gelöscht werden, indem die Option „ignorieren“ gewählt wird (nötig, falls z.B. eine Futtersorte in Zukunft nicht mehr gekauft werden soll)
  

4.	Ein neuer Mitarbeiter wird durch den Manger in die Datenbank aufgenommen und mit einer entsprechenden Rolle versehen
   
  a.	Der Manager kann bei einem bestehenden Mitarbeiter die Rollenzuweisung nachträglich ändern

  
# Fachregeln:
•	Ein Mitarbeiter darf nur entsprechend seiner Rolle agieren:

o	Manager: Neue Tiere aufnehmen, Adoptionen durchführen, Mitarbeiterrollen ändern, neue Mitarbeiter aufnehmen

o	Pfleger: Tiere füttern, Einkaufslisten erstellen & abschließen

o	Doktor: Tiere verarzten, Adoptionen durchführen

•	Tiere müssen bei der Adoption korrekt ausgetragen werden. Dies beinhaltet die Belegung der Gehege, die Lagerberechnungen, die Adoptionstabelle und die Animal-Tabelle

•	Lageritems sollen ab einer bestimmten Bestandanzahl auf eine Einkaufsliste gesetzt werden, der Bestand kann individuell für ein Item gesetzt und geändert werden

•	Bei Abschluss einer Einkaufsliste werden die eingekauften Produktmengen den Lagerbeständen zugerechnet

•	Bei der Bearbeitung/Zuweisung/Änderung eines DB-Objekts (Tier, Mitarbeiter, Produkt) wird außerdem ein entsprechendes Java-Objekt erstellt, welches temporär im Cache zwischen gespeichert wird, solange die Sitzung aktiv ist. In diesem Java-Objekt werden zu Anfang alle aktuellen Informationen aus der DB eingetragen. Alle Änderungen werden zum Schluss durch eine Bestätigung in die DB übernommen. Dies soll ständige Datenbankzugriffe per SQL verhindern und somit die Latenz verbessern.

# Dauerhaft gespeicherte Daten:

•	Datenbank-interne Informationen

•	Statische Java-Variablen


# Fehlerfälle:

1a) Fehlende oder nicht zeichenkonforme Angaben zum Tier, Tier existiert bereits, Spezies nicht bekannt

1b) Gehege entspricht nicht der Spezies, Gehege hat keine Kapazitäten mehr, Gehege existiert nicht

2d) Einkaufsliste wird nie auf abgeschlossen gesetzt und verbleibt ewig in der Datenbank (evtl. Warnung ausgeben oder nach gewisser Zeit löschen)

3a) Der neue Bestand unterschreitet den Mindestbestand oder wurde nicht zeichenkonform angegeben
3b) Die Meldung wird zu lange ignoriert

4) Die angegebenen Informationen zum Mitarbeiter sind fehlerhaft/nicht zeichenkonform, der Mitarbeiter existiert bereits

*Jederzeit*: Der Benutzer verfügt nicht über die notwendige Rolle, die Benutzereingabe entpricht nicht dem gewünschten Input

o	In diesem Fall: Rollback zurück zum Login/Hauptmenü

o	ODER: wiederholen der Benutzeranfrage

