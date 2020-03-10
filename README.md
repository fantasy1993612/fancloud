## 活动 

#### 框架 
- Spring Cloud
- Redis 
- Swagger 文档接口
- Jpa Hibernate ORM
- PerfTest(单元测试进行简单性能测试)

- 需要安装插件 lombok 消除实体类生成get/set
,生成构造函数，复写toString等

#### activity模块



##### 全局日志/异常/返回参数

GlobalLog 记录输入输出参数

GlobalExceptionHandler 记录全局异常

BaseResponse 返回消息包装类

##### 抽奖

- 策略模式抽奖 代码strategy-> DistributeStrategy

- 正常抽奖 controller -> DistributeAwardController

抽奖逻辑分析 （可变不可变只，在不同活动场景判断方式变化）

- 限流器（根据具体活动选择，限制每秒并发数）
- 检查是否为热门活动 (可变)
- 检查是否为活动资格（可变）
- 检查抽奖/领奖限制 （可变 有些活动可能不需要）
- 扣减奖品数量redis （一般不变）

以上流程走缓存 统一由@Cacheable 管理缓存丢失问题
以下流程通过 @Async 异步执行，
由spring自己的线程池接管。根据一致性要求可选择同步
- 扣减奖品数量 （数据库扣减）
- 派发奖品 （一般不变）
- 保存中奖记录 （一般不变）






