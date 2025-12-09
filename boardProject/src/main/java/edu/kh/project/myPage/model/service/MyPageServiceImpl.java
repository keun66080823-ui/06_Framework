package edu.kh.project.myPage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	// 회원 정보 수정
	@Override
	public int updateInfo(Member inputMember, String[] memberAddress) {
		
		// 입력된 주소가 있을 경우
		// A^^^B^^^C 형태로 가공
		
		// 주소가 입력되었을 때
		if(!inputMember.getMemberAddress().equals(",,")) {
			String address = String.join("^^^", memberAddress); // ^^^을 이용해 나눠진 주소들을 하나의 값으로 합침
			inputMember.setMemberAddress(address);
			
		} else {
			// 주소가 입력되지 않았을 때
			inputMember.setMemberAddress(null);
		}
		
		// inputMember : 수정 닉네임, 수정 전화번호, 수정 주소,
		//				 회원 번호
		
		
		return mapper.updateInfo(inputMember);
	}
	
	// 비밀번호 변경
	@Override
	public int chagePw(String currentPw, String newPw, int memberNo) {
		// 1. DB에 저장된 암호화 PW 조회
		String pw = mapper.selectPw(memberNo);
		// 2. 현재 PW(평문) vs 암호문 비교
		
		// 3. 새 PW 암호화(bcrypt.encode)
		
		// 4. DB PW 업데이트(mapper 인터페이스에 기능 추가)
		
		// 암호화된 새 비번과 회원번호 리턴
		
		return 0;
	}
		

	
	// 암호화된 비번 조회(mapper 인터페이스에 회원번호 넘기는 걸로 비번 조회)

}
