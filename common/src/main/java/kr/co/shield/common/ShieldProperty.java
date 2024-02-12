package kr.co.shield.common;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.RandomStringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class ShieldProperty {
	
	public static final long MILLISECOND_FOR_SECOND                                                 = 1_000L;
	public static final long MILLISECOND_FOR_MINUTE                                                 = MILLISECOND_FOR_SECOND * 60;
	public static final long MILLISECOND_FOR_HOUR                                                   = MILLISECOND_FOR_MINUTE * 60;
	public static final long MILLISECOND_FOR_DAY                                                    = MILLISECOND_FOR_HOUR * 24;
	public static final long MILLISECOND_FOR_WEEK                                                   = MILLISECOND_FOR_DAY * 7;
	public static final long MILLISECOND_FOR_MONTH                                                  = MILLISECOND_FOR_DAY * 30;
	public static final long MILLISECOND_FOR_YEAR                                                   = MILLISECOND_FOR_DAY * 365;
	
	public static final long SECOND_FOR_MINUTE                                                      = 60L;
	public static final long SECOND_FOR_HOUR                                                        = SECOND_FOR_MINUTE * 60;
	public static final long SECOND_FOR_DAY                                                         = SECOND_FOR_HOUR * 24;
	public static final long SECOND_FOR_WEEK                                                        = SECOND_FOR_DAY * 7;
	public static final long SECOND_FOR_MONTH                                                       = SECOND_FOR_DAY * 30;
	public static final long SECOND_FOR_YEAR                                                        = SECOND_FOR_DAY * 365;
	
	// security
	public static final String SPRINGDOC_SECURITY_DESCRIPTION                                       = "Set authorization";
	public static final String SPRINGDOC_SECURITY_FORMAT                                            = "JWT";
	public static final String SPRINGDOC_SECURITY_NAME                                              = "x-authorization";
	public static final String SPRINGDOC_SECURITY_SCHEME                                            = "Bearer";
	
	public static final String JWT_HEADER_algorithm                                                 = "alg";
	public static final String JWT_HEADER_key_id                                                    = "kid";
	public static final String JWT_HEADER_type                                                      = "typ";
	public static final String JWT_PAYLOAD_issuer                                                   = "iss";
	public static final String JWT_PAYLOAD_issued_at                                                = "iat";
	public static final String JWT_PAYLOAD_expiration                                               = "exp";
	public static final String JWT_PAYLOAD_subject                                                  = "sub";
	public static final String JWT_PAYLOAD_claim_client                                             = "cus";
	public static final String JWT_PAYLOAD_claim_roles                                              = "roles";
	
	public static final String JWT_HEADER_typ_JWT                                                   = "JWT";
	public static final String JWT_PAYLOAD_issuer_bizspring                                         = "bizspring";
	public static final String JWT_PAYLOAD_issuer_growthplatform                                    = "growthplatform";
	
	// W/O user
	public static final String TKN_AGENCY                                                           = "TOKEN_AGENCY";
	
	// ROLE_, PRIVILEGE_
	public static final String TKN_AUTHORITY                                                        = "TOKEN_AUTHORITY";
	
	// Openfeign
	public static final String TKN_AUTH                                                             = "TOKEN_AUTH";
	
	public static final String TKN_USER                                                             = "TOKEN_USER";
	public static final String TKN_USER_AGENCY                                                      = "TOKEN_USER_AGENCY";
	public static final String TKN_USER_ADMIN                                                       = "TOKEN_USER_ADMIN";
	public static final String TKN_USER_CLIENT                                                      = "TOKEN_USER_CLIENT";
	public static final String TKN_USER_TEAM                                                        = "TOKEN_USER_TEAM";
	
	public static final String RK_CURRENT_APP                                                       = "RK_CURRENT_APP";
	public static final String RK_CURRENT_GROUP                                                     = "RK_CURRENT_GROUP";
	public static final String RK_CURRENT_VIEW                                                      = "RK_CURRENT_VIEW";
	
	public static final String RK_RESPONSE_SUCCESS                                                  = "SUCCESS";
	public static final String RK_RESPONSE_FAILURE                                                  = "FAILURE";
	
	public static final String RK_AUTHORIZATION_BEARER                                              = "Bearer ";
	public static final String RK_AUTHORIZATION_COOKEN_refreshToken                                 = "refreshToken";
	public static final String RK_AUTHORIZATION_HEADER_AGENCY                                       = "x-authorization-agency";
	public static final String RK_AUTHORIZATION_HEADER_ROLE                                         = "x-authorization-role";
	public static final String RK_AUTHORIZATION_HEADER_USER                                         = "x-authorization-user";
	// Remove. Convert attribute (HttpOnly; SameSite; Secure;)
	@Deprecated
	public static final String RK_AUTHORIZATION_KEY_COOKIE                                          = "_token";
	public static final String RK_AUTHORIZATION_KEY_HEADER                                          = "x-authorization";
	public static final String RK_AUTHORIZATION_KEY_PARAMETER                                       = "_token";
	
	public static final String RK_CK_Domain                                                         = "localhost";
	public static final String RK_CK_HttpOnly                                                       = "HttpOnly";
	public static final String RK_CK_SameSite                                                       = "SameSite";
	public static final String RK_CK_Secure                                                         = "Secure";
	public static final String RK_CK_SameSite_Strict                                                = "Strict";
	public static final String RK_CK_SameSite_Lax                                                   = "Lax";
	public static final String RK_CK_SameSite_None                                                  = "None";
	
	public static final String RK_DELIMITER_HTTP_STATUS                                             = "#_#";
	
	public static final String RK_DB_TYPE_bigquery                                                  = "bigquery";
	public static final String RK_DB_TYPE_elasticsearch                                             = "elastic";
	public static final String RK_DB_TYPE_mysql                                                     = "mysql";
	
	// app alias
	public static final String APP_CODE_AIR                                                         = "AIR";
	public static final String APP_CODE_ALARM                                                       = "ALARM";
	public static final String APP_CODE_UTIL                                                        = "UTIL";
	public static final String APP_CODE_TAM                                                         = "TAM";
	public static final String APP_CODE_CXM                                                         = "CXM";
	public static final String APP_CODE_CPN                                                         = "CPN";
	public static final String APP_CODE_CTS                                                         = "CTS";
	public static final String APP_CODE_LOGGER                                                      = "LOGGER";
	public static final String APP_CODE_LOGGERS                                                     = "LOGGERS";
	public static final String APP_CODE_FRAUD                                                       = "FRAUD";
	public static final String APP_CODE_VIRAL                                                       = "VIRAL";
	public static final String APP_CODE_SMARD                                                       = "SMARD";
	public static final String APP_CODE_RTIME                                                       = "RTIME";
	public static final String APP_CODE_AILAB                                                       = "AILAB";
	public static final String APP_CODE_ADMON                                                       = "ADMON";
	
	// authority
	public static final String RK_AUTHORITY_ROLE                                                    = "ROLE_";
	public static final String RK_AUTHORITY_PRIVILEGE                                               = "PRIVILEGE_";
	
	// application
	public static final String RK_DELIMITER_ARRAY                                                   = "#_#";
	public static final String RK_DELIMITER_ITEM                                                    = "__#__";
	public static final String RK_DELIMITER_KEY                                                     = "__#__";
	
	// product
	public static final String RK_PRODUCT_PLAN                                                      = "plan";
	public static final String RK_PRODUCT_ACCOUNT                                                   = "account";
	public static final String RK_PRODUCT_AUDIENCE                                                  = "audience";
	public static final String RK_PRODUCT_PROFILE                                                   = "profile";
	public static final String RK_PRODUCT_SEGMENT                                                   = "segment";
	public static final String RK_PRODUCT_TRAFFIC                                                   = "traffic";
	
	public static final String RK_RESULT_Y                                                          = "Y";
	public static final String RK_RESULT_N                                                          = "N";
	public static final String RK_RESULT_P                                                          = "P";
	
	public static final String RK_MSG_SUCCESS                                                       = RK_RESULT_Y + "#_#";
	public static final String RK_MSG_FAILURE                                                       = RK_RESULT_N + "#_#";
	public static final String RK_MSG_PASS                                                          = RK_RESULT_P + "#_#";
	
	// path
	public static final String RK_REFINER_PATH_UPLOAD                                               = "upload";
	public static final String RK_REFINER_PATH_UPLOAD_account_bulk                                  = "/account_bulk/";
	public static final String RK_REFINER_PATH_UPLOAD_account_stat                                  = "/account_stat/";
	public static final String RK_REFINER_PATH_UPLOAD_keyword_util                                  = "/keyword_util/";
	public static final String RK_REFINER_PATH_UPLOAD_profile_photo                                 = "/profile_photo/";

	public static final String RK_REFINER_PATH_UPLOAD_issue_photo                                   = "/issue_photo/";
	public static final String[] RK_REFINER_PATH_UPLOADS                                            = { RK_REFINER_PATH_UPLOAD_account_bulk, RK_REFINER_PATH_UPLOAD_account_stat, RK_REFINER_PATH_UPLOAD_keyword_util, RK_REFINER_PATH_UPLOAD_profile_photo, RK_REFINER_PATH_UPLOAD_issue_photo };
	
	// supplier
	public static final String RK_SUPPLIER_prefix                                                   = "gp_";
	public static final String RK_SUPPLIER_admin_id                                                 = "adminId";                            //
	public static final String RK_SUPPLIER_admin_pw                                                 = "adminPw";                            // enc_admin_pw
	public static final String RK_SUPPLIER_admin_nm                                                 = "adminNm";                            //
	public static final String RK_SUPPLIER_admin_seq                                                = "adminSeq";                           //
	public static final String RK_SUPPLIER_agency_nm                                                = "agencyNm";                           //
	public static final String RK_SUPPLIER_agency_seq                                               = "agencySeq";                          //
	public static final String RK_SUPPLIER_app_code                                                 = "appCode";                            //
	public static final String RK_SUPPLIER_auth                                                     = "auth";                               //
	public static final String RK_SUPPLIER_client_id                                                = "clientId";                           // client_seq
	public static final String RK_SUPPLIER_client_pw                                                = "clientPw";                           // enc_client_seq
	public static final String RK_SUPPLIER_client_seq                                               = "clientSeq";                          //
	public static final String RK_SUPPLIER_contract                                                 = "contract";                           // enc_contract
	public static final String RK_SUPPLIER_profile_nm                                               = "profileNm";                          //
	public static final String RK_SUPPLIER_role_nm                                                  = "roleNm";                             //
	public static final String RK_SUPPLIER_site_url                                                 = "siteUrl";                            //
	
	// media
	public static final String RK_KEY_MEDIA_GOOGLE_Ad                                               = "Ad";
	public static final String RK_KEY_MEDIA_GOOGLE_AdStat                                           = "AdStat";
	public static final String RK_KEY_MEDIA_GOOGLE_Asset                                            = "Asset";
	public static final String RK_KEY_MEDIA_GOOGLE_AssetStat                                        = "AssetStat";
	public static final String RK_KEY_MEDIA_GOOGLE_CombineAdAsset                                   = "CombineAdAsset";
	public static final String RK_KEY_MEDIA_GOOGLE_CombineGroupAsset                                = "CombineGroupAsset";
	public static final String RK_KEY_MEDIA_GOOGLE_Campaign                                         = "Campaign";
	public static final String RK_KEY_MEDIA_GOOGLE_Criterion                                        = "Criterion";
	public static final String RK_KEY_MEDIA_GOOGLE_Custom                                           = "Custom";
	public static final String RK_KEY_MEDIA_GOOGLE_Group                                            = "Group";
	public static final String RK_KEY_MEDIA_GOOGLE_KeywordStat                                      = "KeywordStat";
	public static final String RK_KEY_MEDIA_GOOGLE_VideoStat                                        = "VideoStat";
	
	// report
	public static final String RK_KEY_REPORT_LOOKUP                                                 = "lookup";
	public static final String RK_KEY_REPORT_LOOKUP_AGG                                             = "agg";
	public static final String RK_KEY_REPORT_LOOKUP_RAW                                             = "raw";
	public static final String RK_KEY_REPORT_DIMENSION                                              = "dimension";
	public static final String RK_KEY_REPORT_METRICS                                                = "metrics";
	public static final String RK_KEY_REPORT_SEARCH_AFTER                                           = "search_after";
	public static final String RK_KEY_REPORT_EXCLUDE                                                = "exclude";
	public static final String RK_KEY_REPORT_MISSING                                                = "missing";
	public static final String RK_KEY_REPORT_PARTS                                                  = "parts";
	public static final String RK_KEY_REPORT_FIELD                                                  = "field";
	public static final String RK_KEY_REPORT_ATTR                                                   = "attr";
	public static final String RK_KEY_REPORT_ATTR_FIRST                                             = "first";
	public static final String RK_KEY_REPORT_ATTR_LAST                                              = "last";
	public static final String RK_KEY_REPORT_ATTR_TIME                                              = "time";
	public static final String RK_KEY_REPORT_ATTR_EACH                                              = "each";
	public static final String RK_KEY_REPORT_ATTR_LINEAR                                            = "linear";
	
	public static final String RK_KEY_REPORT_DOC_SIZE                                               = "doc_size";
	public static final String RK_KEY_REPORT_DOC_COUNT                                              = "_count";
	public static final String RK_KEY_REPORT_SOURCE                                                 = "source";
	public static final String RK_KEY_REPORT_FILTER                                                 = "filter";
	public static final String RK_KEY_REPORT_SORT                                                   = "sort";
	public static final String RK_KEY_REPORT_SORT_IDX                                               = "sort_idx";
	public static final String RK_KEY_REPORT_SIZE                                                   = "size";
	
	public static final String RK_KEY_REPORT_FILTER_NOT                                             = "__NE__";                             // key prefix
	public static final String RK_KEY_REPORT_FILTER_LIKE                                            = "__LIKE__";                           // value prefix QueryBuilders.prefixQuery
	public static final String RK_KEY_REPORT_FILTER_WILD                                            = "__WILD__";                           // value prefix QueryBuilders.wildcardQuery
	
	public static final String RK_KEY_REPORT_QUERY_OPER_EQUAL                                       = "EQUAL";
	public static final String RK_KEY_REPORT_QUERY_OPER_LIKE                                        = "LIKE";
	public static final String RK_KEY_REPORT_QUERY_OPER_WILD                                        = "WILD";
	
	public static final String RK_KEY_REPORT_QUERY_OPER_GT                                          = "GT";
	public static final String RK_KEY_REPORT_QUERY_OPER_GTE                                         = "GTE";
	public static final String RK_KEY_REPORT_QUERY_OPER_LT                                          = "LT";
	public static final String RK_KEY_REPORT_QUERY_OPER_LTE                                         = "LTE";
	public static final String RK_KEY_REPORT_QUERY_OPER_GT_LT                                       = "GT_LT";
	public static final String RK_KEY_REPORT_QUERY_OPER_GT_LTE                                      = "GT_LTE";
	public static final String RK_KEY_REPORT_QUERY_OPER_GTE_LT                                      = "GTE_LT";
	public static final String RK_KEY_REPORT_QUERY_OPER_GTE_LTE                                     = "GTE_LTE";
	public static final String RK_KEY_REPORT_QUERY_OPER_BETWEEN                                     = "BETWEEN";
	
	public static final String RK_KEY_REPORT_FIELD_OPER_AVERAGE                                     = "AVG";
	public static final String RK_KEY_REPORT_FIELD_OPER_CARDINALITY                                 = "CDN";
	public static final String RK_KEY_REPORT_FIELD_OPER_COUNT                                       = "CNT";
	public static final String RK_KEY_REPORT_FIELD_OPER_DIVISION                                    = "DIV";
	public static final String RK_KEY_REPORT_FIELD_OPER_DOC_COUNT                                   = "DCNT";
	public static final String RK_KEY_REPORT_FIELD_OPER_MAXIMUM                                     = "MAX";
	public static final String RK_KEY_REPORT_FIELD_OPER_MINIMUM                                     = "MIN";
	public static final String RK_KEY_REPORT_FIELD_OPER_SUMMARY                                     = "SUM";
	public static final List<String> RK_KEY_REPORT_FIELD_OPERATIONS = List.of(
			RK_KEY_REPORT_FIELD_OPER_AVERAGE,
			RK_KEY_REPORT_FIELD_OPER_CARDINALITY,
			RK_KEY_REPORT_FIELD_OPER_COUNT,
			RK_KEY_REPORT_FIELD_OPER_DIVISION,
			RK_KEY_REPORT_FIELD_OPER_DOC_COUNT,
			RK_KEY_REPORT_FIELD_OPER_MAXIMUM,
			RK_KEY_REPORT_FIELD_OPER_MINIMUM,
			RK_KEY_REPORT_FIELD_OPER_SUMMARY
	);
	public static final List<String> RK_KEY_REPORT_FIELD_SIGNS = List.of(
			"+",
			"-",
			"*",
			"/",
			"(",
			")"
	);
	
	public static String HOSTNAME;
	public static final Gson GSON;
	public static final Locale LOCALE;
	
	public static final DateTimeFormatter DT_FORMATTER;
	
	static {
		try {
			HOSTNAME = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} finally {
			if (HOSTNAME == null)
				HOSTNAME = RandomStringUtils.randomAlphabetic(4);
		}
		
		GSON = new GsonBuilder()
				.disableHtmlEscaping()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.setDateFormat(String.format("%s", "yyyy-MM-dd HH:mm:ss"))
				.create();
		LOCALE = Locale.KOREA;
		DT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault());
	}
	
}

/**
 * 스프링 부트 3.0 으로 전환
 * https://post.dooray.io/we-dooray/tech-insight-ko/back-end/4173/
 * [JAVA] DTO와 VO의 차이
 * https://maenco.tistory.com/entry/Java-DTO%EC%99%80-VO%EC%9D%98-%EC%B0%A8%EC%9D%B4
 * [Spring] 공통 response DTO 만들기
 * https://velog.io/@jomminii/spring-common-response-dto
 * SpringBoot + JWT + Security + JPA 인증 구현, JWT란?
 * https://aljjabaegi.tistory.com/659
 * [Java] Spring Boot Security 이해하기 -4: JWT 환경 설정 및 구성 하기
 * https://adjh54.tistory.com/94
 */
