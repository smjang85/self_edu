@echo CREATE DOCKER IMAGES
set target=%1

cd C:\Users\smjan\Documents\workspace\storagerent\%target%
call mvn clean package
call docker build -t 879772956301.dkr.ecr.ca-central-1.amazonaws.com/user20-%target%:latest .
call docker push 879772956301.dkr.ecr.ca-central-1.amazonaws.com/user20-%target%:latest
call kubectl apply -f ./kubernetes
call kubectl set image deploy log log=879772956301.dkr.ecr.ca-central-1.amazonaws.com/user20-%target%:latest