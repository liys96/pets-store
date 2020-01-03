prompt PL/SQL Developer Export Tables for user SCOTT@ORCL
prompt Created by Administrator on 2019年5月7日
set feedback off
set define off

prompt Creating T_APPRAISE...
create table T_APPRAISE
(
  appraise_id      NUMBER(5) not null,
  appraise_content VARCHAR2(500),
  appraise_date    DATE,
  customer_id      NUMBER(5),
  commodity_id     NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_APPRAISE
  add primary key (APPRAISE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_COMMODITY...
create table T_COMMODITY
(
  commodity_id          NUMBER(5) not null,
  commodity_title       VARCHAR2(200),
  commodity_headpic     VARCHAR2(500),
  commodity_price       NUMBER(10),
  commodity_quantity    VARCHAR2(50),
  commodity_description VARCHAR2(200),
  commodity_createdate  DATE,
  commodity_state       NUMBER(5),
  composition_id        NUMBER(5),
  commodity_unit        VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_COMMODITY
  add primary key (COMMODITY_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_COMPOSITION...
create table T_COMPOSITION
(
  composition_id   NUMBER(5) not null,
  composition_name VARCHAR2(50),
  marque_id        NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_COMPOSITION
  add primary key (COMPOSITION_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_CUSTOMER...
create table T_CUSTOMER
(
  customer_id              NUMBER(5) not null,
  customer_name            VARCHAR2(30),
  customer_sex             VARCHAR2(5),
  customer_phonenumber     VARCHAR2(50),
  customer_account         VARCHAR2(50),
  customer_loginpassword   VARCHAR2(50),
  customer_paypassword     VARCHAR2(50),
  customer_receivedaddress VARCHAR2(100),
  customer_createdate      DATE,
  customer_state           NUMBER(5),
  customer_headpic         NVARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_CUSTOMER
  add primary key (CUSTOMER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_INVENTORY...
create table T_INVENTORY
(
  inventory_id     NUMBER(5) not null,
  inventory_amount NUMBER(10),
  commodity_id     NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_INVENTORY
  add primary key (INVENTORY_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_MARQUE...
create table T_MARQUE
(
  marque_id   NUMBER(5) not null,
  marque_name VARCHAR2(50),
  types_id    NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_MARQUE
  add primary key (MARQUE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_ORDER...
create table T_ORDER
(
  order_id           NUMBER(5) not null,
  order_serialnumber VARCHAR2(50),
  order_totalmoney   NUMBER(10),
  order_date         DATE,
  order_state        NUMBER(5),
  customer_id        NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_ORDER
  add primary key (ORDER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_ORDERCOMMODITY...
create table T_ORDERCOMMODITY
(
  order_id         NUMBER(5),
  commodity_id     NUMBER(5),
  commodity_amount NUMBER(5),
  commodity_money  NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_SHOPCART...
create table T_SHOPCART
(
  shopcart_id      NUMBER(5) not null,
  commodity_id     NUMBER(5),
  commodity_amount NUMBER(5),
  commodity_money  NUMBER(10),
  customer_id      NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_SHOPCART
  add primary key (SHOPCART_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_TYPES...
create table T_TYPES
(
  types_id   NUMBER(5) not null,
  types_name VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_TYPES
  add primary key (TYPES_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating T_USER...
create table T_USER
(
  user_id          NUMBER(5) not null,
  user_name        VARCHAR2(50),
  user_account     VARCHAR2(50),
  user_password    VARCHAR2(50),
  user_createdate  DATE,
  user_state       NUMBER(5),
  user_deletestate NUMBER(5)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table T_USER
  add primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for T_APPRAISE...
alter table T_APPRAISE disable all triggers;
prompt Disabling triggers for T_COMMODITY...
alter table T_COMMODITY disable all triggers;
prompt Disabling triggers for T_COMPOSITION...
alter table T_COMPOSITION disable all triggers;
prompt Disabling triggers for T_CUSTOMER...
alter table T_CUSTOMER disable all triggers;
prompt Disabling triggers for T_INVENTORY...
alter table T_INVENTORY disable all triggers;
prompt Disabling triggers for T_MARQUE...
alter table T_MARQUE disable all triggers;
prompt Disabling triggers for T_ORDER...
alter table T_ORDER disable all triggers;
prompt Disabling triggers for T_ORDERCOMMODITY...
alter table T_ORDERCOMMODITY disable all triggers;
prompt Disabling triggers for T_SHOPCART...
alter table T_SHOPCART disable all triggers;
prompt Disabling triggers for T_TYPES...
alter table T_TYPES disable all triggers;
prompt Disabling triggers for T_USER...
alter table T_USER disable all triggers;
prompt Deleting T_USER...
delete from T_USER;
commit;
prompt Deleting T_TYPES...
delete from T_TYPES;
commit;
prompt Deleting T_SHOPCART...
delete from T_SHOPCART;
commit;
prompt Deleting T_ORDERCOMMODITY...
delete from T_ORDERCOMMODITY;
commit;
prompt Deleting T_ORDER...
delete from T_ORDER;
commit;
prompt Deleting T_MARQUE...
delete from T_MARQUE;
commit;
prompt Deleting T_INVENTORY...
delete from T_INVENTORY;
commit;
prompt Deleting T_CUSTOMER...
delete from T_CUSTOMER;
commit;
prompt Deleting T_COMPOSITION...
delete from T_COMPOSITION;
commit;
prompt Deleting T_COMMODITY...
delete from T_COMMODITY;
commit;
prompt Deleting T_APPRAISE...
delete from T_APPRAISE;
commit;
prompt Loading T_APPRAISE...
insert into T_APPRAISE (appraise_id, appraise_content, appraise_date, customer_id, commodity_id)
values (61, '商品很好哦', to_date('15-04-2019 17:00:52', 'dd-mm-yyyy hh24:mi:ss'), 17, 62);
commit;
prompt 1 records loaded
prompt Loading T_COMMODITY...
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (85, '木质玩具小狗狗', '1f2d98ad-8735-4f85-9b7a-eb5d5d75b756.jpg', 233, '4', '狗狗玩具木质', to_date('19-04-2019 12:16:58', 'dd-mm-yyyy hh24:mi:ss'), 1, 128, '个');
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (86, '狗狗零食牛肉', '058a7e7f-b2f3-4c87-b35d-d2c97ff052f1.jpg', 122, '8', '狗狗零食牛肉', to_date('19-04-2019 12:17:39', 'dd-mm-yyyy hh24:mi:ss'), 1, 117, '袋');
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (84, '猫咪零食主食罐头鸡肉', 'e00d1824-3e06-4f3f-9ab0-c45bb6f74264.jpg', 233, '12', '主食罐头鸡肉', to_date('19-04-2019 12:13:52', 'dd-mm-yyyy hh24:mi:ss'), 1, 119, '袋');
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (81, '狗狗主粮鸡肉测试', '6ef26ba2-50c8-4a25-92ae-d3b23fd0f68d.jpg', 120, '12', '营养健康', to_date('19-04-2019 12:11:54', 'dd-mm-yyyy hh24:mi:ss'), 1, 102, '袋');
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (82, '猫咪主粮幼猫卡比', '5014a1b0-8ab9-40fe-8332-9f175bb68441.jpg', 144, '13', '猫咪主粮幼猫卡比', to_date('19-04-2019 12:12:48', 'dd-mm-yyyy hh24:mi:ss'), 1, 108, '袋');
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (88, '测试1', '232999a5-e1e0-4cf3-89f0-2185780606e9.jpg', 222, '12', '多少', to_date('19-04-2019 12:22:46', 'dd-mm-yyyy hh24:mi:ss'), 1, 117, '袋');
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (83, '牛肉狗狗零食', '4074929b-5852-400d-b93f-7dc157489599.jpg', 355, '23', '牛肉狗狗零食', to_date('19-04-2019 12:13:15', 'dd-mm-yyyy hh24:mi:ss'), 1, 117, '袋');
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (87, '测试', 'e5c67579-92ad-495e-b5cd-cd5b3e3e9c54.jpg', 111, '12', '测试', to_date('19-04-2019 12:22:21', 'dd-mm-yyyy hh24:mi:ss'), 1, 102, '袋');
insert into T_COMMODITY (commodity_id, commodity_title, commodity_headpic, commodity_price, commodity_quantity, commodity_description, commodity_createdate, commodity_state, composition_id, commodity_unit)
values (89, '测试', '9e8ba682-1e81-45cd-bffa-7f7f16b2f40a.jpg', 112, '12', '大幅度', to_date('19-04-2019 12:23:05', 'dd-mm-yyyy hh24:mi:ss'), 1, 123, '袋');
commit;
prompt 9 records loaded
prompt Loading T_COMPOSITION...
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (102, '鸡肉', 3);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (103, '羊肉', 3);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (104, '鱼肉', 3);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (105, '火鸡肉', 4);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (106, '羊肉', 4);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (107, '鱼肉', 4);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (108, '卡比', 5);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (109, '美士', 5);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (110, 'Wellness', 5);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (111, '天衡宝', 6);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (112, '牛油果', 6);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (113, '罐头', 7);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (114, '餐盒', 7);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (115, '妙鲜包', 7);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (116, '鸡肉', 8);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (117, '牛肉', 8);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (118, '鸭肉', 8);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (119, '鸡肉', 9);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (120, '牛肉', 9);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (121, '鱼肉', 9);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (122, '鸡肉', 10);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (123, '牛肉', 10);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (124, '鱼肉', 10);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (125, '憨八龟', 11);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (126, '美丽花朵', 11);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (127, '甜心萝卜', 11);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (128, '美国进口', 12);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (129, '迷宫', 12);
insert into T_COMPOSITION (composition_id, composition_name, marque_id)
values (130, '战斗机', 12);
commit;
prompt 29 records loaded
prompt Loading T_CUSTOMER...
insert into T_CUSTOMER (customer_id, customer_name, customer_sex, customer_phonenumber, customer_account, customer_loginpassword, customer_paypassword, customer_receivedaddress, customer_createdate, customer_state, customer_headpic)
values (17, '张三', '男', '15350067456', 'zhangsan', '1234', '1234', '江西省南昌市青山湖区江西科技学院', to_date('07-12-2018 14:06:48', 'dd-mm-yyyy hh24:mi:ss'), 1, '17e2c9da-96d4-45ec-9ad8-84007032cfa7.jpg');
commit;
prompt 1 records loaded
prompt Loading T_INVENTORY...
insert into T_INVENTORY (inventory_id, inventory_amount, commodity_id)
values (62, 200, 85);
insert into T_INVENTORY (inventory_id, inventory_amount, commodity_id)
values (63, 100, 86);
insert into T_INVENTORY (inventory_id, inventory_amount, commodity_id)
values (64, 300, 84);
insert into T_INVENTORY (inventory_id, inventory_amount, commodity_id)
values (70, 100, 89);
insert into T_INVENTORY (inventory_id, inventory_amount, commodity_id)
values (68, 500, 88);
insert into T_INVENTORY (inventory_id, inventory_amount, commodity_id)
values (69, 300, 87);
insert into T_INVENTORY (inventory_id, inventory_amount, commodity_id)
values (65, 500, 81);
insert into T_INVENTORY (inventory_id, inventory_amount, commodity_id)
values (66, 500, 82);
commit;
prompt 8 records loaded
prompt Loading T_MARQUE...
insert into T_MARQUE (marque_id, marque_name, types_id)
values (3, '幼犬粮', 2);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (4, '成犬粮', 2);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (5, '幼猫粮', 3);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (6, '成猫粮', 3);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (7, '罐头湿粮', 4);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (8, '肉制零食', 4);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (9, '主食罐', 5);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (10, '零食罐', 5);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (11, '食用玩具', 6);
insert into T_MARQUE (marque_id, marque_name, types_id)
values (12, '木质玩具', 6);
commit;
prompt 10 records loaded
prompt Loading T_ORDER...
insert into T_ORDER (order_id, order_serialnumber, order_totalmoney, order_date, order_state, customer_id)
values (141, 'OD201904190001', 139567, to_date('19-04-2019 14:46:35', 'dd-mm-yyyy hh24:mi:ss'), 0, 17);
commit;
prompt 1 records loaded
prompt Loading T_ORDERCOMMODITY...
insert into T_ORDERCOMMODITY (order_id, commodity_id, commodity_amount, commodity_money)
values (103, 63, 30, 3660);
insert into T_ORDERCOMMODITY (order_id, commodity_id, commodity_amount, commodity_money)
values (121, 63, 1, 122);
insert into T_ORDERCOMMODITY (order_id, commodity_id, commodity_amount, commodity_money)
values (141, 85, 99, 23067);
insert into T_ORDERCOMMODITY (order_id, commodity_id, commodity_amount, commodity_money)
values (141, 85, 200, 46600);
insert into T_ORDERCOMMODITY (order_id, commodity_id, commodity_amount, commodity_money)
values (101, 62, 50, 6150);
insert into T_ORDERCOMMODITY (order_id, commodity_id, commodity_amount, commodity_money)
values (102, 62, 1, 123);
insert into T_ORDERCOMMODITY (order_id, commodity_id, commodity_amount, commodity_money)
values (141, 84, 300, 69900);
commit;
prompt 7 records loaded
prompt Loading T_SHOPCART...
prompt Table is empty
prompt Loading T_TYPES...
insert into T_TYPES (types_id, types_name)
values (2, '狗狗主粮');
insert into T_TYPES (types_id, types_name)
values (3, '猫咪主粮');
insert into T_TYPES (types_id, types_name)
values (4, '狗狗零食');
insert into T_TYPES (types_id, types_name)
values (5, '猫咪零食');
insert into T_TYPES (types_id, types_name)
values (6, '宠物玩具');
commit;
prompt 5 records loaded
prompt Loading T_USER...
insert into T_USER (user_id, user_name, user_account, user_password, user_createdate, user_state, user_deletestate)
values (45, '李易峰', 'liyifeng', '1234', to_date('22-03-2019 11:26:17', 'dd-mm-yyyy hh24:mi:ss'), 1, 1);
insert into T_USER (user_id, user_name, user_account, user_password, user_createdate, user_state, user_deletestate)
values (61, '李义盛', 'lys', '1234', to_date('22-03-2019 10:35:33', 'dd-mm-yyyy hh24:mi:ss'), 1, 1);
commit;
prompt 2 records loaded
prompt Enabling triggers for T_APPRAISE...
alter table T_APPRAISE enable all triggers;
prompt Enabling triggers for T_COMMODITY...
alter table T_COMMODITY enable all triggers;
prompt Enabling triggers for T_COMPOSITION...
alter table T_COMPOSITION enable all triggers;
prompt Enabling triggers for T_CUSTOMER...
alter table T_CUSTOMER enable all triggers;
prompt Enabling triggers for T_INVENTORY...
alter table T_INVENTORY enable all triggers;
prompt Enabling triggers for T_MARQUE...
alter table T_MARQUE enable all triggers;
prompt Enabling triggers for T_ORDER...
alter table T_ORDER enable all triggers;
prompt Enabling triggers for T_ORDERCOMMODITY...
alter table T_ORDERCOMMODITY enable all triggers;
prompt Enabling triggers for T_SHOPCART...
alter table T_SHOPCART enable all triggers;
prompt Enabling triggers for T_TYPES...
alter table T_TYPES enable all triggers;
prompt Enabling triggers for T_USER...
alter table T_USER enable all triggers;

set feedback on
set define on
prompt Done
