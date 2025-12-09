package edu.kh.project.myPage.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	/** 회원 정보 수정 SQL
	 * @param inputMember
	 * @return
	 */
	int updateInfo(Member inputMember);

	// 암호화된 비밀번호 조회
	String selectPw(int memberNo);


	
	// 비번 변경

	
	

}
