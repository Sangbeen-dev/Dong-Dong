package com.dao;

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
		System.out.println("DAO의 insert -> "+n);
		return n;
	}
	public int updatePost(SqlSession session, PostDTO dto) {
		return session.update("PostMapper.updatePost",dto);
	}




}
