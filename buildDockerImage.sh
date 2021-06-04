#!/usr/bin/env bash

set -eo pipefail

#modules=( admin-dashboard config-server eureka-server hystrix-dashboard service-a service-b zuul )
modules=(   service-a service-b  )

for module in "${modules[@]}"; do
    docker build -t "harbor-b.alauda.cn/asm/netflix/spring-cloud-netflix-example/${module}:latest" ${module} --load
done
