# Spring Boot 3 Web Docker

## Usage

build image to repository

```shell
gradle jib
```

build image to local docker daemon

```shell
gradle jibDockerBuild
```

build docker image to tar file

```shell
gradle jibBuildTar

# tar file path: build/jib-image.tar
# docker load < jib-image.tar
```

## Configuration

change arch and os

```groovy
        platforms {
            platform {
                architecture = 'amd64' //arm64
                os = 'linux'
            }
        }
```

## Run

```shell
docker run -d --rm -p 8080:8080 --name springboot3-docker-sample alphaegg/springboot3-docker-sample:0.0.1-SNAPSHOT

#  curl http://localhost:8080/api/v1/hello
```

## Doc

[jib-gradle-plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-gradle-plugin)