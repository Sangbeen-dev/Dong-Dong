package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.PostDTO;

public class PostDAO {

   public List<PostDTO> postListByAddr(SqlSession session, String addr) {
	   List<PostDTO> list = session.selectList("PostMapper.postListByAddr", addr);
	   return list;
   }
   
   
   public PostDTO getPostByPNum(SqlSession session, int pNum) {
	   PostDTO dto = session.selectOne("PostMapper.getPostByPNum", pNum);
	   return dto;
   }



   public List<PostDTO> recentList(SqlSession session, String pDate) {
	List<PostDTO> list = 
			   session.selectList("PostMapper.recentList", pDate);
	   return list;
   }

   public List<PostDTO> postListAll(SqlSession session) {
	   List<PostDTO> list = session.selectList("PostMapper.postListAll");
	   return list;
   }


	public int deletePostByPNum(SqlSession session, int pNum) {
		return session.delete("PostMapper.deletePostByPNum",pNum);
	}


	public int newPost(SqlSession session, PostDTO post) {
		int n = session.insert("PostMapper.newPost", post);
		return n;
	}
	public int updatePost(SqlSession session, PostDTO dto) {
		return session.update("PostMapper.updatePost",dto);
	}


	public int updatePHit(SqlSession session, PostDTO dto) {
		return session.update("PostMapper.updatePHit",dto);
	}



	public List<PostDTO> searchByKeyword(SqlSession session, String keyword) {
		List<PostDTO> list = session.selectList("PostMapper.searchByKeyword", keyword);
		return list;
	}	

	public List<PostDTO> mypostList(SqlSession session, String userid) {
		List<PostDTO> list = session.selectList("PostMapper.mypostList", userid);
		return list;
	}

	public int postAllDel(SqlSession session, List<String> list) {
		int n = session.delete("PostMapper.postAllDel", list);
		return n;
	}


}
