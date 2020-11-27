```
docker build -t bmi_db:latest .

docker run -d -p 5432:5432 --name bmi_db bmi_db:latest
```