### XJet

This is a Microservice oriented environment using Spring Boot, Spring, MongoDB and AngularJS, monitored by Dynatrace AppMon.

This App simulates a flight search company (XJet), that consumes two other services (CrazyAir and ToughJet) to list them.

### How to start environment *(using Docker Compose)*

###### Pre-Requisites

* [Install Docker](https://docs.docker.com/engine/installation/linux/)
* [Instal Compose](https://docs.docker.com/compose/install/)


###### Build Java App:
      $ ./travel/gradlew build -p travel/
      $ ./crazyAir/gradlew build -p crazyAir/
      $ ./toughJet/gradlew build -p toughJet/


###### Execute:

      sudo docker-compose up -d

----

#### Applications

##### CrazyAir

Agent name: CrazyAir_Java_XJet

http://{host}:8001/crazyAir


**PUT**

    {
      "airline": "GOL",
      "price": 300,
      "cabinclass": "E",
      "departureAirportCode": "BSB",
      "destinationAirportCode": "GRU",
      "departureDate": "06-21-2017 10:14:00",
      "arrivalDate": "06-26-2017 12:19:00"
    }


##### ToughJet
http://{host}:8002/toughJet

Agent name: ToughJet_Java_XJet

**PUT**

    {
      "carrier": "LATAM",
      "basePrice": 400,
      "tax": 10,
      "discount": 0,
      "departureAirportName": "BSB",
      "arrivalAirportName": "GRU",
      "departureDay": 19,
      "departureMonth": 6,
      "departureYear": 2017,
      "returnDay": 29,
      "returnMonth": 6,
      "returnYear": 2017
    }


##### XJet
http://{host}:8000/searchFlights

Agent name: JavaApplication_Java_XJet

**GET**

Will return all flights.

**Or you can acess http://{host}:8000/ on browser.**
