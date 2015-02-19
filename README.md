# SimpleWeiboBySpringMvc
SpringMVC项目--小微博

###1，项目架构
  SpringMVC + SpringSecurity + MySQL

###2, 项目启动
  |-- 部署至tomcat服务器

  |-- 配置 WEB-INF/rescources/info/db.properties内MySQL登录信息

  |-- 安装依赖
  	  |-- spring,springMVC,SpringSecurity,jaskson,jstl,MySQL java驱动。
	
  |-- 配置MySQL数据
  	  |-- 新建weibo数据库
  	  |-- 新建user表
  	  	  |-- id(自增主键)
  	  	  |-- username
  	  	  |-- password
  	  	  |-- role(默认值为ROLE_USER,管理员权限为ROLE_ADMIN,由SpringSecurity进行权限验证)
  	  |-- 新建weibo表
  	  	  |-- id(自增主键)
  	  	  |-- content(微博内容)
  	  	  |-- name(发送该微博的用户)

###3，运行
  |-- 注册
      |-- 注册时会自动使用AJAX验证用户输入的用户名是否已被占
  |-- 登录
  	  |-- SpringSecurity接管
  |-- 微博相关
  	  |-- 将查询到的微博进行分页，每页显示5条，按微博的发送时间进行排序，最新的最靠前
  	  |-- 每位用户有权删除自己发的微博	  

###4,测试
	|-- 完善中

##5,心得
	|-- 之前都是用的nodejs做的服务端开发，感觉更方便快捷，但是SpringMVC给人的架构感更强，职责区分感更强烈。
	|-- Spring相关真是一个好大的生态，还得继续加深学习！
	|-- 前端就偷懒直接用bootstrap+jquery搭了:)
	|-- 脑补的继续完善列表:
		|-- 单元测试
		|-- 管理员权限相关
		|-- 微博评论
		|-- maven项目(更方便的管理，安装依赖！)
		|-- ...