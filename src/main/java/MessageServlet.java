import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MessageBean;

@WebServlet(urlPatterns = { "/message", "/clear" })
public class MessageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession();

		if (session.getAttribute("history") == null) {
			session.setAttribute("history", new ArrayList<MessageBean>());
		}

		var path = request.getServletPath();
		if (path.equals("/clear")) {
			var list = (ArrayList<MessageBean>) session.getAttribute("history");
			list.clear();
		}

		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		var mesBean = new MessageBean(request.getParameter("name"), request.getParameter("message"));
		var session = request.getSession();
		var list = (ArrayList<MessageBean>) session.getAttribute("history");
		list.add(mesBean);

		request.getRequestDispatcher(
				"/WEB-INF/message.jsp").forward(request, response);
	}
}
