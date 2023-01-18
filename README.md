<div align= center> <img height=200 src="https://user-images.githubusercontent.com/88893818/211281215-56817687-f538-4a8f-8c72-0150b858959a.png"/>
<h1>Docker Homework</h1>
</div>

This is a simple implementation for a Docker assignment.

> Created using the Spring framework

### :telescope: Objective:

- Build the project via Dockerfile

- Push the project to dockerhub using multiple tags

### :eyes: My Project:

- Receives current news headlines of the designated country (source => thenewsapi.com)

- Shows the current Weather forecast (source => weatherapi-com)

- Shows a random joke (source => dad-jokes.p.rapidapi.com)

- And suggests a random activity for the bored (source => www.boredapi.com)

---
## For build in docker

1. Docker build:

  ``docker build . -t [imageName]``

2. Run docker image with port 8080:

  ``docker run -p 8080:8080 -t [imageName]``
