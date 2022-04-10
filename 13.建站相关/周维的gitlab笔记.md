## 1. docker

### 1.1 说明

​	docker和docker-compose安装在192.168.30.102，这台机器外网出口被限制了，需要找运维配白名单，目前配了有：

* https://registry.npmjs.org/ 

* https://registry.npm.taobao.org/

* https://hub.docker.com/ 

* https://2e0u7z77.mirror.aliyuncs.com

* https://repo1.maven.org/maven2/

* http://maven.aliyun.com/nexus/content/groups/public/

### 1.2 安装及配置

```shell
# 安装docker
yum remove docker docker-client docker-client-latest docker-common docker-latest docker-latest-logrotate docker-logrotate docker-engine
yum install -y yum-utils device-mapper-persistent-data lvm2
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
yum install docker-ce docker-ce-cli containerd.io

# 配置docker镜像仓库 {"registry-mirrors":["https://reg-mirror.qiniu.com/"]}
vim /etc/docker/daemon.json

# 配置docker远程访问 ExecStart=/usr/bin/dockerd -H tcp://0.0.0.0:2375 -H unix:///var/run/docker.sock
vim /usr/lib/systemd/system/docker.service

# 安装docker-compose
curl -L https://get.daocloud.io/docker/compose/releases/download/1.25.1/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
```

### 1.3 注意事项

​	gitlab和nexu的数据卷是通过docker volume管理的，可以通过docker volume ls 和 docker volume inspect [name]命令查看，请注意不要误清理掉。

| volume        | 容器内路径      | 用途                                         |
| ------------- | --------------- | -------------------------------------------- |
| gitlab_config | /etc/gitlab     | gitlab配置目录                               |
| gitlab_log    | /var/log/gitlab | gitlab日志目录                               |
| gitlab_data   | /var/opt/gitlab | gitlab数据目录，项目代码所在目录，***重要*** |
| nexus_data    | /nexus-data     | nexus仓库目录                                |



## 2. gitlab

### 2.1 说明

​	CRM前后端和小程序代码都在该gitlab上，版本为gitlab-ce=13.6.2-ce.0

### 2.2 安装及配置

#### 2.2.1 gitlab

```shell
# 创建volume用来映射容器内的目录
docker volume create gitlab_config
docker volume create gitlab_log
docker volume create gitlab_data
# 安装，不用ssh克隆可以去掉22端口映射;停止后需要删掉容器重新跑一下这个命令，注意不要清理volume
docker run -d --name gitlab --privileged=true \
	  -v gitlab_config:/etc/gitlab \
	  -v gitlab_log:/var/log/gitlab \
	  -v gitlab_data:/var/opt/gitlab \
	  -p 2080:2080 \
	  -p 22:22 \
	  gitlab/gitlab-ce
	  
# 配置,添加这行 external_url 'http://210.22.20.163:2080'
vi /var/lib/docker/volumes/gitlab_config/_data/gitlab.rb
docker restart gitlab
```

#### 2.2.2 gitlab-runner

安装gitlab-runner之前需要安装新版本的git，安装包可以在104的/app目录下找到，参考安装方式：

```shell
# 卸载老版本git
yum remove git
# 安装依赖
yum -y install curl-devel expat-devel gettext-devel openssl-devel zlib-devel gcc perl-ExtUtils-MakeMaker
# 通过源码安装git
tar zxf git-2.25.1.tar.gz cd git-2.25.1
make prefix=/usr/local/git all
make prefix=/usr/local/git install
# 添加环境变量: /usr/local/git/bin
vi /etc/bashrc 
source /etc/bashrc
git --version

# 通过rpm安装runner
rpm -ivh gitlab-runner-13.6.0-1.x86_64.rpm --nodeps --force
# 注册，executor选择shell
/usr/bin/gitlab-runner register
# 默认为gitlab-runner用户，测试环境可以切换到root用户
/usr/bin/gitlab-runner uninstall
/usr/bin/gitlab-runner install --working-directory /home/gitlab-runner --user root
/usr/bin/gitlab-runner restart
```

已注册的runner可以在Admin Area -> Overview -> Runners处维护（需要root账号登录gitlab）。其中specific类型的runner需要分配了某个项目之后，那个项目才能使用该runner。这里是部分信息：

| 机器           | 用户          | 类型     | 用途                  |
| -------------- | ------------- | -------- | --------------------- |
| 192.168.30.102 | root          | shared   | 构建                  |
| 192.168.30.104 | root          | specific | 发布到测试环境104节点 |
| 192.168.30.101 | gitlab-runner | shared   | 发布到测试环境101节点 |
| 39.100.118.173 | gitlab-runner | specific | 发布到生产环境        |

注意事项：gitlab-runner用户需要以下权限：

* /opt/log/crm，chmod -R 777 /opt/log/crm
* /app/crm，chmod -R 777 /app/crm
* netstat、xargs，修改/etc/sudoers，添加一行：gitlab-runner ALL=(ALL)   NOPASSWD:/usr/bin/netstat,/usr/bin/xargs

#### 2.2.3 CI

语法可以参考：http://192.168.30.102:2080/help/ci/yaml/README.md

* 前端

  ![](C:\Users\Administrator\Downloads\gitlab-ci-crm-front.svg)

* 后端



## 3. nexus