# 验证记录

- Java：26.0.2.1
- Spring Boot：4.1.2
- 自动化测试：2 tests / 0 failures / 0 errors
- 数据访问：MyBatis-Plus + MySQL
- 测试数据库：H2 MySQL 兼容模式
- Compose 服务：Campus Lab Manager + MySQL 8.4

## 覆盖流程

```text
设备建档 → 预约 → 冲突检测 → 审批 → 借出 → 归还 → 报修 → 维修完成
```

## 验证命令

```bash
mvn test
docker compose config
docker compose up --build -d
```
