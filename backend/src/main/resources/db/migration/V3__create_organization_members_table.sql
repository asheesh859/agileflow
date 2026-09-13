CREATE TABLE organization_members (
    id BIGSERIAL PRIMARY KEY,

    organization_id BIGINT NOT NULL,

    user_id BIGINT NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_org_member_organization
        FOREIGN KEY (organization_id)
        REFERENCES organizations(id),

    CONSTRAINT fk_org_member_user
        FOREIGN KEY (user_id)
        REFERENCES users(id),

    CONSTRAINT uk_organization_user
        UNIQUE (organization_id, user_id)
);