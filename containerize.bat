@echo off
echo Start Containerization
docker buildx build -t local/noteskeeper-local:latest -f .\container\dockerfiles\java_app_basic .
echo Containerization finished...
@pause