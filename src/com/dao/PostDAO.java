package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.PageDTO;
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



	public PageDTO searchByKeyword(SqlSession session, HashMap<String, String> map,int curPage) {
		PageDTO pDTO = new PageDTO();//List, curPage, totalCount, perPage
		int perPage = 16;//db에서 몇개를 읽어올지
		int offset = (curPage-1)*perPage;//db레코드 select 시작번호
		List<PostDTO> list = session.selectList("PostMapper.searchByKeyword", map,new RowBounds(offset,perPage));
		pDTO.setPerPage(perPage);//한페이지당 페이지 개수
		pDTO.setCurPage(curPage);//현재페이지
		pDTO.setOffset(offset);//시작페이지
		pDTO.setList(list);//0~15 16개
		pDTO.setTotalCount(totalCountKeyword(session,map));//전체 레코드 갯수
		
		//PDTO에 모든 데이터 저장완료
		return pDTO;
		
	}	

	public List<PostDTO> mypostList(SqlSession session, String userid) {
		List<PostDTO> list = session.selectList("PostMapper.mypostList", userid);
		return list;
	}

	public int postAllDel(SqlSession session, List<String> list) {
		int n = session.delete("PostMapper.postAllDel", list);
		return n;
	}


	public PageDTO searchByCategory(SqlSession session, HashMap<String, String> map,int curPage) {
		PageDTO pDTO = new PageDTO();//List, curPage, totalCount, perPage
		int perPage = 16;//db에서 몇개를 읽어올지
		int offset = (curPage-1)*perPage;//db레코드 select 시작번호
		List<PostDTO> list = session.selectList("PostMapper.searchByCategory", map,new RowBounds(offset,perPage));
		pDTO.setPerPage(perPage);//한페이지당 페이지 개수
		pDTO.setCurPage(curPage);//현재페이지
		pDTO.setOffset(offset);//시작페이지
		pDTO.setList(list);//0~15 16개
		pDTO.setTotalCount(totalCountCategory(session,map));//전체 레코드 갯수
		//PDTO에 모든 데이터 저장완료
		return pDTO;
	}

	public int totalCount(SqlSession session,String addr) {
		return session.selectOne("totalCount",addr);
	}
	
	public int totalCountKeyword(SqlSession session,HashMap<String, String> map) {
		return session.selectOne("totalCountKeyword",map);
	}
	
	public int totalCountCategory(SqlSession session,HashMap<String, String> map) {
		return session.selectOne("totalCountCategory",map);
	}
	public PageDTO selectAllPostPage(SqlSession session, int curPage,boolean login,String addr) {
		
		
		PageDTO pDTO = new PageDTO();//List, curPage, totalCount, perPage
		int perPage = 16;//db에서 몇개를 읽어올지
		int offset = (curPage-1)*perPage;//db레코드 select 시작번호
		List<PostDTO> list = session.selectList("postListAll",null,new RowBounds(offset,perPage));
		//최초 offset=0, perPage=16
		//데이터를 주고 받는 것 PageDTO
		if(login) { 
			list = session.selectList("postListByAddr",addr,new RowBounds(offset,perPage));
		}else {
			list = session.selectList("postListAll",null,new RowBounds(offset,perPage));
		}
		pDTO.setPerPage(perPage);//한페이지당 페이지 개수
		pDTO.setCurPage(curPage);//현재페이지
		pDTO.setOffset(offset);//시작페이지
		pDTO.setList(list);//0~15 16개
		pDTO.setTotalCount(totalCount(session,addr));//전체 레코드 갯수
		
		//PDTO에 모든 데이터 저장완료
		return pDTO;
		
		
	}

	public int pullPost(SqlSession session, int pNum) {
		return session.update("PostMapper.pullPost",pNum);
	}


	public int poststatus(SqlSession session, int pNum) {
		int n = session.update("PostMapper.poststatus", pNum);
		return n;
	}


}
