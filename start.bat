@echo off
echo Starting...
docker-compose -p noteskeeper-all -f .\container\docker-compose.yaml up -d --build
echo Successfully started
@pause