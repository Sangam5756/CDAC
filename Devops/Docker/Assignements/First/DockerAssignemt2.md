By using the copy method copying file to the docker image

ttpd              "httpd-foreground"       38 seconds ago   Up 37 seconds             0.0.0.0:8080->80/tcp, [::]:8080->80/tcp       web1
4f19be27fe9b   redis:6.2-alpine   "docker-entrypoint.s…"   2 weeks ago      Up 20 minutes (healthy)   0.0.0.0:6379->6379/tcp, [::]:6379->6379/tcp   redis

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ ls
WhatContainer.md  dockerfile  index.html

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ docker cp index.html web1:/usr/local/apache2/htdocs/index.html
Successfully copied 2.05kB to web1:/usr/local/apache2/htdocs/index.html


Now using the method of dockerfile



ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ ls
DockerAssignemt1.md  WhatContainer.md  dock  dockerfile  index.html

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ docker build -t app .
[+] Building 2.2s (7/7) FINISHED                                                                                                                   docker:desktop-linux
 => [internal] load build definition from dockerfile                                                                                                               0.1s
 => => transferring dockerfile: 94B                                                                                                                                0.0s
 => [internal] load metadata for docker.io/library/httpd:latest                                                                                                    0.4s
 => [internal] load .dockerignore                                                                                                                                  0.1s
 => => transferring context: 2B                                                                                                                                    0.0s
 => [internal] load build context                                                                                                                                  0.1s
 => => transferring context: 360B                                                                                                                                  0.0s
 => [1/2] FROM docker.io/library/httpd:latest@sha256:e19cdd61f51985351ca9867d384cf1b050487d26bb1b49c470f2fcda1b5f276c                                              0.4s
 => => resolve docker.io/library/httpd:latest@sha256:e19cdd61f51985351ca9867d384cf1b050487d26bb1b49c470f2fcda1b5f276c                                              0.1s
 => [2/2] COPY index.html /usr/local/apache2/htdocs                                                                                                                0.1s
 => exporting to image                                                                                                                                             0.7s
 => => exporting layers                                                                                                                                            0.3s
 => => exporting manifest sha256:b39104ff6a7770ff7fb17378dee9210d18c3e218eab75c1364d7089cb37a7985                                                                  0.0s
 => => exporting config sha256:5ce82d2a0879948a663add2fb4beb505b7c1dba070fca9d7acc85721681c3cbe                                                                    0.0s
 => => exporting attestation manifest sha256:9821c528baa81f48d5f5f56cb96fa59ee2dbd8b26f66547a001360aee56f83fc                                                      0.1s
 => => exporting manifest list sha256:8f70e1db0cec414da4672ecc6a3ae36c521389a8c21335e6bcf572138743d4e8                                                             0.0s
 => => naming to docker.io/library/app:latest                                                                                                                      0.0s
 => => unpacking to docker.io/library/app:latest                                                                                                                   0.1s

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ docker images;
REPOSITORY    TAG          IMAGE ID       CREATED         SIZE
app           latest       8f70e1db0cec   6 seconds ago   175MB
httpd         latest       e19cdd61f519   38 hours ago    175MB
postgres      latest       38d5c9d52203   3 weeks ago     643MB
mysql         8.0          0275a35e79c6   4 weeks ago     1.06GB
mongo         latest       bf5995bcccb6   5 weeks ago     1.24GB
redis         6.2-alpine   37e002448575   8 weeks ago     44.6MB
ubuntu        latest       c35e29c94501   2 months ago    117MB
hello-world   latest       d4aaab6242e0   4 months ago    20.3kB

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ docker stop httpd
Error response from daemon: No such container: httpd

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ docker ps
CONTAINER ID   IMAGE              COMMAND                  CREATED         STATUS                    PORTS                                         NAMES
e7903999b5d7   httpd              "httpd-foreground"       6 minutes ago   Up 6 minutes              0.0.0.0:8080->80/tcp, [::]:8080->80/tcp       web1
4f19be27fe9b   redis:6.2-alpine   "docker-entrypoint.s…"   2 weeks ago     Up 26 minutes (healthy)   0.0.0.0:6379->6379/tcp, [::]:6379->6379/tcp   redis

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ docker stop web1
web1

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ docker run --name web2 -d -p 8080:80 app
7a62b8ba0256968fdc7bdd19de57a7b097e119c6e0f4225fababf3cef4f073b7

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$ docker ps
CONTAINER ID   IMAGE              COMMAND                  CREATED          STATUS                    PORTS                                         NAMES
7a62b8ba0256   app                "httpd-foreground"       23 seconds ago   Up 22 seconds             0.0.0.0:8080->80/tcp, [::]:8080->80/tcp       web2
4f19be27fe9b   redis:6.2-alpine   "docker-entrypoint.s…"   2 weeks ago      Up 27 minutes (healthy)   0.0.0.0:6379->6379/tcp, [::]:6379->6379/tcp   redis

ADMIN@unknown MINGW64 /d/CDAC/Devops/Docker (main)
$

