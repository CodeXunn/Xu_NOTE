## Docker

### 什么是容器

Docker 是一个开源的应用容器引擎，基于 [Go 语言](https://www.runoob.com/go/go-tutorial.html) 并遵从 Apache2.0 协议开源。

Docker 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。

容器是完全使用沙箱机制，相互之间不会有任何接口（类似 iPhone 的 app）,更重要的是容器性能开销极低。

### 认识 Docker

- Web 应用的自动化打包和发布。
- 自动化测试和持续集成、发布。
- 在服务型环境中部署和调整数据库或其他的后台应用。
- 从头编译或者扩展现有的 OpenShift 或 Cloud Foundry 平台来搭建自己的 PaaS 环境。



### 不同⼈眼中的 Docker

#### 开发眼中的 Docker

- 简化了重复搭建开发环境的⼯作

#### 运维眼中的 Docker
- 交付系统更为流畅
- 伸缩性更好

### Docker在centOs安装

#### 前提条件

需要centos7版本以上的；

也就是内核版本，必须是3.10及以上，可以通过uname -r命令检查内核版本

``` linux
uname -r
```

#### 操作系统要求

要安装Docker Engine，您需要CentOS 7的维护版本。不支持或未测试存档版本。

该centos-extras库必须启用。默认情况下，此存储库是启用的，但是如果已禁用它，则需要 重新启用它。

overlay2建议使用存储驱动程序。

#### 卸载旧版本

较旧的Docker版本称为docker或docker-engine。如果已安装这些程序，请卸载它们以及相关的依赖项。

```linux
$ sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
```

#### 安装方法

您可以根据需要以不同的方式安装Docker Engine：

- 大多数用户会 设置Docker的存储库并从中进行安装，以简化安装和升级任务。这是推荐的方法。

- 一些用户下载并手动安装RPM软件包， 并完全手动管理升级。这在诸如在无法访问互联网的空白系统上安装Docker的情况下非常有用。

- 在测试和开发环境中，一些用户选择使用自动 便利脚本来安装Docker。

> 这里我们用第一种

#### 使用存储库安装

在新主机上首次安装Docker Engine之前，需要设置Docker存储库。之后，您可以从存储库安装和更新Docker。

设置存储库
安装yum-utils软件包（提供yum-config-manager 实用程序）并设置稳定的存储库。

```linux
$  yum install -y yum-utils

$  yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
```

#### 安装DOCKER引擎

1. 安装最新版本的Docker Engine和容器，或转到下一步以安装特定版本：

```
$ yum install docker-ce docker-ce-cli containerd.io
```

2. 配置稳定仓库

   ```
   官网地址
   yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
   ##阿里云地址
   yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
   ```

3. 安装Docker

   ```
   yum install  docker-ce
   ```

4. 启动Docker 并加入开机启动

   ```
   systemctl start docker
   systemctl enable docker
   ```

5. 验证安装

   ```
   docker run hello-world
   或者
   docker -v
   ```

### Docker常用命令

#### 镜像相关

	- 拉取镜像

```
docker pull <image>
```

- 搜索镜像

  ```
  docker search <image>  
  ```

#### 容器相关

- 启动一个容器

```
docker run
```

##### docker run 的常⽤选项

docker run [OPTIONS] IMAGE [COMMAND] [ARG…]
选项说明

	- -d，后台运⾏容器

- -e，设置环境变量

- --expose / -p 宿主端⼝:容器端⼝

- --name，指定容器名称

- --link，链接不同容器

- -v 宿主⽬录:容器⽬录，挂载 磁盘卷

  

- 启动/停止镜像

```
docker start/stop <容器名>
```

- 容器状态

```
docker ps <容器名>
```

- 容器日志信息

```
docker logs <容器名>
```

- 查看所有的容器命令如下

```
docker ps -a
```

- 使用 docker start 启动一个已停止的容器：

```
docker start b750bbbcfd88 #其中b750bbbcfd88是镜像id或者容器名
或
docker restart <容器 ID>
```

- 后台运行
  在大部分的场景下，我们希望 docker 的服务是在后台运行的，我们可以过 -d 指定容器的运行模式。

```
docker run -itd --name ubuntu-test ubuntu /bin/bash
```

- 停止容器的命令

```
docker stop <容器 ID>
```

- 进入容器

```
docker exec -it bc7465908096 bash
```

- 删除容器

```
docker rm -f 1e560fca3906
```

### 参考

https://www.runoob.com/docker/docker-container-usage.html

https://docs.docker.com/engine/install/centos/#installation-methods

https://time.geekbang.org/course/detail/100023501-83549