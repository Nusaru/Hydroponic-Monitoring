# Hydroponic-Monitoring

This is a mini project for Monitoring Hydroponic on a site. In here, server will receive Hydroponic unit's data such pH, Electrical Conductivity (EC), Water Temperature, and Total Disolved Solids (TDS) from sensor reading onsite. Then, those data will sent to client side to be monitored. Here's a brief detail about he project.

- There're 3 Model/Entity.
  - Site
  - Hydroponic Unit.
  - Unit Data.
- In one site, there can be multiple Hydroponic unit.
- UUID is used for id/primary key.

## How To Use

- Clone
```bash
git clone https://github.com/Nusaru/Hydroponic-Monitoring.git
```
- Create a PostgreSQL Database with the name "Hydroponic".
  - Make sure the database setting at application.properties are correct.
  - You can use other name, but you need to change the datasource in the application.properties.
- Run the project. Upon the first run, the table will automatically created in the previously created database.

## API Documentation
Swagger Open API Documentation. To use this, you must run the application.
- http://localhost:8080/swagger-ui/index.html

### Sites
#### Request
```http
GET /sites
```
#### Response
```
{
  "data": [
    {
      "id": "string",
      "siteLocation": "string",
      "siteStatus": true,
      "createdAt": "string"
    }
  ]
}
```
#### Request
```http
GET /sites/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `UUID string` | **Required**. Site id to fetch|

#### Response
```
{
  "data": {
    "id": "string",
    "siteLocation": "string",
    "siteStatus": true,
    "createdAt": "string"
  }
}
```

#### Request
```http
GET /sites/search?site=

```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `site`      | `string` | **Required, Case-Sensitive**. Site location search query|

#### Response
```
{
  "data": {
    "id": "string",
    "siteLocation": "string",
    "siteStatus": true,
    "createdAt": "string"
  }
}
```

#### Request
```http
POST /sites
```
#### Request Body
```
{
  "siteLocation": "string",
  "siteStatus": true
}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `siteLocation`      | `string` | **Required**. Hydroponic site location|
| `siteStatus`      | `boolean` | **Required**. Hydroponic site status|

#### Response
```
{
  "data": {},
  "message": "string"
}
```

#### Request
```http
PUT /sites
```
#### Request Body
```
{
  "id": "string",
  "siteLocation": "string",
  "siteStatus": true
}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `UUID string` | **Required**. Hydroponic site id to edit|
| `siteLocation`      | `string` | **Required**. Hydroponic site location|
| `siteStatus`      | `boolean` | **Required**. Hydroponic site status|

#### Response
```
{
  "data": {},
  "message": "string"
}
```
