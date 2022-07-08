package locs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import locs.model.LocsDTO;
import locs.service.LocsService;

@WebServlet("/locs/mod")
public class LocsModController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LocsService service = new LocsService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		LocsDTO data = service.getId(id);
		
		request.setAttribute("data", data);
		
		String view = "/WEB-INF/jsp/locs/mod.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String locsId = request.getParameter("locsId");
		String streetAddress = request.getParameter("streetAddress");
		String postalCode = request.getParameter("postalCode");
		String city = request.getParameter("city");
		String stateProvince = request.getParameter("stateProvince");
		String countryId = request.getParameter("countryId");
		
		LocsDTO data = new LocsDTO();
		data.setLocsId(Integer.parseInt(locsId));
		data.setStreetAddress(streetAddress);
		data.setPostalCode(postalCode);
		data.setCity(city);
		data.setStateProvince(stateProvince);
		data.setCountryId(countryId);
		
		int result = service.modifyLocs(data);
		
		String view = "/WEB-INF/jsp/locs/mod.jsp";
		request.setAttribute("data", data);
		
		switch (result) {
		case 1:
			response.sendRedirect(request.getContextPath() + "/locs?search=" + data.getLocsId());
			break;
		case 0:
			request.setAttribute("errorMsg", "수정 작업 중 알수 없는 문제가 발생하였습니다.");
			request.getRequestDispatcher(view).forward(request, response);
			break;
		case -1:
			request.setAttribute("errorMsg", "해당 국가 ID가 존재하지 않습니다.");
			request.getRequestDispatcher(view).forward(request, response);
			break;
		}
	}

}
