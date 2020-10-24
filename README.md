# gPlugTest

--run below command to build docker image of java service

docker build --pull --rm -f "Dockerfile" -t gplugtest:latest "." 

-- run below command from with in this directory

docker-compose up

-- import postman collection

create-customer  -- to create customer
create-order --- to create order for particular customerid , repeat ten times, to see discount_value in response, and repeat 20 times to see discount_value increase by 10%