package longinServlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import mysql.mysql;
@WebServlet("/t_loginServlet")
public class t_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public t_loginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int i=0;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
			mysql sql = new mysql();
			ResultSet rs = sql.selectData("select password from manager where username='"+username+"'");
			try {
					if(rs.next()) {
						if(!rs.getString("password").equals(password)) {
							i=1;
							JOptionPane.showMessageDialog(null, "密码错误！","密码错误！",JOptionPane.ERROR_MESSAGE);
							response.setHeader("refresh", "0;URL=login.jsp");
						}
					}else {
						i=1;
						JOptionPane.showMessageDialog(null, "该用户名不存在！请重新输入！","改用户名不存在！",JOptionPane.ERROR_MESSAGE);
						response.setHeader("refresh","0;URL=login.jsp");
					}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==0) {
				response.setHeader("refresh","0;URL=teacher.jsp");
			}
			sql.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
