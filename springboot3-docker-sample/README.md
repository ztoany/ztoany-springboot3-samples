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

## Doc

[jib-gradle-plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-gradle-plugin)