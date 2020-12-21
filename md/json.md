## JSON教程

#### 什么是JSON？

JSON: **J**ava**S**cript **O**bject **N**otation(JavaScript 对象表示法)

JSON 是存储和交换文本信息的语法，类似 XML。

JSON 比 XML 更小、更快，更易解析。

```json
{
    "sites": [
    { "name":"菜鸟教程" , "url":"www.runoob.com" }, 
    { "name":"google" , "url":"www.google.com" }, 
    { "name":"微博" , "url":"www.weibo.com" }
    ]
}

{
    "sites": [
    { "name":"菜鸟教程" , "url":"www.runoob.com" }, 
    { "name":"google" , "url":"www.google.com" }, 
    { "name":"微博" , "url":"www.weibo.com" },
     {"lines" : [
				{"name" : "行信息"}
			]
     }
    ]
}
```

- JSON 指的是 JavaScript 对象表示法（**J**ava**S**cript **O**bject **N**otation）
- JSON 是轻量级的文本数据交换格式
- JSON 独立于语言：JSON 使用 Javascript语法来描述数据对象，但是 JSON 仍然独立于语言和平台。JSON 解析器和 JSON 库支持许多不同的编程语言。 目前非常多的动态（PHP，JSP，.NET）编程语言都支持JSON。
- JSON 具有自我描述性，更易理解

其实JSON数据就是一段字符串而已，只不过有不同意义的分隔符将其分割开来而已，我们看上面的符号，里面有[] ,{}等符号，其中

- 1 []中括号代表的是一个数组；
- 2 {}大括号代表的是一个对象
- 3 双引号“”表示的是属性值
- 4 冒号：代表的是前后之间的关系，冒号前面是属性的名称，后面是属性的值，这个值可以是基本数据类型，也可以是引用数据类型。

#### JSON - 转换为 JavaScript 对象

JSON 文本格式在语法上与创建 JavaScript 对象的代码相同。

由于这种相似性，无需解析器，JavaScript 程序能够使用内建的 eval() 函数，用 JSON 数据来生成原生的 JavaScript 对象。



#### JSON语法

JSON 语法是 JavaScript 语法的子集。

##### JSON语法规则

JSON 语法是 JavaScript 对象表示语法的子集。

- 数据在名称/值对中
- 数据由逗号分隔
- 大括号 **{}** 保存对象
- 中括号 **[]** 保存数组，数组可以包含多个对象

##### JSON 名称/值对

JSON 数据的书写格式是：。

> key : value
>
> "name" : "对象"   > 名称/值对包括字段名称（在双引号中），后面写一个冒号，然后是值
>
> 等价于javaScript 中的  name = "对象"

##### JSON数据类型

- 数字（整数或浮点数）
- 字符串（在双引号中）
- 逻辑值（true 或 false）
- 数组（在中括号中）
- 对象（在大括号中）
- null

##### JSON数字

JSON 数字可以是整型或者浮点型：

```
{"age" : 30}
```

##### JSON对象

JSON 对象在大括号 **{}** 中书写：

```
{key1 : value1, key2 : value2, ... keyN : valueN }
```

对象可以包含多个名称/值对：

```json
{ "name":"学习" , "time":"00000" }
```

这一点也容易理解，与这条 JavaScript 语句等价：

```javascript
name = "学习"
time = "00000"
```

##### JSON数组

JSON 数组在中括号 **[]** 中书写：

数组可包含多个对象：

```json
[
    { key1 : value1-1 , key2:value1-2 }, 
    { key1 : value2-1 , key2:value2-2 }, 
    { key1 : value3-1 , key2:value3-2 }, 
    ...
    { keyN : valueN-1 , keyN:valueN-2 }, 
]
```

```json
//栗子
{
	"Dog" : [
		{"name" : "小花" , "age" : 5},
		{"name" : "来福", "age" : 4},
		{"name" : "gungun" , "age": 3}
	]
}
```

##### JSON 布尔值

JSON 布尔值可以是 true 或者 false：

```
{ "flag":true }
```

##### JSON null

```
{ "runoob":null }
```

##### JSON 使用 JavaScript 语法

因为 JSON 使用 JavaScript 语法，所以无需额外的软件就能处理 JavaScript 中的 JSON。

通过 JavaScript，您可以创建一个对象数组，并像这样进行赋值：

```json
var Dog =  [
            {"name" : "小花" , "age" : 5},
            {"name" : "来福", "age" : 4},
            {"name" : "gungun" , "age": 3}
        ];
```

可以像这样访问 JavaScript 对象数组中的第一项（索引从 0 开始）：

```
sites[0].name;
```

返回的内容是：

```
小花
```

可以像这样修改数据：

```
sites[0].name="大花";
```

##### JSON文件

- JSON 文件的文件类型是 **.json**
- JSON 文本的 MIME 类型是 **application/json**

#### JSON VS XML

```xml
//栗子
<?xml version="1.0" encoding="UTF-8" ?>
<Dog>
    <name>小花</name>
    <age>5</age>
</Dog>
<Dog>
    <name>来福</name>
    <age>4</age>
</Dog>
<Dog>
    <name>gungun</name>
    <age>3</age>
</Dog>
```

JSON 与 XML 的相同之处：

- JSON 和 XML 数据都是 "自我描述" ，都易于理解。
- JSON 和 XML 数据都是有层次的结构
- JSON 和 XML 数据可以被大多数编程语言使用
- 

JSON 与 XML 的不同之处：

- JSON 不需要结束标签
- JSON 更加简短
- JSON 读写速度更快
- JSON 可以使用数组

>**最大的不同是**：XML 需要使用 XML 解析器来解析，JSON 可以使用标准的 JavaScript 函数来解析。
>
>- [JSON.parse()](https://www.runoob.com/js/javascript-json-parse.html): 将一个 JSON 字符串转换为 JavaScript 对象。
>- [JSON.stringify()](https://www.runoob.com/js/javascript-json-stringify.html): 于将 JavaScript 值转换为 JSON 字符串。



##### 为什么 JSON 比 XML 更好？

XML 比 JSON 更难解析。

JSON 可以直接使用现有的 JavaScript 对象解析。

针对 AJAX 应用，JSON 比 XML 数据加载更快，而且更简单：

使用 XML

- 获取 XML 文档
- 使用 XML DOM 迭代循环文档
- 接数据解析出来复制给变量

使用 JSON

- 获取 JSON 字符串
- JSON.Parse 解析 JSON 字符串

##### JSON 字符串转换为 JavaScript 对象

通常我们从服务器中读取 JSON 数据，并在网页中显示数据。

简单起见，我们网页中直接设置 JSON 字符串 (你还可以阅读我们的 [JSON 教程](https://www.runoob.com/json/json-tutorial.html)):

首先，创建 JavaScript 字符串，字符串为 JSON 格式的数据：

```javascript
var text = '{ "sites" : [' +
    '{ "name":"Runoob" , "url":"www.runoob.com" },' +
    '{ "name":"Google" , "url":"www.google.com" },' +
    '{ "name":"Taobao" , "url":"www.taobao.com" } ]}';
    
obj = JSON.parse(text);
document.getElementById("demo").innerHTML = obj.sites[1].name + " " + obj.sites[1].url;
```

#### JSON 对象

##### 对象语法

```json
{ "name":"runoob", "alexa":10000, "site":null }
```

JSON 对象使用在大括号({})中书写。

对象可以包含多个 **key/value（键/值）**对。

key 必须是字符串，value 可以是合法的 JSON 数据类型（字符串, 数字, 对象, 数组, 布尔值或 null）。

key 和 value 中使用冒号(:)分割。

每个 key/value 对使用逗号(,)分割。

##### 访问对象值

你可以使用点号（.）来访问对象的值：

```json
var myObj, x;
myObj = { "name":"runoob", "alexa":10000, "site":null };
x = myObj.name;
```

你也可以使用中括号（[]）来访问对象的值：

```json
var myObj, x;
myObj = { "name":"runoob", "alexa":10000, "site":null };
x = myObj["name"];
```

##### 循环对象

你可以使用 for-in 来循环对象的属性：

```json
var myObj = { "name":"runoob", "alexa":10000, "site":null };
for (x in myObj) {
    document.getElementById("demo").innerHTML += x + "<br>";
}
```

在 for-in 循环对象的属性时，使用中括号（[]）来访问属性的值：

```json
var myObj = { "name":"runoob", "alexa":10000, "site":null };
for (x in myObj) {
    document.getElementById("demo").innerHTML += myObj[x] + "<br>";
}
```

##### 嵌套 JSON 对象

````json
myObj = {
    "name":"runoob",
    "alexa":10000,
    "sites": {
        "site1":"www.runoob.com",
        "site2":"m.runoob.com",
        "site3":"c.runoob.com"
    }
}
````

你可以使用点号(.)或者中括号([])来访问嵌套的 JSON 对象。

```json
x = myObj.sites.site1;
// 或者
x = myObj.sites["site1"];
```

##### 修改值

你可以使用点号(.)来修改 JSON 对象的值：

```json
myObj.sites["site1"] = "www.google.com";
```

##### 删除对象属性

```json
//我们可以使用 delete 关键字来删除 JSON 对象的属性：
delete myObj.sites.site1;
//你可以使用中括号([])来删除 JSON 对象的属性：
delete myObj.sites["site1"]
```

#### JSON数组

数组作为JSON对象

```json
["dog","cat","pig"]
```

JSON 数组在中括号中书写。

JSON 中数组值必须是合法的 JSON 数据类型（字符串, 数字, 对象, 数组, 布尔值或 null）。

JavaScript 中，数组值可以是以上的 JSON 数据类型，也可以是 JavaScript 的表达式，包括函数，日期，及 *undefined*。

##### JSON 对象中的数组 

对象属性的值可以是一个数组：

```json
{
"name":"网站",
"num":3,
"sites":[ "Google", "Runoob", "Taobao" ]
}
```

我们可以使用索引值来访问数组：

```json
x = myObj.sites[0]; 	
```

##### 循环数组

你可以使用 for-in 来访问数组：

```json
for (i in myObj.sites) {
    x += myObj.sites[i] + "<br>";
}
```

你也可以使用 for 循环：

```json
for (i = 0; i < myObj.sites.length; i++) {
    x += myObj.sites[i] + "<br>";
}
```

##### 嵌套 JSON 对象中的数组

JSON 对象中数组可以包含另外一个数组，或者另外一个 JSON 对象：

```json
myObj = {
    "name":"网站",
    "num":3,
    "sites": [
        { "name":"Google", "info":[ "Android", "Google 搜索", "Google 翻译" ] },
        { "name":"Runoob", "info":[ "菜鸟教程", "菜鸟工具", "菜鸟微信" ] },
        { "name":"Taobao", "info":[ "淘宝", "网购" ] }
    ]
}
```

我们可以使用 for-in 来循环访问每个数组：

```javascript
for (i in myObj.sites) {
    x += "<h1>" + myObj.sites[i].name + "</h1>";
    for (j in myObj.sites[i].info) {
        x += myObj.sites[i].info[j] + "<br>";
    }
}
```

##### 修改数组值

你可以使用索引值来修改数组值：

```javascript
myObj.sites[1] = "Github";
```

##### 删除数组元素

我们可以使用 **delete** 关键字来删除数组元素：

```javascript
delete myObj.sites[1];
```

> delete 运算符并不是彻底删除元素，而是删除它的值，但仍会保留空间。
>
> 运算符 delete 只是将该值置为 undefined，而不会影响数组长度，即将其变为稀疏数组（《JS权威指南》7.5节）。

#### JSON.parse()

JSON 通常用于与服务端交换数据。

在接收服务器数据时一般是字符串。

我们可以使用 JSON.parse() 方法将数据转换为 JavaScript 对象。

语法：

```
JSON.parse(text , [reviver])
```

**参数说明：**

- **text:**必需， 一个有效的 JSON 字符串。
- **reviver:** 可选，一个转换结果的函数， 将为对象的每个成员调用此函数。

```javascript
//栗子
var text = '{ "name":"Runoob", "initDate":"2013-12-14", "site":"www.runoob.com"}';
var obj = JSON.parse(text, function (key, value) {
    if (key == "initDate") {
        return new Date(value);
    } else {
        return value;
}});
 
document.getElementById("demo").innerHTML = obj.name + "创建日期：" + obj.initDate;
```



##### JSON 解析实例

例如我们从服务器接收了以下数据：

```javascript
//字符串：
'{ "name":"runoob", "alexa":10000, "site":"www.runoob.com" }'
```

我们使用 JSON.parse() 方法处理以上数据，将其转换为 JavaScript 对象：

```javascript
var obj = JSON.parse('{ "name":"runoob", "alexa":10000, "site":"www.runoob.com" }');
```

##### 异常 解析数据

JSON 不能存储 Date 对象。

如果你需要存储 Date 对象，需要将其转换为字符串。

之后再将字符串转换为 Date 对象。

```javascript
var text = '{ "name":"Runoob", "initDate":"2013-12-14", "site":"www.runoob.com"}';
var obj = JSON.parse(text);
obj.initDate = new Date(obj.initDate);
 
document.getElementById("demo").innerHTML = obj.name + "创建日期: " + obj.initDate;
```

我们可以启用 JSON.parse 的第二个参数 reviver，一个转换结果的函数，对象的每个成员调用此函数。

```javascript
var text = '{ "name":"Runoob", "initDate":"2013-12-14", "site":"www.runoob.com"}';
var obj = JSON.parse(text, function (key, value) {
    if (key == "initDate") {
        return new Date(value);
    } else {
        return value;
}});
 
document.getElementById("demo").innerHTML = obj.name + "创建日期：" + obj.initDate;
```

##### 解析函数

JSON 不允许包含函数，但你可以将函数作为字符串存储，之后再将字符串转换为函数。

```javascript
var text = '{ "name":"Runoob", "alexa":"function () {return 10000;}", "site":"www.runoob.com"}';
var obj = JSON.parse(text);
obj.alexa = eval("(" + obj.alexa + ")");
 
document.getElementById("demo").innerHTML = obj.name + " Alexa 排名：" + obj.alexa();
```

```javascript
//eval(string):函数可计算某个字符串，并执行其中的的 JavaScript 代码。
eval("var a=1");     // 声明一个变量a并赋值1。
eval("2+3");         // 执行加运算，并返回运算值。
eval("mytest()");    // 执行mytest()函数。
eval("{b:2}");       // 声明一个对象。
```

#### JSON.stringify()

JSON 通常用于与服务端交换数据。

在向服务器发送数据时一般是字符串。

我们可以使用 JSON.stringify() 方法将 JavaScript 对象转换为字符串。

**语法**

```javascript
JSON.stringify(value[, replacer[, space]])
```

**参数说明：**

- value:

  必需， 要转换的 JavaScript 值（通常为对象或数组）。

- replacer:

  可选。用于转换结果的函数或数组。

  如果 replacer 为函数，则 JSON.stringify 将调用该函数，并传入每个成员的键和值。使用返回值而不是原始值。如果此函数返回 undefined，则排除成员。根对象的键是一个空字符串：""。

  如果 replacer 是一个数组，则仅转换该数组中具有键值的成员。成员的转换顺序与键在数组中的顺序一样。当 value 参数也为数组时，将忽略 replacer 数组。

- space:

  可选，文本添加缩进、空格和换行符，如果 space 是一个数字，则返回值文本在每个级别缩进指定数目的空格，如果 space 大于 10，则文本缩进 10 个空格。space 也可以使用非数字，如：\t。

##### JavaScript 对象转换

例如我们向服务器发送以下数据：

```javascript
var obj = { "name":"runoob", "alexa":10000, "site":"www.runoob.com"};
```

我们使用 JSON.stringify() 方法处理以上数据，将其转换为字符串：

```javascript
var myJSON = JSON.stringify(obj);
```

myJSON 为字符串。

我们可以将 myJSON 发送到服务器：

```javascript
var obj = { "name":"runoob", "alexa":10000, "site":"www.runoob.com"};
var myJSON = JSON.stringify(obj);
document.getElementById("demo").innerHTML = myJSON;
```

##### JavaScript 数组转换

我们也可以将 JavaScript 数组转换为 JSON 字符串：

```javascript
var arr = [ "Google", "Runoob", "Taobao", "Facebook" ];
var myJSON = JSON.stringify(arr);
```

#### 异常 解析数据

JSON 不能存储 Date 对象。

JSON.stringify() 会将所有日期转换为字符串。

```javascript
var obj = { "name":"Runoob", "initDate":new Date(), "site":"www.runoob.com"};
var myJSON = JSON.stringify(obj);
document.getElementById("demo").innerHTML = myJSON;
```

##### 解析函数

JSON 不允许包含函数，JSON.stringify() 会删除 JavaScript 对象的函数，包括 key 和 value。

```javascript
var obj = { "name":"Runoob", "alexa":function () {return 10000;}, "site":"www.runoob.com"};
var myJSON = JSON.stringify(obj);
 
document.getElementById("demo").innerHTML = myJSON;
```

我们可以在执行 JSON.stringify() 函数前将函数转换为字符串来避免以上问题的发生：

```javascript
var obj = { "name":"Runoob", "alexa":function () {return 10000;}, "site":"www.runoob.com"};
obj.alexa = obj.alexa.toString();
var myJSON = JSON.stringify(obj);
 
document.getElementById("demo").innerHTML = myJSON;
```



参考 ：[菜鸟教程](https://www.runoob.com/json/json-tutorial.html)

