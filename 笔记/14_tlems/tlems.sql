-- 创建员工表
drop table IF EXISTS emp;
create table emp(
	emp_id varchar (50) PRIMARY key,
    emp_pwd varchar(50) not null,
    emp_name varchar(50) not null,
	emp_dept varchar(50) not null,
    emp_level int not null,
    emp_hiredate TIMESTAMP not null default now(),
    emp_desc varchar(200)
);

-- 创建供应商表格
drop table IF EXISTS supplier;
create table supplier(
	sup_id varchar(50) PRIMARY key,
    sup_name varchar(50) not null,
	sup_level int not null,
    sup_contact varchar(50) not null,
    sup_phone varchar(50) not null,
    sup_address varchar(200) not null,
    sup_email varchar(50) not null,
    sup_create_time TIMESTAMP not null default CURRENT_TIMESTAMP,
    sup_desc varchar(200)
);

-- 创建零件信息表
drop table IF EXISTS part;
create table part(
	part_uid varchar (50) PRIMARY key,
    part_id varchar(50) not null,
    part_name varchar(50) not null,
	part_group_id varchar(50) not null,
    part_sup_id varchar(50) not null,
    part_sup_code varchar(50) not null,
    part_weoght double,
    part_material varchar(50),
    part_circle int,
    part_price double not null,
    part_desc VARCHAR(50)
); 

-- 创建模块索引表
drop table if exists module_catalog;
create table module_catalog(
	mdc_id varchar(50) PRIMARY key,
    mdc_name varchar(50) not null,
    mdc_dexc varchar(200) not null,
    mdc_price double not null
);

-- 创建模块组成表
drop table if exists module_parts;
create table module_parts(
	mdp_mdc_id varchar(50) not null,
    mdp_part_id varchar(50) not null,
    mdp_part_amount int not null
);

-- 产品总成信息表
drop table if exists product;
create table product(
	pdt_id VARCHAR(50) PRIMARY key,
    pdt_series varchar(50) not null,
    pdt_desc varchar(200) not null,
    pdt_cost double not null
);

-- 产品模块表
drop table if exists product_module;
create table product_module(
	pdm_pdt_id varchar(50) not null,
    pdm_md_id varchar(50) not null,
    pdm_md_amount int not null
);

-- 采购信息表

-- 出库记录表

-- 库存信息表

-- 客户信息表

-- 注入零件表数据


-- 生成员工数据

-- 生成员工数据

-- 生成员工数据

-- 生成员工数据

-- 生成员工数据

insert into emp values ('100001','100001','大老板','管理部',1,now(),'员工测试数据');
insert into emp values ('100002','100002','总经理','管理部',1,now(),'员工测试数据');
insert into emp values ('100003','100003','张副总','管理部',1,now(),'员工测试数据');
insert into emp values ('100004','100004','李副总','管理部',1,now(),'员工测试数据');
insert into emp values ('100005','100005','王副总','管理部',1,now(),'员工测试数据');
insert into emp values ('100006','100006','赵副总','管理部',1,now(),'员工测试数据');
insert into emp values ('100007','100007','陈部长','管理部',1,now(),'员工测试数据');
insert into emp values ('100008','100008','周部长','管理部',1,now(),'员工测试数据');
insert into emp values ('100009','100009','钱书记','管理部',1,now(),'员工测试数据');
insert into emp values ('100010','100010','孙大炮','研发部',1,now(),'员工测试数据');
insert into emp values ('100011','100011','吴科长','研发部',1,now(),'员工测试数据');
insert into emp values ('100012','100012','郑成功','研发部',1,now(),'员工测试数据');
insert into emp values ('100013','100013','宋小宝','研发部',1,now(),'员工测试数据');
insert into emp values ('100014','100014','沈腾','研发部',1,now(),'员工测试数据');
insert into emp values ('100015','100015','马伊琍','研发部',1,now(),'员工测试数据');
insert into emp values ('100016','100016','文章','研发部',1,now(),'员工测试数据');
insert into emp values ('100017','100017','麦迪','研发部',1,now(),'员工测试数据');
insert into emp values ('100018','100018','陈道明','研发部',1,now(),'员工测试数据');
insert into emp values ('100019','100019','道明寺','研发部',1,now(),'员工测试数据');
insert into emp values ('100020','100020','明道','生产部',1,now(),'员工测试数据');
insert into emp values ('100021','100021','花泽类','生产部',1,now(),'员工测试数据');
insert into emp values ('100022','100022','陈小春','生产部',1,now(),'员工测试数据');
insert into emp values ('100023','100023','张柏芝','生产部',1,now(),'员工测试数据');
insert into emp values ('100024','100024','张无忌','生产部',1,now(),'员工测试数据');
insert into emp values ('100025','100025','黎姿','生产部',1,now(),'员工测试数据');
insert into emp values ('100026','100026','员工:26','生产部',1,now(),'员工测试数据');
insert into emp values ('100027','100027','员工:27','生产部',1,now(),'员工测试数据');
insert into emp values ('100028','100028','员工:28','生产部',1,now(),'员工测试数据');
insert into emp values ('100029','100029','员工:29','生产部',1,now(),'员工测试数据');
insert into emp values ('100030','100030','员工:30','市场部',1,now(),'员工测试数据');
insert into emp values ('100031','100031','员工:31','市场部',1,now(),'员工测试数据');
insert into emp values ('100032','100032','员工:32','市场部',1,now(),'员工测试数据');
insert into emp values ('100033','100033','员工:33','市场部',1,now(),'员工测试数据');
insert into emp values ('100034','100034','员工:34','市场部',1,now(),'员工测试数据');
insert into emp values ('100035','100035','员工:35','市场部',1,now(),'员工测试数据');
insert into emp values ('100036','100036','员工:36','市场部',1,now(),'员工测试数据');
insert into emp values ('100037','100037','员工:37','市场部',1,now(),'员工测试数据');
insert into emp values ('100038','100038','员工:38','市场部',1,now(),'员工测试数据');
insert into emp values ('100039','100039','员工:39','市场部',1,now(),'员工测试数据');
insert into emp values ('100040','100040','员工:40','市场部',1,now(),'员工测试数据');

-- 生成供应商数据

insert into supplier values ('2001','潍柴动力',1,'赵文卓','电话:88881000','山东','邮箱:1',now(),'供应商测试数据');
insert into supplier values ('2002','艾里逊',1,'王小波','电话:88882000','深圳','邮箱:2',now(),'供应商测试数据');
insert into supplier values ('2003','同力车架',1,'张三丰','电话:88883000','地址:3','邮箱:3',now(),'供应商测试数据');
insert into supplier values ('2004','扬州沃盛',1,'王小宇','电话:88884000','地址:4','邮箱:4',now(),'供应商测试数据');
insert into supplier values ('2005','瑞立',1,'李文迪','电话:88885000','地址:5','邮箱:5',now(),'供应商测试数据');
insert into supplier values ('2006','鹤壁永平',1,'黄日华','电话:88886000','地址:6','邮箱:6',now(),'供应商测试数据');
insert into supplier values ('2007','汉德一厂',1,'李米','电话:88887000','地址:7','邮箱:7',now(),'供应商测试数据');
insert into supplier values ('2008','汉德二厂',1,'董静','电话:88888000','地址:8','邮箱:8',now(),'供应商测试数据');
insert into supplier values ('2009','汉德三厂',1,'爱迪生','电话:88889000','地址:9','邮箱:9',now(),'供应商测试数据');
insert into supplier values ('2010','同力货箱',1,'林纳斯','电话:888810000','地址:10','邮箱:10',now(),'供应商测试数据');

-- 生成零件数据

insert into part values ('8bb9e0b5-7605-46fd-8785-528aa6ae40f3','85015001055','零件:1','850','2001','sup_201A',null,'Q235',15,round(15.33598134931038,1),'零件测试数据');
insert into part values ('a7ca2ddc-e523-4695-b2d2-0e7cf09ae6d6','85037001073','零件:2','850','2001','sup_202A',null,'Q235',15,round(90.76813734478948,1),'零件测试数据');
insert into part values ('971e2327-2c95-411f-9a88-17132b577b9c','85027001042','零件:3','850','2001','sup_203A',null,'Q235',15,round(53.99876208247768,1),'零件测试数据');
insert into part values ('13b5a0fd-e98c-4985-8e51-5caeeea233a9','85031001092','零件:4','850','2001','sup_204A',null,'Q235',15,round(22.38545492901707,1),'零件测试数据');
insert into part values ('05e397c9-235d-43cd-bbec-8ec4347f17cf','85010001028','零件:5','850','2001','sup_205A',null,'Q235',15,round(2.943172468100741,1),'零件测试数据');
insert into part values ('4e1c42f1-c6b6-4d24-b065-b6fa707eb1ba','89038001028','零件:6','890','2001','sup_206A',null,'Q235',15,round(71.53086428497232,1),'零件测试数据');
insert into part values ('a75a1968-f0fb-4d7a-83c9-1d513effceb1','87012001045','零件:7','870','2001','sup_207A',null,'Q235',15,round(60.34777337240822,1),'零件测试数据');
insert into part values ('155c6db4-d7e1-44a0-a7b9-a482decbcf7a','87038001062','零件:8','870','2001','sup_208A',null,'Q235',15,round(61.90894361861024,1),'零件测试数据');

-- 生成模块索引数据

insert into module_catalog values ('85031010008','模块1','模块索引测试数据',100);
insert into module_catalog values ('86024010004','模块1:2','模块索引测试数据',100);
insert into module_catalog values ('87031010003','模块1:3','模块索引测试数据',100);
insert into module_catalog values ('89023010008','模块1:4','模块索引测试数据',100);
insert into module_catalog values ('86015010000','模块1:5','模块索引测试数据',100);
insert into module_catalog values ('89035010009','模块1:6','模块索引测试数据',100);
insert into module_catalog values ('88033010004','模块1:7','模块索引测试数据',100);
insert into module_catalog values ('88030010006','模块1:8','模块索引测试数据',100);
insert into module_catalog values ('88024010002','模块1:9','模块索引测试数据',100);

-- 生成模块组成表数据

insert into module_parts values ('89033010008','89039001052',17);
insert into module_parts values ('88028010001','86037001079',17);
insert into module_parts values ('86033010001','86039001085',9);
insert into module_parts values ('85038010004','89036001030',26);
insert into module_parts values ('85037010009','88033001047',17);
insert into module_parts values ('85034010003','89010001056',19);
insert into module_parts values ('88022010000','88012001003',14);
insert into module_parts values ('89039010008','89015001079',7);
insert into module_parts values ('85016010000','85026001095',18);

-- 生成产品索引表数据

insert into product values ('850-1A','850','产品索引测试数据',10086);
insert into product values ('870-2A','870','产品索引测试数据',10086);
insert into product values ('850-3A','850','产品索引测试数据',10086);
insert into product values ('860-4A','860','产品索引测试数据',10086);
insert into product values ('860-5A','860','产品索引测试数据',10086);
insert into product values ('870-6A','870','产品索引测试数据',10086);
insert into product values ('870-7A','870','产品索引测试数据',10086);
insert into product values ('890-8A','890','产品索引测试数据',10086);
insert into product values ('870-9A','870','产品索引测试数据',10086);

-- 生成产品模块表数据

insert into product_module values ('880-1A','88033010003',14);
insert into product_module values ('880-1A','89013010005',23);
insert into product_module values ('880-1A','89037010002',17);
insert into product_module values ('880-1A','85028010004',8);
insert into product_module values ('880-1A','86022010004',15);
insert into product_module values ('880-1A','85020010007',12);
insert into product_module values ('880-1A','87026010002',24);
insert into product_module values ('880-1A','85017010009',20);
insert into product_module values ('880-1A','88024010003',27);
insert into product_module values ('880-1A','88017010008',20);
insert into product_module values ('880-1A','85037010001',5);
insert into product_module values ('880-1A','88018010000',21);
insert into product_module values ('880-1A','85017010006',16);
insert into product_module values ('880-1A','89019010007',19);
insert into product_module values ('880-1A','88032010001',13);
insert into product_module values ('880-1A','87012010006',14);
insert into product_module values ('880-1A','86018010008',26);
insert into product_module values ('880-1A','88018010000',16);
insert into product_module values ('880-1A','89028010008',11);
insert into product_module values ('880-1A','86020010001',8);
insert into product_module values ('880-1A','88013010007',9);
insert into product_module values ('880-1A','87023010009',15);
insert into product_module values ('880-1A','88017010006',22);
insert into product_module values ('880-1A','89015010002',21);
insert into product_module values ('880-1A','86032010002',4);
insert into product_module values ('880-1A','85025010009',18);
insert into product_module values ('880-1A','85016010008',1);
insert into product_module values ('880-1A','86030010001',26);
insert into product_module values ('880-1A','87017010007',25);
insert into product_module values ('880-1A','89019010008',8);



-- 先创建一个prodoct 产品
insert into product values('856-1','850','燃气车, 艾里逊自动变速箱, 潍柴 CNG 燃气发动机',500000);

-- 产品由十个模块组成
insert into product_module values('856-1','85015000017',1);
insert into product_module values('856-1','85016000017',1);
insert into product_module values('856-1','85017000017',1);
insert into product_module values('856-1','85018000017',1);
insert into product_module values('856-1','85019000017',1);
insert into product_module values('856-1','85036000017',1);
insert into product_module values('856-1','85037000017',1);
insert into product_module values('856-1','85038000017',1);
insert into product_module values('856-1','85039000017',1);
insert into product_module values('856-1','85040000017',1);

-- 创建十个模块的信息
insert into module_catalog values('85015000017','发动机总成','潍柴CNG燃气发动机, 360马力',150000);
insert into module_catalog values('85016000017','变速箱总成','艾里逊自动变速线',230000);
insert into module_catalog values('85017000017','车架总成','850通用车架',50000);
insert into module_catalog values('85018000017','驾驶室总成','扬州沃盛宽体驾驶室',40000);
insert into module_catalog values('85019000017','制动系统','制动系统总成',50000);
insert into module_catalog values('85036000017','电气系统','燃气车电气系统',30000);
insert into module_catalog values('85037000017','前桥总成','汉德车桥,前桥13吨',40000);
insert into module_catalog values('85038000017','中桥总成','汉德车桥,中桥15吨',30000);
insert into module_catalog values('85039000017','后桥总成','汉德车桥,后桥15吨',30000);
insert into module_catalog values('85040000017','货箱总成','40方耐磨货箱,带加热风道',50000);

-- 每个模块有十个零件
-- 发动机总成
insert into module_parts values ('85015000017','85015011001',1);
insert into module_parts values ('85015000017','85015011002',1);
insert into module_parts values ('85015000017','85015011003',1);
insert into module_parts values ('85015000017','85015011004',1);
insert into module_parts values ('85015000017','85015011005',1);
insert into module_parts values ('85015000017','85015011006',1);
insert into module_parts values ('85015000017','85015011007',1);
insert into module_parts values ('85015000017','85015011008',1);
insert into module_parts values ('85015000017','85015011009',1);
insert into module_parts values ('85015000017','85015011010',1);


insert into part values ('29aa5c7d-2b27-4687-b514-f6ba64495ac8','85015011001','发动机本体','850','2001','2001-15011001A',null,'Q235',15,round(23.250140709416755,1),'潍柴发动机');
insert into part values ('634045c4-bcb8-47c7-949b-ecb2f0f4711e','85015011002','发动机线束','850','2001','2001-15011002A',null,'Q235',15,round(47.64322365833094,1),'潍柴发动机');
insert into part values ('0b2db992-677a-4036-8596-d63a303c389f','85015011003','火花塞','850','2001','2001-15011003A',null,'Q235',15,round(33.16054077229803,1),'潍柴发动机');
insert into part values ('826e630c-6931-4668-b769-12337e2ae9a4','85015011004','缸盖','850','2001','2001-15011004A',null,'Q235',15,round(56.593200342369755,1),'潍柴发动机');
insert into part values ('389ea321-9b6b-49fa-9adc-d1f0dcd0a493','85015011005','转速传感器','850','2001','2001-15011005A',null,'Q235',15,round(25.224628408251704,1),'潍柴发动机');
insert into part values ('6fe4d42d-431e-4b62-8bcd-f624eca13531','85015011006','水温传感器','850','2001','2001-15011006A',null,'Q235',15,round(45.5482614308072,1),'潍柴发动机');
insert into part values ('a7269a54-571b-4c12-838b-6660c269864d','85015011007','氧传感器','850','2001','2001-15011007A',null,'Q235',15,round(75.82799204713405,1),'潍柴发动机');
insert into part values ('335ffc02-aa05-47c2-95c5-e7462ae5e5db','85015011008','风扇','850','2001','2001-15011008A',null,'Q235',15,round(40.3196555625572,1),'潍柴发动机');
insert into part values ('c48acc90-f35d-4505-831f-f7b3d53282ae','85015011009','发动机ECU','850','2001','2001-15011009A',null,'Q235',15,round(13.779288981236949,1),'潍柴发动机');
insert into part values ('4c12e87c-f2bd-4d09-be1f-0f05c661d35e','85015011010','起动机','850','2001','2001-15011010A',null,'Q235',15,round(83.9439969853918,1),'潍柴发动机');

-- 变速箱总成
insert into module_parts values ('85016000017','85016011001',1);
insert into module_parts values ('85016000017','85016011002',1);
insert into module_parts values ('85016000017','85016011003',1);
insert into module_parts values ('85016000017','85016011004',1);
insert into module_parts values ('85016000017','85016011005',1);
insert into module_parts values ('85016000017','85016011006',1);
insert into module_parts values ('85016000017','85016011007',1);
insert into module_parts values ('85016000017','85016011008',1);
insert into module_parts values ('85016000017','85016011009',1);
insert into module_parts values ('85016000017','85016011010',1);

insert into part values ('f40bfd70-305f-4dab-a009-e14beef03ae9','85016011001','变速箱本体','850','2002','2002-16011001A',null,'Q235',15,round(66.3362086591571,1),'艾里逊变速箱');
insert into part values ('2a0cbd98-50c8-43c5-8136-9af397482c7a','85016011002','变速箱ECU','850','2002','2002-16011002A',null,'Q235',15,round(55.06783670091628,1),'艾里逊变速箱');
insert into part values ('a9471502-d5a2-434a-acfe-e83f10434032','85016011003','变速箱缓速器','850','2002','2002-16011003A',null,'Q235',15,round(67.9705152236593,1),'艾里逊变速箱');
insert into part values ('559c1c0a-9626-403a-974a-f5ad04514a92','85016011004','变速箱线束','850','2002','2002-16011004A',null,'Q235',15,round(82.8281533302789,1),'艾里逊变速箱');
insert into part values ('d9c35611-6dd0-4a5a-a1cd-bbd516283104','85016011005','换挡器','850','2002','2002-16011005A',null,'Q235',15,round(2.6082004181140594,1),'艾里逊变速箱');
insert into part values ('27565bbc-092d-4aa5-b0db-fdebf2e6498a','85016011006','换挡器底座','850','2002','2002-16011006A',null,'Q235',15,round(19.80361070481097,1),'艾里逊变速箱');
insert into part values ('10e857f9-bf1d-49e9-aa84-9c6e50c78617','85016011007','缓速器控制器','850','2002','2002-16011007A',null,'Q235',15,round(26.35836086890675,1),'艾里逊变速箱');
insert into part values ('8bf52afb-4e33-4753-99df-b4b87ee5d689','85016011008','输入转速传感器','850','2002','2002-16011008A',null,'Q235',15,round(14.261200312722123,1),'艾里逊变速箱');
insert into part values ('10cba892-0a09-4a19-b793-3156271afb56','85016011009','输出转速传感器','850','2002','2002-16011009A',null,'Q235',15,round(84.28680331811636,1),'艾里逊变速箱');
insert into part values ('5e9afeb9-cc9a-473a-acb2-352f2390ed64','85016011010','油温传感器','850','2002','2002-16011010A',null,'Q235',15,round(58.51129018715717,1),'艾里逊变速箱');

-- 车架总成
insert into module_parts values ('85017000017','85017011001',1);
insert into module_parts values ('85017000017','85017011002',1);
insert into module_parts values ('85017000017','85017011003',1);
insert into module_parts values ('85017000017','85017011004',1);
insert into module_parts values ('85017000017','85017011005',1);
insert into module_parts values ('85017000017','85017011006',1);
insert into module_parts values ('85017000017','85017011007',1);
insert into module_parts values ('85017000017','85017011008',1);
insert into module_parts values ('85017000017','85017011009',1);
insert into module_parts values ('85017000017','85017011010',1);

insert into part values ('bb2ce9d2-6950-45bf-a569-3c4814ea5279','85017011001','左纵梁','850','2003','2003-17011001A',null,'Q235',15,round(78.02354172510057,1),'车架总成');
insert into part values ('35af9531-2a68-4b78-ac45-cec3038eff00','85017011002','右纵梁','850','2003','2003-17011002A',null,'Q235',15,round(6.41839152139656,1),'车架总成');
insert into part values ('4d53a819-aaa0-4518-8771-899c127fcc06','85017011003','一横梁','850','2003','2003-17011003A',null,'Q235',15,round(5.1553490231611265,1),'车架总成');
insert into part values ('4ee14b31-8e68-4a68-878e-e5c63144915f','85017011004','二横梁','850','2003','2003-17011004A',null,'Q235',15,round(45.01433228431596,1),'车架总成');
insert into part values ('17744f5d-7424-4504-ab1d-e12c1aae1da8','85017011005','三横梁','850','2003','2003-17011005A',null,'Q235',15,round(3.496407196802931,1),'车架总成');
insert into part values ('4f6b042a-d8db-486a-8d18-0342f4a93cd9','85017011006','四横梁','850','2003','2003-17011006A',null,'Q235',15,round(63.057465651035,1),'车架总成');
insert into part values ('d7521075-2d9a-475d-acd3-310550baa54b','85017011007','五横梁','850','2003','2003-17011007A',null,'Q235',15,round(28.31483726883992,1),'车架总成');
insert into part values ('7cc29338-1761-4162-9823-3b29d311b72b','85017011008','加强梁','850','2003','2003-17011008A',null,'Q235',15,round(93.92003661108478,1),'车架总成');
insert into part values ('0ce75f9d-0092-4a86-9227-18af0655c5f1','85017011009','发动机支架','850','2003','2003-17011009A',null,'Q235',15,round(36.09655201418148,1),'车架总成');
insert into part values ('a8066720-81da-45b0-8ba2-8d799eccf33c','85017011010','变速箱支架','850','2003','2003-17011010A',null,'Q235',15,round(77.32353007224017,1),'车架总成');

-- 驾驶室总成
insert into module_parts values ('85018000017','85018011001',1);
insert into module_parts values ('85018000017','85018011002',1);
insert into module_parts values ('85018000017','85018011003',1);
insert into module_parts values ('85018000017','85018011004',1);
insert into module_parts values ('85018000017','85018011005',1);
insert into module_parts values ('85018000017','85018011006',1);
insert into module_parts values ('85018000017','85018011007',1);
insert into module_parts values ('85018000017','85018011008',1);
insert into module_parts values ('85018000017','85018011009',1);
insert into module_parts values ('85018000017','85018011010',1);

insert into part values ('39811199-bab0-422a-ab3a-68a7e6eeb90e','85018011001','驾驶室框架','850','2004','2004-18011001A',null,'Q235',15,round(69.93857352610449,1),'宽体驾驶室');
insert into part values ('16919269-3163-4f74-85ce-f382caafebfc','85018011002','右翼板','850','2004','2004-18011002A',null,'Q235',15,round(10.447597980199742,1),'宽体驾驶室');
insert into part values ('cd4f6347-e59a-4e33-8b7f-fcfa9396d4c9','85018011003','后视镜','850','2004','2004-18011003A',null,'Q235',15,round(47.482489138466256,1),'宽体驾驶室');
insert into part values ('3fe6904e-bf0f-4a7a-890a-7863317f7ff8','85018011004','方向盘','850','2004','2004-18011004A',null,'Q235',15,round(65.39465216642513,1),'宽体驾驶室');
insert into part values ('85835244-7334-4e22-b737-0b6587e5a928','85018011005','电动座椅','850','2004','2004-18011005A',null,'Q235',15,round(58.53843552380542,1),'宽体驾驶室');
insert into part values ('a28da93a-9cae-4be2-96bb-10a0adb11492','85018011006','驾驶室空调','850','2004','2004-18011006A',null,'Q235',15,round(78.79349976988162,1),'宽体驾驶室');
insert into part values ('7f3ed8f4-7377-4efe-a70f-f68bf035a80e','85018011007','烟灰缸','850','2004','2004-18011007A',null,'Q235',15,round(35.13663088388784,1),'宽体驾驶室');
insert into part values ('51adfdac-af0a-45c6-b278-eab62b14e9db','85018011008','内饰板','850','2004','2004-18011008A',null,'Q235',15,round(57.67875219915426,1),'宽体驾驶室');
insert into part values ('e5a9e54a-55e9-4e4d-a54f-5b9b5a211780','85018011009','隔热层','850','2004','2004-18011009A',null,'Q235',15,round(68.41527918298243,1),'宽体驾驶室');
insert into part values ('4836d055-5645-482c-87ab-d4b7181aec24','85018011010','前仓门','850','2004','2004-18011010A',null,'Q235',15,round(51.207655469388946,1),'宽体驾驶室');

-- 制动系统
insert into module_parts values ('85019000017','85019011001',1);
insert into module_parts values ('85019000017','85019011002',1);
insert into module_parts values ('85019000017','85019011003',1);
insert into module_parts values ('85019000017','85019011004',1);
insert into module_parts values ('85019000017','85019011005',1);
insert into module_parts values ('85019000017','85019011006',1);
insert into module_parts values ('85019000017','85019011007',1);
insert into module_parts values ('85019000017','85019011008',1);
insert into module_parts values ('85019000017','85019011009',1);
insert into module_parts values ('85019000017','85019011010',1);

insert into part values ('403bd1a1-bed5-45f1-82f9-c3592df2ce66','85019011001','单向阀','850','2005','2005-19011001A',null,'Q235',15,round(4.061537047793784,1),'制动系统');
insert into part values ('f6f97784-b1f2-43cd-bcd8-4925c0fe81e4','85019011002','压缩罐','850','2005','2005-19011002A',null,'Q235',15,round(63.10436961301738,1),'制动系统');
insert into part values ('e3783296-4ea4-4c66-a63a-8144322f4572','85019011003','干燥罐','850','2005','2005-19011003A',null,'Q235',15,round(48.32923683805603,1),'制动系统');
insert into part values ('2a5a5cf3-9dfe-40a7-8dea-c4a9ad829752','85019011004','进气管','850','2005','2005-19011004A',null,'Q235',15,round(98.09833326156074,1),'制动系统');
insert into part values ('7a49eb2d-a708-4983-90ca-d90102747145','85019011005','出气管','850','2005','2005-19011005A',null,'Q235',15,round(90.13927088448148,1),'制动系统');
insert into part values ('b550a2f8-d53c-4911-beea-4e767d26751f','85019011006','三通','850','2005','2005-19011006A',null,'Q235',15,round(65.50497571017729,1),'制动系统');
insert into part values ('4ed26c55-23ca-4138-85ba-b5a1fdc89bc4','85019011007','气压传感器','850','2005','2005-19011007A',null,'Q235',15,round(79.41396967150506,1),'制动系统');
insert into part values ('c5220ad1-c45f-45a6-a91d-9a7b2154db7f','85019011008','排水阀','850','2005','2005-19011008A',null,'Q235',15,round(93.25337090484226,1),'制动系统');
insert into part values ('85096294-48dd-4f43-8109-efba9f724335','85019011009','制动气室','850','2005','2005-19011009A',null,'Q235',15,round(68.40635674333878,1),'制动系统');
insert into part values ('87b7bdd8-cd46-4b81-86b1-312b3808ab89','85019011010','支架','850','2005','2005-19011010A',null,'Q235',15,round(20.178461543981165,1),'制动系统');

-- 电气系统
insert into module_parts values ('85036000017','85036011001',1);
insert into module_parts values ('85036000017','85036011002',1);
insert into module_parts values ('85036000017','85036011003',1);
insert into module_parts values ('85036000017','85036011004',1);
insert into module_parts values ('85036000017','85036011005',1);
insert into module_parts values ('85036000017','85036011006',1);
insert into module_parts values ('85036000017','85036011007',1);
insert into module_parts values ('85036000017','85036011008',1);
insert into module_parts values ('85036000017','85036011009',1);
insert into module_parts values ('85036000017','85036011010',1);

insert into part values ('6832b5c8-fddd-47ad-939f-949c7967b9b2','85036011001','仪表盘','850','2001','2001-36011001A',null,'Q235',15,round(99.97218689955672,1),'电气系统');
insert into part values ('2b9a771a-d680-47dd-8bb7-b4ddd27a1ca8','85036011002','左大灯','850','2001','2001-36011002A',null,'Q235',15,round(37.65971427154332,1),'电气系统');
insert into part values ('ea12b8d0-66a3-402d-9452-c0051a79e65b','85036011003','右大灯','850','2001','2001-36011003A',null,'Q235',15,round(25.9227488564699,1),'电气系统');
insert into part values ('216ff1ee-5710-4357-8feb-16c64ea75f82','85036011004','雾灯','850','2001','2001-36011004A',null,'Q235',15,round(93.41051164965654,1),'电气系统');
insert into part values ('dc99bd68-7247-4dce-be5d-be6014f3032f','85036011005','左尾灯','850','2001','2001-36011005A',null,'Q235',15,round(29.02806158662059,1),'电气系统');
insert into part values ('9efb6f01-6140-4ee4-b7e6-6766041fa6ff','85036011006','右尾灯','850','2001','2001-36011006A',null,'Q235',15,round(70.42293291721656,1),'电气系统');
insert into part values ('cb8c26f1-a033-4688-bfab-85ea9ed8cbc3','85036011007','收音机','850','2001','2001-36011007A',null,'Q235',15,round(55.96389544585345,1),'电气系统');
insert into part values ('3cbf5c17-0d33-4604-93f1-2a92f9d8070a','85036011008','倒车喇叭','850','2001','2001-36011008A',null,'Q235',15,round(28.082603202185762,1),'电气系统');
insert into part values ('be5c14bb-f56c-454b-8001-cc92e06dc93e','85036011009','气喇叭','850','2001','2001-36011009A',null,'Q235',15,round(5.375408024053929,1),'电气系统');
insert into part values ('27b9ad31-6ba9-4da5-9faf-52ea0245d254','85036011010','翘板开关','850','2001','2001-36011010A',null,'Q235',15,round(75.93274174170413,1),'电气系统');

-- 前桥总成
insert into module_parts values ('85037000017','85037011001',1);
insert into module_parts values ('85037000017','85037011002',1);
insert into module_parts values ('85037000017','85037011003',1);
insert into module_parts values ('85037000017','85037011004',1);
insert into module_parts values ('85037000017','85037011005',1);
insert into module_parts values ('85037000017','85037011006',1);
insert into module_parts values ('85037000017','85037011007',1);
insert into module_parts values ('85037000017','85037011008',1);
insert into module_parts values ('85037000017','85037011009',1);
insert into module_parts values ('85037000017','85037011010',1);

insert into part values ('ee4a77d5-3b15-484e-8cec-faf709b28b1f','85037011001','左前轮','850','2002','2002-37011001A',null,'Q235',15,round(47.94082282693339,1),'前桥总成');
insert into part values ('36803eaa-3dc1-48a0-b334-0264086fd7d1','85037011002','右前轮','850','2002','2002-37011002A',null,'Q235',15,round(24.44236268624679,1),'前桥总成');
insert into part values ('5b102293-8cfd-4bd4-9a90-aa19f00ec5c0','85037011003','左刹车','850','2002','2002-37011003A',null,'Q235',15,round(34.348824648866106,1),'前桥总成');
insert into part values ('db0aa7cd-6f75-4bd2-bdab-60b92850d6ea','85037011004','右刹车','850','2002','2002-37011004A',null,'Q235',15,round(72.69025539970954,1),'前桥总成');
insert into part values ('75827edf-d515-4976-8307-8326a479b732','85037011005','左转向','850','2002','2002-37011005A',null,'Q235',15,round(5.753918684758275,1),'前桥总成');
insert into part values ('d4f55093-3830-48bf-af4d-f87bcb0b92b5','85037011006','右转向','850','2002','2002-37011006A',null,'Q235',15,round(96.69610081895965,1),'前桥总成');
insert into part values ('a199e07c-7dd1-473a-8430-649843311aee','85037011007','转向轴','850','2002','2002-37011007A',null,'Q235',15,round(0.6582289629712079,1),'前桥总成');
insert into part values ('4cab159e-bd7a-4dc4-a3c0-7d42febd1028','85037011008','前桥本体','850','2002','2002-37011008A',null,'Q235',15,round(61.10711068009882,1),'前桥总成');
insert into part values ('dfe0f2ea-ddbf-4946-817e-c65eed4c8370','85037011009','制动臂','850','2002','2002-37011009A',null,'Q235',15,round(26.211894810692904,1),'前桥总成');
insert into part values ('9ce3c8d0-3053-44e1-8ec0-a5d24d1dce79','85037011010','制动毂','850','2002','2002-37011010A',null,'Q235',15,round(3.2903152142457537,1),'前桥总成');

-- 中桥总成
insert into module_parts values ('85038000017','85038011001',1);
insert into module_parts values ('85038000017','85038011002',1);
insert into module_parts values ('85038000017','85038011003',1);
insert into module_parts values ('85038000017','85038011004',1);
insert into module_parts values ('85038000017','85038011005',1);
insert into module_parts values ('85038000017','85038011006',1);
insert into module_parts values ('85038000017','85038011007',1);
insert into module_parts values ('85038000017','85038011008',1);
insert into module_parts values ('85038000017','85038011009',1);
insert into module_parts values ('85038000017','85038011010',1);

insert into part values ('36894c0d-e849-4ef3-b8e2-7a1febb95c29','85038011001','左中轮','850','2003','2003-38011001A',null,'Q235',15,round(62.3655388708797,1),'中桥总成');
insert into part values ('a48638a1-e919-4f5e-9943-6446a21c8251','85038011002','右中轮','850','2003','2003-38011002A',null,'Q235',15,round(15.106183965331866,1),'中桥总成');
insert into part values ('14e127e5-7b9f-454e-a933-b94c7aba6a71','85038011003','左推力杆','850','2003','2003-38011003A',null,'Q235',15,round(8.698175355944059,1),'中桥总成');
insert into part values ('b1a4c62c-b39e-4552-8fbe-a1984efc40e1','85038011004','右推力杆','850','2003','2003-38011004A',null,'Q235',15,round(51.581049457403296,1),'中桥总成');
insert into part values ('fa7bd757-490b-43c7-afd7-13162878e3ee','85038011005','左制动毂','850','2003','2003-38011005A',null,'Q235',15,round(88.44550797923385,1),'中桥总成');
insert into part values ('eceab115-8c35-447c-a1cd-43b9c6a493cd','85038011006','右制动毂','850','2003','2003-38011006A',null,'Q235',15,round(25.49814831538103,1),'中桥总成');
insert into part values ('e05d9b02-2529-44d8-9c4e-110d96faccb5','85038011007','左刹车片','850','2003','2003-38011007A',null,'Q235',15,round(47.44273923673177,1),'中桥总成');
insert into part values ('ef802112-302d-42a1-9a6b-1cb0f0635bca','85038011008','右刹车片','850','2003','2003-38011008A',null,'Q235',15,round(46.04694821830966,1),'中桥总成');
insert into part values ('8c91bfc7-100e-4aaa-9e69-125b1a72c16d','85038011009','左支架','850','2003','2003-38011009A',null,'Q235',15,round(40.36101841450937,1),'中桥总成');
insert into part values ('e9e9ffa7-5412-4233-ba36-65652e76a38d','85038011010','右支架','850','2003','2003-38011010A',null,'Q235',15,round(41.87764561106169,1),'中桥总成');

-- 后桥总成
insert into module_parts values ('85039000017','85039011001',1);
insert into module_parts values ('85039000017','85039011002',1);
insert into module_parts values ('85039000017','85039011003',1);
insert into module_parts values ('85039000017','85039011004',1);
insert into module_parts values ('85039000017','85039011005',1);
insert into module_parts values ('85039000017','85039011006',1);
insert into module_parts values ('85039000017','85039011007',1);
insert into module_parts values ('85039000017','85039011008',1);
insert into module_parts values ('85039000017','85039011009',1);
insert into module_parts values ('85039000017','85039011010',1);

insert into part values ('59117480-b6f4-430c-9181-8eb8493994c3','85039011001','左后轮','850','2004','2004-39011001A',null,'Q235',15,round(78.55823428408723,1),'后桥总成');
insert into part values ('58c3bc34-891a-4321-b372-07b833cc2e78','85039011002','右后轮','850','2004','2004-39011002A',null,'Q235',15,round(83.28396220575051,1),'后桥总成');
insert into part values ('7da3c722-353a-4fcf-9c86-3e34f86a5002','85039011003','左拉力杆','850','2004','2004-39011003A',null,'Q235',15,round(26.696396129490175,1),'后桥总成');
insert into part values ('2abf50ed-00d0-4adc-92ce-6e7dc59eadbe','85039011004','右拉力杆','850','2004','2004-39011004A',null,'Q235',15,round(14.177362247440051,1),'后桥总成');
insert into part values ('d435747a-0279-4688-ae7a-7ae4b80c96a7','85039011005','左制动毂','850','2004','2004-39011005A',null,'Q235',15,round(15.42495669745778,1),'后桥总成');
insert into part values ('2f47db55-d30a-4419-bd00-3a8d523d122b','85039011006','右制动毂','850','2004','2004-39011006A',null,'Q235',15,round(96.72664358110211,1),'后桥总成');
insert into part values ('b4e87253-5f9b-4066-824e-720ed279c5ba','85039011007','左刹车片','850','2004','2004-39011007A',null,'Q235',15,round(79.13063436208941,1),'后桥总成');
insert into part values ('ed484874-1a65-4aaf-9d6c-94a5aa6f20cc','85039011008','右刹车片','850','2004','2004-39011008A',null,'Q235',15,round(5.037871065050958,1),'后桥总成');
insert into part values ('3d423c76-7803-407c-a371-1d3e900d6952','85039011009','左支架','850','2004','2004-39011009A',null,'Q235',15,round(8.060073197174965,1),'后桥总成');
insert into part values ('6ea0ff53-6e9f-42e0-a0ef-481a920370e9','85039011010','右支架','850','2004','2004-39011010A',null,'Q235',15,round(19.372976448222012,1),'后桥总成');

-- 货箱总成
insert into module_parts values ('85040000017','85040011001',1);
insert into module_parts values ('85040000017','85040011002',1);
insert into module_parts values ('85040000017','85040011003',1);
insert into module_parts values ('85040000017','85040011004',1);
insert into module_parts values ('85040000017','85040011005',1);
insert into module_parts values ('85040000017','85040011006',1);
insert into module_parts values ('85040000017','85040011007',1);
insert into module_parts values ('85040000017','85040011008',1);
insert into module_parts values ('85040000017','85040011009',1);
insert into module_parts values ('85040000017','85040011010',1);

insert into part values ('fa919416-345c-425e-9879-ba9122c12239','85040011001','帽檐','850','2005','2005-40011001A',null,'Q235',15,round(7.895637399777655,1),'货箱总成');
insert into part values ('120c3c12-8484-4787-9237-977e8dcbe04f','85040011002','前板','850','2005','2005-40011002A',null,'Q235',15,round(29.79559896425351,1),'货箱总成');
insert into part values ('32569011-05d6-42bc-9ee5-7cfe7a01b96f','85040011003','左侧板','850','2005','2005-40011003A',null,'Q235',15,round(4.782240075231526,1),'货箱总成');
insert into part values ('fa99abc1-d39c-4710-bd19-8b1185b881da','85040011004','右侧板','850','2005','2005-40011004A',null,'Q235',15,round(63.74679762489988,1),'货箱总成');
insert into part values ('fdd1256e-f380-4079-a5d8-951acaa439d5','85040011005','底板','850','2005','2005-40011005A',null,'Q235',15,round(95.352933235197,1),'货箱总成');
insert into part values ('c315574c-cfb5-4a73-80f7-f6b789389bf2','85040011006','加热风道','850','2005','2005-40011006A',null,'Q235',15,round(82.16079433360736,1),'货箱总成');
insert into part values ('7b50e30f-04eb-48d5-a07e-6a2e9144a504','85040011007','货箱门','850','2005','2005-40011007A',null,'Q235',15,round(77.78355950799472,1),'货箱总成');
insert into part values ('f4be69a6-6f39-40d6-96d6-f10a5722f0ba','85040011008','锁门扣','850','2005','2005-40011008A',null,'Q235',15,round(14.913808878452606,1),'货箱总成');
insert into part values ('d18f1274-5392-4d6f-8000-1e4d8d61a46f','85040011009','转轴','850','2005','2005-40011009A',null,'Q235',15,round(77.43554294734663,1),'货箱总成');
insert into part values ('578b3fe1-b42e-4bab-86e9-ab2eb48fa3b1','85040011010','副车架','850','2005','2005-40011010A',null,'Q235',15,round(20.551977032589164,1),'货箱总成');

