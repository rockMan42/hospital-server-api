-- 用户表
CREATE TABLE `h_user_tb` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` VARCHAR(100) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) NOT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_username` (`username`) COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';


-- 患者表
CREATE TABLE h_patient_tb (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  gender CHAR(1) NOT NULL, -- M/F
  id_card VARCHAR(32) UNIQUE,
  birth_date DATE,
  phone VARCHAR(32),
  address VARCHAR(255),
  remark VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='患者表';

INSERT INTO h_patient_tb (`id`, `name`, `gender`, `id_card`, `birth_date`, `phone`, `address`, `remark`, `created_at`, `updated_at`) VALUES (1, '张磊', '男', '1992309', '2025-09-22', '16627898093', '北京市大兴区亦庄', '胃痛', '2025-09-22 14:57:53', '2025-09-22 14:57:53');

-- 1
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('张三', 'M', '110101199003078888', '1990-03-07', '13800138001', '北京市朝阳区建国路1号', '高血压病史');

-- 2
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('李四', 'F', '110102198512156666', '1985-12-15', '13800138002', '上海市浦东新区陆家嘴环路100号', '糖尿病患者');

-- 3
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('王五', 'M', '110103197806223333', '1978-06-22', '13800138003', '广州市天河区珠江新城A栋', '术后康复中');

-- 4
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('赵六', 'F', '110104199508304444', '1995-08-30', '13800138004', '深圳市南山区科技园北区', '首次就诊');

-- 5
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('孙七', 'M', '110105198211117777', '1982-11-11', '13800138005', '杭州市西湖区文三路123号', '慢性胃炎');

-- 6
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('周八', 'F', '110106199902289999', '1999-02-28', '13800138006', '成都市武侯区人民南路四段', '过敏体质');

-- 7
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('吴九', 'M', '110107197504182222', '1975-04-18', '13800138007', '南京市鼓楼区中山北路500号', '心脏支架术后');

-- 8
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('郑十', 'F', '110108199207051111', '1992-07-05', '13800138008', '武汉市江汉区解放大道1001号', '孕产妇建档');

-- 9
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('陈十一', 'M', '110109198809195555', '1988-09-19', '13800138009', '重庆市渝中区解放碑步行街', '体检客户');

-- 10
INSERT INTO h_patient_tb (name, gender, id_card, birth_date, phone, address, remark)
VALUES ('林十二', 'F', '110110200012310000', '2000-12-31', '13800138010', '西安市雁塔区小寨东路88号', '学生医保');


-- 科室表
CREATE TABLE h_department_tb (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(32) NOT NULL,
  code VARCHAR(100) NOT NULL, 
  description VARCHAR(3255),
  dc_id INT NOT NULL,
  doctor_id INT NOT NULL,
  job_title VARCHAR(32) NOT NULL,
  phone VARCHAR(16) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  established_time DATE,
  status int DEFAULT(0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='科室表';


-- 科室类型表
CREATE TABLE h_department_class_tb (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  department_class_name VARCHAR(32) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='科室类型表';


-- 医生职称表
CREATE TABLE h_profashion_title (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    profashion_titile VARCHAR(32) COMMENT '职称：主任医师，副主任医师，主治医师，住院医师',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医生职称表';

-- 医生表
CREATE TABLE h_doctor_tb (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    name VARCHAR(100) COMMENT '医生姓名',
    work_id VARCHAR(32) COMMENT '工号',
    gender CHAR(1) COMMENT '性别：男/女',
    age INT COMMENT '年龄',
    pt_id INT COMMENT '医生职称id',
    department_id INT COMMENT '科室id',
    major_direct VARCHAR(32) COMMENT '专业方向',
    phone VARCHAR(64) COMMENT '电话',
    enter_date DATE COMMENT '入职日期',
    status INT DEFAULT 0 COMMENT '初始状态（默认）0 ：在岗，1：休假，2：停职',
    description VARCHAR(255) COMMENT '备注',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='医生表';

INSERT INTO h_department_class_tb (department_class_name) VALUES
('内科'), ('外科'), ('儿科'), ('妇产科'), ('急诊科'),
('眼科'), ('耳鼻喉科'), ('皮肤科'), ('口腔科'), ('中医科'), ('康复科');

INSERT INTO h_profashion_title (profashion_titile) VALUES
('主任医师'), ('副主任医师'), ('主治医师'), ('住院医师'), ('实习医师'),
('主任医师'), ('副主任医师'), ('主治医师'), ('住院医师'), ('主任医师'), ('主治医师');

INSERT INTO h_doctor_tb (name, work_id, gender, age, pt_id, department_id, major_direct, phone, enter_date, status, description) VALUES
('张伟', 'DOC001', '男', 45, 1, 1, '心血管内科', '13800138001', '2010-03-15', 0, '资深专家'),
('李娜', 'DOC002', '女', 38, 2, 2, '普外科', '13800138002', '2012-07-22', 0, '技术骨干'),
('王强', 'DOC003', '男', 35, 3, 3, '小儿呼吸', '13800138003', '2015-01-10', 0, NULL),
('赵敏', 'DOC004', '女', 40, 1, 4, '产科', '13800138004', '2009-11-05', 1, '产假中'),
('刘洋', 'DOC005', '男', 30, 4, 5, '创伤急救', '13800138005', '2018-08-30', 0, '夜班主力'),
('陈静', 'DOC006', '女', 33, 3, 6, '白内障手术', '13800138006', '2016-04-12', 0, NULL),
('杨磊', 'DOC007', '男', 37, 2, 7, '鼻窦炎治疗', '13800138007', '2014-09-18', 0, '过敏科方向'),
('黄芳', 'DOC008', '女', 29, 4, 8, '银屑病', '13800138008', '2019-06-25', 2, '进修中'),
('周杰', 'DOC009', '男', 36, 3, 9, '正畸', '13800138009', '2013-12-03', 0, '擅长儿童牙科'),
('吴婷', 'DOC010', '女', 42, 1, 10, '针灸推拿', '13800138010', '2008-05-14', 0, '老中医'),
('郑凯', 'DOC011', '男', 31, 4, 11, '运动康复', '13800138011', '2020-02-20', 0, '健身爱好者');
INSERT INTO h_department_tb (name, code, description, dc_id, doctor_id, job_title, phone, established_time, status) VALUES
('心内科', 'DEP001', '心血管疾病诊疗', 1, 1, '主任医师', '010-12345678', '2005-01-01', 0),
('普外科', 'DEP002', '普通外科手术', 2, 2, '副主任医师', '010-12345679', '2006-03-10', 0),
('儿科', 'DEP003', '儿童疾病专科', 3, 3, '主治医师', '010-12345680', '2007-07-15', 0),
('妇产科', 'DEP004', '孕产及妇科疾病', 4, 4, '主任医师', '010-12345681', '2008-09-20', 1),
('急诊科', 'DEP005', '24小时急诊服务', 5, 5, '住院医师', '010-12345682', '2009-12-01', 0),
('眼科', 'DEP006', '眼科疾病与手术', 6, 6, '主治医师', '010-12345683', '2010-04-11', 0),
('耳鼻喉科', 'DEP007', '耳鼻喉相关疾病', 7, 7, '副主任医师', '010-12345684', '2011-08-25', 0),
('皮肤科', 'DEP008', '皮肤病与美容', 8, 8, '住院医师', '010-12345685', '2012-11-30', 2),
('口腔科', 'DEP009', '牙齿与口腔健康', 9, 9, '主治医师', '010-12345686', '2013-02-14', 0),
('中医科', 'DEP010', '中医诊疗与调理', 10, 10, '主任医师', '010-12345687', '2014-06-18', 0),
('康复科', 'DEP011', '术后及运动康复', 11, 11, '住院医师', '010-12345688', '2015-10-05', 0);

-- 科室表 → 科室类型表
ALTER TABLE h_department_tb
ADD CONSTRAINT fk_dept_dc_id_d2
FOREIGN KEY (dc_id) REFERENCES h_department_class_tb(id)
ON DELETE SET NULL ON UPDATE CASCADE;

-- 科室表 → 医生表（主任医师）
ALTER TABLE h_department_tb
ADD CONSTRAINT fk_dept_doctor_id
FOREIGN KEY (doctor_id) REFERENCES h_doctor_tb(id)
ON DELETE SET NULL ON UPDATE CASCADE;

-- 医生表 → 职称表
ALTER TABLE h_doctor_tb
ADD CONSTRAINT fk_doctor_pt_id
FOREIGN KEY (pt_id) REFERENCES h_profashion_title(id)
ON DELETE SET NULL ON UPDATE CASCADE;

-- 医生表 → 科室表
ALTER TABLE h_doctor_tb
ADD CONSTRAINT fk_doctor_dept_id
FOREIGN KEY (department_id) REFERENCES h_department_tb(id)
ON DELETE SET NULL ON UPDATE CASCADE;

-- 测试14: 查找在职医生（status=0）
SELECT 
    name AS 医生姓名,
    work_id AS 工号,
    major_direct AS 专业方向,
    phone AS 电话
FROM h_doctor_tb 
WHERE status = 0
ORDER BY name;

-- 测试15: 查找正常运营的科室（status=0）
SELECT 
    d.name AS 科室名称,
    dc.department_class_name AS 科室类型,
    doc.name AS 科室主任,
    d.phone AS 科室电话
FROM h_department_tb d
JOIN h_department_class_tb dc ON d.dc_id = dc.id
JOIN h_doctor_tb doc ON d.doctor_id = doc.id
WHERE d.status = 0
ORDER BY d.name;

-- 测试16: 查找年龄在30-40岁之间的医生
SELECT 
    doc.name AS 医生姓名,
    doc.age AS 年龄,
    pt.profashion_titile AS 职称,
    dept.name AS 科室
FROM h_doctor_tb doc
LEFT JOIN h_profashion_title pt ON doc.pt_id = pt.id
LEFT JOIN h_department_tb dept ON doc.department_id = dept.id
WHERE doc.age BETWEEN 30 AND 40
ORDER BY doc.age;

-- 诊室表
CREATE TABLE h_clinic_room_tb (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '诊室ID',
    room_number VARCHAR(20) NOT NULL COMMENT '诊室编号或名称，如：诊室A101',
    department_id BIGINT NOT NULL COMMENT '所属科室ID',
    location VARCHAR(100) COMMENT '位置信息，如：门诊楼3楼东区',
    status TINYINT DEFAULT 1 COMMENT '状态：0-停用，1-启用，2-维护中',
    description VARCHAR(255) COMMENT '备注信息',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    -- 添加唯一约束（防止重复诊室编号）
    UNIQUE KEY uk_room_number (room_number),
    
    -- 外键约束：关联科室表
    CONSTRAINT fk_clinic_room_department 
        FOREIGN KEY (department_id) REFERENCES h_department_tb(id)
        ON DELETE CASCADE ON UPDATE CASCADE
    

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='诊室表';

-- 插入测试科室（如果还没有）
INSERT INTO h_department_tb (name, code, dc_id, doctor_id, job_title, phone, established_time)
VALUES 
('内科', 'NK001', 1, 1001, '主任医师', '010-12345678', '2020-01-15'),
('外科', 'WK002', 2, 1002, '副主任医师', '010-87654321', '2020-02-20');

-- 插入测试医生（如果还没有）
INSERT INTO h_doctor_tb (name, work_id, gender, age, pt_id, department_id, major_direct, phone, enter_date)
VALUES 
('张伟', 'DOC1001', '男', 45, 1, 1, '心血管内科', '13800001111', '2015-03-01'),
('李芳', 'DOC1002', '女', 38, 2, 2, '普外科', '13800002222', '2016-07-15');

-- 插入诊室数据
INSERT INTO h_clinic_room_tb (room_number, department_id, location, status, description)
VALUES 
('C101', 1, '门诊楼1层东侧', 1, '内科普通门诊'),
('C102', 6, '门诊楼1层东侧', 1, '内科专家门诊'),
('C201', 2, '门诊楼2层西侧', 1, '外科门诊'),
('C301', 4, '门诊楼3层北区', 0, '备用诊室，暂未启用');

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (1, '心内科', 'DEP001', '心血管疾病诊疗', 1, 1, NULL, '主任医师', '010-12345678', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2005-01-01', 0);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (2, '普外科', 'DEP002', '普通外科手术', 2, 2, NULL, '副主任医师', '010-12345679', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2006-03-10', 0);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (3, '儿科', 'DEP003', '儿童疾病专科', 3, 3, NULL, '主治医师', '010-12345680', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2007-07-15', 0);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (4, '妇产科', 'DEP004', '孕产及妇科疾病', 4, 4, NULL, '主任医师', '010-12345681', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2008-09-20', 1);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (5, '急诊科', 'DEP005', '24小时急诊服务', 5, 5, NULL, '住院医师', '010-12345682', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2009-12-01', 0);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (6, '眼科', 'DEP006', '眼科疾病与手术', 6, 6, NULL, '主治医师', '010-12345683', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2010-04-11', 0);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (7, '耳鼻喉科', 'DEP007', '耳鼻喉相关疾病', 7, 7, NULL, '副主任医师', '010-12345684', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2011-08-25', 0);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (8, '皮肤科', 'DEP008', '皮肤病与美容', 8, 8, NULL, '住院医师', '010-12345685', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2012-11-30', 2);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (9, '口腔科', 'DEP009', '牙齿与口腔健康', 9, 9, NULL, '主治医师', '010-12345686', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2013-02-14', 0);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (10, '中医科', 'DEP010', '中医诊疗与调理', 10, 10, NULL, '主任医师', '010-12345687', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2014-06-18', 0);

INSERT INTO `hospital`.`h_department_tb` 
(`id`, `name`, `code`, `description`, `dc_id`, `doctor_id`, `clinic_room_id`, `job_title`, `phone`, `created_at`, `updated_at`, `established_time`, `status`) 
VALUES (11, '康复科', 'DEP011', '术后及运动康复', 11, 11, NULL, '住院医师', '010-12345688', '2025-09-22 19:05:07', '2025-09-22 19:05:07', '2015-10-05', 0);




-- 删除旧的诊室记录（如果需要）
DELETE FROM h_clinic_room_tb;
ALTER TABLE h_clinic_room_tb DROP INDEX uk_room_number;
-- 插入新的诊室记录
INSERT INTO h_clinic_room_tb (room_number, department_id, location, status, description)
VALUES 
('C101', 1, '门诊楼1层东侧', 1, '心内科普通门诊'), -- 心内科
('C102', 1, '门诊楼1层东侧', 1, '心内科专家门诊'), -- 心内科
('C201', 2, '门诊楼2层西侧', 1, '普外科门诊'),     -- 普外科
('C301', 4, '门诊楼3层北区', 0, '备用诊室，暂未启用'), -- 妇产科
('C401', 5, '急诊楼1层', 1, '急诊科门诊'),         -- 急诊科
('C501', 6, '门诊楼4层南侧', 1, '眼科门诊'),       -- 眼科
('C601', 7, '门诊楼5层西侧', 1, '耳鼻喉科门诊'),   -- 耳鼻喉科
('C701', 8, '门诊楼6层东侧', 0, '皮肤科备用诊室'), -- 皮肤科
('C801', 9, '门诊楼7层北区', 1, '口腔科门诊'),     -- 口腔科
('C901', 10, '中医楼2层', 1, '中医科门诊'),        -- 中医科
('C1001', 11, '康复楼1层', 1, '康复科门诊');       -- 康复科

CREATE TABLE `h_user_tb` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` VARCHAR(100) NOT NULL COMMENT '用户名',
  `password` VARCHAR(100) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 诊室医生表
CREATE TABLE `h_clinic_room_doctor_tb`(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  clinic_romm_id INT NOT NULL COMMENT '诊室id',
  doctor_id INT NOT NULL COMMENT '医生id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='诊室医生表';

INSERT INTO h_clinic_room_doctor_tb(clinic_room_id,doctor_id) VALUES(37,7);
INSERT INTO h_clinic_room_doctor_tb(clinic_room_id,doctor_id) VALUES(38,8);
INSERT INTO h_clinic_room_doctor_tb(clinic_room_id,doctor_id) VALUES(39,9);
INSERT INTO h_clinic_room_doctor_tb(clinic_room_id,doctor_id) VALUES(40,10);
INSERT INTO h_clinic_room_doctor_tb(clinic_room_id,doctor_id) VALUES(41,11);

-- 角色表
CREATE TABLE `h_role_tb`(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(32) NOT NULL COMMENT '角色名称',
  description VARCHAR(255) NOT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色表';

INSERT INTO h_role_tb(role_name,description) VALUES('doctor','医生');
INSERT INTO h_role_tb(role_name,description) VALUES('nurse','护士');
INSERT INTO h_role_tb(role_name,description) VALUES('manager','管理员');

-- 用户表 → 角色表
ALTER TABLE h_user_tb
ADD CONSTRAINT fk_user_role_id
FOREIGN KEY (role_id) REFERENCES h_role_tb(id)
ON DELETE SET NULL ON UPDATE CASCADE;



-- 护士表
CREATE TABLE h_nurse_tb (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    name VARCHAR(100) COMMENT '医生姓名',
    work_id VARCHAR(32) COMMENT '工号',
    gender CHAR(1) COMMENT '性别：男/女',
    age INT COMMENT '年龄',
    npt_id INT COMMENT '护士职称id',
    clinic_room_id INT COMMENT '诊室id',
    major_direct VARCHAR(32) COMMENT '专业方向',
    phone VARCHAR(64) COMMENT '电话',
    enter_date DATE COMMENT '入职日期',
    status INT DEFAULT 0 COMMENT '初始状态（默认）0 ：在岗，1：休假，2：停职',
    description VARCHAR(255) COMMENT '备注',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护士表';


-- 护士职称表
CREATE TABLE h_nurse_profashion_title_tb (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    nurse_profashion_titile VARCHAR(32) COMMENT '职称：主任护师、副主任护师',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='护士职称表';

-- 诊室护士表
CREATE TABLE `h_clinic_room_nurse_tb`(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  clinic_romm_id INT NOT NULL COMMENT '诊室id',
  nurse_id INT NOT NULL COMMENT '护士id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='诊室护士表';

INSERT INTO h_nurse_profashion_title_tb (nurse_profashion_titile) VALUES
('护士'),
('护师'),
('主管护师'),
('副主任护师'),
('主任护师'),
('专科护士'),
('责任护士'),
('护士长'),
('副护士长'),
('总护士长'),
('实习护士');

INSERT INTO h_nurse_tb (name, work_id, gender, age, npt_id, clinic_room_id, major_direct, phone, enter_date, status, description) VALUES
('李小红', 'N001', '女', 28, 1, 9, '内科护理', '13800138001', '2020-03-15', 0, '经验丰富的内科护士，工作认真负责'),
('王美丽', 'N002', '女', 32, 3, 11, '外科护理', '13800138002', '2018-07-20', 0, '外科护理专家，手术室经验丰富'),
('张晓芳', 'N003', '女', 26, 2, 10, '儿科护理', '13800138003', '2021-05-10', 0, '擅长儿童护理，深受小朋友喜爱'),
('陈静', 'N004', '女', 35, 4, 10, '妇产科护理', '13800138004', '2017-02-28', 0, '妇产科资深护士，助产经验丰富'),
('刘慧敏', 'N005', '女', 29, 3, 39, '急诊护理', '13800138005', '2019-09-12', 0, '急诊科护士，应急处理能力强'),
('赵雅琴', 'N006', '女', 31, 2, 40, '眼科护理', '13800138006', '2018-11-05', 0, '眼科护理专业，细致耐心'),
('孙丽娜', 'N007', '女', 27, 1, 41, '耳鼻喉护理', '13800138007', '2020-08-18', 0, '耳鼻喉科护理，专业技能扎实'),
('周文静', 'N008', '女', 33, 5, 42, '皮肤科护理', '13800138008', '2016-12-03', 1, '皮肤科护理专家，目前休假中'),
('吴小燕', 'N009', '女', 25, 11, 43, '口腔护理', '13800138009', '2022-01-20', 0, '口腔科新人护士，学习能力强'),
('马晓梅', 'N010', '女', 30, 8, 44, '中医护理', '13800138010', '2019-04-15', 0, '中医护理专业，熟悉中医理疗'),
('胡秀兰', 'N011', '女', 34, 9, 45, '康复护理', '13800138011', '2017-06-30', 0, '康复科护士长，管理经验丰富');


INSERT INTO h_clinic_room_nurse_tb (clinic_romm_id, nurse_id) VALUES
(9, 1),  -- 内科诊室 - 李小红
(11, 2),  -- 外科诊室 - 王美丽
(10, 3),  -- 儿科诊室 - 张晓芳
(10, 4),  -- 妇产科诊室 - 陈静
(39, 5),  -- 急诊科诊室 - 刘慧敏
(40, 6),  -- 眼科诊室 - 赵雅琴
(41, 7),  -- 耳鼻喉科诊室 - 孙丽娜
(42, 8),  -- 皮肤科诊室 - 周文静
(43 ,9),  -- 口腔科诊室 - 吴小燕
(44, 10), -- 中医科诊室 - 马晓梅
(45, 11); -- 康复科诊室 - 胡秀兰

-- 护士表 → 护士职称表
ALTER TABLE h_nurse_tb
ADD CONSTRAINT fk_nurse_profashion_title_id
FOREIGN KEY (npt_id) REFERENCES h_nurse_profashion_title_tb(id)
ON DELETE SET NULL ON UPDATE CASCADE;

-- 护士表 → 诊室表
ALTER TABLE h_nurse_tb
ADD CONSTRAINT fk_nurse_clinic_room_id
FOREIGN KEY (clinic_room_id) REFERENCES h_clinic_room_tb(id)
ON DELETE SET NULL ON UPDATE CASCADE;

-- 管理员表
CREATE TABLE h_manager_tb (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    name VARCHAR(100) COMMENT '管理员姓名',
    work_id VARCHAR(32) COMMENT '工号',
    clinic_room_id INT COMMENT '诊室id',
    mpt_id BIGINT COMMIT "管理员职称id",
    phone VARCHAR(64) COMMENT '电话',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员表';

-- 管理员职称表
CREATE TABLE h_it_profashion_title_tb (
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    it_professional_title VARCHAR(32) COMMENT '职称：运维工程师',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员职称表';

-- 诊室管理员表
CREATE TABLE `h_clinic_room_manager_tb`(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  clinic_romm_id INT NOT NULL COMMENT '诊室id',
  manager_id INT NOT NULL COMMENT '管理员id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='诊室管理员表';


-- 管理员表 → 诊室表
ALTER TABLE h_manager_tb
ADD CONSTRAINT fk_manager_clinic_room_id
FOREIGN KEY (clinic_room_id) REFERENCES h_clinic_room_tb(id)
ON DELETE SET NULL ON UPDATE CASCADE;

-- 管理员表 → 管理员职称表
ALTER TABLE h_manager_tb
ADD CONSTRAINT fk_manager_profashion_title_id
FOREIGN KEY (mpt_id) REFERENCES h_it_profashion_title_tb(id)
ON DELETE SET NULL ON UPDATE CASCADE;

INSERT INTO h_manager_tb (name, work_id, clinic_room_id, mpt_id, phone) VALUES
('张志强', 'M001', 9, 1, '13900139001'),
('李建华', 'M002', 10, 2, '13900139002'),
('王德明', 'M003', 11, 3, '13900139003'),
('陈国栋', 'M004', 12, 4, '13900139004'),
('刘永刚', 'M005', 35, 5, '13900139005'),
('赵文博', 'M006', 36, 6, '13900139006'),
('孙海涛', 'M007', 37, 7, '13900139007'),
('周建军', 'M008', 38, 8, '13900139008'),
('吴志远', 'M009', 38, 9, '13900139009'),
('马晓东', 'M010', 40, 10, '13900139010'),
('胡国庆', 'M011', 41, 11, '13900139011');


INSERT INTO h_it_profashion_title_tb (it_professional_title) VALUES
('系统管理员'),
('运维工程师'),
('网络管理员'),
('数据库管理员'),
('信息安全管理员'),
('技术支持工程师'),
('IT主管'),
('信息化专员'),
('系统架构师'),
('DevOps工程师'),
('IT经理');

INSERT INTO h_clinic_room_manager_tb (clinic_romm_id, manager_id) VALUES
(9, 1),   -- 内科诊室 - 张志强
(10, 2),   -- 外科诊室 - 李建华
(11, 3),   -- 儿科诊室 - 王德明
(12, 4),   -- 妇产科诊室 - 陈国栋
(35, 5),   -- 急诊科诊室 - 刘永刚
(36, 6),   -- 眼科诊室 - 赵文博
(37, 7),   -- 耳鼻喉科诊室 - 孙海涛
(38, 8),   -- 皮肤科诊室 - 周建军
(39, 9),   -- 口腔科诊室 - 吴志远
(40, 10), -- 中医科诊室 - 马晓东
(41, 11); -- 康复科诊室 - 胡国庆





ALTER TABLE h_user_tb
MODIFY created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE your_table_name 
MODIFY updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;



-- 就诊卡号唯一约束
ALTER TABLE h_patient_tb ADD CONSTRAINT uk_id_card UNIQUE (patient_id);

-- 身份证号唯一约束（允许NULL）
ALTER TABLE h_patient_tb ADD CONSTRAINT uk_patient_id UNIQUE (id_card);

















