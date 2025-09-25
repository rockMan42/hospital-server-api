# hospital-server-api
医院服务器后端 API

## 简介
本项目为医院管理系统的服务端 API，提供诊室、科室、医生、预约等业务的统一后端支持，配套前端为 Vue3 管理系统。

## 技术选型

### 后端技术栈
- 框架：Spring Boot 2.7+
- 数据库：MySQL 8.0 + MyBatis Plus
- 缓存：Redis 6.0+
- 消息：WebSocket + STOMP
- 认证：JWT + Spring Security
- 监控：Spring Boot Actuator + Micrometer

### 前端技术栈
- 框架：Vue 3 + Composition API
- UI 库：Element Plus
- 状态管理：Pinia
- 路由：Vue Router 4
- HTTP：Axios
- WebSocket：STOMP.js
- 构建：Vite

## 环境要求
- JDK 8/11+
- Node.js 16+（如需本地启动前端示例）
- MySQL 8.0+
- Redis 6.0+

## 快速开始（后端）
```bash
# 1. 配置数据库与Redis
# 在 application.yml 中设置 MySQL 与 Redis 连接信息

# 2. 初始化数据库（可选）
# 导入 docs/sql/ 下的初始化脚本

# 3. 启动后端
mvn spring-boot:run
