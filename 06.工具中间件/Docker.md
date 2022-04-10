# █ Docker

# 一. 概述

## 1. 概述

## 2. docker 架构

- **镜像（Image）**：Docker 镜像（Image），就相当于是一个 root 文件系统。比如官方镜像 ubuntu:16.04 就包含了完整的一套 Ubuntu16.04 最小系统的 root 文件系统。
- **容器（Container）**：镜像（Image）和容器（Container）的关系，就像是面向对象程序设计中的类和实例一样，镜像是静态的定义，容器是镜像运行时的实体。容器可以被创建、启动、停止、删除、暂停等。
- **仓库（Repository）**：仓库可看成一个代码控制中心，用来保存镜像。

# 二. 安装与配置

## 1. 安装

### 1.1. 脚本安装

### 1.2. yum

### 1.3. apt

## 2. 基本配置

## 3. 基本操作



# 三. 镜像与仓库

# 四. 应用部署

> 参考网址：https://www.runoob.com/docker/docker-run-command.html

##### centos 环境下安装docker

```shell
curl -sSL https://get.daocloud.io/docker | sh
#默认docker安装位置 /var/lib/docker
```

##### 启动/停止命令

```shell
#启动docker服务，守护进程
systemctl start docker
#查看状态
systemctl status docker
```

##### 查找镜像

```shell
docker search [OPTIONS] TERM
OPTIONS说明：
    --automated :只列出 automated build类型的镜像；
    --no-trunc :显示完整的镜像描述；
    --filter :过滤条件
示例：docker search nginx
```

##### 下载镜像

```shell
docker pull [OPTIONS] NAME[:TAG|@DIGEST]
OPTIONS说明：
    -a :拉取所有 tagged 镜像
    --disable-content-trust :忽略镜像的校验,默认开启
 示例：docker pull nginx 拉取最新版本的nginx
```

##### 上传镜像

```shell
#将本地的镜像上传到镜像仓库,要先登陆到镜像仓库
docker push [OPTIONS] NAME[:TAG]
OPTIONS说明：
	--disable-content-trust :忽略镜像的校验,默认开启
```

##### 查看有已经下载了哪些镜像

```shell
docker images [OPTIONS] [REPOSITORY[:TAG]]
OPTIONS说明：
    -a :列出本地所有的镜像（含中间映像层，默认情况下，过滤掉中间映像层）；
    --digests :显示镜像的摘要信息；
    -f :显示满足条件的镜像；
    --format :指定返回值的模板文件；
    --no-trunc :显示完整的镜像信息；
    -q :只显示镜像ID。
示例：docker images
```

##### 根据镜像创建（并启动）容器

```shell
#创建容器但不启动
docker create [OPTIONS] IMAGE [COMMAND] [ARG...]
# 创建并启动容器
docker run [OPTIONS] IMAGE [COMMAND] [ARG...]
OPTIONS说明：
    -a stdin: 指定标准输入输出内容类型，可选 STDIN/STDOUT/STDERR 三项；
    -d: 后台运行容器，并返回容器ID；
    -i: 以交互模式运行容器，通常与 -t 同时使用；
    -P: 随机端口映射，容器内部端口随机映射到主机的端口
    -p: 指定端口映射，格式为：主机(宿主)端口:容器端口
    -t: 为容器重新分配一个伪输入终端，通常与 -i 同时使用；
    --name="nginx-lb": 为容器指定一个名称；
    --dns 8.8.8.8: 指定容器使用的DNS服务器，默认和宿主一致；
    --dns-search example.com: 指定容器DNS搜索域名，默认和宿主一致；
    -h "mars": 指定容器的hostname；
    -e username="ritchie": 设置环境变量；
    --env-file=[]: 从指定文件读入环境变量；
    --cpuset="0-2" or --cpuset="0,1,2": 绑定容器到指定CPU运行；
    -m :设置容器使用内存最大值；
    --net="bridge": 指定容器的网络连接类型，支持 bridge/host/none/container: 		四种类型；
    --link=[]: 添加链接到另一个容器；
    --expose=[]: 开放一个端口或一组端口；
    --volume , -v:	绑定一个卷
示例：docker run -dit --name=nginx_container nginx
```

##### 列出容器

```shell
docker ps [OPTIONS]
OPTIONS说明：
    -a :显示所有的容器，包括未运行的。
    -f :根据条件过滤显示的内容。
    --format :指定返回值的模板文件。
    -l :显示最近创建的容器。
    -n :列出最近创建的n个容器。
    --no-trunc :不截断输出。
    -q :静默模式，只显示容器编号。
    -s :显示总的文件大小。
示例：docker ps -a
```

##### 启动/重启/停止/删除/进入容器

```shell
#启动
docker start nginx_container
#重启
docker restart nginx_container
#停止
docker stop nginx_container
#删除(停止状态下才能删除)
docker rm nginx_container
#暂停容器内所有进程
docker pause nginx_container
#恢复容器内所有进程
docker unpause nginx_container
```

##### 查看镜像元信息

```shell
docker inspect [OPTIONS] NAME|ID [NAME|ID...]
OPTIONS说明：
    -f :指定返回值的模板文件。
    -s :显示总的文件大小。
    --type :为指定类型返回JSON。
示例：docker inspect nginx
```

##### 日志

```shell
docker logs [OPTIONS] CONTAINER
OPTIONS说明：
    -f : 跟踪日志输出
    --since :显示某个开始时间的所有日志
    -t : 显示时间戳
    --tail :仅列出最新N条容器日志
```







