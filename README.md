### AguaBsb

### How to start environment *(using Docker Compose)*

###### Pre-Requisites

* [Install Docker](https://docs.docker.com/engine/installation/linux/)
* [Instal Compose](https://docs.docker.com/compose/install/)


###### Build Java App:
      $ ./aguaBsb/gradlew build -p aguaBsb/


###### Execute:

      sudo docker-compose up -d

----

##### AguaBsb
http://{host}:80/agua

**GET**

Will return all month data.
