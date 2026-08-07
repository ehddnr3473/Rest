CREATE TABLE IF NOT EXISTS users (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(255) NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    name            VARCHAR(100) NOT NULL,
    status          VARCHAR(20) NOT NULL DEFAULT 'ACTIVE', -- ACTIVE, WITHDRAWN
    withdrawn_at    DATETIME NULL
);

CREATE TABLE IF NOT EXISTS user_withdrawal_logs (
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id         BIGINT       NOT NULL,
    email           VARCHAR(255) NOT NULL, -- 탈퇴 시점 원본 이메일 스냅샷
    name            VARCHAR(100) NOT NULL,
    reason          VARCHAR(255),
    withdrawn_at    DATETIME     NOT NULL
);