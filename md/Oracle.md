## oracle
### 一、SELECT 语句
`SELECT语句语法： SELECT * | {[DISTINCT] column|expression [alias],...} FROM table;`
- SELECT 表示要取哪些列
- FROM 表示要从哪些表中取


SQL语句中的数学表达式：对于数值和日期型字段，可以进行 “加减乘除”

`SELECT last_name, salary, salary + 300 FROM employees;`


关于NULL的概念 ： 
    NULL表示 不可用、未赋值、不知道、不适用 ， 它既不是0 也不是空格。 记住：一个数值       与NULL进行四则运算，其结果是？ NULL


在Select的时候给列起个别名（注意双引号的作用）：
![20ae03861e7e2dd815c867f8444fd5f5.png](en-resource://database/1637:1)


- 字符串连接操作符： “||”
`SELECT last_name||job_id AS "Employees" FROM employees;`

- DISTINCT 去除重复行：
![61bc3a6f5d794d569b1e64bfb07c0a99.png](en-resource://database/1639:1)

- 条件限制的关键词：WHERE
`SELECT *|{[DISTINCT] column|expression [alias],...} FROM table [WHERE condition(s)];`

- 比较操作符：

| 比较操作符         | 意义                                                         |
| ------------------ | ------------------------------------------------------------ |
| =                  | 等于                                                         |
| >                  | 大于                                                         |
| >=                 | 大于等于                                                     |
| <                  | 小于                                                         |
| <=                 | 小于等于                                                     |
| <>                 | 不等于                                                       |
| BETWEEN ... AND .. | 在这两个值之间                                               |
| IN(set)            | 在一个集合范围                                               |
| LIKE               | 匹配一个字符串样子，可以使用%通配符，%表示多个字符，_表示单个字符 |
| IS NULL            | 是一个空值，注意不能使用 =NULL                               |

- 使用LIKE做模糊匹配：

可使用% 或者_ 作为通配符：
- % 代表 0个或者多个 字符.
- _ 代表一个单个字符.


如果要搜索统配符本身该怎么办呢？：

这需要使用ESCAPE 标识转义字符

`select * from t_char where a like '%\%%' escape '\';`

### 第二单元 条件限制和排序

* 使用null条件：
```

SELECT last_name, manager_id FROM employees WHERE manager_id IS NULL;

```
* 使用多个条件组合的逻辑操作符

| 逻辑操作符 | 意义                         |
| ---------- | ---------------------------- |
| AND        | 所有条件都满足，返回TRUE     |
| OR         | 只要有一个条件满足，返回TRUE |
| NOT        | 如果条件是FLASE,返回TRUE     |

* 使用ORDER BY 子句进行排序：
    ASC : 升序
    DESC : 降序
* 使用字段别名排序
  
```

SELECT employee_id, last_name, salary*12 annsal FROM employees ORDER BY annsal;

```
* 按照多个字段排序
  
```

SELECT last_name, department_id, salary FROM employees ORDER BY department_id, salary DESC;

```
### 第三单元 单行函数
SQL函数类型： 单行函数和多行函数

* 字符函数
  

| 函数                  | 结果       |
| --------------------- | ---------- |
| LOWER('SQL Course')   | sql course |
| UPPER('SQL Course')   | SQL COURSE |
| INITCAP('SQL course') | Sql Course |

* 字符操作函数

| 函数                        | 结果        |
| --------------------------- | ----------- |
| CONCAT('Hello', 'World')    | HelloWorld  |
| SUBSTR('HelloWorld',1,5)    | Hello       |
| LENGTH('HelloWorld')        | 10          |
| INSTR('HelloWorld', 'W')    | 6           |
| LPAD(salary,10,'*')         | ****24000   |
| RPAD(salary, 10, '*')       | 24000*****  |
| TRIM('H' FROM 'HelloWorld') | elloWorld   |
| TRIM(' HelloWorld')         | HelloWorld  |
| TRIM('Hello World')         | Hello World |

* 数字操作函数


| 函数             | 结果  |
| ---------------- | ----- |
| ROUND(45.926, 2) | 45.93 |
| TRUNC(45.926, 2) | 45.92 |
| MOD(1600, 300)   | 100   |

`
SELECT ROUND(45.923,2), ROUND(45.923,0), ROUND(45.923,-1) FROM DUAL;
`

| ROUND(45.923,2) | ROUND(45.923,0) | ROUND(45.923,-1) |
| --------------- | --------------- | ---------------- |
| 45.92           | 46              | 50               |

`
SELECT TRUNC(45.923,2), TRUNC(45.923), TRUNC(45.923,-2) FROM DUAL;
`

| TRUNC(45.923,2) | TRUNC(45.923) | TRUNC(45.923,-2) |
| --------------- | ------------- | ---------------- |
| 45.92           | 45            | 0                |

* 日期操作函数


| 函数                                            | 结果                                          |
| ----------------------------------------------- | --------------------------------------------- |
| MONTHS_BETWEEN ('01-SEP-95','11-JAN-94')        | 19.6774194                                    |
| ADD_MONTHS ('11-JAN-94',6)                      | 11-Jul-94                                     |
| NEXT_DAY ('01-SEP-95','FRIDAY')                 | 8-Sep-95                                      |
| NEXT_DAY ('01-SEP-95',1)                        | 3-Sep-95                                      |
| NEXT_DAY ('1995-09-01',1)                       | ORA01861:literal does not match format string |
| NEXT_DAY (to_date('1995-09-01','YYYY-MM-DD'),1) | 3-Sep-95                                      |
| LAST_DAY('01-FEB-95') 28-Feb-95                 | 28-Feb-95                                     |
| ROUND('25-JUL-95','MONTH')                      | 1-Aug-95                                      |
| ROUND('25-JUL-95' ,'YEAR')                      | 1-Jan-96                                      |
| TRUNC('25-JUL-95' ,'MONTH')                     | 1-Jul-95                                      |
| TRUNC('25-JUL-95','YEAR')                       | 1-Jan-95                                      |

- TO_CHAR() 函数：日期到字符串的转换
`
TO_CHAR(date, 'format_model') ;
`

| 日期格式化元素 | 意义                           |
| -------------- | ------------------------------ |
| YYYY           | 4位数字表示的年份              |
| YEAR           | 英文描述的年份                 |
| MM             | 2位数字表示的月份              |
| MONTH          | 英文描述的月份                 |
| MON            | 三个字母的英文描述月份简称     |
| DD             | 2位数字表示的日期              |
| DAY            | 英文描述的星期几               |
| DY             | 三个字母的英文描述的星期几简称 |
| HH24:MI:SS AM  | 时分秒的格式化                 |
| DDspth         | 英文描述的月中第几天           |
| fm             | 格式化关键字，可选             |

* TO_CHAR() 函数：数字到字符串的转换

| 数字格式化元素 | 意义                 |
| -------------- | -------------------- |
| 9              | 表示一个数字         |
| 0              | 强制显示0            |
| $              | 放一个美元占位符     |
| L              | 使用浮点本地币种符号 |
| .              | 显示一个小数点占位符 |
| ,              | 显示一个千分位占位符 |

```
alter session set NLS_CURRENCY = '￥';
SELECT TO_CHAR(salary, 'L99,999.00') SALARY FROM employees WHERE last_name = 'Ernst';
```
结果：
| salary     |      |
| ---------- | ---- |
| ￥6,000.00 |      |

```
alter session set NLS_CURRENCY = ‘$';
```
结果：
| salary    |      |
| --------- | ---- |
| $6,000.00 |      |

* TO_NUMBER() 函数：字符串到数字的转换
`TO_NUMBER(char[, 'format_model']) ;`
