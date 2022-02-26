@echo CREATE DOCKER IMAGES
set docker_build_bat_path=C:\Users\smjan\Documents\workspace\storagerent

start %docker_build_bat_path%\docker_build_target.bat message
start %docker_build_bat_path%\docker_build_target.bat payment
start %docker_build_bat_path%\docker_build_target.bat reservation
start %docker_build_bat_path%\docker_build_target.bat storage
start %docker_build_bat_path%\docker_build_target.bat viewpage
start %docker_build_bat_path%\docker_build_target.bat log

cd C:\Users\smjan\Documents\workspace\storagerent