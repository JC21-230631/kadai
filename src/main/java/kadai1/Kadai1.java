package kadai1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kadai1Bean;



@WebServlet("/keisan")
public class Kadai1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Kadai1() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
 
		String strMoney = (String) request.getParameter("money");
		String strRate = (String) request.getParameter("rate");
	
		int money = 0; 
		double rate = 0.0; 
		int tax = 0; 
		int withTax = 0; 
		String result = "";
		Kadai1Bean bean = new Kadai1Bean();
 
		try {
			
			money = Integer.parseInt(strMoney);
			
			if (Integer.parseInt(strRate) == 1) {
				rate = 8.0;
			}else if(Integer.parseInt(strRate) == 2){
				rate = 10.0;
			}else {
				throw new Exception();
			}
			
			tax = (int)(money * rate / 100);
			withTax = money + tax;
			
		
		} catch(NumberFormatException e) {
			e.printStackTrace();
			if(strMoney == "" || strMoney == null) {
				result = result + "金額が\"\"、またはnullになっています。";
			}else if(money == 0){
				result = result + "金額が整数値ではありません";
			}if(strRate == "" || strRate == null) {
				result = result + "消費税が\"\"、またはnullになっています。";
			}else if(Integer.parseInt(strRate) != 1 && Integer.parseInt(strRate) != 2) {
				result = result + "消費税が 1または2以外の値になっています。";
			}
			bean.setResult(result);
			request.setAttribute("BEAN", bean);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			//return;	
			
			
		} catch(Exception e) {
			e.printStackTrace();
			if(strMoney == "" || strMoney == null) {
				result = result + "金額が\"\"、またはnullになっています。";
			}if(strRate == "" || strRate == null) {
				result = result + "消費税が\"\"、またはnullになっています。";
			}else if(Integer.parseInt(strRate) != 1 && Integer.parseInt(strRate) != 2 ){
				result = result + "消費税が 1または2以外の値になっています。";
			}
			bean.setResult(result);
			request.setAttribute("BEAN", bean);
			request.getRequestDispatcher("error.jsp").forward(request, response);
			//return;
		}
		
		
		bean.setMoney(money);
		bean.setRate(rate);
		bean.setTax(tax);
		bean.setWithTax(withTax);
		request.setAttribute("BEAN", bean);
		request.getRequestDispatcher("kadai1.jsp").forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
 
		String result = "";
		Kadai1Bean bean = new Kadai1Bean();
		result = result + "データが存在しません。";
		bean.setResult(result);
		request.setAttribute("BEAN", bean);
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
}