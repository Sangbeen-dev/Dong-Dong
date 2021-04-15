package com.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.PostDTO;

public class PostDAO {

   public List<PostDTO> postListByAddr(SqlSession session, String addr) {
	   List<PostDTO> list = session.selectList("PostMapper.postListByAddr", addr);
	   return list;
   }
   
   
   public HashMap<String, String> getPostDetailByPNum(SqlSession session, int pNum) {
	   HashMap<String, String> map = session.selectOne("PostMapper.getPostDetailByPNum", pNum);
	   return map;
   }


<<<<<<< HEAD
   public List<PostDTO> recentList(SqlSession session, String pDate) {
	List<PostDTO> list = 
			   session.selectList("PostMapper.recentList", pDate);
	   return list;
}
=======
   public List<PostDTO> postListAll(SqlSession session) {
	   List<PostDTO> list = session.selectList("PostMapper.postListAll");
	   System.out.println("DAO의 postListAll->"+list);
	   return list;
   }



>>>>>>> fe8d71e00738aab8488e0e1706f330d5dc1ebfd5
}
