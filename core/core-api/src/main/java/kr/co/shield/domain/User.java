package kr.co.shield.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String adminId;
	private String adminPw;
	private String adminNm;
	private String actSt;
	
	private List<String> roles;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = this.roles.stream()
				.map(r -> new SimpleGrantedAuthority(r))
				.collect(Collectors.toList());
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return adminPw;
	}
	
	@Override
	public String getUsername() {
		return adminId;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return actSt.equals("201001");
	}
	
}
