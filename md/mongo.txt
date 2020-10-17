# mongo





## 1.什么是MongoDB ?

​	MongoDB 是由C++语言编写的，是一个基于分布式文件存储的开源数据库系统。

在高负载的情况下，添加更多的节点，可以保证服务器性能。

MongoDB 旨在为WEB应用提供可扩展的高性能数据存储解决方案。

MongoDB 将数据存储为一个文档，数据结构由键值(key=>value)对组成。MongoDB 文档类似于 JSON 对象。字段值可以包含其他文档，数组及文档数组。



## 2.主要特点

- MongoDB的提供了一个面向文档存储，操作起来比较简单和容易。
- 你可以在MongoDB记录中设置任何属性的索引 (如：FirstName="Sameer",Address="8 Gandhi Road")来实现更快的排序。
- 你可以通过本地或者网络创建数据镜像，这使得MongoDB有更强的扩展性。
- 如果负载的增加（需要更多的存储空间和更强的处理能力） ，它可以分布在计算机网络中的其他节点上这就是所谓的分片。
- Mongo支持丰富的查询表达式。查询指令使用JSON形式的标记，可轻易查询文档中内嵌的对象及数组。
- MongoDb 使用update()命令可以实现替换完成的文档（数据）或者一些指定的数据字段 。
- Mongodb中的Map/reduce主要是用来对数据进行批量处理和聚合操作。
- Map和Reduce。Map函数调用emit(key,value)遍历集合中所有的记录，将key与value传给Reduce函数进行处理。
- Map函数和Reduce函数是使用Javascript编写的，并可以通过db.runCommand或mapreduce命令来执行MapReduce操作。
- GridFS是MongoDB中的一个内置功能，可以用于存放大量小文件。
- MongoDB允许在服务端执行脚本，可以用Javascript编写某个函数，直接在服务端执行，也可以把函数的定义存储在服务端，下次直接调用即可。
- MongoDB支持各种编程语言:RUBY，PYTHON，JAVA，C++，PHP，C#等多种语言。
- MongoDB安装简单。



## 3.在docker容器中使用



### 3.1. 官方指引 

https://hub.docker.com/_/mongo 

### 3.2. 获取镜像  

`docker pull mongo` 

### 3.3. 运行 MongoDB 镜像

  ```docker run --name mongo -p 27017:27017 -v ~/dockerdata/mongo:/data/db -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin -d mongo``` 

### 3.4. 通过 Docker 启动 MongoDB

 * 登录到 MongoDB 容器器中 

   `docker exec -it mongo bash`

* 通过 Shell 连接 MongoDB

  `mongo -u admin -p admin `

### 3.5 初始化 MongoDB 的库及权限

* 创建库

  `use springbucks;`

* 创建用户

  

```sql
 db.createUser(    
     {      
     user: "springbucks",      
     pwd: "springbucks",      
     roles: [         
         { role: "readWrite", db: "springbucks" }      
     ]    
     }  
 )
```

* 显示数据库列表：show dbs

  ```shell
  > show dbs
  admin  0.000GB
  local  0.000GB
  wgq    0.000GB
  ###新建的数据库要有数据才会显示
  ```

* 切换当前数据库/创建数据库：use <db name>

  ``````
  > use test
  switched to db test
  ``````

  

## 4. MangoDB基础知识

 

![20190118191204864](D:\学习\md笔记\Xu_NOTE\md\images\20190118191204864.png)



### 4.1 一些基本概念 

* 文档是MongoDB的核心概念。文档就是键值对的一个有序集{‘msg’:‘hello’,‘foo’:3}。类似于python中的有序字典。

  需要注意的是：
  * 文档中的键/值对是有序的。
    * 文档中的值不仅可以是在双引号里面的字符串，还可以是其他几种数据类型（甚至可以是整个嵌入的文档)。
    * MongoDB区分类型和大小写。
    * MongoDB的文档不能有重复的键。
    * 文档中的值可以是多种不同的数据类型，也可以是一个完整的内嵌文档。文档的键是字符串。除了少数例外情况，键可以使用任意UTF-8字符。
  *    文档键命名规范：
    * 键不能含有\0 (空字符)。这个字符用来表示键的结尾。
    * $和.有特别的意义，只有在特定环境下才能使用。
    * 以下划线"_"开头的键是保留的(不是严格要求的)。

* 集合就是一组文档。如果将MongoDB中的一个文档比喻为关系型数据的一行，那么一个集合就是相当于一张表

  * 集合存在于数据库中，通常情况下为了方便管理，不同格式和类型的数据应该插入到不同的集合，但其实集合没有固定的结构，这意味着我们完全可以把不同格式和类型的数据统统插入一个集合中。
  * 组织子集合的方式就是使用“.”，分隔不同命名空间的子集合。
    比如一个具有博客功能的应用可能包含两个集合，分别是blog.posts和blog.authors，这是为了使组织结构更清晰，这里的blog集合（这个集合甚至不需要存在）跟它的两个子集合没有任何关系。
    在MongoDB中，使用子集合来组织数据非常高效，值得推荐
  * 当第一个文档插入时，集合就会被创建。合法的集合名：
    集合名不能是空字符串""。
    集合名不能含有\0字符（空字符)，这个字符表示集合名的结尾。
    集合名不能以"system."开头，这是为系统集合保留的前缀。
    用户创建的集合名字不能含有保留字符。有些驱动程序的确支持在集合名里面包含，这是因为某些系统生成的集合中包含该字符。除非你要访问这种系统创建的集合，否则千万不要在名字里出现$。

* 数据库：在MongoDB中，多个文档组成集合，多个集合可以组成数据库

  * 数据库也通过名字来标识。数据库名可以是满足以下条件的任意UTF-8字符串：
    * 不能是空字符串（"")。
    * 不得含有' '（空格)、.、$、/、\和\0 (空字符)。
    * 应全部小写。
    * 最多64字节。
  * 有一些数据库名是保留的，可以直接访问这些有特殊作用的数据库。
    * admin： 从身份认证的角度讲，这是“root”数据库，如果将一个用户添加到admin数据库，这个用户将自动获得所有数据库的权限。再者，一些特定的服务器端命令也只能从admin数据库运行，如列出所有数据库或关闭服务器
    * local: 这个数据库永远都不可以复制，且一台服务器上的所有本地集合都可以存储在这个数据库中
    * config: MongoDB用于分片设置时，分片信息会存储在config数据库中

* 强调：把数据库名添加到集合名前，得到集合的完全限定名，即命名空间

  * 例如：
    如果要使用cms数据库中的blog.posts集合，这个集合的命名空间就是
    cmd.blog.posts。命名空间的长度不得超过121个字节，且在实际使用中应该小于100个字节

### 4.2 安装

``` 
1、安装路径为D:\MongoDB，将D:\MongoDB\bin目录加入环境变量

#2、新建目录与文件
D:\MongoDB\data\db
D:\MongoDB\log\mongod.log

#3、新建配置文件mongod.cfg,参考：https://docs.mongodb.com/manual/reference/configuration-options/
systemLog:
   destination: file
   path: "D:\MongoDB\log\mongod.log"
   logAppend: true
storage:
   journal:
      enabled: true
   dbPath: "D:\MongoDB\data\db"
net:
   bindIp: 0.0.0.0
   port: 27017
setParameter:
   enableLocalhostAuthBypass: false
    
#4、制作系统服务
mongod --config "D:\MongoDB\mongod.cfg" --bind_ip 0.0.0.0 --install
或者直接在命令行指定配置
mongod --bind_ip 0.0.0.0 --port 27017 --logpath D:\MongoDB\log\mongod.log --logappend --dbpath D:\MongoDB\data\db  --serviceName "MongoDB" --serviceDisplayName "MongoDB"  --install

        
先停掉服务：net stop MongoDB
然后移除服务：mongo --remove
再重新制作服务，需要加上--auth，表示加载认证功能
mongod --bind_ip 0.0.0.0 --port 27017 --logpath D:\MongoDB\log\mongod.log --logappend --dbpath D:\MongoDB\data\db  --serviceName "MongoDB" --serviceDisplayName "MongoDB"  --install --auth       
        


#5、启动\关闭
net start MongoDB
net stop MongoDB

#6、登录
mongo
```

### 4.3 账号管理

```
1、创建账号
use admin
db.createUser(
  {
    user: "root",
    pwd: "123",
    roles: [ { role: "root", db: "admin" } ]
  }
)

use test
db.createUser(
  {
    user: "tom",
    pwd: "123",
    roles: [ { role: "readWrite", db: "test" },
             { role: "read", db: "db1" } ]
  }
)


#2、重启数据库
mongod --remove
mongod --config "C:\mongodb\mongod.cfg" --bind_ip 0.0.0.0 --install --auth

#3、登录：注意使用双引号而非单引号
mongo --port 27017 -u "root" -p "123" --authenticationDatabase "admin"

也可以在登录之后用db.auth("账号","密码")登录
mongo
use admin
db.auth("root","123")


```

### 4.4 命令行shell

```
#1、mongo 127.0.0.1:27017/config #连接到任何数据库config

#2、mongo --nodb #不连接到任何数据库

#3、启动之后，在需要时运行new Mongo(hostname)命令就可以连接到想要的mongod了：
> conn=new Mongo('127.0.0.1:27017')
connection to 127.0.0.1:27017
> db=conn.getDB('admin')
admin

#4、help查看帮助

#5、mongo是一个简化的JavaScript shell，是可以执行JavaScript脚本的
```



### 4.5 "_id"与ObjectId

```
MongoDB中存储的文档必须有一个"_id"键。这个键的值可以是任意类型，默认是个ObjectId对象。
在一个集合里，每个文档都有唯一的“_id”,确保集合里每个文档都能被唯一标识。
不同集合"_id"的值可以重复，但同一集合内"_id"的值必须唯一

#1、ObjectId
ObjectId是"_id"的默认类型。因为设计MongoDb的初衷就是用作分布式数据库，所以能够在分片环境中生成
唯一的标识符非常重要，而常规的做法：在多个服务器上同步自动增加主键既费时又费力，这就是MongoDB采用
ObjectId的原因。
ObjectId采用12字节的存储空间，是一个由24个十六进制数字组成的字符串
    0|1|2|3|   4|5|6|     7|8    9|10|11    
    时间戳      机器      PID    计数器
如果快速创建多个ObjectId，会发现每次只有最后几位有变化。另外，中间的几位数字也会变化（要是在创建过程中停顿几秒）。
这是ObjectId的创建方式导致的，如上图

时间戳单位为秒，与随后5个字节组合起来，提供了秒级的唯一性。这个4个字节隐藏了文档的创建时间，绝大多数驱动程序都会提供
一个方法，用于从ObjectId中获取这些信息。

因为使用的是当前时间，很多用户担心要对服务器进行时钟同步。其实没必要，因为时间戳的实际值并不重要，只要它总是不停增加就好。
接下来3个字节是所在主机的唯一标识符。通常是机器主机名的散列值。这样就可以保证不同主机生成不同的ObjectId，不产生冲突

接下来连个字节确保了在同一台机器上并发的多个进程产生的ObjectId是唯一的

前9个字节确保了同一秒钟不同机器不同进程产生的ObjectId是唯一的。最后3个字节是一个自动增加的 计数器。确保相同进程的同一秒产生的
ObjectId也是不一样的。

#2、自动生成_id
如果插入文档时没有"_id"键，系统会自帮你创建 一个。可以由MongoDb服务器来做这件事。
但通常会在客户端由驱动程序完成。这一做法非常好地体现了MongoDb的哲学：能交给客户端驱动程序来做的事情就不要交给服务器来做。
这种理念背后的原因是：即便是像MongoDB这样扩展性非常好的数据库，扩展应用层也要比扩展数据库层容易的多。将工作交给客户端做就
减轻了数据库扩展的负担。
```

### 4.6 MangoDB基本数据类型

```
#1、null：用于表示空或不存在的字段
d={'x':null}
#2、布尔型：true和false
d={'x':true,'y':false}
#3、数值
d={'x':3,'y':3.1415926}
#4、字符串
d={'x':'tom'}
#5、日期
d={'x':new Date()}
d.x.getHours()
#6、正则表达式
d={'pattern':/^egon.*?nb$/i}

正则写在／／内，后面的i代表:
i 忽略大小写
m 多行匹配模式
x 忽略非转义的空白字符
s 单行匹配模式

#7、数组
d={'x':[1,'a','v']}

#8、内嵌文档
user={'name':'tom','addr':{'country':'China','city':'YT'}}
user.addr.country

#9、对象id:是一个12字节的ID,是文档的唯一标识，不可变
d={'x':ObjectId()}
```



## 5. CRUD操作

### 5.1 数据库操作

```
#1、增
use db1 #如果数据库不存在，则创建数据库，否则切换到指定数据库。

#2、查
show dbs #查看所有
可以看到，我们刚创建的数据库db1并不在数据库的列表中， 要显示它，我们需要向db1数据库插入一些数据。
db.table1.insert({'a':1})

#3、删
use db1 #先切换到要删的库下
db.dropDatabase() #删除当前库
```

### 5.2 集合操作

```
#1、增
当第一个文档插入时，集合就会被创建
> use database1
switched to db database1
> db.table1.insert({'a':1})
WriteResult({ "nInserted" : 1 })
> db.table2.insert({'b':2})
WriteResult({ "nInserted" : 1 })

db.user
db.user.info	表名是user.info，跟user表没有任何关系
db.user.auth



#2、查
> show tables
table1
table2

#3、删
> db.table1.drop()
true
> show tables
table2
```

### 5.3 文档操作

#### 5.3.1 CREATE

```
#1、没有指定_id则默认ObjectId,_id不能重复，且在插入后不可变

#2、插入单条
user0={
    "name":"tom",
    "age":10,
    'hobbies':['music','read','dancing'],
    'addr':{
        'country':'China',
        'city':'BJ'
    }
}

db.test.insert(user0)
db.test.find()

#3、插入多条
user1={
    "_id":1,
    "name":"zhang3",
    "age":10,
    'hobbies':['music','read','dancing'],
    'addr':{
        'country':'China',
        'city':'weifang'
    }
}

user2={
    "_id":2,
    "name":"li4",
    "age":20,
    'hobbies':['music','read','run'],
    'addr':{
        'country':'China',
        'city':'hebei'
    }
}


user3={
    "_id":3,
    "name":"wang5",
    "age":30,
    'hobbies':['music','drink'],
    'addr':{
        'country':'China',
        'city':'heibei'
    }
}

user4={
    "_id":4,
    "name":"zhao6",
    "age":40,
    'hobbies':['music','read','dancing','tea'],
    'addr':{
        'country':'China',
        'city':'BJ'
    }
}

user5={
    "_id":5,
    "name":"sun7",
    "age":50,
    'hobbies':['music','read',],
    'addr':{
        'country':'China',
        'city':'henan'
    }
}
db.user.insertMany([user1,user2,user3,user4,user5])


db.t1.insert({"_id":1,"a":"1","b":"2","c":"3"})
db.t1.save({"_id":1,"z":"6"})   有就用新的记录覆盖掉原来的记录，无就新增
```

#### 5.3.2 READ

##### 5.3.2.1 比较运算

```
# SQL：=,!=,>,<,>=,<=
# MongoDB：{key:value}代表什么等于什么
"$ne"====>不等于
"$gt"====>大于
"$lt"====>小于
"gte"====>大于等于
"lte"====>小于等于
其中"$ne"能用于所有数据类型

#1、select * from db1.user where name = "alex";
db.user.find({'name':'alex'})

#2、select * from db1.user where name != "alex";
db.user.find({'name':{"$ne":'alex'}})

#3、select * from db1.user where id > 2;
db.user.find({'_id':{'$gt':2}})

#4、select * from db1.user where id < 3;
db.user.find({'_id':{'$lt':3}})

#5、select * from db1.user where id >= 2;
db.user.find({"_id":{"$gte":2,}})

#6、select * from db1.user where id <= 2;
db.user.find({"_id":{"$lte":2}})
```

##### 5.3.2.2 逻辑运算

```
# SQL：and，or，not
# MongoDB：字典中逗号分隔的多个条件是and关系，"$or"的条件放到[]内,"$not"

#1、select * from db1.user where id >= 2 and id < 4;
db.user.find({'_id':{"$gte":2,"$lt":4}})

#2、select * from db1.user where id >= 2 and age < 40;
db.user.find({"_id":{"$gte":2},"age":{"$lt":40}})

#3、select * from db1.user where id >= 5 or name = "alex";
db.user.find({
    "$or":[
        {'_id':{"$gte":5}},
        {"name":"alex"}
        ]
})

#4、select * from db1.user where id % 2=1;
db.user.find({'_id':{"$mod":[2,1]}})

#5、上题，取反
db.user.find({'_id':{"$not":{"$mod":[2,1]}}})
```

##### 5.3.2.3 成员运算

```
# SQL：in，not in
# MongoDB："$in","$nin"

#1、select * from db1.user where age in (20,30,31);
db.user.find({"age":{"$in":[20,30,31]}})

#2、select * from db1.user where name not in ('alex','yuanhao');
db.user.find({"name":{"$nin":['alex','yuanhao']}})
```

##### 5.3.2.4 正则匹配

```
# SQL: regexp 正则
# MongoDB: /正则表达/i

#1、select * from db1.user where name regexp '^j.*?(g|n)$';
db.user.find({'name':/^j.*?(g|n)$/i})
```

##### 5.3.2.5 去指定的字段

```
#1、select name,age from db1.user where id=3;
db.user.find({'_id':3},{'_id':0,'name':1,'age':1})
1:代表要，类似True
0：代表不要，类似Flase,默认是0
```

##### 5.3.2.6 查询数组

```
#1、查看有dancing爱好的人
db.user.find({'hobbies':'dancing'})

#2、查看既有dancing爱好又有tea爱好的人
db.user.find({
    'hobbies':{
        "$all":['dancing','tea']
        }
})

#3、查看第4个爱好为tea的人:".方法"
db.user.find({"hobbies.3":'tea'})

#4、查看所有人最后两个爱好:"$slice"
db.user.find({},{'hobbies':{"$slice":-2},"age":0,"_id":0,"name":0,"addr":0})

#5、查看所有人的第2个到第3个爱好
db.user.find({},{'hobbies':{"$slice":[1,2]},"age":0,"_id":0,"name":0,"addr":0})

> db.blog.find().pretty()
{
        "_id" : 1,
        "name" : "sun7公司破产的真相",
        "comments" : [
                {
                        "name" : "zhang3",
                        "content" : "sun7是谁？？？",
                        "thumb" : 200
                },
                {
                        "name" : "li4",
                        "content" : "我去，真的假的",
                        "thumb" : 300
                },
                {
                        "name" : "wang5",
                        "content" : "吃喝嫖赌抽，欠下两个亿",
                        "thumb" : 40
                },
                {
                        "name" : "zhao6",
                        "content" : "丐帮欢迎你",
                        "thumb" : 0
                }
        ]
}
db.blog.find({},{'comments':{"$slice":-2}}).pretty() #查询最后两个
db.blog.find({},{'comments':{"$slice":[1,2]}}).pretty() #查询1到2
```

##### 5.3.2.7 排序

```
# 排序:1代表升序，-1代表降序
db.user.find().sort({"name":1})
db.user.find().sort({"age":-1,'_id':1})
```

##### 5.3.2.8 分页

```
# 分页:limit代表取多少个document，skip代表跳过前多少个document。 
db.user.find().sort({'age':1}).limit(1).skip(2)
```

##### 5.3.2.9 获取数量

```
# 获取数量
db.user.count({'age':{"$gt":30}}) 

--或者
db.user.find({'age':{"$gt":30}}).count()
```

##### 5.3.2.10 获取数量

```
# 获取数量
db.user.count({'age':{"$gt":30}}) 

--或者
db.user.find({'age':{"$gt":30}}).count()
```

##### 5.3.2.11  其他

```
#1、{'key':null} 匹配key的值为null或者没有这个key
db.t2.insert({'a':10,'b':111})
db.t2.insert({'a':20})
db.t2.insert({'b':null})

> db.t2.find({"b":null})
{ "_id" : ObjectId("5a5cc2a7c1b4645aad959e5a"), "a" : 20 }
{ "_id" : ObjectId("5a5cc2a8c1b4645aad959e5b"), "b" : null }

#2、查找所有
db.user.find() #等同于db.user.find({})
db.user.find().pretty()

#3、查找一个，与find用法一致，只是只取匹配成功的第一个
db.user.findOne({"_id":{"$gt":3}})

#4、去重
db.user.find().distinct()
```

#### 5.3.3 UPDATE 

```
update() 方法用于更新已存在的文档。语法格式如下：
db.collection.update(
   <query>,
   <update>,
   {
     upsert: <boolean>,
     multi: <boolean>,
     writeConcern: <document>
   }
)
参数说明：对比update db1.t1 set name='zhangsan',sex='Male' where name='zhang3' and age=18;

query : 相当于where条件。
update : update的对象和一些更新的操作符（如$,$inc...等，相当于set后面的
upsert : 可选，默认为false，代表如果不存在update的记录不更新也不插入，设置为true代表插入。
multi : 可选，默认为false，代表只更新找到的第一条记录，设为true,代表更新找到的全部记录。
writeConcern :可选，抛出异常的级别。

更新操作是不可分割的：若两个更新同时发送，先到达服务器的先执行，然后执行另外一个，不会破坏文档。
```

##### 5.3.3.1 覆盖式

```
#注意：除非是删除，否则_id是始终不会变的
#1、覆盖式:
db.user.update({'age':20},{"name":"wang5","hobbies_count":3})
是用{"_id":2,"name":"wang5","hobbies_count":3}覆盖原来的记录

#2、一种最简单的更新就是用一个新的文档完全替换匹配的文档。这适用于大规模式迁移的情况。例如
var obj=db.user.findOne({"_id":2})

obj.username=obj.name+'SB'
obj.hobbies_count++
delete obj.age

db.user.update({"_id":2},obj)
```

##### 5.3.3.2 设置：$set

```
#设置：$set

通常文档只会有一部分需要更新。可以使用原子性的更新修改器，指定对文档中的某些字段进行更新。
更新修改器是种特殊的键，用来指定复杂的更新操作，比如修改、增加后者删除

#1、update db1.user set  name="wang5" where id = 2
db.user.update({'_id':2},{"$set":{"name":"wang5",}})

#2、没有匹配成功则新增一条{"upsert":true}
db.user.update({'_id':6},{"$set":{"name":"wang5","age":18}},{"upsert":true})

#3、默认只改匹配成功的第一条,{"multi":改多条}
db.user.update({'_id':{"$gt":4}},{"$set":{"age":28}})
db.user.update({'_id':{"$gt":4}},{"$set":{"age":38}},{"multi":true})

#4、修改内嵌文档，把名字为wang5的人所在的地址国家改成Japan
db.user.update({'name':"wang5"},{"$set":{"addr.country":"Japan"}})

#5、把名字为wang5的人的地2个爱好改成piao
db.user.update({'name':"wang5"},{"$set":{"hobbies.1":"piao"}})

#6、删除wang5的爱好,$unset
db.user.update({'name':"wang5"},{"$unset":{"hobbies":""}})
```

##### 5.3.3.3 增加和减少：$inc

```
#增加和减少：$inc

#1、所有人年龄增加一岁
db.user.update({},
    {
        "$inc":{"age":1}
    },
    {
        "multi":true
    }
    )
#2、所有人年龄减少5岁
db.user.update({},
    {
        "$inc":{"age":-5}
    },
    {
        "multi":true
    }
    )
```

##### 5.3.3.4 添加删除数组内元素： p u s h , push, push,pop,$pull

```
#添加删除数组内元素
    
往数组内添加元素:$push
#1、为名字为wang5的人添加一个爱好read
db.user.update({"name":"wang5"},{"$push":{"hobbies":"read"}})

#2、为名字为wang5的人一次添加多个爱好tea，dancing
db.user.update({"name":"wang5"},{"$push":{
    "hobbies":{"$each":["tea","dancing"]}
}})

按照位置且只能从开头或结尾删除元素：$pop
#3、{"$pop":{"key":1}} 从数组末尾删除一个元素

db.user.update({"name":"wang5"},{"$pop":{
    "hobbies":1}
})

#4、{"$pop":{"key":-1}} 从头部删除
db.user.update({"name":"wang5"},{"$pop":{
    "hobbies":-1}
})

#5、按照条件删除元素,："$pull" 把符合条件的统统删掉，而$pop只能从两端删
db.user.update({'addr.country':"China"},{"$pull":{
    "hobbies":"read"}
},
{
    "multi":true
}
)
```

##### 避免添加重复："$addToSet"

```
#避免添加重复："$addToSet"

db.urls.insert({"_id":1,"urls":[]})

db.urls.update({"_id":1},{"$addToSet":{"urls":'http://www.baidu.com'}})
db.urls.update({"_id":1},{"$addToSet":{"urls":'http://www.baidu.com'}})
db.urls.update({"_id":1},{"$addToSet":{"urls":'http://www.baidu.com'}})

db.urls.update({"_id":1},{
    "$addToSet":{
        "urls":{
        "$each":[
            'http://www.baidu.com',
            'http://www.baidu.com',
            'http://www.xxxx.com'
            ]
            }
        }
    }
)
```

##### 其他

```
#1、了解：限制大小"$slice"，只留最后n个

db.user.update({"_id":5},{
    "$push":{"hobbies":{
        "$each":["read",'music','dancing'],
        "$slice":-2
    }
    }
})

#2、了解：排序The $sort element value must be either 1 or -1"
db.user.update({"_id":5},{
    "$push":{"hobbies":{
        "$each":["read",'music','dancing'],
        "$slice":-1,
        "$sort":-1
    }
    }
})

#注意：不能只将"$slice"或者"$sort"与"$push"配合使用，且必须使用"$eah"
```

#### 5.3.4 DELETE

```
#1、删除多个中的第一个
db.user.deleteOne({ 'age': 8 })

#2、删除国家为China的全部
db.user.deleteMany( {'addr.country': 'China'} ) 

#3、删除全部
db.user.deleteMany({})
```

#### 5.3.5 聚合

```
如果你有数据存储在MongoDB中，你想做的可能就不仅仅是将数据提取出来那么简单了；你可能希望对数据进行分析并加以利用。MongoDB提供了以下聚合工具：
#1、聚合框架
#2、MapReduce(详见MongoDB权威指南)
#3、几个简单聚合命令：count、distinct和group。(详见MongoDB权威指南)

#聚合框架：
可以使用多个构件创建一个管道，上一个构件的结果传给下一个构件。
这些构件包括（括号内为构件对应的操作符）：筛选($match)、投射($project)、分组($group)、排序($sort)、限制($limit)、跳过($skip)
不同的管道操作符可以任意组合，重复使用
```

#### 5.3.6 准备数据

```
from pymongo import MongoClient
import datetime

client=MongoClient('mongodb://root:123@localhost:27017')
table=client['db1']['emp']
# table.drop()

l=[
('tom','male',18,'20170301','校长',73000.33,401,1), #以下是教学部
('bob','male',78,'20150302','teacher',10000.31,401,1),
('sam','male',81,'20130305','teacher',8300,401,1),
('zhang3','male',73,'20140701','teacher',3500,401,1),
('li4','male',28,'20121101','teacher',2100,401,1),
('may','female',18,'20110211','teacher',9000,401,1),
('wang5','male',18,'19000301','teacher',30000,401,1),
('成龙','male',48,'20101111','teacher',10000,401,1),

('歪歪','female',48,'20150311','sale',3000.13,402,2),#以下是销售部门
('丫丫','female',38,'20101101','sale',2000.35,402,2),
('丁丁','female',18,'20110312','sale',1000.37,402,2),
('星星','female',18,'20160513','sale',3000.29,402,2),
('格格','female',28,'20170127','sale',4000.33,402,2),

('张野','male',28,'20160311','operation',10000.13,403,3), #以下是运营部门
('程咬金','male',18,'19970312','operation',20000,403,3),
('程咬银','female',18,'20130311','operation',19000,403,3),
('程咬铜','male',18,'20150411','operation',18000,403,3),
('程咬铁','female',18,'20140512','operation',17000,403,3)
]

for n,item in enumerate(l):
    d={
        "_id":n,
        'name':item[0],
        'sex':item[1],
        'age':item[2],
        'hire_date':datetime.datetime.strptime(item[3],'%Y%m%d'),
        'post':item[4],
        'salary':item[5]
    }
    table.save(d)
```

#####  5.3.6.1 筛选：$match

```
{"$match":{"字段":"条件"}},可以使用任何常用查询操作符$gt,$lt,$in等

#例1、select * from db1.emp where post='teacher';
db.emp.aggregate({"$match":{"post":"teacher"}})

#例2、select * from db1.emp where id > 3 group by post;  
db.emp.aggregate(
    {"$match":{"_id":{"$gt":3}}},
    {"$group":{"_id":"$post",'avg_salary':{"$avg":"$salary"}}}
)

#例3、select * from db1.emp where id > 3 group by post having avg(salary) > 10000;  
db.emp.aggregate(
    {"$match":{"_id":{"$gt":3}}},
    {"$group":{"_id":"$post",'avg_salary':{"$avg":"$salary"}}},
    {"$match":{"avg_salary":{"$gt":10000}}}
)
```

##### 5.3.6.2 投射：$project

```
{"$project":{"要保留的字段名":1,"要去掉的字段名":0,"新增的字段名":"表达式"}}

#1、select name,post,(age+1) as new_age from db1.emp;
db.emp.aggregate(
    {"$project":{
        "name":1,
        "post":1,
        "new_age":{"$add":["$age",1]}
        }
})

#2、表达式之数学表达式
{"$add":[expr1,expr2,...,exprN]} #相加
{"$subtract":[expr1,expr2]} #第一个减第二个
{"$multiply":[expr1,expr2,...,exprN]} #相乘
{"$divide":[expr1,expr2]} #第一个表达式除以第二个表达式的商作为结果
{"$mod":[expr1,expr2]} #第一个表达式除以第二个表达式得到的余数作为结果

#3、表达式之日期表达式:$year,$month,$week,$dayOfMonth,$dayOfWeek,$dayOfYear,$hour,$minute,$second
#例如：select name,date_format("%Y") as hire_year from db1.emp
db.emp.aggregate(
    {"$project":{"name":1,"hire_year":{"$year":"$hire_date"}}}
)

#例如查看每个员工的工作多长时间
db.emp.aggregate(
    {"$project":{"name":1,"hire_period":{
        "$subtract":[
            {"$year":new Date()},
            {"$year":"$hire_date"}
        ]
    }}}
)


#4、字符串表达式
{"$substr":[字符串/$值为字符串的字段名,起始位置,截取几个字节]}
{"$concat":[expr1,expr2,...,exprN]} #指定的表达式或字符串连接在一起返回,只支持字符串拼接
{"$toLower":expr}
{"$toUpper":expr}

db.emp.aggregate( {"$project":{"NAME":{"$toUpper":"$name"}}})

#5、逻辑表达式
$and
$or
$not
其他见Mongodb权威指南
```

##### 分组：$group

```
{"$group":{"_id":分组字段,"新的字段名":聚合操作符}}

#1、将分组字段传给$group函数的_id字段即可
{"$group":{"_id":"$sex"}} #按照性别分组
{"$group":{"_id":"$post"}} #按照职位分组
{"$group":{"_id":{"state":"$state","city":"$city"}}} #按照多个字段分组，比如按照州市分组

#2、分组后聚合得结果,类似于sql中聚合函数的聚合操作符：$sum、$avg、$max、$min、$first、$last
#例1：select post,max(salary) from db1.emp group by post; 
db.emp.aggregate({"$group":{"_id":"$post","max_salary":{"$max":"$salary"}}})

#例2：去每个部门最大薪资与最低薪资
db.emp.aggregate({"$group":{"_id":"$post","max_salary":{"$max":"$salary"},"min_salary":{"$min":"$salary"}}})

#例3：如果字段是排序后的，那么$first,$last会很有用,比用$max和$min效率高
db.emp.aggregate({"$group":{"_id":"$post","first_id":{"$first":"$_id"}}})

#例4：求每个部门的总工资
db.emp.aggregate({"$group":{"_id":"$post","count":{"$sum":"$salary"}}})

#例5：求每个部门的人数
db.emp.aggregate({"$group":{"_id":"$post","count":{"$sum":1}}})

#3、数组操作符
{"$addToSet":expr}：不重复
{"$push":expr}：重复

#例：查询岗位名以及各岗位内的员工姓名:select post,group_concat(name) from db1.emp group by post;
db.emp.aggregate({"$group":{"_id":"$post","names":{"$push":"$name"}}})
db.emp.aggregate({"$group":{"_id":"$post","names":{"$addToSet":"$name"}}})
```

##### 排序： s o r t 、 限 制 ： sort、限制： sort、限制：limit、跳过：$skip

```
{"$sort":{"字段名":1,"字段名":-1}} #1升序，-1降序
{"$limit":n} 
{"$skip":n} #跳过多少个文档

#例1、取平均工资最高的前两个部门
db.emp.aggregate(
{
    "$group":{"_id":"$post","平均工资":{"$avg":"$salary"}}
},
{
    "$sort":{"平均工资":-1}
},
{
    "$limit":2
}
)
#例2、
db.emp.aggregate(
{
    "$group":{"_id":"$post","平均工资":{"$avg":"$salary"}}
},
{
    "$sort":{"平均工资":-1}
},
{
    "$limit":2
},
{
    "$skip":1
}
)
```

##### 随机选取n个：$sample

```
#集合users包含的文档如下
{ "_id" : 1, "name" : "dave123", "q1" : true, "q2" : true }
{ "_id" : 2, "name" : "dave2", "q1" : false, "q2" : false  }
{ "_id" : 3, "name" : "ahn", "q1" : true, "q2" : true  }
{ "_id" : 4, "name" : "li", "q1" : true, "q2" : false  }
{ "_id" : 5, "name" : "annT", "q1" : false, "q2" : true  }
{ "_id" : 6, "name" : "li", "q1" : true, "q2" : true  }
{ "_id" : 7, "name" : "ty", "q1" : false, "q2" : true  }

#下述操作时从users集合中随机选取3个文档
db.users.aggregate(
   [ { $sample: { size: 3 } } ]
)
```









参考：

https://blog.csdn.net/qq_42721964/article/details/86545189?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.nonecase

https://www.runoob.com/mongodb/mongodb-window-install.html

https://www.cnblogs.com/zhoujinyi/p/4610050.html