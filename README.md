This project is built in within SpringBoot and mongoDb 

- TO Test API
- first: Open Swagger - http://localhost:8080/swagger-ui/index.html
- for Post Method use the follwoing payload
[
  {
    "batteryName": "string",
    "postcode": "string",
    "wattCapacity": 0,
    "size": 0,
    "total": 0
  }
]
by using 
http://localhost:8080/api/batteries -----> POST API

- for get Method use the following api
  http://localhost:8080/api/batteries?startPostcode={n}&endPostcode={n} -----> Get API

These API can be used using postman as well 
