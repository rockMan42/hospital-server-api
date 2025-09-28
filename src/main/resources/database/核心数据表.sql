

-- 费用类别表
CREATE TABLE IF NOT EXISTS `h_fee_category_tb` (
                                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '类别ID',
                                                   `category_code` varchar(50) NOT NULL COMMENT '类别编码',
    `category_name` varchar(100) NOT NULL COMMENT '类别名称',
    `category_type` tinyint NOT NULL COMMENT '1挂号费 2检查费 3治疗费 4药品费 5材料费 6手术费 7住院费',
    `description` varchar(200) DEFAULT NULL COMMENT '类别描述',
    `is_active` tinyint NOT NULL DEFAULT '1' COMMENT '是否启用',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_category_code` (`category_code`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='费用类别表';

-- 费用类别表数据插入
INSERT INTO `h_fee_category_tb` (`category_code`, `category_name`, `category_type`, `description`, `is_active`) VALUES
-- 1. 挂号费类别
('REG_001', '普通门诊挂号费', 1, '普通门诊科室挂号收费', 1),
('REG_002', '专家门诊挂号费', 1, '专家门诊科室挂号收费', 1),
('REG_003', '急诊挂号费', 1, '急诊科室挂号收费', 1),

-- 2. 检查费类别
('CHK_001', 'X光检查费', 2, 'X光影像检查收费', 1),
('CHK_002', 'CT检查费', 2, 'CT影像检查收费', 1),
('CHK_003', 'MRI检查费', 2, '核磁共振检查收费', 1),
('CHK_004', 'B超检查费', 2, 'B超检查收费', 1),
('CHK_005', '心电图检查费', 2, '心电图检查收费', 1),
('CHK_006', '血常规检查费', 2, '血液常规检验收费', 1),
('CHK_007', '尿常规检查费', 2, '尿液常规检验收费', 1),

-- 3. 治疗费类别
('TRT_001', '物理治疗费', 3, '物理康复治疗收费', 1),
('TRT_002', '针灸治疗费', 3, '针灸理疗收费', 1),
('TRT_003', '推拿治疗费', 3, '推拿按摩治疗收费', 1),
('TRT_004', '输液治疗费', 3, '静脉输液治疗收费', 1),
('TRT_005', '雾化治疗费', 3, '雾化吸入治疗收费', 1),

-- 4. 药品费类别
('MED_001', '西药费', 4, '西药处方药品收费', 1),
('MED_002', '中药费', 4, '中药处方药品收费', 1),
('MED_003', '中成药费', 4, '中成药处方药品收费', 1),
('MED_004', '注射药品费', 4, '注射类药品收费', 1),

-- 5. 材料费类别
('MAT_001', '一次性耗材费', 5, '一次性医用耗材收费', 1),
('MAT_002', '植入材料费', 5, '植入性医用材料收费', 1),
('MAT_003', '敷料材料费', 5, '医用敷料材料收费', 1),
('MAT_004', '导管材料费', 5, '各类导管材料收费', 1),

-- 6. 手术费类别
('SUR_001', '门诊小手术费', 6, '门诊小型手术收费', 1),
('SUR_002', '住院手术费', 6, '住院大型手术收费', 1),
('SUR_003', '麻醉费', 6, '手术麻醉服务收费', 1),
('SUR_004', '手术室使用费', 6, '手术室设备使用收费', 1),

-- 7. 住院费类别
('INP_001', '床位费', 7, '住院床位占用收费', 1),
('INP_002', '护理费', 7, '住院护理服务收费', 1),
('INP_003', '监护费', 7, '重症监护服务收费', 1),
('INP_004', '陪护费', 7, '陪护服务收费', 1);





-- 费用项目表
CREATE TABLE IF NOT EXISTS `h_fee_item_tb` (
                                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '项目ID',
                                               `item_code` varchar(50) NOT NULL COMMENT '项目编码',
    `item_name` varchar(100) NOT NULL COMMENT '项目名称',
    `category_id` bigint NOT NULL COMMENT '费用类别ID',
    `standard_price` decimal(10,2) NOT NULL COMMENT '标准价格',
    `insurance_price` decimal(10,2) DEFAULT NULL COMMENT '医保价格',
    `cost_price` decimal(10,2) DEFAULT NULL COMMENT '成本价格',
    `unit` varchar(20) NOT NULL COMMENT '计价单位',
    `insurance_type` varchar(10) DEFAULT 'B' COMMENT '医保类别：A甲类 B乙类 C丙类 self自费',
    `department_ids` json DEFAULT NULL COMMENT '适用科室ID数组',
    `description` text COMMENT '项目描述',
    `is_active` tinyint NOT NULL DEFAULT '1' COMMENT '是否启用',
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_item_code` (`item_code`),
    KEY `idx_category_id` (`category_id`),
    KEY `idx_is_active` (`is_active`),
    CONSTRAINT `fk_fee_item_category` FOREIGN KEY (`category_id`) REFERENCES `h_fee_category_tb` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='费用项目表';

-- 费用项目表数据插入
-- 注意：这里的category_id需要对应之前创建的h_fee_category_tb表中的实际ID
INSERT INTO `h_fee_item_tb` (`item_code`, `item_name`, `category_id`, `standard_price`, `insurance_price`, `cost_price`, `unit`, `insurance_type`, `department_ids`, `description`, `is_active`) VALUES

-- 挂号费项目 (category_id对应REG类别)
('REG001', '普通门诊挂号', 1, 10.00, 8.00, 2.00, '次', 'B', '[1,2,3,4,5]', '普通门诊科室挂号费用', 1),
('REG002', '专家门诊挂号', 2, 30.00, 25.00, 5.00, '次', 'B', '[1,2,3,4,5]', '专家门诊科室挂号费用', 1),
('REG003', '急诊挂号', 3, 20.00, 15.00, 3.00, '次', 'B', '[6]', '急诊科室挂号费用', 1),

-- 检查费项目 (category_id对应CHK类别)
('CHK001', '胸部X光片', 4, 80.00, 70.00, 30.00, '次', 'A', '[1,2,3,4,5,6]', '胸部X光影像检查', 1),
('CHK002', '头部CT平扫', 5, 300.00, 280.00, 150.00, '次', 'A', '[1,2,3,6]', '头部CT影像检查', 1),
('CHK003', '腰椎MRI', 6, 800.00, 750.00, 400.00, '次', 'A', '[7,8]', '腰椎核磁共振检查', 1),
('CHK004', '腹部B超', 7, 120.00, 100.00, 50.00, '次', 'A', '[1,2,3,4,5]', '腹部B超检查', 1),
('CHK005', '心电图', 8, 30.00, 25.00, 10.00, '次', 'A', '[1,2,3,6]', '心电图检查', 1),
('CHK006', '血常规', 9, 25.00, 20.00, 8.00, '次', 'A', '[1,2,3,4,5,6]', '血液常规检验', 1),
('CHK007', '尿常规', 10, 15.00, 12.00, 5.00, '次', 'A', '[1,2,3,4,5,6]', '尿液常规检验', 1),

-- 治疗费项目 (category_id对应TRT类别)
('TRT001', '物理治疗', 11, 80.00, 70.00, 30.00, '次', 'B', '[7,8]', '物理康复治疗', 1),
('TRT002', '针灸治疗', 12, 60.00, 50.00, 20.00, '次', 'B', '[9]', '针灸理疗', 1),
('TRT003', '推拿治疗', 13, 50.00, 40.00, 15.00, '次', 'B', '[7,8,9]', '推拿按摩治疗', 1),
('TRT004', '静脉输液', 14, 20.00, 18.00, 8.00, '次', 'A', '[1,2,3,4,5,6]', '静脉输液治疗', 1),
('TRT005', '雾化吸入', 15, 25.00, 20.00, 10.00, '次', 'A', '[1,2,3,10]', '雾化吸入治疗', 1),

-- 药品费项目 (category_id对应MED类别)
('MED001', '阿莫西林胶囊', 16, 15.00, 12.00, 8.00, '盒', 'A', '[1,2,3,4,5,6]', '抗生素类西药', 1),
('MED002', '感冒清热颗粒', 17, 25.00, 20.00, 12.00, '盒', 'B', '[1,2,3,4,5,6]', '中成药感冒药', 1),
('MED003', '板蓝根颗粒', 18, 18.00, 15.00, 10.00, '盒', 'B', '[1,2,3,4,5,6]', '中成药清热解毒', 1),
('MED004', '生理盐水注射液', 19, 8.00, 6.00, 3.00, '瓶', 'A', '[1,2,3,4,5,6]', '注射用药品', 1),

-- 材料费项目 (category_id对应MAT类别)
('MAT001', '一次性注射器', 20, 2.00, NULL, 1.00, '支', 'self', '[1,2,3,4,5,6]', '一次性医用耗材', 1),
('MAT002', '心脏支架', 21, 15000.00, 12000.00, 8000.00, '个', 'A', '[1]', '心脏植入支架', 1),
('MAT003', '医用纱布', 22, 5.00, NULL, 2.00, '包', 'self', '[1,2,3,4,5,6,7,8]', '医用敷料', 1),
('MAT004', '导尿管', 23, 25.00, 20.00, 12.00, '根', 'B', '[2,4,5]', '一次性导尿管', 1),

-- 手术费项目 (category_id对应SUR类别)
('SUR001', '阑尾切除术', 24, 2000.00, 1800.00, 800.00, '次', 'A', '[2]', '腹腔镜阑尾切除手术', 1),
('SUR002', '白内障手术', 25, 3000.00, 2500.00, 1200.00, '次', 'A', '[11]', '白内障摘除手术', 1),
('SUR003', '全身麻醉', 26, 800.00, 700.00, 300.00, '次', 'A', '[1,2,3,4,5]', '手术全身麻醉', 1),
('SUR004', '手术室使用', 27, 500.00, 450.00, 200.00, '小时', 'A', '[1,2,3,4,5]', '手术室设备使用', 1),

-- 住院费项目 (category_id对应INP类别)
('INP001', '普通病房床位', 28, 80.00, 70.00, 30.00, '天', 'A', '[1,2,3,4,5]', '普通病房床位费', 1),
('INP002', 'ICU床位', 29, 300.00, 280.00, 150.00, '天', 'A', '[1,2,3,4,5,6]', '重症监护病房床位费', 1),
('INP003', '一级护理', 30, 50.00, 45.00, 20.00, '天', 'A', '[1,2,3,4,5,6]', '住院一级护理服务', 1),
('INP004', '陪护服务', 31, 100.00, NULL, 50.00, '天', 'self', '[1,2,3,4,5,6]', '住院陪护服务', 1);

-- 创建员工类型表
CREATE TABLE IF NOT EXISTS hospital.h_staff_type_tb (
                                                        id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '类型ID',
                                                        type_code VARCHAR(20) NOT NULL COMMENT '类型代码',
    type_name VARCHAR(50) NOT NULL COMMENT '类型名称',
    description VARCHAR(200) COMMENT '类型描述',
    is_active TINYINT DEFAULT 1 COMMENT '是否启用：0禁用，1启用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    UNIQUE KEY uk_type_code (type_code),
    INDEX idx_is_active (is_active)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='员工类型定义表（用于排班系统）';

-- 创建班次时间段表
CREATE TABLE IF NOT EXISTS hospital.h_time_slot_tb (
                                                       id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '班次ID',
                                                       slot_code VARCHAR(20) NOT NULL COMMENT '班次代码',
    slot_name VARCHAR(50) NOT NULL COMMENT '班次名称',
    start_time TIME NOT NULL COMMENT '开始时间',
    end_time TIME NOT NULL COMMENT '结束时间',
    description VARCHAR(200) COMMENT '班次描述',
    is_active TINYINT DEFAULT 1 COMMENT '是否启用：0禁用，1启用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    UNIQUE KEY uk_slot_code (slot_code),
    INDEX idx_is_active (is_active),
    INDEX idx_time_range (start_time, end_time)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='班次时间段定义表（用于排班系统）';

-- 插入员工类型数据
INSERT INTO hospital.h_staff_type_tb (type_code, type_name, description, is_active) VALUES
                                                                                        ('DOCTOR', '医生', '执业医师，负责诊疗工作', 1),
                                                                                        ('NURSE', '护士', '执业护士，负责护理工作', 1),
                                                                                        ('TECHNICIAN', '技师', '医技人员，负责检查检验工作', 1),
                                                                                        ('PHARMACIST', '药师', '执业药师，负责药品管理和用药指导', 1),
                                                                                        ('ADMIN', '行政人员', '行政管理人员，负责医院管理工作', 1),
                                                                                        ('SECURITY', '保安', '安保人员，负责医院安全保卫工作', 1),
                                                                                        ('CLEANER', '保洁', '保洁人员，负责医院环境卫生', 1),
                                                                                        ('CASHIER', '收费员', '收费人员，负责医疗费用收取', 1);

-- 插入班次时间段数据
INSERT INTO hospital.h_time_slot_tb (slot_code, slot_name, start_time, end_time, description, is_active) VALUES
                                                                                                             ('MORNING', '上午班', '08:00:00', '12:00:00', '上午工作时间段', 1),
                                                                                                             ('AFTERNOON', '下午班', '14:00:00', '18:00:00', '下午工作时间段', 1),
                                                                                                             ('EVENING', '晚班', '18:00:00', '22:00:00', '晚间工作时间段', 1),
                                                                                                             ('NIGHT', '夜班', '22:00:00', '08:00:00', '夜间工作时间段（跨日）', 1),
                                                                                                             ('FULL_DAY', '全天班', '08:00:00', '18:00:00', '全天工作时间段', 1),
                                                                                                             ('EMERGENCY', '急诊班', '00:00:00', '23:59:59', '24小时急诊值班', 1),
                                                                                                             ('WEEKEND_AM', '周末上午', '09:00:00', '12:00:00', '周末上午时间段', 1),
                                                                                                             ('WEEKEND_PM', '周末下午', '14:00:00', '17:00:00', '周末下午时间段', 1),
                                                                                                             ('HOLIDAY', '节假日班', '09:00:00', '17:00:00', '节假日值班时间段', 1),
                                                                                                             ('ON_CALL', '待命班', '08:00:00', '18:00:00', '待命状态，随时可调用', 1);
