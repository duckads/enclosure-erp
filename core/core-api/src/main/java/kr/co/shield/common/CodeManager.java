package kr.co.shield.common;

import jakarta.annotation.PostConstruct;
import kr.co.shield.repository.CodeDtlRepository;
import kr.co.shield.repository.CodeRepository;

import kr.co.shield.domain.Code;
import kr.co.shield.domain.CodeDtl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class CodeManager {
	
	private final CodeRepository codeRepository;
	private final CodeDtlRepository codeDtlRepository;
	
	private static Map<String, String> aliasMap;
	private static Map<String, List<String>> codeMap;
	private static Map<String, List<String>> codeSub;
	
//	private static final int IDX_CODE   = 0;
	private static final int IDX_ALIAS  = 1;
	private static final int IDX_NAME   = 2;
	private static final int IDX_DESC   = 3;
	
	@PostConstruct
	private void init() {
		aliasMap = new HashMap<>();
		codeMap = new HashMap<>();
		codeSub = new HashMap<>();
		
		List<Code> codes = this.codeRepository.findAll();
		for (Code code : codes) {
			String cdNo = code.getCdNo();
			String cdAlias = code.getCdAlias();
			String cdName = code.getCdNm();
			String cdDesc = code.getCdDesc();
			
			aliasMap.put(cdAlias, cdNo);
			codeMap.put(cdNo, List.of(cdNo, cdAlias, cdName, cdDesc));
		}
		
		List<CodeDtl> codeDtls = this.codeDtlRepository.findAll();
		for (CodeDtl codeDtl : codeDtls) {
			String dtlNo = codeDtl.getCdDtlNo();
			String dtlAlias = codeDtl.getCdDtlAlias();
			String dtlName = codeDtl.getCdDtlNm();
			String dtlDesc = codeDtl.getCdDtlDesc();
			String cdNo = codeDtl.getCdNo();
			
			aliasMap.put(dtlAlias, dtlNo);
			codeMap.put(dtlNo, List.of(dtlNo, dtlAlias, dtlName, dtlDesc));
			
			List<String> dtlNos = null;
			if (codeSub.containsKey(cdNo)) {
				dtlNos = codeSub.get(cdNo);
			} else {
				dtlNos = new ArrayList<>();
				codeSub.put(cdNo, dtlNos);
			}
			dtlNos.add(dtlNo);
		}
		
		log.info("CodeManager is loaded.");
	}
	
	public static List<String> codes(String code) {
		List<String> rtn = null;
		if (codeSub != null && codeSub.containsKey(code)) {
			rtn = codeSub.get(code);
		} else {
			rtn = Collections.emptyList();
		}
		return rtn;
	}
	
	public static String code(String alias) {
		String rtn = "";
		if (aliasMap != null && aliasMap.containsKey(alias)) {
			rtn = aliasMap.get(alias);
		}
		return rtn;
	}
	public static String alias(String code) {
		String rtn = "";
		if (codeMap != null && codeMap.containsKey(code)) {
			rtn = codeMap.get(code).get(IDX_ALIAS);
		}
		return rtn;
	}
	public static String desc(String code) {
		String rtn = "";
		if (codeMap != null && codeMap.containsKey(code)) {
			rtn = codeMap.get(code).get(IDX_DESC);
		}
		return rtn;
	}
	public static String name(String code) {
		String rtn = "";
		if (codeMap != null && codeMap.containsKey(code)) {
			rtn = codeMap.get(code).get(IDX_NAME);
		}
		return rtn;
	}
	
}

