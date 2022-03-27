package com.demo.servlet;

import com.demo.dao.FruitDAO;
import com.demo.dao.impl.FruitDAOImpl;
import com.demo.myMVC.ViewBaseServlet;
import com.demo.pojo.fruit;
import com.demo.until.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


@WebServlet("/fruit.do")
public class fruitServlet extends ViewBaseServlet {

    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String operate = request.getParameter("operate");
        if(StringUtil.isEmpty(operate)){
            operate="index";
        }
        //1.2 改成通过反射获得fruitServlet中对应的method对象。并填入参数来执行
        try {
            Method method = getClass().getDeclaredMethod(operate,HttpServletRequest.class,HttpServletResponse.class);
            if(method!=null){
                method.invoke(this,request,response);
                return;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("operatez值非法！");

        //1.1最初用这个方式优化，但是如果方法很多的话不便于管理
        /*switch (operate){
            case "index":
                index(request,response);
                break;
            case "add":
                add(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "update":
                update(request,response);
                break;
            case "edit":
                edit(request,response);
            default:
                throw new RuntimeException("operate值非法");

        }*/

    }
    //编辑
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uidStr = req.getParameter("uid");
        if(StringUtil.isNotEmpty(uidStr)){
            int uid = Integer.parseInt(uidStr);
            fruit fru = fruitDAO.getFruitListById(uid);
            req.setAttribute("fruit",fru);
            super.processTemplate("edit",req,resp);
        }

    }



    //修改
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        int  price = Integer.parseInt(req.getParameter("price"));
        int number = Integer.parseInt(req.getParameter("number"));
        int uid = Integer.parseInt(req.getParameter("uid"));

        fruit fru = new fruit(uid,name,price,number);

        fruitDAO.updateFruitListById(fru);

        resp.sendRedirect("/fruit.do");
    }


    //删除
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        if(uid!=0){
            fruitDAO.deleteFruitById(uid);

            resp.sendRedirect("/fruit.do");
        }

    }


    //增加的方法
    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        int  price = Integer.parseInt(req.getParameter("price"));
        int number = Integer.parseInt(req.getParameter("number"));

        fruitDAO.addFruit(new fruit(0,name,price,number));

        resp.sendRedirect("/fruit.do");
    }

    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNum = 1;
        HttpSession session = req.getSession();


        String flag = req.getParameter("flag");
        String keyWord = null;
        if(StringUtil.isNotEmpty(flag) && "search".equals(flag)){
            //点击了查询按钮并且字符不为空，说明调用查询方法
            //设置回第一页
            pageNum = 1;
            keyWord = req.getParameter("keyWord");
            if(StringUtil.isEmpty(keyWord)){
                keyWord="";
            }
            session.setAttribute("keyWord",keyWord);
        }else{
            //否则就是正常的分页展示
            //此时keyWord应该从session作用域获取,为了让keyWord显示在搜索框内

            String pageNumStr = req.getParameter("pageNum");
            if(StringUtil.isNotEmpty(pageNumStr)){
                pageNum = Integer.parseInt(pageNumStr);
            }
            Object keyWordObj = session.getAttribute("keyWord");
            //第一次输入网址keyWord为null，所以要判断
            if(keyWordObj != null){
                keyWord = (String) keyWordObj;
            }else{
                keyWord="";
            }
        }




        List<fruit> fruitList = fruitDAO.getFruitListByPageNum(keyWord,pageNum);

        //总记录条数
        int count = (fruitDAO.getFruitCount(keyWord)).intValue();
        //总页数
        int pageCount = (count+5 - 1)/5;

        session.setAttribute("pageCount",pageCount);
        session.setAttribute("fruitList",fruitList);
        //更新当前页的值
        session.setAttribute("pageNum",pageNum);

        super.processTemplate("fruitListIndex",req,resp);

    }
}
