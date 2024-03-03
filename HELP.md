# 后端接口开发

### 项目相关
后端框架：Spring Boot3.2.0
数据库：MS SERVER2019

### 数据库car及表vehical创建、数据录入
CREATE DATABASE car;<br>
CREATE TABLE vehical
(
    cid tinyint IDENTITY(1,1) PRIMARY KEY,
    cname char(6) NOT NULL,
    ccolor char(6) NOT NULL,
    cprice int NOT NULL,
    cage tinyint NOT NULL
)<br>
INSERT INTO vehical VALUES
('Car1', 'Red', 1, 5),('Car2', 'Blue', 2, 6),('Car3', 'Black', 3, 7),('Car4', 'Grey', 4, 8),('Car5', 'Red', 1, 5),
('Car6', 'Blue', 2, 6),('Car7', 'Black', 3, 7),('Car8', 'Grey', 4, 8),('Car9', 'Red', 1, 5),('Car10', 'Blue', 2, 6),
('Car11', 'Black', 3, 7),('Car12', 'Grey', 4, 8),('Car13', 'Red', 1, 5),('Car14', 'Blue', 2, 6),('Car15', 'Black', 3, 7),
('Car16', 'Grey', 4, 8),('Car17', 'Red', 1, 5),('Car18', 'Blue', 2, 6),('Car19', 'Black', 3, 7),('Car20', 'Grey', 4, 8);