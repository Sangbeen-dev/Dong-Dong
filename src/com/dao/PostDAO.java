package com.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.PostDTO;

public class PostDAO {

   public List<PostDTO> postList(SqlSession session, String pCategory) {
	   List<PostDTO> list = 
			   session.selectList("PostMapper.PostList", pCategory);
	   return list;
   }
   
   
   public HashMap<String, String> getPostDetailByPNum(SqlSession session, int pNum) {
	   HashMap<String, String> map = session.selectOne("PostMapper.getPostDetailByPNum", pNum);
	   return map;
   }


   public List<PostDTO> recentList(SqlSession session, String pDate) {
	List<PostDTO> list = 
			   session.selectList("PostMapper.recentList", pDate);
	   return list;
}
}
