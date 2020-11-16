## Redis

### 一、概述

Redis 是速度非常快的非关系型（NoSQL）内存键值数据库，可以存储键和五种不同类型的值之间的映射。

键的类型只能为字符串，值支持五种数据类型：字符串、列表、集合、散列表、有序集合。

Redis 支持很多特性，例如将内存中的数据持久化到硬盘中，使用复制来扩展读性能，使用分片来扩展写性能。



### 二、数据类型

| 数据类型 |      可以存储的值      |                             操作                             |
| :------: | :--------------------: | :----------------------------------------------------------: |
|  STRING  | 字符串、整数或者浮点数 | 对整个字符串或者字符串的其中一部分执行操作<br/>对整数和浮点数执行自增或者自减操作 |
|   LIST   |          列表          | 从两端压入或者弹出元素 <br/>对单个或者多个元素进行修剪，<br/>只保留一个范围内的元素 |
|   SET    |        无序集合        | 添加、获取、移除单个元素<br/>检查一个元素是否存在于集合中<br/>计算交集、并集、差集<br/>从集合里面随机获取元素 |
|   HASH   | 包含键值对的无序散列表 | 添加、获取、移除单个键值对<br/>获取所有键值对<br/>检查某个键是否存在 |
|   ZSET   |        有序集合        | 添加、获取、删除元素<br/>根据分值范围或者成员来获取元素<br/>计算一个键的排名 |

[官网文档](https://redislabs.com/ebook/part-1-getting-started/chapter-1-getting-to-know-redis/1-2-what-redis-data-structures-look-like/)

```
##进入redis容器
docker exec -it redis redis-cli
```

#### STRING

```
127.0.0.1:6379> set Hello world
OK
127.0.0.1:6379> get Hello
"world"
127.0.0.1:6379> get hello
(nil)
127.0.0.1:6379> del Hello
(integer) 1
127.0.0.1:6379> get Hello
(nil)
```

#### LIST

```
127.0.0.1:6379> rpush list-key item
(integer) 1
127.0.0.1:6379> rpush list-key item1
(integer) 2
127.0.0.1:6379> rpush list-key item2
(integer) 3
127.0.0.1:6379> lrange list-key 0 -1
1) "item"
2) "item1"
3) "item2"
127.0.0.1:6379> lindex list-key 1
"item1"
127.0.0.1:6379> lpop list-key
"item"
127.0.0.1:6379> lrange list-key 0 -1
1) "item1"
2) "item2"
```

#### SET

```
127.0.0.1:6379> sadd set-key item
(integer) 0
127.0.0.1:6379> sadd set-key item
(integer) 0
127.0.0.1:6379> sadd set-key item1
(integer) 1
127.0.0.1:6379> sadd set-key item2
(integer) 0
127.0.0.1:6379> smembers set-key
1) "item2"
2) "item1"
3) "item3"
4) "item"
127.0.0.1:6379> sadd set-key1 item
(integer) 1
127.0.0.1:6379> sadd set-key1 item2
(integer) 1
127.0.0.1:6379> sadd set-key1 item3
(integer) 1
127.0.0.1:6379> sadd set-key1 item
(integer) 0
127.0.0.1:6379> SMEMBERS set-key1
1) "item2"
2) "item3"
3) "item"
127.0.0.1:6379> SISMEMBER set-key1 item4
(integer) 0
127.0.0.1:6379> SISMEMBER set-key1 item
(integer) 1
127.0.0.1:6379> SMEMBERS set-key1
1) "item2"
2) "item3"
3) "item"
127.0.0.1:6379> srem set-key1 item2
(integer) 1
127.0.0.1:6379> srem set-key1 item2
(integer) 0
127.0.0.1:6379> SMEMBERS set-key1
1) "item3"
2) "item"
```

#### HASH

```
127.0.0.1:6379> HSET hash-key sub-key1 value1
(integer) 1
127.0.0.1:6379> HSET hash-key sub-key2 value2
(integer) 1
127.0.0.1:6379> HSET hash-key sub-key2 value2
(integer) 0
127.0.0.1:6379> hgetall hash-key
1) "sub-key1"
2) "value1"
3) "sub-key2"
4) "value2"
127.0.0.1:6379> hdel hash-key sub-key2
(integer) 1
127.0.0.1:6379> hdel hash-key sub-key2
(integer) 0
127.0.0.1:6379> hget hash-key sub-key1
"value1"
127.0.0.1:6379> hgetall hash-key
1) "sub-key1"
2) "value1"
```

#### ZSET

```
127.0.0.1:6379> zadd zset728 member1
(error) ERR wrong number of arguments for 'zadd' command
127.0.0.1:6379> zadd zset-key 728 member1
(integer) 1
127.0.0.1:6379> zadd zset-key 982 member2
(integer) 1
127.0.0.1:6379> zadd zset-key 982 member2
(integer) 0
127.0.0.1:6379> zrange zset-key 0 -1
1) "member1"
2) "member2"
127.0.0.1:6379> zrange zset-key 0 -1 withscores
1) "member1"
2) "728"
3) "member2"
4) "982"
127.0.0.1:6379> ZRANGEBYSCORE zset-key 0 800 withscores
1) "member1"
2) "728"
127.0.0.1:6379> ZREM zset-key member1
(integer) 1
127.0.0.1:6379> ZREM zset-key member1
(integer) 0
127.0.0.1:6379> zrange zset-key 0 -1 withscores
1) "member2"
2) "982"
```

