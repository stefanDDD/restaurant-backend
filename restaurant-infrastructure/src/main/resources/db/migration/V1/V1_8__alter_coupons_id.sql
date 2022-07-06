DROP TABLE COUPONS;

CREATE TABLE COUPONS(
COUPON_ID VARCHAR(50) NOT NULL,
CUSTOMER_ID BIGINT,
DISCOUNT INT NOT NULL,
DISCOUNT_TYPE VARCHAR(10)  NOT NULL,
PRIMARY KEY (COUPON_ID),
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID));