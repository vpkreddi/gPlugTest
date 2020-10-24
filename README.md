# gPlugTest
--run below command to build jar file

mvn clean package

--run below command to build docker image of java service

docker build --pull --rm -f "Dockerfile" -t gplugtest:latest "." 

-- run below command from with in this directory to bring up db, app services

docker-compose up

-- import postman collection

create-customer  -- to create customer
create-order --- to create order for particular customerid , repeat ten times, to see discount_value in response, and repeat 20 times to see discount_value increase by 10%

CRON job runs every 2 minutes, logs in to app service

**NOTE**
If not want to use docker , please change the following property in src/main/resources/application.properties to use localhost
spring.data.mongodb.uri=mongodb://localhost:27017/oms
