package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.FavoriteDTO;
import com.dto.PostDTO;

public class FavoriteDAO {

	public List<PostDTO> favoriteList(SqlSession session, String userid) {
		List<PostDTO> list = session.selectList("FavoriteMapper.favoriteList", userid);
		return list;
	}

	public FavoriteDTO getFavorite(SqlSession session, FavoriteDTO dto) {
		FavoriteDTO returnDTO = session.selectOne("FavoriteMapper.getFavorite", dto);
		return returnDTO;
	}

	public int insertFavoite(SqlSession session, FavoriteDTO dto) {
		return session.insert("FavoriteMapper.insertFavoite",dto);
	}

	public int deleteFavoite(SqlSession session, FavoriteDTO dto) {
		return session.delete("FavoriteMapper.deleteFavoite",dto);
	}

	public int favoriteDel(SqlSession session, int num) {
		int n = session.delete("FavoriteMapper.favoriteDel", num);
		return n;
	}

	public int favoriteAllDel(SqlSession session, List<String> list) {
		int n = session.delete("FavoriteMapper.favoriteAllDel", list);
		return n;
	}

	public int getFavoriteCountByPNum(SqlSession session, int pNum) {
		int n = session.selectOne("FavoriteMapper.getFavoriteCountByPNum", pNum);
		return n;
	}
}
