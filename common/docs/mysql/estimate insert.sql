use shield_erp;

INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('101', 'COMPANY_TP', '회사 종류', '회사 종류');

INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('102', 'EXTERNAL_COM_TP', '외부 회사 종류', '외부 회사 종류');

INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('103', 'EXTERNAL_MEMBER_TP', '외부 회사 직원 종류', '외부 회사 직원 종류');

INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('104', 'ESTIMATE_TP', '공사 납품 구분 정보', '공사 납품 구분 정보');

INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('105', 'CONSTRUCT_TP', '재료비, 노무비, 경비비', '공사 견적 구분 정보');

INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('106', 'CONSTRUCT_INSTALL_TP', '설치 타입 구분 정보', '설치 타입 구분 정보');

INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('107', 'QUOTATION_PAY_TP', '견적서 결제 정보', '견적서 결제 정보');

INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('108', 'INVOICE_FORM_TP', '거래서 구분 정보', '거래서 구분 정보');


-- 201
INSERT INTO code (cd_no, cd_alias, cd_desc, cd_nm)
VALUES ('201', 'ACTIVE_ST', '사용 상태', '사용 상태');


INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('101001', 'COMPANY_TP_CUSTOMER', '고객사 회사', '회사 종류', '101');

-- 외부 회사
INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('102001', 'EXTERNAL_COM_TP_CUSTOMER', '고객처', '고객처', '102');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('102002', 'EXTERNAL_COM_TP_SUPPLY', '매입처', '매입처', '102');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('102003', 'EXTERNAL_COM_TP_COOPERATIVE', '협력 소장', '협력 소장', '102');

-- 외부 회사 직원 종류
INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('103001', 'EXTERNAL_MEMBER_TP_CUSTOMER', '고객처 직원', '고객처 직원', '103');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('103002', 'EXTERNAL_MEMBER_TP_SUPPLY', '매입처 직원', '매입처 직원', '103');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('103003', 'EXTERNAL_MEMBER_TP_COOPERATIVE', '협력 직원', '협력 직원', '103');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('104001', 'ESTIMATE_TP_CONSTRUCTION', '공사', '공사', '104');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('104002', 'ESTIMATE_TP_DELIVERY', '납품', '납품', '104');



INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('105001', 'CONSTRUCT_TP_DELIVERY_COST', '납품비', '납품비', '105');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('105002', 'CONSTRUCT_TP_DELIVERY_MATERIAL_COST', '재료비', '재료비', '105');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('105003', 'CONSTRUCT_TP_LABOR_COST', '노무비', '노무비', '105');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('105004', 'CONSTRUCT_TP_OVERHAED_COST', '경비비', '경비비', '105');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('106001', 'CONSTRUCT_INSTALL_TP_PIPE', '파이프', '파이프', '106');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('106002', 'CONSTRUCT_INSTALL_TP_PANEL', '방음판', '방음판', '106');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('107001', 'QUOTATION_PAY_TP_ADVANCE', '선금', '선금', '107');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('107002', 'QUOTATION_PAY_TP_LATER', '후불', '후불', '107');


INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('108001', 'INVOICE_FORM_TP_ESTIMATE', '견적서', '견적서', '108');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('108002', 'INVOICE_FORM_TP_ORDER', '견적서', '견적서', '108');


-- 201
INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('201001', 'ACTIVE_ST_Y', '사용중', '사용중', '201');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('201002', 'ACTIVE_ST_N', '사용중지', '사용중지', '201');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('201003', 'ACTIVE_ST_F', '사용종료', '사용종료', '201');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('201004', 'ACTIVE_ST_W', '사용대기', '사용대기', '201');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('201005', 'ACTIVE_ST_X', '사용불가', '사용불가', '201');

INSERT INTO code_dtl (cd_dtl_no, cd_dtl_alias, cd_dtl_desc, cd_dtl_nm, cd_no)
VALUES ('201006', 'ACTIVE_ST_D', '사용불가', '삭제요청', '201');


INSERT INTO company (seq, company_nm, company_option, manager_member_seq, act_st, reg_dt, upd_dt)
VALUES (1, '실드 주식회사', '{"phone":"02-2269-1233","fax":"02-2285-1236","addresss":"경기도 양주시 백석읍 중앙로 287","sector":"제조업,건설업 외","type":"건설기자재,방음벽 외"}', 1, '201001', now(), now());

INSERT INTO producer (seq, producer_nm, producer_option, act_st, reg_dt, upd_dt, company_seq)
VALUES (1, '실드 주식회사', '{"phone":"02-2269-1233","fax":"02-2285-1236","addresss":"경기도 양주시 백석읍 중앙로 287","sector":"제조업,건설업 외","type":"건설기자재,방음벽 외"}', '201001', now(), now(), 1);

INSERT INTO member (seq, member_id, member_nm, member_option, member_pw, act_st, reg_dt, upd_dt, company_seq)
VALUES (1, 'koon', '안성군', '{"phone":"01032439515","email":"koon@naver.com"}', '$2a$10$24n0xERjyyxO1leAiu3DeuEQOkyHjE.coEzEXZygmVCg.QNOJt7Hq','201001', NOW(), NOW(), 1);

INSERT INTO member (seq, member_id, member_nm, member_option, member_pw, act_st, reg_dt, upd_dt, company_seq)
VALUES (2, 'jin', '최경진', '{"phone":"01032439515","email":"koon@naver.com"}', '$2a$10$24n0xERjyyxO1leAiu3DeuEQOkyHjE.coEzEXZygmVCg.QNOJt7Hq','201001', NOW(), NOW(), 1);

INSERT INTO member (seq, member_id, member_nm, member_option, member_pw, act_st, reg_dt, upd_dt, company_seq)
VALUES (3, 'jinchoi', '최혁진', '{"phone":"01032439515","email":"koon@naver.com"}', '$2a$10$24n0xERjyyxO1leAiu3DeuEQOkyHjE.coEzEXZygmVCg.QNOJt7Hq','201001', NOW(), NOW(), 1);


INSERT INTO role (seq, role_nm, role_option, reg_dt)
VALUES ('1', 'super', '{"title":"super_admin","description":"super admin"}', now());

INSERT INTO role (seq, role_nm, role_option, reg_dt)
VALUES ('2', 'admin', '{"title":"admin","description":"admin"}', now());

INSERT INTO role (seq, role_nm, role_option, reg_dt)
VALUES ('3', 'member', '{"title":"member","description":"member"}', now());

INSERT INTO member_role (seq, member_seq, role_seq)
VALUES (1, 1, 3);

INSERT INTO member_role (seq, member_seq, role_seq)
VALUES (2, 2, 3);

INSERT INTO member_role (seq, member_seq, role_seq)
VALUES (3, 3, 3);




