# Campus Lab Manager

Campus Lab Manager 是一个校园实验室设备预约与维护平台，覆盖设备建档、学生预约、管理员审批、现场借出与归还、故障报修和维修完成等业务环节。

## 功能

- 实验设备建档和状态查询
- 学生按时间段提交设备预约
- 检测同一设备的预约时间冲突
- 管理员批准或拒绝预约
- 设备借出、归还及状态联动
- 故障报修、维修记录和设备重新开放
- 仪表盘统计设备、待审批预约和待处理维修单
- 参数校验与统一异常响应

## 业务流程

```text
设备建档 → 提交预约 → 冲突检测 → 审批 → 借出 → 归还
                                      ↓
                              故障报修 → 维修完成 → 重新开放预约
```

## 技术栈

- Java 26、Spring Boot 4.1
- MyBatis-Plus
- MySQL、H2
- Jakarta Validation
- JUnit、MockMvc
- Docker、Docker Compose

## 快速启动

环境要求：JDK 26、Maven 3.9+。使用容器化环境时还需要 Docker Compose。

### 本地模式

本地模式默认使用 H2 内存数据库。

```bash
git clone https://github.com/lingyifan123-ship-it/campus-lab-manager.git
cd campus-lab-manager
mvn spring-boot:run
```

服务默认运行在 `http://localhost:8082`。

### Docker Compose

```bash
git clone https://github.com/lingyifan123-ship-it/campus-lab-manager.git
cd campus-lab-manager
docker compose up --build -d
docker compose ps
```

Compose 会启动 Campus Lab Manager 和 MySQL 8.4。停止服务：

```bash
docker compose down
```

## 接口示例

创建设备：

```bash
curl -X POST http://localhost:8082/api/equipment \
  -H "Content-Type: application/json" \
  -d '{"assetCode":"LAB-001","name":"数字示波器","category":"电子测量","labRoom":"A301"}'
```

查询设备：

```bash
curl http://localhost:8082/api/equipment
```

提交预约：

```bash
curl -X POST http://localhost:8082/api/reservations \
  -H "Content-Type: application/json" \
  -d '{"equipmentId":1,"studentId":1001,"startAt":"2026-12-01T14:00:00","endAt":"2026-12-01T16:00:00","purpose":"电路实验"}'
```

审批、借出和归还：

```bash
curl -X PATCH http://localhost:8082/api/reservations/1/review \
  -H "Content-Type: application/json" \
  -d '{"decision":"APPROVED","note":"时间可用"}'

curl -X POST http://localhost:8082/api/reservations/1/checkout
curl -X POST http://localhost:8082/api/reservations/1/return
```

报修并完成维修：

```bash
curl -X POST http://localhost:8082/api/repairs \
  -H "Content-Type: application/json" \
  -d '{"equipmentId":1,"reporterId":1001,"description":"通道一无波形"}'

curl -X PATCH http://localhost:8082/api/repairs/1/resolve \
  -H "Content-Type: application/json" \
  -d '{"resolution":"更换探头并完成校准"}'
```

查看仪表盘：

```bash
curl http://localhost:8082/api/dashboard
```

## 主要接口

| 方法 | 路径 | 说明 |
|---|---|---|
| `POST` | `/api/equipment` | 创建设备 |
| `GET` | `/api/equipment` | 查询设备 |
| `POST` | `/api/reservations` | 提交预约 |
| `PATCH` | `/api/reservations/{id}/review` | 审批预约 |
| `POST` | `/api/reservations/{id}/checkout` | 借出设备 |
| `POST` | `/api/reservations/{id}/return` | 归还设备 |
| `POST` | `/api/repairs` | 提交报修 |
| `PATCH` | `/api/repairs/{id}/resolve` | 完成维修 |
| `GET` | `/api/dashboard` | 查看统计数据 |

## 配置

| 环境变量 | 默认值 | 说明 |
|---|---|---|
| `DB_URL` | H2 内存数据库 | JDBC 连接地址 |
| `DB_USERNAME` | `sa` | 数据库用户名 |
| `DB_PASSWORD` | 空 | 数据库密码 |
| `SERVER_PORT` | `8082` | 服务端口 |

## 测试

```bash
mvn test
```

集成测试覆盖预约冲突、审批、借出、归还、报修、维修完成、仪表盘统计和非法参数。

## 目录结构

- `domain`：设备、预约和维修单实体
- `mapper`：MyBatis-Plus 数据访问层
- `service`：预约、设备状态和维修业务逻辑
- `api`：REST 接口、DTO 和异常处理
- `schema.sql`：数据库表结构

## 后续计划

- 接入学校统一身份认证和管理员权限控制
- 增加设备图片、附件和维修工单指派
- 增加预约日历、分页查询和消息提醒
