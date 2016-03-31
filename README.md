### cjoop-dm - 大漠插件java版本
[![Build Status](https://travis-ci.org/cjjava/cjoop-dm.svg?branch=master)](https://travis-ci.org/cjjava/cjoop-dm)

该java插件针对v3.1233免费版本开发.请对号入座.

请看百度介绍[大漠插件](http://baike.baidu.com/link?url=I_rtZHMyHmPJAAH9agzWfNi61pWC8y-LPfF-p0anCDSERGJbPG2DpCpNCT3wiPz6d0hJpdMqMdLoVP1Oa0hSAK)

请配合最后的免费版本工具使用.[工具下载](http://bbs.anjian.com/showtopic-343817-1.aspx)

可以引入仓库地址:

```sh
<repository>
		<id>cjoop-repo</id>
		<url>https://raw.githubusercontent.com/cjjava/cjoop-repo/master</url>
</repository>
```
添加依赖:

```sh
<dependency>
	<groupId>com.cjoop</groupId>
	<artifactId>cjoop-dm</artifactId>
	<version>0.0.1</version>
</dependency>
```
使用简单代码运行：
```sh
DmSoft dm = new DmSoft();
System.out.println("version:" + dm.Ver());
System.out.println("path:"+dm.GetBasePath());
```
