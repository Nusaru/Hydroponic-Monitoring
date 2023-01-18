# Hydroponic-Monitoring

This is a mini project for Monitoring Hydroponic on a site. In here, server will receive Hydroponic unit's data such pH, Electrical Conductivity (EC), Water Temperature, and Total Disolved Solids (TDS) from sensor reading onsite. Then, those data will sent to client side to be monitored. Here's a brief detail about he project.

- There're 3 Model/Entity.
  - Site
  - Hydroponic Unit.
  - Unit Data.
- In one site, there can be multiple Hydroponic unit.
- UUID is used for id/primary key.

## API Documentation
Swagger Open API Documentation
- http://localhost:8080/swagger-ui/index.html

## How To Use

- Clone
```bash
git clone https://github.com/Nusaru/Hydroponic-Monitoring.git
```
- Create a PostgreSQL Database with the name "Hydroponic".
  - Make sure the database setting at application.properties are correct.
  - You can use other name, but you need to change the datasource in the application.properties.
- Run the project. Upon the first run, the table will automatically created in the previously created database.
