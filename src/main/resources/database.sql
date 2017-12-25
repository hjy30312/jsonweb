DROP TABLE tb_user
CREATE TABLE tb_user(
  id INT  PRIMARY KEY ,
  username VARCHAR(20) ,
  password VARCHAR(20)
);

CREATE TABLE tb_commodity(
    id INT PRIMARY KEY,
    name VARCHAR2(20) ,
    type VARCHAR2(20) ,
    weight NUMBER (4,2),
    value NUMBER(4,2)
);

CREATE TABLE tb_ShoppingCart(
    id INT PRIMARY KEY ,
    user_id INT ,
    commodity_id INT ,
    value NUMBER (4,2),
);

/** 订单表：
 id 订单编号
 user 客户
 time 时间
 value 价格
小数类型为 decimal ，禁止使用 float 和 double 。
说明： float 和 double 在存储的时候，存在精度损失的问题，很可能在值的比较时，得到不
正确的结果。如果存储的数据范围超过 decimal 的范围，建议将数据拆成整数和小数分开存储。
 */
CREATE TABLE taobao_order(
  id PRIMARY KEY,
  user VARCHAR,
  time DATA,
  value DECIMAL
);
/** 订单明细表：
  order_id 订单编号
  product_id 产品编号
  value 单价
  count 数量
  all_value 总价格
 */
CREATE TABLE order_product(
  order_id,
  product_id,
  value DECIMAL,
  count ,
  all_value DECIMAL
);
/**产品表：
  id 产品编号
  name 名称
  manufacturer 生产厂家
  describe 说明
 */
CREATE TABLE taobao_product(
  id INT  PRIMARY KEY ,
  name VARCHAR NOT NULL ,
  manufacturer VARCHAR,
  describe VARCHAR
);
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
INSERT INTO tb_commodity(id,name,type,weight,value) VALUES ('1','书','文具','1','1');
INSERT INTO tb_commodity(id,name,type,weight,value) VALUES ('2','笔','文具','1','1');
INSERT INTO tb_ShoppingCart(id,user_id,commodity_id,value) VALUES ()