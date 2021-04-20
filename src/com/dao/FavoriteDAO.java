package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.FavoriteDTO;
import com.dto.PostDTO;

public class FavoriteDAO {

	public List<FavoriteDTO> favoriteList(SqlSession session, String userid) {
		List<FavoriteDTO> list = session.selectList("FavoriteMapper.favoriteList", userid);
		return list;
	}

	public int deleteFavoriteByPNum(SqlSession session, int pNum) {
		return session.delete("FavoriteMapper.deleteFavoriteByPNum",pNum);
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

	public int updateFavoriteByPost(SqlSession session, PostDTO dto) {
		return session.update("FavoriteMapper.updateFavoriteByPost",dto);
	}

}
