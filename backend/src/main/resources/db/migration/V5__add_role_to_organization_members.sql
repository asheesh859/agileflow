ALTER TABLE organization_members
ADD COLUMN role_id BIGINT NOT NULL;

ALTER TABLE organization_members
ADD CONSTRAINT fk_org_member_role
FOREIGN KEY (role_id)
REFERENCES roles(id);