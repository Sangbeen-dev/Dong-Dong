package com.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.dto.PostDTO;

public class PostDAO {

   public List<PostDTO> goodsList(SqlSession session, String gCategory) {
	   List<PostDTO> list = 
			   session.selectList("PostMapper.PostList", gCategory);
	   return list;
   }
}
