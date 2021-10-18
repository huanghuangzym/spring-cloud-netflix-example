#!/usr/bin/env bash

set -eo pipefail

#modules=( admin-dashboard config-server eureka-server hystrix-dashboard service-a service-b zuul )
modules=( service-a service-b service-c service-d service-e )

for module in "${modules[@]}"; do
    docker build -t "harbor-b.alauda.cn/asm/netflix/spring-cloud-netflix-example/${module}:ip" ${module} --load
done
