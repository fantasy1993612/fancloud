package com.fantasy.hystrixdashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: xiangming
 * @Date: 2020-02-04-18:06
 * @Describetion
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class HystrixdashboardApplication {

}
