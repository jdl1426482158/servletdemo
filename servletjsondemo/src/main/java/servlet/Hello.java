/**
 * servlet
 */
package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * @author LCM
 * @Description
 * @date 2018年10月10日
 * @type Hello
 */
@WebServlet("/hello")
public class Hello extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Hello() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(readJSONString(request));

		// 设置返回数据编码为utf-8,解决返回数据乱码
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("abc", "你好啊");
		map.put("msg", 124);
		//返回json字符串
		response.getWriter().append(JSON.toJSONString(map));
	}

	/**
	 * 从服务端读取json字符串对象,前提是页面需要把json对象转换为json字符串 author : jdl
	 * 
	 * @param request
	 * @return
	 */
	public String readJSONString(HttpServletRequest request) {
		// 设置字符缓存
		StringBuffer json = new StringBuffer();
		String lineString = null;
		try {
			BufferedReader reader = request.getReader();
			// 循环读取所有内容
			while ((lineString = reader.readLine()) != null) {
				//将内容添加到字符缓存中去
				json.append(lineString);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return json.toString();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
