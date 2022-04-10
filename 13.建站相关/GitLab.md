# gitlab ci/cd

* 版本
  * gitlab-ce=13.6.2-ce.0
* 文档
  * https://docs.gitlab.com/13.6/ee/ci/yaml/README.html
  * https://gitlab.deepexi.top/help/ci/yaml/README.md#gitlab-cicd-pipeline-configuration-reference

## 一. gitlab

```shell
# 安装，不用ssh克隆可以去掉22端口映射
# 停止后需要删掉容器重新跑一下这个命令，注意不要清理volume
docker run -d --name gitlab --privileged=true \
	  -v gitlab_config:/etc/gitlab \
	  -v gitlab_log:/var/log/gitlab \
	  -v gitlab_data:/var/opt/gitlab \
	  -p 2080:2080 \
	  -p 22:22 \
	  gitlab/gitlab-ce
	  
# 配置
vi /var/lib/docker/volumes/gitlab_config/_data/gitlab.rb
# 添加这行 external_url 'http://192.168.30.102:2080'
docker restart gitlab
```

## 二. runner

```shell
# 1.rpm安装
rpm -ivh gitlab-runner-13.6.0-1.x86_64.rpm --nodeps --force
# 注册，executor选择shell
/usr/bin/gitlab-runner register
# 切换root用户
/usr/bin/gitlab-runner uninstall
/usr/bin/gitlab-runner install --working-directory /home/gitlab-runner --user root
/usr/bin/gitlab-runner restart

# 2.docker安装，注册的时候executor选择docker
docker run -it --name gitlab-runner \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v gitlab_runner_config:/etc/gitlab-runner \
    -v /var/lib/.m2/reposiotry:/var/lib/.m2/repository \
    gitlab/gitlab-runner:latest register
```

## 三. git

```shell
# 卸载老版本
yum remove git
# 安装依赖
yum -y install curl-devel expat-devel gettext-devel openssl-devel zlib-devel gcc perl-ExtUtils-MakeMaker
# vi /etc/yum.repos.d/CentOS-Media.repo，将里面的enabled=1改成enabled=0，然后保存退出
tar zxf git-2.25.1.tar.gz cd git-2.25.1
make prefix=/usr/local/git all
make prefix=/usr/local/git install
# 添加环境变量: /usr/local/git/bin
vi /etc/bashrc 
source /etc/bashrc
git --version
```

## 四. nexus

```shell
docker run -d --name nexus3 --restart=always \
    -v nexus_data:/nexus-data \
    -p 2081:8081 \
    sonatype/nexus3:3.29.0
```

# █ gitlab-ci.yml

要使用 gitlab 的 CI/CD 功能, 需要在项目根目录下添加一个 `gitlab-ci.yml` 文件, 在这个文件里, 我们可以对项目的持续集成进行管理

## 准备工作

1. 将项目提交到 gitlab
2. 当前用户是项目的 maintainer 或 owner, 以便有权限进行 CI/CD 设置
3. 需要提供一个 gitlab runner, 可以是整个 gitlab 服务器, 也可以针对项目或组织的
4. 在项目根目录中创建一个 `gitlab-ci.yml` 文件, 在里面定义 CI/CD 的具体操作

## CI Lint

可以在提交 `gitlab-ci.yml` 之前, 检查脚本是否正确, 

当前项目-CI/CD, 点击右上角的 `CI Lint`  进入检查界面, 在文本框中粘贴完整的脚本.

注意, 对于通过 include 包含子项目的 `gitlab-ci.yml` 的多文件配置的场景, 需要先提交子项目的 `gitlab-ci.yml`, 否则无法通过检查.

### 为项目启用 runner

gitlab 的 CI/CD 需要通过 runner 来执行, 为了满足不同的需求, 可以使用不同的 runner.

对于一个具体的项目, 我们需要为该项目指定要使用的 runner

- Go to **Settings > CI/CD** and expand **Runners**.

该页面下有三种 runner, 只要有任意一个, 均可执行 gitlab CI/CD Jobs

- shared runner, 共享的, 当前gitlab 服务器下的所有项目均可使用
- group runner, 组内共享的, 当前用户所属的组织可以使用
- specific runner, 项目特有的, 只有当前项目可以使用

如果没有 runner, 需要先安装 runner, 详见[官方文档](https://docs.gitlab.com/runner/install/)

## 编写 gitlab-ci.yml

在这个文件里, 我们需要定义以下内容

- 需要执行的 job 的结构以及执行顺序
- 决定是否执行 job 的条件

```yaml
# 使用 variables 声明变量
variables:
  release: "false"
  deployment: ""
  gitlab_server: "gitlab.vstecstest.com"
  release_xml: "web-package"

# 使用 stages 声明各阶段的执行顺序, 有默认值
stages:
  - build
  - test
  - deploy
  - release
  - test-deployment

# 使用任意名称, 定义job
${job的名称}:
	stage: 必须, 指定job要在哪个阶段执行
	script: 
		- 要执行的脚本
		- 用横杠分行, 每行依次执行
```

## 执行 CI

每当有新的修改提交到 gitlab 时, 就会执行指定的 jobs, 组成了一个 pipeline

### 查看 pipeline 历史

- Go **CI/CD > Pipelines**.
- 主页会展示所有 pipeline 历史记录
- 点击 pipeline 可以查看该次 pipeline 的详情
- 点击 job 可以查看该 job 的执行详情及控制台输出信息





# 一. 基本概念

## pipeline

一次 ci 的全流程, 包括多个 stages, 每个 stage 时可以执行多个 job

## stage



## job

基本操作步骤, 指定条件以及要执行的具体操作

每个 job 需要有一个独一无二的 job 名称, 并且不能使用以下关键字: 

| 关键字        | 描述                                            |
| :------------ | :---------------------------------------------- |
| image         | 用于docker镜像，查看docker文档                  |
| services      | 用于docker服务，查看docker文档                  |
| stages        | 定义构建阶段                                    |
| types         | stages 的别名(已废除)                           |
| before_script | 定义在每个job之前运行的命令                     |
| after_script  | 定义在每个job之后运行的命令                     |
| variable      | 定义构建变量                                    |
| cache         | 定义一组文件列表，可在后续运行中使用            |
| include       | 指定要引入到当前文件的的其他 gitlab-ci 配置文件 |

# 文件结构详情

## 全局配置

有一些关键字配置, 必须在 `gitlab-ci.yml` 文件的顶层中进行配置, 这些内容将会影响所有的 job

### 声明变量 variables

### 构建阶段 stages

- 在全局范围内为项目的 job 划分了执行顺序
- 同 stage 的 job 会并行执行
- 后一 stage, 会在前一 stage 的所有 job 执行成功后再执行, 如果某一个 job 执行失败, 则该次 pipeline 被中断, 后续 stage 的 job 都不会被执行
- 若项目未定义 stages , 则使用默认的 `build`, `test`, `deploy` 三阶段
- 如果一个 job 没有指定 stage, 则该 job 会在 stage=test 时执行

除了通过 `stages` 显式声明的 stage, gitlab-ci 的全流程还包含了两个隐藏的 stage: `.pre` 和 `.post`

- job 中的 stage 可以使用 `stages` 块声明的阶段, 也能使用 `.pre` 和`.post`
- `.pre` 在 stages 声明的所有阶段之前执行
- `.post` 在 stages 声明的所有阶段之后执行
- `.pre` 和 `.post` 不需在 `stages` 中声明, 声明了也会被忽略, 顺序也不能被改变
- 若 `.pre` 和 `.post` 之间没有其他 stage, 则 pipeline 不会启动

### 工作流 workflow

根据条件决定是否要创建一个 pipeline. 下面有一个 `rules` 配置, rules 下有 `if` 和 `when` 两个配置

- `if`: 指定一个条件
- `when`: 当 `if` 的条件满足时, 执行什么操作
  - 要执行 pipeline, 使用 `always`, 默认
  - 要中止 pipeline, 使用 `never`

如果 rules 下的 if 都不满足, 则 pipeline 不会启动

```yaml
# commit message 中带 -wip 的, 不会触发pipeline, 其余的 push 操作都会启动 pipeline
workflow:
  rules:
    - if: $CI_COMMIT_MESSAGE =~ /-wip$/
      when: never
    - if: '$CI_PIPELINE_SOURCE == "push"'
```

另外, 也可以只指定不触发 pipeline 的条件, 其余情况都触发 pipeline

```yaml
# 前面指定了不触发 pipeline 的条件, 其余的都会触发 pipeline
workflow:
  rules:
    - if: '$CI_PIPELINE_SOURCE == "schedule"'
      when: never
    - if: '$CI_PIPELINE_SOURCE == "push"'
      when: never
    - when: always
```

使用 rules 时需要注意, 某些情况下可能会导致重复的pipeline, 为了避免重复 pipeline, gitlab 提供了一些模板, 可以参考

### 导入文件 include

为了方便代码复用和提高可读性, gitlab-ci.yml 也支持通过 `include` 导入外部的 yaml 文件, 完善当前 `gitlab-ci.yml` 的配置内容.

可以导入项目内的其他 yaml 文件, 也可以将一些模板文件添加到中央仓库中, 以便跨项目共享配置.

`include` 只允许导入 yaml 文件, 必须使用`.yml` 或 `.yaml` 扩展名

注意, 使用 yaml 锚点时, 只能引用同文件内的锚点, 不支持跨文件引用, 但可以通过 gitlab 提供的 `extends` 继承配置功能来实现跨文件引用. 

可以使用以下的内容, 并且不能使用变量表达式

| Keyword    | Method                                          |
| ---------- | ----------------------------------------------- |
| `local`    | 从**当前项目**路径中导入文件                    |
| `file`     | 从**另一项目**路径中导入文件                    |
| `remote`   | 从**远程url**中引用文件, 该文件必须允许公开访问 |
| `template` | 从 gitlab 的 template 中导入模板                |

- include 的文件内容, 会递归地合并到 gitlab-ci.yml 中
- 总是先计算表达式的值, 再合并到 gitlab-ci.yml, 因此要注意变量的作用域, gitlab-ci.yml 的定义将会覆盖被导入的文件中的定义

#### local

local 会从当前仓库中查找要导入的文件, 使用相对于项目根目录的路径来指定文件位置, 并要注意, gitlab-ci.yml 必须与被导入的文件处在同一分支中. 

不支持从 git submodule 中导入文件

```yaml

```



#### file

从当前 gitlab 服务器的其他项目导入文件时, 需要`project`指定项目名, 并用`file`指定文件路径

也可以通过`ref`指定要使用的分支, tag, commit编号等

```yaml
include:
  - project: 'my-group/my-project'
    file: '/templates/.gitlab-ci-template.yml'

include:
  - project: 'my-group/my-project'
    ref: master
    file: '/templates/.gitlab-ci-template.yml'

  - project: 'my-group/my-project'
    ref: v1.0.0
    file: '/templates/.gitlab-ci-template.yml'

  - project: 'my-group/my-project'
    ref: 787123b47f14b552955ca2786bc9542ae66fee5b  # Git SHA
    file: '/templates/.gitlab-ci-template.yml'
```

允许从同一项目中导入多个文件, 只需要使用列表形式指定文件路径即可

```yaml
include:
  - project: 'my-group/my-project'
    ref: master
    file:
      - '/templates/.builds.yml'
      - '/templates/.tests.yml'
```

#### remote

使用远程 url 获取文件时, 该文件必须能通过 http/https 的 get 请求访问

```yaml
include:
  - remote: 'https://gitlab.com/awesome-project/raw/master/.gitlab-ci-template.yml'
```

#### template

需要先将 template 文件添加到 gitlab 中

```yaml
include:
  - template: Android-Fastlane.gitlab-ci.yml
  - template: Auto-DevOps.gitlab-ci.yml
```

### 默认配置 default

可以使用 `default` 为 job 指定默认值, 可以在 `default` 块中指定默认值的配置有以下几个

| 关键字          | 描述                                 |
| :-------------- | :----------------------------------- |
| `image`         | 用于docker镜像，查看docker文档       |
| `services`      | 用于docker服务，查看docker文档       |
| `before_script` | 定义在每个job之前运行的命令          |
| `after_script`  | 定义在每个job之后运行的命令          |
| `tags`          | 指定要使用的 runner                  |
| `cache`         | 定义一组文件列表，可在后续运行中使用 |
| `artifacts`     |                                      |
| `retry`         |                                      |
| `timeout`       |                                      |
| `interruptible` |                                      |

默认值将被应用到所有未声明同名配置的 job, 若 job 中单独声明了同名的 配置, 则以 job 中的为准

```yaml
default:
  image: ruby:2.5

# 未声明 image, 使用默认值, ruby 2.5
rspec:
  script: bundle exec rspec

# 单独声明了 image, 覆盖默认值, 使用 ruby 2.6
rspec 2.6:
  image: ruby:2.6
  script: bundle exec rspec
```

#### 继承 inherit

默认情况下, 各个 job 中未声明的配置, 都会继承 `default` 中的默认值, 但可能有个别的 job, 我们不希望它们继承 默认值, 或是选择性地继承, 有以下两种做法:

- 通过 `true` 或 `false` 控制是否继承 default 和 variables 块中的配置
- 通过数组或列表, 显式的声明要继承的配置, 其他配置将被忽略

```yaml
default:
  image: 'ruby:2.4'
  before_script:
    - echo Hello World

variables:
  DOMAIN: example.com
  WEBHOOK_URL: https://my-webhook.example.com

rubocop:
  # 禁用 default 和 variables 中的所有配置
  inherit:
    default: false
    variables: false
  script: bundle exec rubocop

rspec:
  # 选择性继承 default 和 variables 中的配置
  inherit:
    default: [image]
    variables: [WEBHOOK_URL]
  script: bundle exec rspec

capybara:
  # 继承 default, 忽略 variables
  inherit:
    variables: false
  script: bundle exec capybara

karma:
  # 继承 default, 选择性继承 variables
  inherit:
    default: true
    variables: [DOMAIN]
  script: karma
```

## Job的配置

在 gitlab-ci.yml 文件的顶层配置中, 除了特殊的关键字声明的段, 其余的段都被视为是 job

在 job 下面, 可以对每个 job 做一些针对性的配置

### 脚本 script

每个 job 都必须有 script 属性, 用来指定该 job 需要完成什么操作, script 是job 中唯一一个必填属性, 除了 script, 其他属性可以省略, 或者有默认值.

- 在 script 中, 可以使用 yaml 的锚点及引用.
- script 中使用 shell 命令, 可以以列表形式提供多个命令
- 在某些时候, 可能需要用双引号将命令括起来, 比如使用了特殊符号或关键字时
- 如果任意一个命令返回了一个退出代码而不是0, 那么该 job 将认为失败, 中止执行

```yaml
job:
  script:
    - false || exit_code=$?
    - if [ $exit_code -ne 0 ]; then echo "Previous command failed"; fi;
```

### 前处理脚本 before_script

在每个 job 的 script 前执行, 会与 job 的 script 合并在一起后执行, 必须以列表形式给出

- 如果定义了全局的 before_script, 会应用到每个 job
- 如果在 job 内定义了 before_script, 会覆盖全局配置的 before_script
- 在 before_script 中, 可以使用 yaml 锚点与引用

### 后处理脚本 after_script

在每个 job 的 script 后执行, 包括失败的 job, 也会执行 after_script, 必须以列表形式给出

- 如果定义了全局的 after_script, 会应用到每个 job
- 如果 job 不是执行成功或失败, 而是因为超时而结束, 则 after_script 不会执行
- 如果在 job 内定义了 after_script, 会覆盖全局配置的 after_script
- 在 after_script中, 可以使用 yaml 锚点与引用
- after_script 在一个有别与 before_script 与 script 的新 shell 中运行, 因此, 在 before_script 和 script 中做出的临时更改, 不会影响 after_script, 包括:
  - 工作目录重置到默认路径
  - 不能访问 before_script 和 script 中做出的改动, 如命令别名, 变量 





### 隐藏的job

如果不想让job 执行, 可以在job 的名称前添加一个 `.` 即可, 不需要将整个 job 注释掉. 

并且, 使用这种方式, 这个隐藏 job 可以配合 job 的 extends, 成为另一个 job 的一部分, 以便 job 脚本的复用

```yaml
.app_custom:
  only:
    changes:
      - crm-custom/**/*
      - crm-common/**/*
      - crm-kit/**/*
  variables:
    APP_PATH: ./crm-custom/crm-custom-impl
    IMAGE_NAME: crm-custom
    APP_NAME: crm-custom-impl
    PORT: 8001
```

### 扩展 extends

# 二. 示例

## 1. 单元测试



## 2. 发布到maven



## 3. 部署应用



## 4. 触发控制

### 按分支控制

### 按模块控制