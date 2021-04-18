package com.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.PostDTO;

public class PostDAO {

   public List<PostDTO> postListByAddr(SqlSession session, String addr) {
	   System.out.println("addr 마지막단 ===="+addr);
	   List<PostDTO> list = session.selectList("PostMapper.postListByAddr", addr);
	   return list;
   }
   
   
   public PostDTO getPostByPNum(SqlSession session, int pNum) {
	   PostDTO dto = session.selectOne("PostMapper.getPostByPNum", pNum);
	   return dto;
   }

  

   public List<PostDTO> postListAll(SqlSession session) {
	   List<PostDTO> list = session.selectList("PostMapper.postListAll");
	   System.out.println("DAO의 postListAll->"+list);
	   return list;
   }




}
