# Weather App
L'applicazione web presente nella repository è una REST API in grado di fornire dati riguardo condizioni meteo presenti e future, creare storici di dati e estrapolarne statistiche.



# Dataset

Il dataset è stato creato utilizzando i dati della città di Londra, ma è sufficiente cambiare la città desiderata per crearne di nuovi. Esso è strutturato in due diversi file:

 - il file di testo (.txt) contiene lo storico delle condizioni meteo relative alla città inserita; esso viene creato o aggiornato tramite una rotta specifica ed al suo interno contiene i dati presi sul momento relativi a: data, temperatura, pressione, nuvolosità, umidità, vento, visibilità e condizioni generali
 - il file JSON (.json) contiene lo storico soltanto di dati specifici utili a generare statistiche, ovvero temperatura, pressione e nuvolosità; esso viene creato o aggiornato tramite una rotta specifica.
 
 Tutti i dati sono presi tramite le API di OpenWeather. 

## Storico dati

 - file di testo: dal 14/03 al 18/03
 - file json: dal 14/03 al 18/03

## Formato dei dati restituiti

Le rotte di visualizzazione restituiscono delle risposte pre-costruite in formato stringa utilizzando i dati ottenuti dalla API, mentre le rotte di salvataggio restituiscono i path dei file contenenti i dati salvati.

 1. esempio di rotta di visualizzazione dati del presente (tipo String):
 
*Current London conditions:
Temperature is: 282.43°k
But it feels like: 278.5°k
The minimum and maximum temperature are:281.15°k and 282.59°k
The pressure is: 1033.0 bar 
The humidity is of 71.0% 
The weather is Clouds (few clouds)
The clouds' level is(in percentage): 20.0
The wind is blowing at 3.09 mph and its direction's degree is of 300.0
The visibility level is 10000.0m* 

 2. esempio di rotta di salvataggio file:
 *C:\Users\frede\git\repositoryproject\projectLondon.txt*

## Statistiche

Le statistiche vengono calcolate in base al periodo inserito dall'utente, che rappresenta il numero di giorni precedenti al presente a cui risalire per ottenere i dati richiesti; i dati necessari ai calcoli sono estratti dal file **.json** e consistono in: valori di massimo, minimo, media e varianza di temperatura, pressione e nuvolosità. Una volta effettuati i calcoli i risultati vengono inseriti in un oggetto della classe apposita, che verrà poi restituito tramite la rotta specifica.

## Rotte dell'Applicazione


|tipo di chiamata  | rotta |
|--|--|
| 1) **GET**| /predictions |
| 2) **GET**|/current|
| 3) **GET**| /save_history |
| 4) **GET**|/stats  |
| 5) **GET**| /see_stats|
| 6)**POST**| /calculate |

 1. rotta che fa visualizzare le previsioni meteo per i prossimi 5 giorni della città inserita e passata come parametro "q".
 2. rotta che fa visualizzare le condizioni meteo attuali (param=q).
 3. rotta che salva le condizioni meteo attuali in un file di testo(param=q).
 4. rotta che salva i dati necessari a generare statistiche in un file json(param=q).
 5. rotta di prova utile a verificare se il FileReader fuziona, restituisce un oggetto  di tipo stats con i dati ottenuti dal file json(param=q).
 6. rotta che restituisce un oggetto i quali attributi sono le statistiche calcolate(param=q, param=period);

## Conclusioni
La rotta 5 presenta un errore di lettura, perciò la rotta 6 pur essendo stata implementata non può funzionare finché non viene risolto il suddetto errore.
Le librerie utilizzate e i diagrammi UML sono disponibili rispettivamente nel pom.xml e nella cartella UML.


Pangrazi Federico
Alfano Lorenza




