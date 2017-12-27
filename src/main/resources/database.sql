DROP TABLE tb_user;
DROP SEQUENCE user_id;
CREATE SEQUENCE user_id INCREMENT BY 1 START WITH 1;
CREATE TABLE tb_user(
  id INTEGER PRIMARY KEY ,
  username VARCHAR(20) ,
  password VARCHAR(20)
);

INSERT INTO tb_user(id,username, password) VALUES (user_id.nextval,'123','456');

/**产品表：
  id 产品编号
  name 名称
  manufacturer 生产厂家
  describe 说明
  value 价格
 */
DROP TABLE tb_commodity;
DROP SEQUENCE commodity_id;
CREATE SEQUENCE commodity_id INCREMENT BY 1 START WITH 1;
CREATE TABLE tb_commodity(
    id INT PRIMARY KEY,
    name VARCHAR2(20) ,
    manufacturer VARCHAR2(20),
    describe VARCHAR2(20),
    value NUMBER(4,2)
);
INSERT INTO tb_commodity(id,name,type,manufacturer,describe,value) VALUES (commodity_id.nextval,'书','文具','汽院','','1');
INSERT INTO tb_commodity(id,name,type,manufacturer,describe,value) VALUES (commodity_id.nextval,'笔','文具','汽院','','80');

DROP TABLE tb_ShoppingCart;
DROP SEQUENCE ShoppingCart_id;
CREATE SEQUENCE ShoppingCart_id INCREMENT BY 1 START WITH 1;
CREATE TABLE tb_ShoppingCart(
    id INT PRIMARY KEY ,
    user_id INT ,
    commodity_id INT ,
    value NUMBER (4,2)
);
INSERT INTO tb_ShoppingCart(id,user_id,commodity_id,value) VALUES (ShoppingCart_id.nextval,'','','')


/** 订单表：
 id 订单编号
 user 客户
 time 时间
 value 价格
小数类型为 decimal ，禁止使用 float 和 double 。
说明： float 和 double 在存储的时候，存在精度损失的问题，很可能在值的比较时，得到不
正确的结果。如果存储的数据范围超过 decimal 的范围，建议将数据拆成整数和小数分开存储。
 */
CREATE TABLE tb_order(
  id INT PRIMARY KEY,
  user_id VARCHAR, --客户id
  time DATA,       --下单时间
  value NUMBER (4,2)   --价格
);
/** 订单明细表：
  order_id 订单编号
  product_id 产品编号
  value 单价
  count 数量
  all_value 总价格
 */
CREATE TABLE tb_order_product(
  order_id INT ,
  product_id INT ,
  value NUMBER (4,2),
  count INT ,
  all_value NUMBER (4,2)
);
/**产品表：
  id 产品编号
  name 名称
  manufacturer 生产厂家
  describe 说明
 */

/**价格表：
  id 产品编号
  value 价格
  effectiveTime      价格有效时间
  effectiveStratTime 有效开始时间
  effectiveEndTime   有效结束时间
 */
CREATE TABLE taobao_value(
  id INT PRIMARY KEY,
  value DECIMAL,
  effectiveTime TIME,
  effectiveStratTime TIME,
  effectiveEndTime TIME,
);

INSERT INTO tb_user(id,username, password) VALUES ('1','123','456');
insert into taobao_product (id, name, manufacturer, describe) values ('1','玩具','湖北','这是一个玩具');
INSERT INTO tb_commodity(id,name,type,manufacturer,describe,value) VALUES ('1','书','文具','汽院','','1');
INSERT INTO tb_commodity(id,name,type,manufacturer,describe,value) VALUES ('2','笔','文具','汽院','','1');
INSERT INTO tb_order(id, user_id, time, value) VALUES ('s_test.nextval','1','',1);
INSERT INTO tb_ShoppingCart(id,user_id,commodity_id,value) VALUES ()