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

@WebServlet("/s_loginServlet")
public class s_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public s_loginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int i=0;
		String ID=request.getParameter("ID");
		String identify=request.getParameter("identify");
		String name=request.getParameter("name");
			mysql sql = new mysql();
			ResultSet rs = sql.selectData("select name,identify from student where id='"+ID+"'");
			try {
					if(rs.next()) {
						if(!rs.getString("identify").equals(identify)) {
							i=1;
							JOptionPane.showMessageDialog(null, "身份证号错误！","身份证号错误！",JOptionPane.ERROR_MESSAGE);
							response.setHeader("refresh", "0;URL=login.jsp");
						}else if(!rs.getString("name").equals(name)) {
							i=1;
							JOptionPane.showMessageDialog(null, "名字错误！","名字错误！",JOptionPane.ERROR_MESSAGE);
							response.setHeader("refresh","0;URL=login.jsp");
						}
					}else {
						i=1;
						JOptionPane.showMessageDialog(null, "该ID不存在！请重新输入！","ID不存在！",JOptionPane.ERROR_MESSAGE);
						response.setHeader("refresh","0;URL=login.jsp");
						
					}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(i==0) {
				response.setHeader("refresh","0;URL=student.jsp");
			}
			sql.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
