package locs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import locs.model.LocsDTO;
import locs.service.LocsService;

@WebServlet("/locs/add")
public class LocsAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocsService service = new LocsService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/locs/add.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locsId = request.getParameter("locsId");
		String streetAddress = request.getParameter("streetAddress");
		String postalCode = request.getParameter("postalCode");
		String city = request.getParameter("city");
		String stateProvince = request.getParameter("stateProvince");
		String countryId = request.getParameter("countryId");
		
		/*
		 * 데이터 -> service
		 * service -> dao
		 * dao -> SQL 구문
		 */
		
		LocsDTO data = service.addLocs(locsId, streetAddress, postalCode, city, stateProvince, countryId);
		
		String view = "/WEB-INF/jsp/locs/add.jsp";
		if(data != null) {
			// 저장 성공
			if(data.getLocsId() == -1) {
				// 지역코드 중복
				request.setAttribute("error", data);
				request.setAttribute("errorMsg", "지역코드 중복!");
				request.getRequestDispatcher(view).forward(request, response);
			} else if(data.getCountryId().equals("-1")) {
				// 해당 지역 ID 없음
				request.setAttribute("error", data);
				request.setAttribute("errorMsg", "해당 지역 ID 없음");
				request.getRequestDispatcher(view).forward(request, response);
			} else {
				// 저장 성공 후 리다이렉트를 사용하여 페이지를 이동하게 함
				response.sendRedirect(request.getContextPath() + "/locs?search=" + data.getLocsId());
			}
		} else {
			// 저장 실패
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
