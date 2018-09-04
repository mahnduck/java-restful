package com.mahnduck.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Service;

import com.mahnduck.domain.BoardVO;
import com.mahnduck.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		boardDAO.create(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return boardDAO.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		boardDAO.update(board);

	}

	@Override
	public int remove(Integer bno) throws Exception {
		return boardDAO.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDAO.listAll();
	}

}
