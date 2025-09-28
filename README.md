# 🏥 医院管理系统后端服务 (HospitalServer)

## 📋 项目简介

医院管理系统后端服务是一个基于Spring Boot开发的现代化医院信息管理系统，提供完整的医院业务管理功能，包括人员管理、科室管理、诊室管理、费用管理等核心模块。系统采用前后端分离架构，为医院提供高效、安全、易用的信息化管理解决方案。

## 🚀 核心功能

### 👥 人员管理模块
- **医生管理**: 医生信息的增删改查、分页查询、职称管理
- **护士管理**: 护士信息的增删改查、分页查询、职称管理  
- **患者管理**: 患者信息管理、就诊记录管理
- **用户管理**: 系统用户权限管理、登录认证

### 🏢 组织架构管理
- **科室管理**: 科室信息维护、科室列表查询
- **诊室管理**: 诊室信息管理、科室诊室二级联动
- **人员分配**: 医生护士与诊室的绑定关系管理

### 💰 费用管理模块
- **费用类别管理**: 费用分类的增删改查、分页查询
- **费用项目管理**: 具体收费项目管理、价格维护
- **医保管理**: 支持甲类、乙类、丙类、自费等医保类型

### 📁 文件管理
- **头像上传**: 支持医生、护士头像上传
- **文件管理**: 图片文件的上传、存储、访问

### 🔐 安全认证
- **JWT认证**: 基于Token的用户身份认证
- **权限控制**: 接口访问权限控制
- **跨域支持**: 支持前后端分离部署

## 🛠️ 技术栈

### 后端框架
- **Spring Boot 3.4.4**: 主框架，提供自动配置和快速开发能力
- **Spring Web**: Web层框架，提供RESTful API支持
- **Spring Validation**: 参数校验框架

### 数据持久化
- **MyBatis 3.0.5**: ORM框架，提供灵活的SQL映射
- **MySQL**: 关系型数据库，存储业务数据
- **HikariCP**: 高性能数据库连接池

### 开发工具
- **Lombok 1.18.30**: 简化Java代码，减少样板代码
- **MapStruct 1.5.5**: 对象映射框架，DTO与Entity转换
- **Hutool 5.6.3**: Java工具类库，提供常用工具方法

### 安全认证
- **Java-JWT 3.9.0**: JWT Token生成和验证
- **Commons-Lang 2.6**: 字符串和对象处理工具

### 其他工具
- **Spring Boot DevTools**: 开发时热部署
- **Log4j2**: 日志框架
- **JSON**: JSON数据处理

## 🏗️ 项目架构

```
src/main/java/com/hospital/hospitalserver/
├── config/                 # 配置类
│   ├── TokenInterceptor.java      # JWT拦截器
│   └── WebConfiguration.java      # Web配置
├── controller/             # 控制器层
│   ├── HospitalDoctorController.java     # 医生管理
│   ├── HospitalNurseController.java      # 护士管理
│   ├── HospitalPatientController.java    # 患者管理
│   ├── HospitalDepartmentController.java # 科室管理
│   ├── HospitalClinicRoomController.java # 诊室管理
│   ├── HospitalFeeController.java        # 费用管理
│   ├── FileController.java               # 文件管理
│   └── HospitalUserController.java       # 用户管理
├── domain/                 # 数据传输对象
│   ├── dto/
│   │   ├── request/        # 请求DTO
│   │   └── response/       # 响应DTO
│   ├── entity/             # 实体类
│   └── enums/              # 枚举类
├── mapper/                 # 数据访问层
├── service/                # 业务逻辑层
├── mapping/                # 对象映射
├── util/                   # 工具类
└── exception/              # 异常处理
```

## 🗄️ 数据库设计

### 核心数据表
- `h_doctor_tb`: 医生信息表
- `h_nurse_tb`: 护士信息表
- `h_patient_tb`: 患者信息表
- `h_department_tb`: 科室信息表
- `h_clinic_room_tb`: 诊室信息表
- `h_profashion_title_tb`: 医生职称表
- `h_nurse_profashion_title_tb`: 护士职称表
- `h_fee_category_tb`: 费用类别表
- `h_fee_item_tb`: 费用项目表

### 关联关系表
- `h_clinic_room_doctor_tb`: 诊室医生关联表
- `h_clinic_room_nurse_tb`: 诊室护士关联表

### 排班管理表
- `h_person_type_tb`: 人员类型表
- `h_schedule_time_tb`: 排班时间表
- `h_doctor_schedule_tb`: 医生排班表
- `h_nurse_schedule_tb`: 护士排班表

## 🚀 快速开始

### 环境要求
- JDK 21+
- Maven 3.6+
- MySQL 8.0+

### 安装步骤

1. **克隆项目**
```bash
git clone <repository-url>
cd HospitalServer
```

2. **配置数据库**
```bash
# 执行数据库初始化脚本
mysql -u root -p < src/main/resources/database/01_init_tables.sql
```

详细的数据库设计和初始化说明请参考：[数据库文档](src/main/resources/database/README.md)

3. **修改配置文件**
```yaml
# src/main/resources/application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/hospital?useUnicode=true&characterEncoding=utf8&useSSL=false
    username: your_username
    password: your_password
```

4. **安装依赖并启动**
```bash
mvn clean install
mvn spring-boot:run
```

5. **访问应用**
- 服务地址: http://localhost:8081
- 静态资源: http://localhost:8081/img/

## 📚 API文档

### 医生管理 API
- `POST /hospital/doctor/getDoctorPage` - 医生分页查询
- `POST /hospital/doctor/createDoctor` - 创建医生
- `POST /hospital/doctor/updateDoctor` - 更新医生信息
- `POST /hospital/doctor/deleteDoctor` - 删除医生
- `POST /hospital/doctor/getDoctorDetail` - 获取医生详情
- `GET /hospital/doctor/getProfessionTitleList` - 获取职称列表

### 护士管理 API
- `POST /hospital/nurse/getNurseFullPage` - 护士分页查询
- `POST /hospital/nurse/createNurse` - 创建护士
- `POST /hospital/nurse/updateNurse` - 更新护士信息
- `POST /hospital/nurse/deleteNurse` - 删除护士
- `POST /hospital/nurse/getNurseDetail` - 获取护士详情

### 科室诊室管理 API
- `GET /hospital/department/getDepartmentList` - 获取科室列表
- `POST /hospital/clinicroom/getClinicRoomListByDepartmentId` - 根据科室获取诊室列表

### 费用管理 API
- `POST /hospital/fee/getFeeCategoryPage` - 费用类别分页查询
- `POST /hospital/fee/getFeeItemPage` - 费用项目分页查询
- `POST /hospital/fee/addFeeItem` - 添加费用项目
- `POST /hospital/fee/updateFeeItem` - 更新费用项目

### 文件管理 API
- `POST /file/uploadAvatar` - 头像上传
- `POST /file/uploadPhoto` - 照片上传

## 🔧 配置说明

### 数据库配置
```yaml
spring:
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/hospital
    username: root
    password: root
```

### 文件上传配置
```yaml
spring:
  servlet:
    multipart:
      enabled: true
      max-file-size: 2MB
      max-request-size: 2MB
```

### MyBatis配置
```yaml
mybatis:
  mapper-locations: classpath*:mappers/*.xml
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

## 🎯 核心特性

### 1. 科室诊室二级联动
支持前端下拉菜单的二级联动效果，选择科室后自动加载对应的诊室列表。

### 2. 统一响应格式
```json
{
  "code": 200,
  "message": "success",
  "data": {}
}
```

### 3. 分页查询支持
所有列表查询接口都支持分页，包含总数统计和条件筛选。

### 4. 参数校验
使用Jakarta Validation进行请求参数校验，确保数据完整性。

### 5. 异常处理
统一的异常处理机制，提供友好的错误信息返回。

## 🤝 贡献指南

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情

## 📞 联系方式

如有问题或建议，请通过以下方式联系：
- 项目Issues: [GitHub Issues](https://github.com/your-repo/issues)
- 邮箱: your-email@example.com

## 🔄 更新日志

### v0.0.1 (当前版本)
- ✅ 完成医生管理模块
- ✅ 完成护士管理模块  
- ✅ 完成科室诊室管理模块
- ✅ 完成费用管理模块
- ✅ 完成文件上传功能
- ✅ 完成科室诊室二级联动功能
- ✅ 完成JWT认证机制

---

⭐ 如果这个项目对你有帮助，请给它一个星标！
