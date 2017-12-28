
/**
 * 用户表
 */
DROP TABLE tb_user;
DROP SEQUENCE user_id;
CREATE SEQUENCE user_id INCREMENT BY 1 START WITH 1;
CREATE TABLE tb_user(
  id INTEGER PRIMARY KEY , --用户id
  username VARCHAR(20) NOT NULL ,    --用户名称
  password VARCHAR(20) NOT NULL      --用户密码
);
INSERT INTO tb_user(id,username, password) VALUES (user_id.nextval,'123','456');

/**
 * 产品表
 */
DROP TABLE tb_commodity;
DROP SEQUENCE commodity_id;
CREATE SEQUENCE commodity_id INCREMENT BY 1 START WITH 1;
CREATE TABLE tb_commodity(
    id INT PRIMARY KEY,       --产品编号
    name VARCHAR2(20) NOT NULL,        --产品名称
    manufacturerId VARCHAR2(20), --生产厂家编号
    describe VARCHAR2(20),     --说明
    value NUMBER(4,2)         --价格
);
INSERT INTO tb_commodity(id,name,type,manufacturer,describe,value) VALUES (commodity_id.nextval,'书','文具','汽院','','1');
INSERT INTO tb_commodity(id,name,type,manufacturer,describe,value) VALUES (commodity_id.nextval,'笔','文具','汽院','','80');



/**
 * 购物车表
 */
DROP TABLE tb_ShoppingCart;
DROP SEQUENCE ShoppingCart_id;
CREATE SEQUENCE ShoppingCart_id INCREMENT BY 1 START WITH 1;
CREATE TABLE tb_ShoppingCart(
    id INT PRIMARY KEY ,  --购物车id
    user_id INT ,          --用户id
    commodity_id INT ,     --商品id
    count INT ,            --商品数量
    value NUMBER (4,2)     --价格
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES tb_user(id) ON DELETE CASCADE
);
INSERT INTO tb_ShoppingCart(id,user_id,commodity_id,value) VALUES (ShoppingCart_id.nextval,'','','')


/**
 * 订单表
 */
CREATE TABLE tb_order(
  id INT PRIMARY KEY,   --订单编号
  user_id VARCHAR,       --客户id
  time DATA,             --下单时间
  value NUMBER (4,2)     --订单价格
);
/**
 * 订单明细表
 */
CREATE TABLE tb_order_product(
  order_id INT ,     --订单编号
  product_id INT ,   --产品编号
  value NUMBER (4,2),   --单价
  count INT ,           --数量
  all_value NUMBER (4,2)  --总价格
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