package kr.co.shield.ext;

public interface OptionKey {
	
	String ACCOUNT_account_id                               = "account_id";                         // mobon
	String ACCOUNT_balance                                  = "balance";                            // 매체 잔액
	String ACCOUNT_client_account_id                        = "client_account_id";                  // 대행사 하위 계정명(매체 제공)
	String ACCOUNT_linked_profile                           = "linked_profile";                     // tb_account_profile 연동 갯수 (DB에는 저장하지 않음)
	String ACCOUNT_login_customer_id                        = "login_customer_id";
	String ACCOUNT_manager                                  = "manager";
	String ACCOUNT_sync_state                               = "sync_state";                         // 매체 최종 상태 [success|failure]
	String ACCOUNT_sync_time                                = "sync_time";                          // 매체 최종 확인 시간 millis
	
	String ACCOUNT_ALARM_balance                            = "balance";                            // { "oper": "lt", "value": "3000" }
	String ACCOUNT_ALARM_charge                             = "charge";                             // { "oper": "eq", "value": "Y" }
	String ACCOUNT_ALARM_stats                              = "stats";                              // { "oper": "", "value": "5" } [lt(e)|gt(e)|lt(e),gt(e)], [-3,0|0,14|-5,5] %
	String ACCOUNT_ALARM_trans                              = "trans";                              // { "oper": "eq", "value": "Y" } 대행사 변경
	String ACCOUNT_ALARM_allowed_times                      = "allowed_times";                      // "08:30-11:00","12","15-18"
	String ACCOUNT_ALARM_channel_types                      = "channel_types";                      // phone,email
	
	String ACCOUNT_BULK_WORK_admin_nm                       = "admin_nm";
	String ACCOUNT_BULK_WORK_failure                        = "failure";
	String ACCOUNT_BULK_WORK_success                        = "success";
	String ACCOUNT_BULK_WORK_total                          = "total";
	String ACCOUNT_BULK_WORK_report_job_id                  = "report_job_id";
	String ACCOUNT_BULK_WORK_download_url                   = "download_url";

	String ACTION_asset_names                               = "asset_names";
	String ACTION_asset_seqs                                = "asset_seqs";
	String ACTION_audience_names                            = "audience_names";
	String ACTION_audience_seqs                             = "audience_seqs";
	String ACTION_audience_tags                             = "audience_tags";
	String ACTION_audience_type                             = "audience_type";                      // 오디언스 종류 [all|target]
	String ACTION_fatigue                                   = "fatigue";
	String ACTION_pfnos                                     = "pfnos";                              // 프로파일번호 리스트, 미구현
	
	String ADMIN_job_position                               = "job_position";                       // 직위/직책
	String ADMIN_linked_client_seq                          = "linked_client_seq";                  // 연결된 고객 번호
	String ADMIN_linked_client_nm                           = "linked_client_nm";                   // 연결된 고객명
	String ADMIN_login_cnt                                  = "login_cnt";
	String ADMIN_login_dt                                   = "login_dt";
	String ADMIN_phone                                      = "phone";                              // 전화번호
	String ADMIN_profile_photo                              = "profile_photo";                      // 프로필 사진
	String ADMIN_role_nm                                    = "role_nm";
	String ADMIN_role_seq                                   = "role_seq";
	String[] ADMIN_OPTIONS                                  = {
			ADMIN_job_position,
			ADMIN_linked_client_seq,
			ADMIN_linked_client_nm,
			ADMIN_phone,
			ADMIN_profile_photo
	};
	
	String ADMIN_APP_list_order                             = "list_order";
	String ADMIN_APP_pin_yn                                 = "pin_yn";
	String ADMIN_APP_restriction                            = "restriction";
	String ADMIN_APP_service_dt                             = "service_dt";
	
	String AGENCY_company                                   = "company";
	String AGENCY_company_favicon                           = "favicon";
	String AGENCY_company_logo                              = "logo";
	String AGENCY_company_text                              = "text";
	String AGENCY_company_title                             = "title";
	String AGENCY_contract                                  = "contract";
	String AGENCY_contract_account                          = "account";
	String AGENCY_contract_order_no                         = "order_no";                         // 서비스 사용중에 추가 결제시 임시 저장되는 주문 번호. 현재 contract 종료시 반영
	String AGENCY_contract_pe_dt                            = "pe_dt";
	String AGENCY_contract_pe_tm                            = "pe_tm";
	String AGENCY_contract_product_tp                       = "product_tp";                       // 상품 종류 코드
	String AGENCY_contract_profile                          = "profile";
	String AGENCY_contract_ps_dt                            = "ps_dt";
	String AGENCY_contract_ps_tm                            = "ps_tm";
	String AGENCY_contract_traffic                          = "traffic";
	String AGENCY_master_secret                             = "master_secret";
	String AGENCY_page                                      = "page";
	String AGENCY_page_error                                = "error";
	String AGENCY_page_first                                = "first";
	String AGENCY_register_team_seq                         = "register_team_seq";
	String AGENCY_issue                                     = "issue";                            // 세금계산서 정보
	String AGENCY_issue_name                                = "name";                             // 상호(법인명)
	String AGENCY_issue_ceo_name                            = "ceo_name";                         // 대표자명
	String AGENCY_issue_ssn                                 = "ssn";                              // 사업자등록번호
	String AGENCY_issue_addr                                = "addr";                             // 사업장 주소
	String AGENCY_issue_manager_name                        = "manager_name";                     // 세금계산서 담당자명 
	String AGENCY_issue_manager_phone                       = "manager_phone";                    // 세금계산서 전화번호
	String AGENCY_issue_manager_email                       = "manager_email";                    // 세금계산서 담당자 이메일
	String AGENCY_issue_biz_type                            = "biz_type";                         // 업태
	String AGENCY_issue_biz_name                            = "biz_name";                         // 종목
	String AGENCY_issue_biz_photo                           = "biz_photo";                        // 사업자등록증
	String AGENCY_issue_bank_photo                          = "bank_photo";                       // 통장사본
	
	String AGENCY_APP_service_dt                            = "service_dt";
	
	String AGGREGATION_description                          = "description";
	String AGGREGATION_load_tp                              = "load_tp";
	String AGGREGATION_repeat                               = "repeat";
	
	String APP_code                                         = "code";
	String APP_context                                      = "context";
	String APP_contract                                     = "contract";
	String APP_description                                  = "description";
	String APP_icon                                         = "icon";
	String APP_opt_client_type                              = "opt_client_type";                    // 클라이언트 옵션 종류 [all|client|none]
	String APP_path                                         = "path";
	String APP_privilege                                    = "privilege";
	String APP_svc_app                                      = "svc_app";
	String APP_svc_dt                                       = "svc_dt";
	String APP_supplier                                     = "supplier";
	String APP_supplier_contract                            = "contract";
	String APP_supplier_modal                               = "modal";                              // logger, select client
	String APP_supplier_prefix                              = "prefix";
	String APP_supplier_secession                           = "secession";
	String APP_supplier_sign_in                             = "sign_in";
	String APP_supplier_sign_up                             = "sign_up";
	String APP_supplier_target                              = "target";                             // tgt, [window(새창)|iframe]
	String APP_guide                                        = "guide";
	
	String AUDIENCE_admin_nm                                = "admin_nm";                           // 검색 필터
	String AUDIENCE_admin_seq                               = "admin_seq";                          // 검색 필터
	String AUDIENCE_description                             = "description";
	String AUDIENCE_segment_period                          = "segment_period";                     // if snapshot, save option
	String AUDIENCE_segment_seq                             = "segment_seq";                        // Only snapshot
	String AUDIENCE_segment_type                            = "segment_type";                       // 오디언스 종류
	String AUDIENCE_team_nm                                 = "team_nm";                            // 검색 필터
	String AUDIENCE_team_seq                                = "team_seq";                           // 검색 필터
	
	String AUDIENCE_WORK_agg_audience_user_seq              = "agg_audience_user_seq";              // template#22
	String AUDIENCE_WORK_agg_audience_prop_seq              = "agg_audience_prop_seq";              // template#23
	String AUDIENCE_WORK_agg_work_seq                       = "agg_work_seq";
	String AUDIENCE_WORK_audience_seq                       = "audience_seq";                       // for snapshot segment period
	String AUDIENCE_WORK_audience_tag                       = "audience_tag";
	String AUDIENCE_WORK_audience_type                      = "audience_type";
	String AUDIENCE_WORK_set_audience_seqs                  = "set_audience_seqs";
	String AUDIENCE_WORK_set_audience_tags                  = "set_audience_tags";
	String AUDIENCE_WORK_set_audience_nms                   = "set_audience_nms";
	String AUDIENCE_WORK_set_operator                       = "set_operator";                       // union,intersection,subtraction-left,subtraction-right
	String AUDIENCE_WORK_save_as                            = "save_as";
	String AUDIENCE_WORK_save_dt                            = "save_dt";
	String AUDIENCE_WORK_segment_seq                        = "segment_seq";
	String AUDIENCE_WORK_segment_tag                        = "segment_tag";
	String AUDIENCE_WORK_seg_work_seq                       = "seg_work_seq";
	
	String CAMPAIGN_cnt_action                              = "cnt_action";
	String CAMPAIGN_cnt_segment                             = "cnt_segment";
	String CAMPAIGN_fatigue                                 = "fatigue";
	String CAMPAIGN_memo                                    = "memo";
	String CAMPAIGN_pin_yn                                  = "pin_yn";
	
	String CLIENT_apps_in_use                               = "apps_in_use";
	String CLIENT_goal_prefix                               = "g";
	int CLIENT_goal_count                                   = 10;
	String CLIENT_goal_field                                = "field";
	String CLIENT_goal_use_yn                               = "use_yn";                             // "g1":{"field":"전환","use_yn":"Y"}
	String CLIENT_g1                                        = "g1";
	String CLIENT_g2                                        = "g2";
	String CLIENT_g3                                        = "g3";
	String CLIENT_g4                                        = "g4";
	String CLIENT_g5                                        = "g5";
	String CLIENT_g6                                        = "g6";
	String CLIENT_g7                                        = "g7";
	String CLIENT_g8                                        = "g8";
	String CLIENT_g9                                        = "g9";
	String CLIENT_g10                                       = "g10";
	String CLIENT_logger                                    = "logger";
	String CLIENT_logger_id                                 = "id";
	String CLIENT_logger_pw                                 = "pw";
	
	String CUSTOM_TEMPLATE_button_bg_color                  = "button_bg_color";
	String CUSTOM_TEMPLATE_button_font_color                = "button_font_color";
	String CUSTOM_TEMPLATE_button_text                      = "button_text";
	String CUSTOM_TEMPLATE_content                          = "content";
	String CUSTOM_TEMPLATE_image_url                        = "image_url";
	String CUSTOM_TEMPLATE_landing_url                      = "landing_url";
	String CUSTOM_TEMPLATE_title                            = "title";
	String[] CUSTOM_TEMPLATE                                = {
			CUSTOM_TEMPLATE_button_bg_color,
			CUSTOM_TEMPLATE_button_font_color,
			CUSTOM_TEMPLATE_button_text,
			CUSTOM_TEMPLATE_content,
			CUSTOM_TEMPLATE_image_url,
			CUSTOM_TEMPLATE_landing_url,
			CUSTOM_TEMPLATE_title
	};
	
	String DEFERRAL_addon                                   = "addon";
	String DEFERRAL_quota                                   = "quota";
	String DEFERRAL_usage                                   = "usage";
	
	String DIMENSION_bigquery                               = "bigquery";
	String DIMENSION_elastic                                = "elastic";
	String DIMENSION_mysql                                  = "mysql";
	
	String LICENSE_customer_id                              = "customer_id";                        // naver CUSTOMER_ID
	String LICENSE_access_license                           = "access_license";                     // naver 액세스라이선스
	String LICENSE_secret_key                               = "secret_key";                         // naver 비밀키
	String LICENSE_app_key                                  = "app_key";                            // kakao 앱 키(REST API 키)
	String LICENSE_refresh_token                            = "refresh_token";                      // kakao, google 리프레시토큰
	String LICENSE_admin_account                            = "admin_account";                      // google 관리자 계정
	String LICENSE_client_id                                = "client_id";                          // google 클라이언트 ID, facebook 클라이언트 ID
	String LICENSE_client_secret                            = "client_secret";                      // google 클라이언트 Secret, facebook 클라이언트 Secret
	String LICENSE_developer_token                          = "developer_token";                    // google 개발자 토큰
	String LICENSE_access_token                             = "access_token";                       // facebook 액세스토큰(Long Lived)
	String LICENSE_account_no                               = "account_no";                         // scrap 계정번호
	String LICENSE_agency_yn                                = "agency_yn";                          // scrap 대행사 계정 여부 [Y|N]
	String LICENSE_login_id                                 = "login_id";                           // scrap 로그인 ID
	String LICENSE_login_pw                                 = "login_pw";                           // scrap 로그인 PW
	String LICENSE_is_agency                                = "is_agency";                          // scrap 대행사 계정 여부
	String[] LICENSE_OPTIONS                                = {
			LICENSE_customer_id,
			LICENSE_access_license,
			LICENSE_secret_key,
			LICENSE_app_key,
			LICENSE_refresh_token,
			LICENSE_admin_account,
			LICENSE_client_id,
			LICENSE_client_secret,
			LICENSE_developer_token,
			LICENSE_access_token,
			LICENSE_account_no,
			LICENSE_login_id,
			LICENSE_login_pw
	};
	
	String LICENSE_OAUTH_oauth_id                           = "oauth_id";                           // OAuthId
	String LICENSE_OAUTH_oauth_nm                           = "oauth_nm";                           // OAuthNm
	String[] LICENSE_OAUTH_OPTIONS                          = {
			LICENSE_OAUTH_oauth_id,
			LICENSE_OAUTH_oauth_nm
	};
	
	String MARKETING_ASSET_channel_type                     = "channel_type";
	String MARKETING_ASSET_memo                             = "memo";
	String MARKETING_ASSET_pin_yn                           = "pin_yn";
	String MARKETING_ASSET_path_image                       = "path_image";
	String MARKETING_ASSET_path_template                    = "path_template";
	String MARKETING_ASSET_url_type                         = "url_type";                           // landing|redirect
	String MARKETING_ASSET_url                              = "url";
	// 채널별 변수 설정
	// 온사이트 메시지
	String MARKETING_ASSET_rest                             = "rest";                               // 온사이트 메시지 테이블
	String MARKETING_ASSET_rest_title                       = "title";
	String MARKETING_ASSET_rest_content                     = "content";
	String MARKETING_ASSET_rest_button_bg_color             = "button_bg_color";                    // backgroup color
	String MARKETING_ASSET_rest_button_font_color           = "button_font_color";                  // font color
	String MARKETING_ASSET_rest_button_text                 = "button_text";
	String MARKETING_ASSET_rest_image_url                   = "image_url";
	String MARKETING_ASSET_rest_landing_url                 = "landing_url";
	String MARKETING_ASSET_rest_position_horizontal         = "position_horizontal";                // [left|center|right]
	String MARKETING_ASSET_rest_position_vertical           = "position_vertical";                  // [top|middle|bottom]
	// 이메일
	String MARKETING_ASSET_email                            = "email";                              // 이메일 테이블
	String MARKETING_ASSET_email_template                   = "template";
	// SMS
	String MARKETING_ASSET_sms                              = "sms";
	// 알림톡
	String MARKETING_ASSET_kakao                            = "kakao";
	// 웹푸시
	String MARKETING_ASSET_push                             = "push";
	
	
	String MEDIA_info                                       = "info";
	String MEDIA_info_campaign_tp                           = "campaign_tp";
	String MEDIA_info_media_tp                              = "media_tp";
	String[] MEDIA_infos                                    = {
			MEDIA_info_campaign_tp,
			MEDIA_info_media_tp
	};
	String MEDIA_mapping                                    = "mapping";
	String MEDIA_mapping_extension                          = "extension";
	String MEDIA_mapping_fields                             = "fields";
	String MEDIA_mapping_template                           = "template";
	String[] MEDIA_mappings                                 = {
			MEDIA_mapping_extension,
			MEDIA_mapping_fields,
			MEDIA_mapping_template
	};
	String MEDIA_parameter                                  = "parameter";
	String MEDIA_parameter_media_type                       = "media_type";
	String MEDIA_parameter_campaign_type                    = "campaign_type";
	String MEDIA_parameter_adgroup_type                     = "adgroup_type";
	String MEDIA_parameter_keyword_type                     = "keyword_type";
	String MEDIA_parameter_campaign_id                      = "campaign_id";
	String MEDIA_parameter_adgroup_id                       = "adgroup_id";
	String MEDIA_parameter_keyword_id                       = "keyword_id";
	String MEDIA_parameter_keyword                          = "keyword";
	String MEDIA_parameter_creative_id                      = "creative_id";
	String MEDIA_parameter_creative                         = "creative";
	String MEDIA_parameter_creative_link_id                 = "creative_link_id";
	String MEDIA_parameter_query                            = "query";
	String[] MEDIA_parameters                               = {
			MEDIA_parameter_media_type,
			MEDIA_parameter_campaign_type,
			MEDIA_parameter_adgroup_type,
			MEDIA_parameter_keyword_type,
			MEDIA_parameter_campaign_id,
			MEDIA_parameter_adgroup_id,
			MEDIA_parameter_keyword_id,
			MEDIA_parameter_keyword,
			MEDIA_parameter_creative_id,
			MEDIA_parameter_creative,
			MEDIA_parameter_creative_link_id,
			MEDIA_parameter_query
	};
	String MEDIA_category                                   = "category";
	String MEDIA_category_bsp1                              = "bsp1";
	String MEDIA_category_bsp2                              = "bsp2";
	String MEDIA_category_bsp3                              = "bsp3";
	String MEDIA_category_bsp4                              = "bsp4";
	String MEDIA_category_bsp5                              = "bsp5";
	String MEDIA_category_bsp6                              = "bsp6";
	String MEDIA_category_bsp7                              = "bsp7";
	String MEDIA_category_bsp8                              = "bsp8";
	String MEDIA_category_bsp9                              = "bsp9";
	String MEDIA_category_bsp10                             = "bsp10";
	String[] MEDIA_categorys                                = {
			MEDIA_category_bsp1,
			MEDIA_category_bsp2,
			MEDIA_category_bsp3,
			MEDIA_category_bsp4,
			MEDIA_category_bsp5,
			MEDIA_category_bsp6,
			MEDIA_category_bsp7,
			MEDIA_category_bsp8,
			MEDIA_category_bsp9,
			MEDIA_category_bsp10
	};
	
	/** *********************
	String MEDIA_media_tp                                   = "media_tp";
	String MEDIA_campaign_type                              = "campaign_type";
	String MEDIA_campaign                                   = "campaign";
	String MEDIA_param                                      = "param";
	String[] MEDIA_OPTIONS                                  = {
			MEDIA_media_tp,
			MEDIA_campaign_type,
			MEDIA_campaign,
			MEDIA_param
	};
	String MEDIA_campaign_bsp1                              = "bsp1";
	String MEDIA_campaign_bsp2                              = "bsp2";
	String MEDIA_campaign_bsp3                              = "bsp3";
	String MEDIA_campaign_bsp4                              = "bsp4";
	String MEDIA_campaign_bsp5                              = "bsp5";
	String MEDIA_campaign_bsp6                              = "bsp6";
	String MEDIA_campaign_bsp7                              = "bsp7";
	String MEDIA_campaign_bsp8                              = "bsp8";
	String MEDIA_campaign_bsp9                              = "bsp9";
	String MEDIA_campaign_bsp10                             = "bsp10";
	String[] MEDIA_CAMPAIGNS                                = {
			MEDIA_campaign_bsp1,
			MEDIA_campaign_bsp2,
			MEDIA_campaign_bsp3,
			MEDIA_campaign_bsp4,
			MEDIA_campaign_bsp5,
			MEDIA_campaign_bsp6,
			MEDIA_campaign_bsp7,
			MEDIA_campaign_bsp8,
			MEDIA_campaign_bsp9,
			MEDIA_campaign_bsp10
	};
	String MEDIA_param_media_type                           = "p_media_type";
	String MEDIA_param_campaign_type                        = "p_campaign_type";
	String MEDIA_param_adgroup_type                         = "p_adgroup_type";
	String MEDIA_param_keyword_type                         = "p_keyword_type";
	String MEDIA_param_campaign_id                          = "p_campaign_id";
	String MEDIA_param_adgroup_id                           = "p_adgroup_id";
	String MEDIA_param_keyword_id                           = "p_keyword_id";
	String MEDIA_param_keyword                              = "p_keyword";
	String MEDIA_param_creative_id                          = "p_creative_id";
	String MEDIA_param_creative                             = "p_creative";
	String MEDIA_param_creative_link_id                     = "p_creative_link_id";
	String MEDIA_param_query                                = "p_query";
	String[] MEDIA_PARAMS                                   = {
			MEDIA_param_media_type,
			MEDIA_param_campaign_type,
			MEDIA_param_adgroup_type,
			MEDIA_param_keyword_type,
			MEDIA_param_campaign_id,
			MEDIA_param_adgroup_id,
			MEDIA_param_keyword_id,
			MEDIA_param_keyword,
			MEDIA_param_creative_id,
			MEDIA_param_creative,
			MEDIA_param_creative_link_id,
			MEDIA_param_query
	};
	
	String MEDIA_category                                   = "category";
	String MEDIA_mapping                                    = "mapping";
	String MEDIA_mapping_column                             = "column";
	String MEDIA_mapping_header                             = "header";
	String MEDIA_mapping_type                               = "type";
	String MEDIA_parameter                                  = "parameter";
	 */
	
	String METRICS_attr_yn                                  = "attr_yn";
	String METRICS_elastic                                  = "elastic";
	String METRICS_met_type                                 = "met_type";
	String METRICS_shown_yn                                 = "shown_yn";
	
	String ML_description                                   = "description";
	String ML_evaluate_agg_seq                              = "evaluate_agg_seq";
	String ML_model_dataset                                 = "model_dataset";
	String ML_model_name                                    = "model_name";
	String ML_model_options                                 = "model_options";
	String ML_model_ps                                      = "model_ps";
	String ML_model_pe                                      = "model_pe";
	String ML_model_transform                               = "model_transform";
	String ML_model_type                                    = "model_type";
	String ML_predict_agg_seq                               = "predict_agg_seq";
	
	String NOTICE_agency_seqs                               = "agency_seqs";
	String NOTICE_admin_seqs                                = "admin_seqs";
	String NOTICE_client_seqs                               = "client_seqs";
	String NOTICE_cnt                                       = "notice_cnt";
	
	String NOTICE_TEMPLATE_inline_image                     = "inline_image";
	
	// trasient for inipay
	String ORDERS_hashed_key                                = "hashed_key";
	String ORDERS_merchant_id                               = "merchant_id";
	String ORDERS_signature                                 = "signature";
	String ORDERS_timestamp                                 = "timestamp";
	
	String ORDERS_contract                                  = "contract";
	String ORDERS_contract_apply                            = "apply";
	String ORDERS_contract_apply_account                    = "account";
	String ORDERS_contract_apply_product_tp                 = "product_tp";
	String ORDERS_contract_apply_profile                    = "profile";
	String ORDERS_contract_apply_traffic                    = "traffic";
	String ORDERS_contract_month                            = "month";
	String ORDERS_contract_price                            = "price";
	String ORDERS_contract_title                            = "title";
	String ORDERS_contract_type                             = "type";
	String ORDERS_deferreds                                 = "deferreds";
	String ORDERS_deferred_addon                            = "addon";
	String ORDERS_deferred_price                            = "price";
	String ORDERS_deferred_quota                            = "quota";
	String ORDERS_deferred_seq                              = "seq";
	String ORDERS_deferred_title                            = "title";
	String ORDERS_deferred_usage                            = "usage";
	String ORDERS_products                                  = "products";
	String ORDERS_product_cnt                               = "cnt";                                // 상품단가 tb_product.product_option.price
	String ORDERS_product_seq                               = "seq";
	String ORDERS_prorated                                  = "prorated";
	String ORDERS_prorated_price                            = "price";
	String ORDERS_prorated_req_dt                           = "req_dt";
	String ORDERS_prorated_title                            = "title";
	String ORDERS_summary                                   = "summary";
	String ORDERS_summary_contract                          = "contract";
	String ORDERS_summary_deferred                          = "deferred";
	String ORDERS_summary_prorated                          = "prorated";
	String ORDERS_summary_total_sum                         = "total_sum";
	String ORDERS_summary_total_vat                         = "total_vat";
	String ORDERS_vact_bankname                             = "vact_bankname";
	String ORDERS_vact_num                                  = "vact_num";
	String ORDERS_vact_input_name                           = "vact_input_name";
	
	// tb_orders.issue
	String ORDERS_issue_bill_email                          = "bill_email";
	String ORDERS_issue_ssn                                 = "ssn";
	String ORDERS_issue_name                                = "name";
	String ORDERS_issue_ceo_name                            = "ceo_name";
	String ORDERS_issue_addr                                = "addr";
	String ORDERS_issue_biz_type                            = "biz_type";
	String ORDERS_issue_biz_name                            = "biz_name";
	
	String PROFILE_agency_seq                               = "agency_seq";
	String PROFILE_apps                                     = "apps";
	String PROFILE_attr_window                              = "attr_window";
	String PROFILE_referrer                                 = "referrer";
	String[] PROFILE_OPTIONS                                = {
			PROFILE_attr_window,
			PROFILE_referrer
	};
	
	String PRODUCT_apps                                     = "apps";
	String PRODUCT_contract                                 = "contract";
	String PRODUCT_description                              = "description";
	String PRODUCT_period                                   = "period";
	String PRODUCT_price                                    = "price";
	String PRODUCT_type                                     = "type";
	
	String PROFILE_LANDING_pfno                             = "pfno";                               // {tb_profile_landing.landing_url}?{bsprg}&{bsp}{tb_profile_landing.landing_ccn}
	String PROFILE_LANDING_site_url                         = "site_url";
	String PROFILE_LANDING_media_no                         = "media_no";
	String PROFILE_LANDING_ad_type                          = "ad_type";
	String PROFILE_LANDING_ad_media                         = "ad_media";
	String PROFILE_LANDING_ad_platform                      = "ad_platform";
	String PROFILE_LANDING_ad_program                       = "ad_program";
	String PROFILE_LANDING_bsprg                            = "bsprg";                              // BSPRG=NAVERBR
	String PROFILE_LANDING_bsp1                             = "bsp1";                               // BSCCN1=
	
	String PUBLISHING_media_tp                              = "media_tp";
	String PUBLISHING_account_no                            = "account_no";
	String PUBLISHING_ps                                    = "ps";                                 // 스케줄 활성화 기간(시작일)
	String PUBLISHING_pe                                    = "pe";                                 // 스케줄 활성화 기간(종료일)
	String PUBLISHING_crontime                              = "crontime";
	String PUBLISHING_description                           = "description";
	String PUBLISHING_lookback                              = "lookback";
	String PUBLISHING_audience_seq                          = "audience_seq";
	String PUBLISHING_end_point                             = "end_point";
	
	String QNA_q_admin_id                                   = "q_admin_id";
	String QNA_q_admin_nm                                   = "q_admin_nm";
	String QNA_q_client_seq                                 = "q_client_seq";
	String QNA_q_client_nm                                  = "q_client_nm";
	String QNA_q_cnt                                        = "q_cnt";
	String QNA_a_admin_id                                   = "a_admin_id";
	String QNA_a_admin_nm                                   = "a_admin_nm";
	String QNA_a_upd_dt                                     = "a_upd_dt";
	
	String REPORT_db_type                                   = "db_type";
	String REPORT_table_nm                                  = "table_nm";
	
	String REPORT_VIEW_filter                               = "filter";
	String REPORT_VIEW_icon                                 = "icon";
	String REPORT_VIEW_link_url                             = "link_url";                           // menu service 에서 생성
	String REPORT_VIEW_opt_client_type                      = "opt_client_type";                    // 클라이언트 옵션 종류 [all|client|none]
	String REPORT_VIEW_path                                 = "path";
	String REPORT_VIEW_privilege                            = "privilege";
	String REPORT_VIEW_privilege_report                     = "report";
	String REPORT_VIEW_privilege_methods                    = "methods";
	
	String ROLE_description                                 = "description";
	String ROLE_title                                       = "title";
	
	String SEGMENT_admin_nm                                 = "admin_nm";                           // 검색 필터
	String SEGMENT_admin_seq                                = "admin_seq";                          // 검색 필터
	String SEGMENT_audiences                                = "audiences";                          // seq__#__tag__#__nm
	String SEGMENT_audience_tags                            = "audience_tags";
	String SEGMENT_crontime                                 = "crontime";                           // w/ audience:A, 10 0 * * * ? second minute hour day_of_month month day_of_week
	String SEGMENT_description                              = "description";
	String SEGMENT_hashtag                                  = "hashtag";                            // 검색 필터
	String SEGMENT_lookback                                 = "lookback";                           // 세그먼트 대상 기간
	String SEGMENT_parts                                    = "parts";
	String SEGMENT_pin_yn                                   = "pin_yn";                             // 고정 여부 [Y:pinned|N:not pinned]
	String SEGMENT_pfnos                                    = "pfnos";                              // 프로파일번호 리스트
	String SEGMENT_profiles                                 = "profiles";                           // 프로파일명 리스트
	String SEGMENT_ps_date                                  = "ps_date";                            // 세그먼트 고정일자 시작일
	String SEGMENT_pe_date                                  = "pe_date";                            // 세그먼트 고정일자 종료일
	String SEGMENT_repeat_type                              = "repeat_type";                        // 세그먼트 반복 종류 [single|repeat]
	String SEGMENT_save_as                                  = "save_as";                            // 타겟오디언스 자동 생성 여부 [none|create|append]
	String SEGMENT_team_nm                                  = "team_nm";                            // 검색 필터
	String SEGMENT_team_seq                                 = "team_seq";                           // 검색 필터
	String SEGMENT_template_type                            = "template_type";                      // tb_template.template_tp [behavioral|cluster|rfm]
	
	String SEGMENT_WORK_agg_work_seq                        = "agg_work_seq";
	String SEGMENT_WORK_audience_tags                       = "audience_tags";
	String SEGMENT_WORK_period                              = "period";
	String SEGMENT_WORK_save_as                             = "save_as";
	String SEGMENT_WORK_segment_tag                         = "segment_tag";
	
	String SEGMENTLET_composite                             = "composite";                          // 복합차원
	String SEGMENTLET_composite_relation                    = "relation";                           // 상/하위 세그먼틀릿 관계
	String SEGMENTLET_composite_seg_m                       = "seg_m";                              // 상위 세그먼틀릿
	String SEGMENTLET_composite_seg_s                       = "seg_s";                              // 하위 세그먼틀릿 리스트
	String SEGMENTLET_attribution                           = "attribution";                        // 속성
	String SEGMENTLET_attribution_attr                      = "attr";                               // 속성코드
	String SEGMENTLET_attribution_attr_nm                   = "attr_nm";                            // 속성명
	String SEGMENTLET_attribution_database                  = "database";                           // 데이터베이스
	String SEGMENTLET_attribution_field                     = "field";                              // seg 저장 필드
	String SEGMENTLET_attribution_seg                       = "seg";                                // 대표 세그먼틀릿
	String SEGMENTLET_attribution_table                     = "table";                              // 테이블
	String SEGMENTLET_attribution_type                      = "type";                               // 타입 [field|value(default)]
	String SEGMENTLET_display_limit                         = "display_limit";                      // 최대 표시 개수
	String SEGMENTLET_input_type                            = "input_type";                         // 입력 타입
	String SEGMENTLET_input_value                           = "input_value";
	String SEGMENTLET_input_type_attribution                = "attribution";                        // 입력 타입 속성
	String SEGMENTLET_segment_type                          = "segment_type";                       // 세그먼트 타입
	String SEGMENTLET_label                                 = "label";                              // 라벨
	String SEGMENTLET_label_class_nm                        = "class_nm";                           // 라벨 클래스명
	String SEGMENTLET_label_title                           = "title";                              // 라벨 사용 시, 제목
	String SEGMENTLET_label_content                         = "content";                            // 라벨 내용
	
	String SERVER_alias                                     = "alias";
	String SERVER_job                                       = "job";
	String SERVER_job_last                                  = "last";
	String SERVER_job_next                                  = "next";
	String SERVER_nm                                        = "nm";
	String SERVER_power                                     = "power";
	
	String STAT_TEMPLATE_admin_id                           = "admin_id";
	String STAT_TEMPLATE_admin_nm                           = "admin_nm";
	String STAT_TEMPLATE_admin_seq                          = "admin_seq";
	String STAT_TEMPLATE_client_nm                          = "client_nm";
	String STAT_TEMPLATE_file_length                        = "file_length";
	String STAT_TEMPLATE_file_size                          = "file_size";
	String STAT_TEMPLATE_header_yn                          = "header_yn";
	String STAT_TEMPLATE_media_nm                           = "media_nm";
	String STAT_TEMPLATE_media_no                           = "media_no";
	String STAT_TEMPLATE_pfno                               = "pfno";
	String STAT_TEMPLATE_profile_nm                         = "profile_nm";
	
	String TARGETING_admin_seq                              = "admin_seq";                          // 검색 필터
	String TARGETING_audience_nm                            = "audience_nm";
	String TARGETING_audience_seqs                          = "audience_seqs";
	String TARGETING_audience_tags                          = "audience_tags";
	String TARGETING_crontime                               = "crontime";
	String TARGETING_description                            = "description";
	String TARGETING_error                                  = "error";
	String TARGETING_team_seq                               = "team_seq";                           // 검색 필터
	String TARGETING_user_list_id                           = "user_list_id";
	
	String TARGETING_WORK_account_no                        = "account_no";
	String TARGETING_WORK_admin_account                     = "admin_account";
	String TARGETING_WORK_agency_seq                        = "agency_seq";
	String TARGETING_WORK_audience_tags                     = "audience_tags";
	String TARGETING_WORK_client_id                         = "client_id";
	String TARGETING_WORK_client_secret                     = "client_secret";
	String TARGETING_WORK_crontime                          = "crontime";
	String TARGETING_WORK_developer_token                   = "developer_token";                    // google 개발자 토큰
	String TARGETING_WORK_long_lived_access_token           = "long_lived_access_token";
	String TARGETING_WORK_media_tp                          = "media_tp";
	String TARGETING_WORK_oauth_seq                         = "oauth_seq";                          // oauth_seq
	String TARGETING_WORK_refresh_token                     = "refresh_token";                      // kakao, google 리프레시토큰
	String TARGETING_WORK_result_count                      = "result_count";
	String TARGETING_WORK_result_date                       = "result_date";
	String TARGETING_WORK_user_list_id                      = "user_list_id";
	
	// template key for segment
	String TEMPLATE_description                             = "description";
	// segment
	String TEMPLATE_main_view                               = "main_view";
	String TEMPLATE_init_view                               = "init_view";
	String TEMPLATE_trait_views                             = "trait_views";
	String TEMPLATE_key_field                               = "key_field";
	String TEMPLATE_variables                               = "variables";
	String TEMPLATE_sub_template_seqs                       = "sub_template_seqs";
	// audience
	String TEMPLATE_db_type                                 = "db_type";
	String TEMPLATE_expire_dt                               = "expire_dt";
	String TEMPLATE_header                                  = "header";
	String TEMPLATE_load_type                               = "load_type";
	String TEMPLATE_target                                  = "target";
	
	// segment_defined
	String TEMPLATE_crontime                                = "crontime";                           // w/ audience:A, 10 0 * * * ? second minute hour day_of_month month day_of_week         
	String TEMPLATE_hashtag                                 = "hashtag";                            // 검색 필터                                                                                
	String TEMPLATE_lookback                                = "lookback";                           // 세그먼트 대상 기간                                                                          
	String TEMPLATE_name                                    = "name";
	String TEMPLATE_parts                                   = "parts";                              // segment_part                                                          
	String TEMPLATE_parts_seg                               = "seg";
	String TEMPLATE_parts_seg_value                         = "seg_value";
	String TEMPLATE_parts_seg_oper                          = "seg_oper";
	String TEMPLATE_parts_seg_conj                          = "seg_conj";
	String TEMPLATE_parts_idx                               = "idx";
	String TEMPLATE_parts_group_idx                         = "group_idx";
	String TEMPLATE_parts_parent_idx                        = "parent_idx";
	String TEMPLATE_repeat_type                             = "repeat_type";                        // 세그먼트 반복 종류 [single|repeat]                                                          
	String TEMPLATE_save_as                                 = "save_as";                            // 타겟오디언스 자동 생성 여부 [none|create|append]                                               
	String TEMPLATE_type                                    = "type";                               // [behavioral|cluster|rfm]                                      
	String TEMPLATE_template_seq                            = "template_seq";
	
	// template key for ml segment
	String TEMPLATE_model_template_seq                      = "model_template_seq";
	
	// template key for ml modeling
	String TEMPLATE_dataset_sampling                        = "dataset_sampling";
	String TEMPLATE_evaluate_template_seq                   = "evaluate_template_seq";
	String TEMPLATE_model_dataset                           = "model_dataset";
	String TEMPLATE_model_options                           = "model_options";
	String TEMPLATE_model_ps                                = "model_ps";
	String TEMPLATE_model_pe                                = "model_pe";
	String TEMPLATE_model_transform                         = "model_transform";
	String TEMPLATE_model_trigger                           = "model_trigger";
	String TEMPLATE_model_type                              = "model_type";
	String TEMPLATE_predict_template_seq                    = "predict_template_seq";
	// template key for ml query [evaluate|predict]
	String TEMPLATE_agg_export_type                         = "agg_export_type";                    // [NONE|DB_ELASTIC]
	String TEMPLATE_agg_load_type                           = "agg_load_type";                      // [create|insert]
	String TEMPLATE_agg_ps                                  = "agg_ps";
	String TEMPLATE_agg_pe                                  = "agg_pe";
	String TEMPLATE_agg_target                              = "agg_target";
	String TEMPLATE_agg_trigger                             = "agg_trigger";

	String TRIGGER_description                              = "description";
	String TRIGGER_memo                                     = "memo";
	String TRIGGER_pin_yn                                   = "pin_yn";
	String TRIGGER_action_type                              = "action_type";                        // [DETECT|EXPIRE]
	String TRIGGER_period                                   = "period";                             // int
	String TRIGGER_period_unit                              = "period_unit";                        // [DAY|HOUR|MINUTE|SECOND]
	String TRIGGER_wiring                                   = "wiring";
	String TRIGGER_wiring_field                             = "field";
	String TRIGGER_wiring_value                             = "value";
	String TRIGGER_wiring_operator                          = "operator";
	String TRIGGER_wiring_description                       = "description";
	String TRIGGER_detect                                   = "detect";
	String TRIGGER_detect_field                             = "field";
	String TRIGGER_detect_value                             = "value";
	String TRIGGER_detect_operator                          = "operator";
	String TRIGGER_detect_description                       = "description";
	
	String CUSTOM_dimension                                 = "dimension";
	String CUSTOM_metric                                    = "metric";
	String CUSTOM_filter                                    = "filter";
	
}
