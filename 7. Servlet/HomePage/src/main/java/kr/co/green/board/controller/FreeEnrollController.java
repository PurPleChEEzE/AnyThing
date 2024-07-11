package kr.co.green.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/enroll.do")
public class FreeEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 어떤 사용자가 글작성 요청을 했는지
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("userNo");
		
		// DTO에 정보 저장
		FreeDtoImpl freeDto = new FreeDtoImpl();
		freeDto.setBoardTitle(title);
		freeDto.setBoardContent(content);
		freeDto.setMemberNo(memberNo);
		
		
		// 파일 업로드
		Collection<Part> parts = request.getParts();
		String uploadDirectory = "C:\\dev\\work-space\\7. Servlet\\HomePage\\src\\main\\webapp\\resources\\uploads\\freeBoard";
		
		// 파일 업로드 디렉토리가 존재하지 않으면 생성
		File filePath = new File(uploadDirectory);
		if(!filePath.exists()) {
			filePath.mkdirs();
		}
		
		String fileName = null;
		

		// 서비스 호출
		FreeServiceImpl freeService = new FreeServiceImpl();
		int result = freeService.enroll(freeDto); // 게시글 등록
		
		// 등록된 게시글의 no 가져오기
		FreeDtoImpl resultDto = freeService.selectNo(freeDto);
		
		for(Part part : parts) {
			fileName = getFileName(part);
			if(fileName != null) {
				part.write(filePath + File.separator + fileName);
				
				freeDto.setFilePath(uploadDirectory);
				freeDto.setFileName(fileName);
				
				int resultUpload = freeService.fileUpload(freeDto);
			}
		}
		
		// RequestDispatcher  		 vs   	response.sendRedirect
		// jsp로 데이터 담아서 이동할때			다른 컨트롤러를 다시 요청해야할 때
		if(result == 1) {
			response.sendRedirect("/freeBoard/list.do?cpage=1&category=fb_title&search-text=");
		}
	}
	
	
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return null;
    }

}






