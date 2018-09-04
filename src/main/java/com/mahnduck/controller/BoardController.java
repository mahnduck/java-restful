package com.mahnduck.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mahnduck.domain.BoardVO;
import com.mahnduck.service.BoardService;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService service;

	
	// refer to https://viralpatel.net/blogs/spring-4-mvc-rest-example-json/
	
	@GetMapping("/board/index.do")
//	@RequestMapping(value = "/board/index.do", method = RequestMethod.GET)
	public String home() {
		logger.info("This is home...");
		return "home";
		//return "redirect:/board/listAll.do";
	}

	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get...");
	}

	@PostMapping(value = "/board/register")	
	public ResponseEntity registerPOST(@RequestBody BoardVO board) throws Exception {
		logger.info("register post...");
		System.out.println(board);
		//isExisting 확인해야 하지만, 화면이 있으면 구지?
		service.regist(board);
		return new ResponseEntity(board, HttpStatus.OK);
	//	model.addAttribute("msg", "SUCCESS");
//		return "http://localhost:3000/NoticeList";

	}

	@GetMapping("/board/listAll")
	public ResponseEntity listAll() throws Exception {
		logger.info("show all list...");
		List<BoardVO> list = service.listAll();
		return new ResponseEntity<List<BoardVO>>(list, HttpStatus.OK);		
	}
/*
	@RequestMapping(value = "/board/read.do", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}
*/
	
	@GetMapping("/board/read/{bno}")
	public ResponseEntity read(@PathVariable("bno") int bno) throws Exception {
		BoardVO vo = service.read(bno);
		if (vo == null) {
			return new ResponseEntity("No Customer found for ID " + bno, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(vo, HttpStatus.OK);	
	}

	@PutMapping("/board/update/")
	public ResponseEntity modify(@RequestBody BoardVO board) throws Exception {
		logger.info("update started");
		bno: this.state.bno,
        writer: this.state.writer,
        viewcnt: this.state.viewcnt,
        content: this.state.content,
        regdate: this.state.regdate,
        title: this.state.title		service.modify(board);
		return new ResponseEntity("Update is done,", HttpStatus.OK);
	}
	@DeleteMapping("/board/remove/{bno}")
	public ResponseEntity remove(@PathVariable("bno") int bno) throws Exception {

		int result = service.remove(bno);
		logger.info("Result of query: "+String.valueOf(result));
		if (result != 1) {
			return new ResponseEntity("Fail to delete " + bno, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity (bno + " is deleted.", HttpStatus.OK);
		
/*
		if (null == customerDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);
*/
	}
	
}




















