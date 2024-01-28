package kr.co.shield.service.inf;

import java.util.Map;

public interface AuthService {
	
	public String verify(String token);
	
	public Map<String, Object> getAdminClaims(int adminSeq) throws Exception;
	
	public Map<String, Object> getClientClaims(String adminId, int clientSeq) throws Exception;
	
}
