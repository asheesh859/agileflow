CREATE TABLE user_identities (
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    provider VARCHAR(50) NOT NULL,

    provider_user_id VARCHAR(255) NOT NULL,

    email VARCHAR(255),

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user_identity_user
        FOREIGN KEY (user_id)
        REFERENCES users(id),

    CONSTRAINT uk_provider_user
        UNIQUE (provider, provider_user_id)
);