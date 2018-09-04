package com.mahnduck.persistence;

import java.util.List;

import com.mahnduck.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public int delete (Integer bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	
}
