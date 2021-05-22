# CloudServer
王程毕业设计：基于web的社区物业管理系统 使用SpringCloud实现

cloud-consumer-order8088    服务转发服务。cloud-api-commons

cloud-controller-charge8012   收费管理模块

cloud-controller-config8014   配置管理模块

cloud-controller-property8011   社区管理中心模块

cloud-controller-service8013    服务中心模块

cloud-controller-user8010    用户中心模块

cloud-eureka-server7001       服务发现1

cloud-eureka-server7002      服务发现2

cloud-provider-payment8001   支付功能模块



运行方法：
  首先运行cloud-eureka-server7001 ===>cloud-eureka-server7002====>cloud-provider-payment8001====>cloud-controller-user8010====>cloud-controller-property8011====>cloud-controller-charge8012====>cloud-controller-service8013====>cloud-controller-config8014====>cloud-consumer-order8088
