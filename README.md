# CaseStudy


#### SensorAgent
Voor de CaseStudy is er een simpele SensorAgent gemaakt die een DHT11 sensor uitleest op een Raspberry Pi.  
De CaseStudy maakt gebruik van een Raspberry Pi B+ waarop Raspbian is geinstalleerd.
Voor deze implementatie wordt de datapin aangesloten op "WiringPi" pin **21**.   
Zie http://pi4j.com/pins/model-b-plus.html voor een overzicht van beschikbare pins op de B+
Ook wordt de CPU temperatuur van de raspberry pi uitgelezen.

In de casestudy zijn de volgende plans/alerts ingesteld:
* CPU Temperatuur boven 50C ("Watch out" via slack)
* CPU Temperatuur boven de 100C of onder de 0C ("Panic!" via slack)
* DHT11 Temperatuur boven de 50C ("Watch out" via slack)
* DHT11 Temperatuur boven de 60C ("Panic!" via slack)
  
#### Volledige Stack op de Raspberry Pi
Ook heeft voor de casestudy de volledige stack gedraaid op de Raspberry Pi, dit was geen probleem binnen de kaders 
van de inmiddels al "verouderde" hardware.
