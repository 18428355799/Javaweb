package T8;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T8.PageObject;

import T8.BookJiekou;
import T8.BookImaple;
import T8.TushuVo;
public class BookServlet extends HttpServlet{
	
	BookJiekou base=new BookImaple();
	public  void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action=req.getParameter("action");
		if(action!=null){
			if(action.equals("init")){
				List<TushuVo> tushuList = base.tushuList();
				req.setAttribute("tushuList", tushuList);
				req.getRequestDispatcher("/T8/bookAdd.jsp").forward(req, resp);
			}else if(action.equals("add")){
				String zuozhe=req.getParameter("zuozhe");
				String biaoti=req.getParameter("biaoti");
				String chuban=req.getParameter("chuban");
				String shijian=req.getParameter("shijian");
				String jiage=req.getParameter("jiage");
				TushuVo dd=new TushuVo();
				dd.setBookzuozhe(zuozhe);
				dd.setBiaoti(biaoti);
				dd.setChuban(chuban);
				dd.setShijian(shijian);
				dd.setJiage(Float.parseFloat(jiage));
				base.TushuAdd(dd);
				listPage(req, resp);
				req.getRequestDispatcher("/T8/BookList.jsp").forward(req, resp);
			}else if(action.equals("update")){
				String bookId=req.getParameter("bookId");
				TushuVo  boid=base.findBook(bookId);
				req.setAttribute("boid", boid);
				req.getRequestDispatcher("/T8/BookUpdate.jsp").forward(req, resp);
			}else if(action.equals("updateSave")){
				String book=req.getParameter("book");
				String zuozhe=req.getParameter("zuozhe");
				String biaoti=req.getParameter("biaoti");
				String chuban=req.getParameter("chuban");
				String shijian=req.getParameter("shijian");
				String jiage=req.getParameter("jiage");
				TushuVo ff=new TushuVo();
				ff.setBookid(Integer.parseInt(book));
				ff.setBookzuozhe(zuozhe);
				ff.setBiaoti(biaoti);
				ff.setChuban(chuban);
				ff.setShijian(shijian);
				ff.setJiage(Float.parseFloat(jiage));
				base.TushuUpdate(ff);
				listPage(req, resp);
				req.getRequestDispatcher("/T8/BookList.jsp").forward(req, resp);
			}else if(action.equals("del")){
				String bookId=req.getParameter("bookId");
				base.TushuDel(Integer.parseInt(bookId));
				listPage(req, resp);
				req.getRequestDispatcher("/T8/BookList.jsp").forward(req, resp);
			}else if(action.equals("list")){
				listPage(req, resp);
				req.getRequestDispatcher("/T8/BookList.jsp").forward(req, resp);
			}else if(action.equals("buy")){
				String bookId = req.getParameter("bookId");
				TushuVo boid = base.findBook(bookId);
				req.setAttribute("boid", boid);
				req.getRequestDispatcher("/T8/BookBuy.jsp").forward(req, resp);
			}else if(action.equals("buySave")){
				String jiage = req.getParameter("jiage");
				String zhifu = req.getParameter("zhifu");
				if(jiage.equals(zhifu)){
					if(jiage.equals("45.0")){//ˮ䰴��ļ۸�
						req.getRequestDispatcher("/T8/Book1.jsp").forward(req, resp);
					}else {
						req.getRequestDispatcher("/T8/Book.jsp").forward(req, resp);
					}
				}else{
					String bookId = req.getParameter("book");
					TushuVo boid = base.findBook(bookId);
					req.setAttribute("boid", boid);
					req.getRequestDispatcher("/T8/BookBuy.jsp").forward(req, resp);
				}
			}
		}
	}
	//��ѯ�鼮����
	public void list(HttpServletRequest req,HttpServletResponse resp)
	throws IOException ,ServletException{
		List<TushuVo> booList=base.tushuList();
		req.setAttribute("booList",booList);
	}
	//��ҳ
	public void listPage(HttpServletRequest req,HttpServletResponse resp)
	throws IOException ,ServletException{
		//��ȡҳ��Ĳ���
		String currentPage = req.getParameter("currentPage");
		String opr = req.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getBookCount();
		PageObject pager = new PageObject();
		//���õ�һ������
		pager.setRecordCount(cnt);
		//���õڶ�������
		if(currentPage==null || currentPage.equals("")){
			pager.setCurrentPage(1);
		}else{
			pager.setCurrentPage(Integer.parseInt(currentPage));
		}
		//���õ���������
		if(opr==null || opr.equals("")){
			pager.setOpr("first");
		}else{
			pager.setOpr(opr);
		}
		//��ȡ��ǰҳ
		int currPage = pager.getCurrentPage();
		//��ȡ���ݿ��е�����
		List<TushuVo> tushuList = base.tushuList(pager.getPageSize(),pager.getStartPos());
		//�������request����������������е��鼮��Ϣ
		req.setAttribute("tushuList", tushuList);
		req.setAttribute("pager", pager);
	}
}
