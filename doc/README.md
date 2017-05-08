## 登陆数据库
默认登入dev

    ./login-db.sh

登入其他环境

    ./login-db.sh beta.conf


## 对某个环境数据库执行脚本

    ./login-db.sh < schema/0_init.sql
    ./login-db.sh beta.conf < schema/0_init.sql
