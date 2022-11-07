# Ford Spare Parts Booking

GitHub URL : https://github.com/sahanshah-k/sparepartbooking/

Implementations: <br>
### Mandatory

Admin can do the following:

- Add spare part items

- View the spare parts

- Remove the spare parts

- Update the details of the spare parts

- Update stock/inventory of spare part

Users can do the following:

- Book a spare part

- View the spare part

- Book bulk spare parts

- Book multiple spare parts in bulk in a single order

- Only a single booking API should be used to handle all the use cases

- A user cannot book an item if it is out of stock

### Advanced

- An API to fetch all spare part items along with inventory

-  An API to fetch all booked items

- Dockerize the application (Dockerizing action in github - https://github.com/sahanshah-k/sparepartbooking/actions/workflows/main.yml), <br>Dockerfile - https://github.com/sahanshah-k/sparepartbooking/blob/main/Dockerfile

Schemas

- User

- SparePart

- Orders


Documentation - https://sparepart-ford.herokuapp.com/swagger-ui.html

Deployed in Heroku - Base URL - https://sparepart-ford.herokuapp.com/

Tech stack

Spring boot, Hibernate Java

Database - MongoDB

CICD - Github actions - https://github.com/sahanshah-k/sparepartbooking/blob/main/.github/workflows/main.yml

