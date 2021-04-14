package com.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.PostDTO;

public class PostDAO {

   public List<PostDTO> postList(SqlSession session, String pCategory) {
	   List<PostDTO> list = 
			   session.selectList("PostMapper.PostList", pCategory);
	   return list;
   }
}
