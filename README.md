## 使用 Docker 构建、运行 Spring Boot 应用

### 构建

#### 首先创建一个最简单的 Spring Boot 应用

#### 配置Docker
然后在 `pom.xml` 中配置一下 `docker-maven-plugin` :

```
<properties>
    <docker.image.prefix>craftcoder</docker.image.prefix>
</properties>

<plugin>
    <groupId>com.spotify</groupId>
    <artifactId>docker-maven-plugin</artifactId>
    <version>1.0.0</version>
    <configuration>
        <imageName>${docker.image.prefix}/${project.artifactId}</imageName>
        <dockerDirectory>src/main/docker</dockerDirectory>
        <resources>
            <resource>
                <targetPath>/</targetPath>
                <directory>${project.build.directory}</directory>
                <include>${project.build.finalName}.jar</include>
            </resource>
        </resources>
    </configuration>
</plugin>
```

+ `imageName`: 指定镜像的名字
+ `dockerDirectory`: 指定Dockerfile的位置
+ `resources`: 是指那些需要和 Dockerfile 放在一起，在构建镜像时使用的文件，一般应用 jar 包需要纳入

#### 编写Dockerfile
```
FROM java:8-jdk-alpine
VOLUME /tmp
ADD spring-boot-docker-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
```

+ `VOLUME`: 指定了临时文件目录为 `/tmp`,其效果是在主机 `/var/lib/docker` 目录下创建了一个临时文件，并链接到容器的 `/tmp`。此步骤是可选的，如果涉及到文件系统的应用就很有必要了。`/tmp` 目录用来持久化到 Docker 数据文件夹，因为 Spring Boot 使用的内嵌 Tomcat 容器默认使用 `/tmp` 作为工作目录;
+ 将项目的打出的包 `spring-boot-docker-0.0.1-SNAPSHOT.jar` 添加到容器中，重命名成 `app.jar`;
+ `ENTRYPOINT`: 执行项目 `app.jar` 。为了缩短 Tomcat 启动时间，添加一个系统属性指向 `/dev/urandom` 作为 `Entropy Source`。

### 运行

#### 使用maven打包运行

```
mvn package

java -jar target/spring-boot-docker-0.0.1-SNAPSHOT.jar
```

#### 使用Docker运行

```shell
mvn package docker:build
docker run --name sb-docker -d -p 8090:8090 craftcoder/spring-boot-docker
```

### 访问

url: `http://localhost:8090/`

```
# curl localhost:8090
{"app":"spring-boot-docker-app","time":"Thu Jun 22 04:57:06 GMT 2017"}
```
