代码编写说明：
网页跳转的控制器已经写好统一放在HTMLController中，自己需要跳转页面是请使用转发(return "forward:/**";)。
自己创建service和controller时请使用对应的实体类的名称+service/controller，避免起名冲突，也方便他人调用。
开始编写代码前请更新本地代码，在编写完毕后请先更新在上传。
需要他人对应的模块的信息时，请和对应的人进行说明，告知你需要的信息，由对应的人编写提供查询方法，不要乱动他人负责的代码块。
如果发现需要修改数据库时，请告知其他所有人，统一修改，避免数据库不统一。
数据库中有一份用户数据用于登录
登录后将用户实体保存在session中，session.setAttribute("user", user);
用户名：admin，密码：123456
git连接地址：https://github.com/echo-02/rjdj.git
网页说明：
login：登录页面
index：登陆后进入的首页，也是用户信息修改页面
collect：收银页面
shopManagement:店铺管理页面
positionAuthority:职位权限页面
staffManagement：员工管理页面
proType：商品类别页面
proManagement：商品管理页面
proUploading：商品上传页面
supplier：供应商页面
purchase：采购单页面
vipInfo：会员信息页面
levelSetting：等级设置页面
integralSetting：积分设置页面
chargingOffset：充值抵扣页面
transactionRecord：成交记录页面
authorityManagement：权限管理页面
编写说明：
bootstrap样式以及脚本自行参考资料。
网页编写大致参照原网页，但不要改变现有项目的基础结构。
基础构架已经打好了，在自己负责的网页找到<!-- 自己的页面内容 -->注解，在其中编写网页代码，所有js脚本统一编写在<!-- JavaScript files-->注解下方(请注意脚本顺序)。
自己额外使用的外部js脚本请统一放到js文件夹中，额外的css文件同理放入css文件夹中，其余文件同理放入对应的文件夹中统一管理。
另：
原网页部分截图在日进斗金管理系统页面文档中，详情可以登录进原网页查看，也可以查看老师的视频
登录页面验证码部分已完成基础部分，事件以及结果处理自行修改。
若需要额外加上新的页面并需要基础架构请复制test页面中的代码。