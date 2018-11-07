package org.injae.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.injae.domain.MemberVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class CustomUser extends User {
	
	private MemberVO vo;
	
	public CustomUser(MemberVO vo) {
		this(vo.getUserid(), vo.getUserpw(), true, true, true, true,
				vo.getAuthList().stream()
				.map(auth-> new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		
		this.vo = vo;
	}

	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

}
