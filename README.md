# Campus Lab Manager

校园实验室设备预约与维护平台。学生预约设备，管理员审批，现场借出归还；设备出问题后提交报修，维修完成再恢复可预约，形成完整闭环。

技术栈：Java 26、Spring Boot 4.1、MyBatis-Plus、MySQL/H2、参数校验、JUnit、MockMvc、Docker Compose。

```bash
git clone https://github.com/lingyifan123-ship-it/campus-lab-manager.git
cd campus-lab-manager
docker compose up --build -d
curl http://localhost:8082/api/equipment
```

关键接口：`POST /api/equipment`、`POST /api/reservations`、`PATCH /api/reservations/{id}/review`、`POST /api/reservations/{id}/checkout`、`POST /api/reservations/{id}/return`、`POST /api/repairs`、`PATCH /api/repairs/{id}/resolve`、`GET /api/dashboard`。

运行 `mvn test` 可验证预约冲突、审批、借出、归还、报修、维修完成和非法参数。

目录分为 `domain`、`mapper`、`service`、`api`。已知问题：当前用学生 ID 代替统一身份系统；生产版需要接学校账号和管理员鉴权。

重建说明：原本地项目因系统恢复丢失，本仓库依据留存需求重新实现；提交时间代表本次恢复过程。
