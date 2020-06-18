# todoDemo
学习vue-element-admin的练习项目后端,实现一个简单的用户注册及查询待办事项

* 使用springboot+mybatis实现简单的后端,前端是vue-element-admin
* 返回的数据格式和前端目前的格式略有差异,不能直接部署就调用.如果部署项目需要将vue中的返回值等重新修改下
* 前端访问在dev环境中可以用Vue的devServer完成反向代理,单独打包部署可以用Nginx实现
* 仅仅是个Demo

## 包结构
以下目录内容是mybatis-generator自动生成的,生成代码的类为com.bear.todo.utils.GeneratorArtifacts
* com.bear.todo.generatormapper
* com.bear.todo.generatormodel;
* resources>mapper>com>bear>todo>generatormapper

## 数据库初始化
数据库脚本在resouces>sql内,需要手工初始化一下

## 其他
无