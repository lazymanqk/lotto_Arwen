package Lotto649_Package;
//package Lotto649_Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Test
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");//可將字串內容打印成網頁格式
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8"); //獲取網頁傳輸的內容
        /** 設定響應頭允許ajax跨域訪問 **/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星號表示所有的異域請求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");


/**      =================================================================
         * 接收*/
        // 接受屬性name的字串資料
        String n1 = request.getParameter("n1");
        String n2 = request.getParameter("n2");
        String n3 = request.getParameter("n3");
        String n4 = request.getParameter("n4");
        String n5 = request.getParameter("n5");
        String n6 = request.getParameter("n6");
        
        System.out.println("MyServlet.java:頁面取得資料：");
        System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6);

/**		=================================================================
         * 返回*/
        String []nar = {"22","31","34","9","12","15"};
        String n0[] = {n1,n2,n3,n4,n5,n6};
        lotto649_Sqlite lottoGo = new lotto649_Sqlite(nar);
        lottoGo.detect();
        
        PrintWriter out = response.getWriter();
//        在字串的位置可以改成html程式碼，即能打印出一個網頁
        String title = "資料回應";
        String docType = "<!DOCTYPE html> \n";
        out.println(
                docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
                        + "<h1 align=\"center\">" + title + "</h1>\n" + "取得獎號\r\n" +n1+" "+n2+" "+n3+" "+n4+" "+n5+" "+n6+ "</body>\r\n" + "</html>");
        out.close();

		doGet(request, response);
	}

}
