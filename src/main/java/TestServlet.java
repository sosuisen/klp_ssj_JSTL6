import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MemberBean;

@WebServlet(name = "servletName", urlPatterns = { "/test" })
public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("name", "kcg");
		req.setAttribute("address", "kyoto");
		var session = req.getSession();
		session.setAttribute("address", "rakuhoku");

		req.setAttribute("num", 5);
		
	    req.setAttribute("member", new MemberBean("鴨川桂"));

	    var list = new ArrayList<String>();
	    list.add("駅前校");
	    list.add("洛北校");
	    list.add("鴨川校");
	    req.setAttribute("list", list);

		// req.getRequestDispatcher("/WEB-INF/test.jsp").forward(req, res);
	    req.getRequestDispatcher("/WEB-INF/test2.jsp").forward(req, res);
	}
}