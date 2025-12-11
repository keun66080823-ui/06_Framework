package edu.kh.project.myPage.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.dto.UploadFile;

@Mapper
public interface MyPageMapper {

	/** 회원 정보 수정 SQL
	 * @param inputMember
	 * @return
	 */
	int updateInfo(Member inputMember);

	/**암호화된 비밀번호 조회 SQL
	 * @param memberNo
	 * @return
	 */
	String selectPw(int memberNo);

	/** 비밀번호 변경 SQL
	 * @param newEncryptedPw
	 * @param memberNo
	 * @return
	 */
	int updatePw(String newEncryptedPw, int memberNo);

	/** 회원 탈퇴 SQL (update)
	 * @param memberNo
	 * @return
	 */
	int secession(int memberNo);

	/** 파일 정보를 DB에 삽입 SQL (insert)
	 * @param uf
	 * @return
	 */
	int insertUploadFile(UploadFile uf);

	/** 파일 목록 조회하는 SQL
	 * @param memberNo
	 * @return
	 */
	List<UploadFile> fileList(int memberNo);

	/** 프로필 이미지를 변경하는 SQL
	 * @param member
	 * @return
	 */
	int profile(Member member);
	


	
	
	
	

}
