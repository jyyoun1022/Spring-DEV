package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	
	private final BoardService service;
	
	
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list 메서드 시작");
		model.addAttribute("list",service.getList());
		
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes re) {
		
		log.info("REGISTER : "+board);
		
		service.register(board);
		
		re.addFlashAttribute("result",board.getBno());
	log.info("여기에 게시글 번호 찎혀야합니다"+board.getBno());
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno")Long bno,Model model) {
		
		log.info("/get or modify");
		
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board,RedirectAttributes re) {
		log.info(board);
		
		if(service.modify(board)) {
			re.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno")Long bno,RedirectAttributes re)throws Exception {
		log.info("=============+");
		log.info("삭제된게시글 번호 : "+bno);
		if(service.remove(bno)) {
			re.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
}
	
	
