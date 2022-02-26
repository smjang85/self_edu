@echo CREATE DOCKER IMAGES
set target=%1

cd C:\Users\smjan\Documents\workspace\storagerent\log
call kubectl apply -f ./kubernetes

cd C:\Users\smjan\Documents\workspace\storagerent\message
call kubectl apply -f ./kubernetes

cd C:\Users\smjan\Documents\workspace\storagerent\payment
call kubectl apply -f ./kubernetes

cd C:\Users\smjan\Documents\workspace\storagerent\reservation
call kubectl apply -f ./kubernetes

cd C:\Users\smjan\Documents\workspace\storagerent\storage
call kubectl apply -f ./kubernetes

cd C:\Users\smjan\Documents\workspace\storagerent\viewpage
call kubectl apply -f ./kubernetes