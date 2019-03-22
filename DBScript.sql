DROP DATABASE Dominos;

CREATE DATABASE Dominos;
USE Dominos;

CREATE TABLE Login(
  LName VARCHAR(10) NOT NULL UNIQUE,
  LPassword VARCHAR(10),
  LType VARCHAR(5) NOT NULL,
  PRIMARY KEY(LName)
);
INSERT INTO Login VALUES
('Chamod','12345','other'),
('root','root','admin');

CREATE TABLE Customer(
  CID VARCHAR(4) NOT NULL UNIQUE,
  CName VARCHAR(50) NOT NULL,
  TPNo INT(10) NOT NULL,
  Address VARCHAR(100),
  PRIMARY KEY (CID),
  UNIQUE KEY (TPNo)
);

CREATE TABLE Orders(
  OrderID VARCHAR(4),
  OrderDate DATE NOT NULL,
  CID VARCHAR(5),
  Discount INT(2),
  OrderStatus VARCHAR(7),
  PRIMARY KEY (OrderID),
  CONSTRAINT FOREIGN KEY (CID) REFERENCES Customer(CID) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Orders VALUES
('001','2017-5-29','C0001','5','Paid'),
('002','2017-5-29','C0002','10','Paid'),
('003','2017-5-29','C0003','0','Paid'),
('004','2017-5-28','C0001','20','Paid');

CREATE TABLE Item(
  ICode VARCHAR(4),
  Description VARCHAR(50) NOT NULL,
  UnitPrice DECIMAL(8,2) NOT NULL,
  ItemType VARCHAR(10),
  ItemImage VARCHAR(1000),
  PRIMARY KEY(ICode)
);
INSERT INTO Item VALUES
('I001','CHOCO LAVA CAKE','240','Sides','lava Cake');


CREATE TABLE OrderDetails(
  OrderID VARCHAR(4),
  ICode VARCHAR(4) NOT NULL,
  QTY INT NOT NULL,
  CONSTRAINT  PRIMARY KEY(OrderID,ICode),
  CONSTRAINT FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (ICode) REFERENCES Item(Icode) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO OrderDetails VALUES('001','I001','7');
INSERT INTO OrderDetails VALUES('001','I004','2');
INSERT INTO OrderDetails VALUES('001','I001','1');
INSERT INTO OrderDetails VALUES('002','I002','10');
INSERT INTO OrderDetails VALUES('002','I005','10');
INSERT INTO OrderDetails VALUES('003','I001','1');
INSERT INTO OrderDetails VALUES('004','I007','20');
INSERT INTO OrderDetails VALUES('004','I008','2');
INSERT INTO OrderDetails VALUES('001','I003','1');
INSERT INTO OrderDetails VALUES('002','I003','3');
INSERT INTO OrderDetails VALUES('002','I006','4');

CREATE TABLE Payment(
  PID VARCHAR(4),
  OrderID VARCHAR(4) REFERENCES Orders(OrderID)
  ON UPDATE CASCADE ON DELETE CASCADE,
  Price DECIMAL(6,2) NOT NULL,
  Discount INT NOT NULL,
  PRIMARY KEY(PID)
);

INSERT INTO Payment VALUES('P001','O001','4800','0');


CREATE TABLE Deliverer(
  DID VARCHAR(4) NOT NULL UNIQUE,
  DName VARCHAR(50) NOT NULL,
  Tel INT(10) NOT NULL,
  PRIMARY KEY(DID)
);

CREATE TABLE Delivery(
  OrderID VARCHAR(4) REFERENCES Orders(OrderID)
  ON UPDATE CASCADE ON DELETE CASCADE,
  DID VARCHAR(4) REFERENCES Deliverer(DID)
  ON UPDATE CASCADE ON DELETE CASCADE,
  PRIMARY KEY (OrderID,DID)
);

///////////////////////////////////
Join Queries
///////////////////////////////////

1)Top Moving Items

select Description, count(orderid) as no_of_orders
from Item i,OrderDetails od,orders o
where i.icode=od.icode && o.OrderDate='2017-06-03'
group by i.icode
order by 2 desc limit 10;

//

//

2)Top Buying Customers

select CName,count(orderid) as no_of_orders
from orders o,Customer c
where o.CID=c.CID
group by c.CID
order by 2 desc limit 10;

//by year
select CName,count(orderid) as no_of_orders
from orders o,Customer c
where o.CID=c.CID && o.OrderDate='2017-06-03'
group by c.CID
order by 2 desc limit 10;

3)
select o.orderId,count(o.orderid)
from orders o,customer c
where o.CID=c.CID && o.CID='C001'
group by o.orderId;

4)Pending Orders

SELECT o.OrderID,CName,count(od.ICode),p.Price
FROM orders o,customer c,Item i,OrderDetails od,Payment p
WHERE o.CID=c.CID && o.orderId=od.orderId && o.OrderStatus='Pending' && o.orderId=p.orderId
GROUP BY o.orderid;

////
SELECT o.OrderID,CName,count(od.ICode),count(od.QTY),i.Description
FROM orders o,customer c,Item i,OrderDetails od
WHERE o.CID=c.CID && o.orderId=od.orderId && od.ICode=i.ICode && o.OrderStatus='Pending'
GROUP BY o.orderid;

//
SELECT o.OrderID,CName,p.Price
FROM orders o,customer c,Payment p
WHERE o.CID=c.CID && o.OrderStatus='Pending' && o.orderId=p.orderId GROUP BY p.pID

SELECT o.OrderID,CName
FROM orders o,customer c,Payment p
WHERE o.CID=c.CID && o.OrderStatus='Pending';

//
SELECT o.OrderID,CName
FROM orders o,customer c,Item i,OrderDetails od
WHERE o.CID=c.CID && o.orderId=od.orderId && o.OrderStatus='Pending'
GROUP BY o.orderid

5)View All Orders

SELECT o.OrderID,o.CID,c.CName,o.OrderDate,p.Price,o.OrderStatus
FROM orders o,customer c,Payment p
WHERE o.CID=c.CID && o.OrderID=p.OrderID;
6)View Order Details

SELECT od.ICode,i.Description,od.QTY,i.UnitPrice
FROM Orders o,Item i,OrderDetails od
WHERE o.OrderID=od.OrderID && od.ICode=i.ICode && o.OrderID='O027'
